package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.MenuDAO;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.Menu;

import java.util.List;

@Slf4j
@Controller
public class MenuSearchController {

    @Autowired
    private MenuDAO MenuDAO;

    @GetMapping("/menusearch/menusearch")
    public ModelAndView getMenu() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("menusearch/menusearch");

        return response;
    }

        @GetMapping("/menu/search")
    public ModelAndView search(@RequestParam(name = "item", required = false) String item) {
        ModelAndView response = new ModelAndView();
        response.setViewName("menusearch/menusearch");

        List<Menu> items;

        items = MenuDAO.findMenuByItemContaining(item);

//        log.info(String.valueOf(items.get(0).getItem()));

        response.addObject("items", items);

        return response;
    }

}
