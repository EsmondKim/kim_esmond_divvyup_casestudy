package teksystems.esmondkimcasestudy.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="menus")
@Data
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
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Menu menu;

}
