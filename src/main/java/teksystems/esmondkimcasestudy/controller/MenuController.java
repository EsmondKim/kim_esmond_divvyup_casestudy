package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.MenuDAO;
import teksystems.esmondkimcasestudy.database.dao.DinerDAO;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.Menu;
import teksystems.esmondkimcasestudy.formbean.RegisterFormBean;
import teksystems.esmondkimcasestudy.formbean.DinerFormBean;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class MenuController {

    @Autowired
    private MenuDAO MenuDAO;
    private DinerDAO DinerDAO;

    @GetMapping("/menu/menu")
    public ModelAndView getMenu() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("menu/menu");

        List<Menu> menu = MenuDAO.findAll();
        response.addObject("menuValue", menu);
        log.info(String.valueOf(response));

    return response;
    }

    @RequestMapping(value = "/diner/submit", method = RequestMethod.POST)
    public ModelAndView dinerSubmit() throws Exception {
        ModelAndView response =new ModelAndView();

        DinerFormBean form = new DinerFormBean();

        Diner diner = new Diner();

        diner.setDinerNickname(form.getDinerNickname());
        diner.setSeatNumber(form.getSeatNumber());
        diner.setCreditCard(form.getCreditCard());
        diner.setStatus(form.getStatus());
        diner.setUserId(form.getUserId());

        DinerDAO.save(diner);

        response.setViewName("redirect:/user/edit/" + diner.getId());

        return response;
    }

}
