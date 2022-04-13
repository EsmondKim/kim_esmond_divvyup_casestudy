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

    @ManyToOne
    @JoinColumn(name = "seat_number_id", nullable = false)
    private Diner diner;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Menu menu;

    @Column(name = "seat_number_id", updatable = false, insertable = false)
    private Integer seatNumberId;

    @Column(name = "item_id", updatable = false, insertable = false)
    private int itemId;

    @Column(name = "quantity")
    private Integer quantity;

}
