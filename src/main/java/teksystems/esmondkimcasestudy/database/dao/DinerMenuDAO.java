package teksystems.esmondkimcasestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.esmondkimcasestudy.database.entity.Diner;
import teksystems.esmondkimcasestudy.database.entity.DinerMenu;

import java.util.List;

@Repository
public interface DinerMenuDAO extends JpaRepository<DinerMenu, Long> {

        public List<DinerMenu> findAll();



}
