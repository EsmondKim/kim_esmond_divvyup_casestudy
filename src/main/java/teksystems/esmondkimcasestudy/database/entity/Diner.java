package teksystems.esmondkimcasestudy.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="diners")
@Data
public class Diner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "diner_nickname")
    private String dinerNickname;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "credit_card")
    private String creditCard;

    @Column(name = "status")
    private String status;

    @Column(name = "user_id")
    private String userId;

}
