package teksystems.esmondkimcasestudy.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.esmondkimcasestudy.database.dao.DinerDAO;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.dao.MenuDAO;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;
import teksystems.esmondkimcasestudy.database.entity.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DivvyUpService {

    private DinerDAO DinerDAO;
    private DinerMenuDAO DinerMenuDAO;
    private MenuDAO MenuDAO;

    @Autowired
    public DivvyUpService(teksystems.esmondkimcasestudy.database.dao.DinerDAO dinerDAO, teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO dinerMenuDAO, teksystems.esmondkimcasestudy.database.dao.MenuDAO menuDAO) {
        DinerDAO = dinerDAO;
        DinerMenuDAO = dinerMenuDAO;
        MenuDAO = menuDAO;
    }

    public Object groupByDiner() {

            List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();

            Map<Object, List<DinerMenu>> dinerMenuGroupedByDinerName =
                dinerMenu.stream().
                collect(Collectors.groupingBy(d -> d.getDiner().getDinerNickname(), Collectors.toList()));

            dinerMenuGroupedByDinerName.forEach((k,v) -> System.out.println("Key = "
                    + k + ", Value = " + v));

            return dinerMenuGroupedByDinerName;
        }//groupedByDiner

        public Object sumByPricePerDiner() {

            List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();

            Map<Object, Double> dinerMenuSumByPrice =
                    dinerMenu.stream()
                            .collect(Collectors.groupingBy(d -> d.getDiner().getSeatNumber(), Collectors.summingDouble(d -> d.getMenu().getPrice())));
            System.out.println(dinerMenuSumByPrice);

            return dinerMenuSumByPrice;

    }//sumByPricePerDiner

}//DivvyUpService{}
