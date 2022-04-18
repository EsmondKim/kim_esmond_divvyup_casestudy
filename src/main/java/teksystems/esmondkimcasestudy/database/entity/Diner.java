package teksystems.esmondkimcasestudy.database.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="diners")
@Getter
@Setter
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

    //Many diners can have one user (server) in this ManyToOne from the users table.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    //One side of ManyToMany Join in the DinerMenu table.
    @JsonManagedReference
    @OneToMany(mappedBy = "diner")
    private Set<DinerMenu> dinerMenus = new HashSet<DinerMenu>();

    public Diner() {
        
    }

}

