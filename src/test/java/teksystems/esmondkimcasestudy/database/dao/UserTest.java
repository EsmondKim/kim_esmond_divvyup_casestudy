package teksystems.esmondkimcasestudy.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import teksystems.esmondkimcasestudy.database.entity.User;
import teksystems.esmondkimcasestudy.database.entity.UserRole;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {

    @Autowired
    UserDAO UserDAO;

    @Autowired
    UserRoleDAO UserRoleDAO;

    @Test
    @Order(1)
    public void getUserTest() {

        User expected = new User();
        expected.setId(4);

        User actual = UserDAO.findById(4);

        Assertions.assertEquals(expected.getId(), actual.getId());
    }

    @Test
    @Order(2)
    public void createTest() {
        User expected = new User();
        expected .setFirstName("test");
        expected.setLastName("test");
        expected.setPassword("test");
        expected.setEmail("test");

        UserDAO.save(expected);

        Assertions.assertTrue(expected.getId() > 0);
    }

    @Test
    @Order(3)
    public void updateTest() {

        User actual = UserDAO.findById(1);
        actual.setFirstName("updated");

        UserDAO.save(actual);

        Assertions.assertEquals(actual.getFirstName(), "updated");
    }

    @Test
    @Order(4)
    public void deleteTest() {

        User actual = UserDAO.findById(1);
        List<UserRole> roles = UserRoleDAO.findByUserId(1);

        for (UserRole role : roles) {
            UserRoleDAO.delete(role);
        }

        UserDAO.delete(actual);

        Assertions.assertNull(UserDAO.findById(1));

    }

}
