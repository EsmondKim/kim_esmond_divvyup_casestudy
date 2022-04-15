package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.MenuDAO;
import teksystems.esmondkimcasestudy.database.dao.DinerDAO;
import teksystems.esmondkimcasestudy.database.dao.UserDAO;

import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.Menu;
import teksystems.esmondkimcasestudy.database.entity.User;


import java.util.List;

@Slf4j
@Controller
public class MenuController {

    @Autowired
    private MenuDAO MenuDAO;

    @Autowired
    private DinerDAO DinerDAO;

    @Autowired
    private UserDAO UserDAO;

    @GetMapping("/menu/menu")
    public ModelAndView getMenu() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("menu/menu");

        List<Diner> diner = DinerDAO.findAll();
        response.addObject("dinerValue", diner);
        log.info(String.valueOf(diner));

        List<Menu> menu = MenuDAO.findAll();
        response.addObject("menuValue", menu);


    return response;
    }

    @RequestMapping(value="/menu/menuSubmit")
    public ModelAndView addMenuItemToOrder(@RequestParam Integer productId, String message) throws Exception {
        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        log.debug(currentPrincipalName);

        if (authentication.isAuthenticated() ) {
            String currentPrincipalName = authentication.getName();
            User loggedInUser = UserDAO.findByEmail(currentPrincipalName);
            log.debug("Logged in user record = " + loggedInUser);
        }

        response.setViewName("menu/menu");

        return response;
    }

}//MenuController
