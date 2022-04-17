package teksystems.esmondkimcasestudy.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class DivvyUpService {

    @Autowired
    private DinerMenuDAO DinerMenuDAO;

    public Object groupByDiner() {

        List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();

        Map<Object, List<DinerMenu>> dinerMenuGroupedBySeatNumber =
                dinerMenu.stream().
                collect(Collectors.groupingBy(d -> d.getDiner().getSeatNumber(), Collectors.toList()));

        System.out.println(dinerMenuGroupedBySeatNumber.get(1).get(0).getDiner().getSeatNumber());
        System.out.println(dinerMenuGroupedBySeatNumber.get(1).get(0).getDiner().getDinerNickname());
        System.out.println(dinerMenuGroupedBySeatNumber.get(2).get(0).getDiner().getSeatNumber());
        System.out.println(dinerMenuGroupedBySeatNumber.get(2).get(0).getDiner().getDinerNickname());
//        dinerMenuGroupedBySeatNumber.forEach((k,v) -> System.out.println("Key = "
//                + k + ", Value = " + v));

        return dinerMenuGroupedBySeatNumber;

        }

        public Object sumByPricePerDiner() {

        List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();

        Map<Object, Double> dinerMenuSumByPrice =
                dinerMenu.stream()
                .collect(Collectors.groupingBy(d -> d.getDiner().getSeatNumber(), Collectors.summingDouble(d -> d.getMenu().getPrice())));
        System.out.println(dinerMenuSumByPrice);

        return dinerMenuSumByPrice;

    }//sumByPricePerDiner


}//DivvyUpService{}
