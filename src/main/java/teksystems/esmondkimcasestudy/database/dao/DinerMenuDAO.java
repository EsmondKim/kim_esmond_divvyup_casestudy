package teksystems.esmondkimcasestudy.database.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;

import java.util.List;
import java.util.Map;

@Repository
public interface DinerMenuDAO extends JpaRepository<DinerMenu, Long> {

        public List<DinerMenu> findAll();

        @Query(value="select seat_number, diner_nickname, item, quantity, price, credit_card\n" +
                "from diners as d, menus as m, diners_menus as dm\n" +
                "where seat_number_id = d.id and item_id = m.id\n" +
                "order by seat_number; ", nativeQuery = true)
        List<Map<String, Object>> getDinerMenuDetails();

}
