package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.DinerDAO;
import teksystems.esmondkimcasestudy.database.dao.UserDAO;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.User;
import teksystems.esmondkimcasestudy.formbean.DinerFormBean;

import javax.validation.Valid;



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
    public ModelAndView dinerSubmit(@Valid DinerFormBean form,  BindingResult bindingResult) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User loggedInUser = UserDAO.findByEmail(currentPrincipalName);

        ModelAndView response =new ModelAndView();

        if ( bindingResult.hasErrors() ) {

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("diner/diner");
            return response;
        }//if bindingResult.hasErrors()

        Diner diner = new Diner();

        diner.setDinerNickname(form.getDinerNickname());
        diner.setSeatNumber(form.getSeatNumber());
        diner.setUser(loggedInUser);

        DinerDAO.save(diner);

        response.setViewName("redirect:/menu/menu");

        return response;
    }



}
