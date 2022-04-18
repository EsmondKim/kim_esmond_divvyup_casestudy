package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teksystems.esmondkimcasestudy.database.service.DivvyUpService;

@Slf4j
@Controller
public class AjaxController {

    @Autowired
    private DivvyUpService DivvyUpService;

    @Autowired
    private DivvyUpController DivvyUpController;

    @RequestMapping(value = "/ajaxDinerMenuGroupedBySeatNumber", method = RequestMethod.GET)
    public ResponseEntity<Object> ajaxRequestDinerMenuGroupedBySeatNumber() throws Exception {

        return new ResponseEntity(DivvyUpService.groupByDiner(), HttpStatus.OK);
    }//ajaxDinerMenuGroupedBySeatNumber

    @RequestMapping(value = "/ajaxSumByPricePerDiner", method = RequestMethod.GET)
    public ResponseEntity<Double> ajaxRequestSumByPricePerDiner() throws Exception {

        return new ResponseEntity(DivvyUpService.sumByPricePerDiner(), HttpStatus.OK);
    }//ajaxSumByPricePerDiner

}//Ajax Controller {}
