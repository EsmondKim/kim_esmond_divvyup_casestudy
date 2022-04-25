package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class PersonOfTheHourController {
    @Autowired
    private teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO DinerMenuDAO;

    @RequestMapping(value = "/personofthehour/personofthehour", method = RequestMethod.GET)
    public ModelAndView getPersonOfTheHour() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("personofthehour/personofthehour");

        List<Map<String, Object>> divvyUpTaxAndTotalRows = DinerMenuDAO.getDivvyUpTaxAndTotalRows();
        response.addObject("divvyUpTaxAndTotalRows", divvyUpTaxAndTotalRows);

        return response;
    }//
}
