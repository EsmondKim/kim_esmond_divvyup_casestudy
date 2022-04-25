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

//        select p.id as product_id, p.name, p.price, op.quantity, o.id as order_id, (price * quantity) as total
//        from products p, order_products op, orders o
//        where p.id = op.product_id and o.id = op.order_id
//        and o.user_id = 1 and status = "PENDING";



}
