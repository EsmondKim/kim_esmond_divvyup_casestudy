package teksystems.esmondkimcasestudy.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import teksystems.esmondkimcasestudy.database.entity.Diner;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DinerTest {

    @Autowired
    DinerDAO DinerDAO;

    @Autowired
    UserDAO UserDAO;

    @Autowired
    DinerMenuDAO DinerMenuDAO;

    @Test
    @Order(1)
    public void getUserTest() {

        Diner expected = new Diner();
        expected.setId(28);

        Diner actual = DinerDAO.findById(28);

        Assertions.assertEquals(expected.getId(), actual.getId());
    }

    @Test
    @Order(2)
    public void createTest() {
        Diner expected = new Diner();

        expected.setDinerNickname("test");
        expected.setSeatNumber(99);
        expected.setUser(UserDAO.findById(1));

        DinerDAO.save(expected);

        Assertions.assertTrue(expected.getId() > 0);
    }

    @Test
    @Order(3)
    public void updateTest() {

        Diner actual = DinerDAO.findById(28);
        actual.setDinerNickname("updated");

        DinerDAO.save(actual);

        Assertions.assertEquals(actual.getDinerNickname(), "updated");
    }

}
