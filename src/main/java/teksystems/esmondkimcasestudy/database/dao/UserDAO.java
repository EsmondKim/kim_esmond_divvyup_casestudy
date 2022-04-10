package teksystems.esmondkimcasestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.esmondkimcasestudy.database.entity.User;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    public User findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);

    public List<User> findByFirstName(@Param("firstName") String firstName);

    public List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName") String firstName);

//    public List<Registration> findByFirsNameAndLast_name(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query(value = "select u from User u where u.password = :password")
    public List<User> getByPassword(@Param("password") String password);

}
