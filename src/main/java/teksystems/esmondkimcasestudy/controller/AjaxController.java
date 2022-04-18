package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.service.DivvyUpService;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class AjaxController {

    private DivvyUpService DivvyUpService;
    private DinerMenuDAO DinerMenuDAO;

    @Autowired

    public AjaxController(teksystems.esmondkimcasestudy.database.service.DivvyUpService divvyUpService, teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO dinerMenuDAO) {
        DivvyUpService = divvyUpService;
        DinerMenuDAO = dinerMenuDAO;
    }

    @RequestMapping(value = "/ajaxDinerMenuGroupedByDinerName", method = RequestMethod.GET)
    public ResponseEntity<Object> ajaxRequestDinerMenuGroupedByDinerName() throws Exception {

        return new ResponseEntity(DivvyUpService.groupByDiner(), HttpStatus.OK);
    }//ajaxDinerMenuGroupedByDinerName

    @RequestMapping(value = "/ajaxSumByPricePerDiner", method = RequestMethod.GET)
    public ResponseEntity<Double> ajaxRequestSumByPricePerDiner() throws Exception {

        return new ResponseEntity(DivvyUpService.sumByPricePerDiner(), HttpStatus.OK);
    }//ajaxSumByPricePerDiner

    @RequestMapping(value = "/ajaxGetDinerMenuDetails", method = RequestMethod.GET)
    public ResponseEntity<Object> ajaxGetDinerMenuDetails() throws Exception {

        return new ResponseEntity(DinerMenuDAO.getDinerMenuDetails(), HttpStatus.OK);
    }//ajaxSumByPricePerDiner


}//Ajax Controller {}
