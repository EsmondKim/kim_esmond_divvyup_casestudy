package teksystems.esmondkimcasestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddItemFormBean {

    private int id;

    private String item;

    private String description;

    private Double price;

}
