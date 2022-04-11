package teksystems.esmondkimcasestudy.database.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

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
    private Integer seatNumber;

    @Column(name = "credit_card")
    private String creditCard;

//    @Column(name = "status")
//    private String status;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

//    private String userId;

    public Diner() {
        
    }

}

