package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;
import teksystems.esmondkimcasestudy.database.service.DivvyUpService;

import java.util.List;

@Slf4j
@Controller
public class DivvyUpController {


    private DinerMenuDAO DinerMenuDAO;

    private DivvyUpService DivvyUpService;

    @Autowired
    public DivvyUpController(teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO dinerMenuDAO, teksystems.esmondkimcasestudy.database.service.DivvyUpService divvyUpService) {
        DinerMenuDAO = dinerMenuDAO;
        DivvyUpService = divvyUpService;
    }

    @RequestMapping(value = "/divvyup/divvyup", method = RequestMethod.GET)
    public ModelAndView getDivvyUp() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("divvyup/divvyup");

        List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();
        response.addObject("dinerMenu", dinerMenu);

        return response;
    }//ModelAndView index()

}//DivvyUp Controller {}

