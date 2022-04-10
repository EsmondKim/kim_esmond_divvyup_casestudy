package teksystems.esmondkimcasestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.Menu;
import teksystems.esmondkimcasestudy.database.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DinerDAO extends JpaRepository<Diner, Long> {

    public Diner findById(@Param("id") Integer id);

}
