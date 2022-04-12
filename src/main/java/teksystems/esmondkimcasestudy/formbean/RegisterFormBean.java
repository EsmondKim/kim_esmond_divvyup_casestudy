package teksystems.esmondkimcasestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import teksystems.esmondkimcasestudy.validation.EmailUnique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    @NotBlank(message = "First Name is required.")
    private String firstName;

    @NotBlank (message = "Last Name is required.")
    private String lastName;

    @EmailUnique(message = "Email already exists in database")
    @Email(message = "@Email from spring validator")
    @NotBlank(message = "Email is required.")
    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Email format invalid.")
    private String email;

    @Length(min=3, max=15, message = "Password must be between 3 and 15 characters.")
    @NotBlank(message = "Password is required.")
    private String password;

    @NotBlank(message = "Confirm Password is required.")
    private String confirmPassword;

}
