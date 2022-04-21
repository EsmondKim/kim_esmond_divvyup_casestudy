package teksystems.esmondkimcasestudy.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import teksystems.esmondkimcasestudy.database.entity.Menu;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MenuTest {

    @Autowired
    private MenuDAO MenuDAO;

    @Autowired
    private DinerMenuDAO DinerMenuDAO;

    @Test
    @Order(1)
    public void getUserTest() {

        Menu expected = new Menu();
        expected.setId(7);

        Menu actual = MenuDAO.findById(7);

        Assertions.assertEquals(expected.getId(), actual.getId());
    }

    @Test
    @Order(2)
    public void createTest() {
        Menu expected = new Menu();

        expected.setItem("test");
        expected.setDescription("test");
        expected.setPrice(0.99);

        MenuDAO.save(expected);

        Assertions.assertTrue(expected.getId() > 0);
    }

    @Test
    @Order(3)
    public void updateTest() {

        Menu actual = MenuDAO.findById(4);

        actual.setItem("updated");

        MenuDAO.save(actual);

        Assertions.assertEquals(actual.getItem(), "updated");
    }


}
