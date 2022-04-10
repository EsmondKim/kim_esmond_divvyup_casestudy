package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.MenuDAO;
import teksystems.esmondkimcasestudy.database.entity.Menu;

import java.util.List;

@Slf4j
@Controller
public class MenuController {

    @Autowired
    private MenuDAO MenuDAO;

    @GetMapping("/menu/menu")
    public ModelAndView getMenu() {
        ModelAndView response = new ModelAndView();
        response.setViewName("menu/menu");

        List<Menu> menu = MenuDAO.findAll();
        response.addObject("menuValue", menu);
        log.info(String.valueOf(response));

    return response;
    }
}
