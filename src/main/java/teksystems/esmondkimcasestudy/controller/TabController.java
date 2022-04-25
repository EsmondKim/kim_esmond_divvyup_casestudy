package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class TabController {

    @Autowired
    private DinerMenuDAO DinerMenuDAO;

    @RequestMapping(value = "/tab/tab", method = RequestMethod.GET)
    public ModelAndView getTab() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("tab/tab");

        List<Map<String, Object>> tabRows = DinerMenuDAO.getItemQuantityPriceTotal();
        response.addObject("tabRows", tabRows);

        List<Map<String, Object>> taxAndTotalRows = DinerMenuDAO.getTotalsAndTaxes();
        response.addObject("taxAndTotalRows", taxAndTotalRows);


        return response;
    }//ModelAndView index()

}//TabController {}
