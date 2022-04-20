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
public class UserRoleTest {

    @Autowired
    UserRoleDAO UserRoleDAO;

    @Test
    @Order(1)
    public void getUserTest() {

        UserRole expected = new UserRole();
        expected.setId(1);

        List<UserRole> actual = UserRoleDAO.findByUserId(1);

        Assertions.assertEquals(expected.getId(), actual.get(1));
    }

}
