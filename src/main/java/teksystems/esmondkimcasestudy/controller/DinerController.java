package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.DinerDAO;
import teksystems.esmondkimcasestudy.database.dao.UserDAO;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.Menu;
import teksystems.esmondkimcasestudy.database.entity.User;
import teksystems.esmondkimcasestudy.formbean.DinerFormBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@ControllerAdvice
public class DinerController {

    @Autowired
    private UserDAO UserDAO;

    @Autowired
    private DinerDAO DinerDAO;

    @GetMapping("/diner/diner")
    public ModelAndView getDinerForm() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("diner/diner");

        return response;
    }

    @PostMapping("/diner/submit")
    public ModelAndView dinerSubmit(DinerFormBean form) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        log.debug(currentPrincipalName);

        User loggedInUser = UserDAO.findByEmail(currentPrincipalName);
        log.debug("Logged in user record = " + loggedInUser);

        ModelAndView response =new ModelAndView();

        Diner diner = new Diner();

        diner.setDinerNickname(form.getDinerNickname());
        diner.setSeatNumber(form.getSeatNumber());
        diner.setCreditCard(form.getCreditCard());
        diner.setUser(loggedInUser);
//        diner.setStatus(form.getStatus());
//        diner.setUserId(form.getUserId());
        log.info(String.valueOf(form));
        log.info(String.valueOf(diner));
        DinerDAO.save(diner);

        response.setViewName("redirect:/menu/menu");
//        response.setViewName("redirect:/menu/menu/");
//        response.setViewName("redirect:/user/edit/" + diner.getId());

        return response;
    }



}
