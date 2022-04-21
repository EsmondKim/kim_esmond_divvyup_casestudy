package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.MenuDAO;
import teksystems.esmondkimcasestudy.database.entity.Menu;
import teksystems.esmondkimcasestudy.formbean.AddItemFormBean;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AddItemController {

    @Autowired
    private MenuDAO MenuDAO;

    @GetMapping("/additem/additem")
    public ModelAndView getAddItem() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("additem/additem");

        return response;
    }

    @PostMapping("/menu/additem/submit")
    public ModelAndView addItemSubmit(AddItemFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        Menu menu = new Menu();

        menu.setItem(form.getItem());
        menu.setDescription(form.getDescription());
        menu.setPrice(form.getPrice());

        MenuDAO.save(menu);

        response.setViewName("redirect:/menu/menu");

        return response;

    }
}
