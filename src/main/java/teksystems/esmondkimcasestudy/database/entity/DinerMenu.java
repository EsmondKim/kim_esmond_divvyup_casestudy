package teksystems.esmondkimcasestudy.database.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "diners_menus")
public class DinerMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //The OneToMany from the Diner class
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_number_id")
    private Diner diner;

    //The OneToMany from the Menu class
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Menu menu;

    @Column(name = "quantity")
    private Integer quantity;

}
