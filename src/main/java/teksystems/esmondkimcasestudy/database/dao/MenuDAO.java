package teksystems.esmondkimcasestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.esmondkimcasestudy.database.entity.Menu;

import java.util.List;

@Repository
public interface MenuDAO extends JpaRepository<Menu, Long> {

    public List<Menu> findAll();

    public Menu findById(@Param("id") Integer id);

    public List<Menu> findMenuByItemContaining(@Param("item") String item);

}
