package teksystems.esmondkimcasestudy.database.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="menus")
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "item")
    private String item;

    @Lob
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price")
    private Double price;

    //One side of ManyToMany Join in the DinerMenu table.
    @JsonManagedReference
    @OneToMany(mappedBy = "menu")
    private Set<DinerMenu> dinerMenus = new HashSet<DinerMenu>();

}
