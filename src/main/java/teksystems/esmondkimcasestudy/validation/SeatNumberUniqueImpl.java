package teksystems.esmondkimcasestudy.validation;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import teksystems.esmondkimcasestudy.database.dao.DinerDAO;
import teksystems.esmondkimcasestudy.database.entity.Diner;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SeatNumberUniqueImpl implements ConstraintValidator <SeatNumberUnique, Integer> {

    public static final Logger LOG = LoggerFactory.getLogger(SeatNumberUnique.class);

    @Autowired
    private DinerDAO DinerDAO;

    @Override
    public void initialize(SeatNumberUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        Diner diner = DinerDAO.findBySeatNumber(value);
        return(diner == null);
    }

}
