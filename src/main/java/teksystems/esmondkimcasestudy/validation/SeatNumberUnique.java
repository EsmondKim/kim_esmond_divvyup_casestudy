package teksystems.esmondkimcasestudy.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SeatNumberUniqueImpl.class)
@Target( {ElementType.METHOD, ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface SeatNumberUnique {

    String message() default "{SeatNumberUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
