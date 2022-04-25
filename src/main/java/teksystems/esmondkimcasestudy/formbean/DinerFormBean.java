package teksystems.esmondkimcasestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import teksystems.esmondkimcasestudy.validation.SeatNumberUnique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class DinerFormBean {

    private Integer id;

    @NotBlank(message = "A diner nickname is required.")
    private String dinerNickname;

    @NotNull(message = "You must assign a seat number.")
    @SeatNumberUnique(message = "This seat number already exists at this table.")
    private Integer seatNumber;

}
