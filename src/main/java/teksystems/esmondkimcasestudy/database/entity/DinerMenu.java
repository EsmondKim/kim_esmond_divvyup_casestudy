package teksystems.esmondkimcasestudy.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "diners_menus")
@Getter
@Setter
public class DinerMenu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_number_id")
    private Diner diner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Menu menu;

    @Column(name = "quantity")
    private Integer quantity;

}
