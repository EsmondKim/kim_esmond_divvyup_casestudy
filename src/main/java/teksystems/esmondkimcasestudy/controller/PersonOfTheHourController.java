package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;

import java.util.List;

@Slf4j
@Controller
public class PersonOfTheHourController {
    @Autowired
    private teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO DinerMenuDAO;

    @RequestMapping(value = "/personofthehour/personofthehour", method = RequestMethod.GET)
    public ModelAndView getPersonOfTheHour() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("personofthehour/personofthehour");

        List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();
        response.addObject("dinerMenu", dinerMenu);

        return response;
    }//
}
