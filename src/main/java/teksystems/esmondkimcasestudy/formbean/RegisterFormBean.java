package teksystems.esmondkimcasestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmPassword;

}
