package teksystems.esmondkimcasestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.esmondkimcasestudy.database.entity.Diner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface DinerDAO extends JpaRepository<Diner, Long> {

    public List<Diner> findAll();

    public Diner findById(@Param("id") Integer id);

    public Diner findBySeatNumber(@Param("seatNumberId") Integer seatNumberId);

}
