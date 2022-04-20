package teksystems.esmondkimcasestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class DinerFormBean {

    private Integer id;

    @NotBlank(message = "A diner nickname is required.")
    private String dinerNickname;

    @NotBlank(message = "You must assign a seatnumber.")
    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "You must enter a number.")
    private Integer seatNumber;

    private String creditCard;

//    private String status;

//    private String userId;

}
