package teksystems.esmondkimcasestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;


import java.util.List;
import java.util.Map;

@Repository
public interface DinerMenuDAO extends JpaRepository<DinerMenu, Long> {

        public List<DinerMenu> findAll();

        @Query(value="select item as 'item', quantity as 'quantity', price as 'price', (price * quantity) as 'total'\n" +
                "from menus as m, diners_menus as dm\n" +
                "where m.id = dm.item_id;", nativeQuery = true)
        List<Map<String, Object>> getItemQuantityPriceTotal();

        @Query(value="select sum(price * quantity) as 'subtotal', (sum(price * quantity)) * 0.03 as 'salestax',  (sum(price * quantity)) + sum(price * quantity) * 0.03 as 'total'\n" +
                "from menus as m, diners_menus as dm\n" +
                "where m.id = dm.item_id;", nativeQuery = true)
        List<Map<String, Object>> getTotalsAndTaxes();

        @Query(value="select seat_number, diner_nickname, item, quantity, price, credit_card\n" +
                "from diners as d, menus as m, diners_menus as dm\n" +
                "where seat_number_id = d.id and item_id = m.id\n" +
                "order by seat_number; ", nativeQuery = true)
        List<Map<String, Object>> getDinerMenuDetails();

        @Query(value="select item as 'item', quantity as 'quantity', price as 'price', (price * quantity) as 'total', diner_nickname as 'diner_nickname'\n" +
                "from menus as m, diners_menus as dm, diners as d\n" +
                "where m.id = dm.item_id and d.id = dm.seat_number_id", nativeQuery = true)
        List<Map<String, Object>> getDivvyUpRows();

        @Query(value="select diner_nickname as 'diner_nickname', sum(price * quantity) as 'subtotal', (sum(price * quantity)) * 0.03 as 'salestax', (sum(price * quantity)) + sum(price * quantity) * 0.03 as 'total'\n" +
                "from menus as m, diners_menus as dm, diners as d\n" +
                "where m.id = dm.item_id and d.id = dm.seat_number_id\n" +
                "group by diner_nickname;", nativeQuery = true)
        List<Map<String, Object>> getDivvyUpTaxAndTotalRows();


}
