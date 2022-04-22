package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.dao.MenuDAO;
import teksystems.esmondkimcasestudy.database.dao.DinerDAO;
import teksystems.esmondkimcasestudy.database.dao.UserDAO;

import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;
import teksystems.esmondkimcasestudy.database.entity.Menu;
import teksystems.esmondkimcasestudy.database.entity.User;
import teksystems.esmondkimcasestudy.formbean.DinerMenuFormBean;
import teksystems.esmondkimcasestudy.formbean.RegisterFormBean;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class MenuController {

    @Autowired
    private MenuDAO MenuDAO;

    @Autowired
    private DinerDAO DinerDAO;

    @Autowired
    private DinerMenuDAO DinerMenuDAO;

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
    }//getMenu()

    @RequestMapping(value = "/menu/menuSubmit", method = { RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addMenuItemToOrder(@Valid DinerMenuFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        DinerMenu dinerMenu = new DinerMenu();

        dinerMenu.setDiner(DinerDAO.findBySeatNumber(form.getSeatNumberId()));
        dinerMenu.setMenu(MenuDAO.findById(form.getItemId()));
        dinerMenu.setQuantity(form.getQuantity());

        DinerMenuDAO.save(dinerMenu);
        log.info(form.toString());

        response.setViewName("redirect:/menu/menu");

        return response;
    }//ModelAndView menuSubmit()


}//MenuController
