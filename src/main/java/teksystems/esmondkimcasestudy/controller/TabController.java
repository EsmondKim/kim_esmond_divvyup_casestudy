package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;
import teksystems.esmondkimcasestudy.database.entity.Menu;

import java.util.List;

@Slf4j
@Controller
public class TabController {

    @Autowired
    private DinerMenuDAO DinerMenuDAO;

    @RequestMapping(value = "/tab/tab", method = RequestMethod.GET)
    public ModelAndView getTab() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("tab/tab");

        List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();
        log.info(String.valueOf(dinerMenu));
        log.info(String.valueOf(dinerMenu.get(0).getMenu().getItem()));
        log.info(String.valueOf(dinerMenu.get(0).getMenu().getPrice()));
        log.info(String.valueOf(dinerMenu.get(0).getDiner().getSeatNumber()));
        log.info(String.valueOf(dinerMenu.get(0).getDiner().getDinerNickname()));
        response.addObject("dinerMenu", dinerMenu);

        return response;
    }//ModelAndView index()

}//TabController {}
