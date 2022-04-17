package teksystems.esmondkimcasestudy.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DivvyUpService {

    @Autowired
    private DinerMenuDAO DinerMenuDAO;

    public Object groupByDiner() {

        List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();
        Map<Object, List<DinerMenu>> dinerMenuGrouped =
                dinerMenu.stream().collect(Collectors.groupingBy(e -> e.getDiner().getSeatNumber()));

        System.out.println(dinerMenuGrouped.entrySet());

        //        dinerMenuGrouped.entrySet().stream()

        return dinerMenuGrouped;

    }//groupByDiner()


}//groupByDiner()
