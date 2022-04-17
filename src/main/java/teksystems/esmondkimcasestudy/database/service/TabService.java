package teksystems.esmondkimcasestudy.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.esmondkimcasestudy.database.dao.DinerMenuDAO;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class TabService {

    @Autowired
    private DinerMenuDAO DinerMenuDAO;
    Double subtotal = 0.00;
    Double salesTaxPercentage = 0.03;
    Double salesTaxDollarAmt = 0.00;
    Double tabTotal = 0.00;

    public Double calculateTabSubtotal() {
        List<DinerMenu> dinerMenu = DinerMenuDAO.findAll();

        for ( DinerMenu diner : dinerMenu ) {
            Double dishPrice = diner.getMenu().getPrice();
            subtotal = subtotal + dishPrice;
        };
        System.out.println(subtotal);
        return subtotal;
    }//calculateTabTotal()

    public Double calculateSalesTax() {
        salesTaxDollarAmt = salesTaxPercentage * subtotal;
        System.out.println(salesTaxDollarAmt);
        return salesTaxDollarAmt;
    }//calculateSalesTax()

    public Double calculateTabTotal() {
        tabTotal = subtotal + salesTaxDollarAmt;
        System.out.println(tabTotal);
        return tabTotal;
    }

}//class TabService
