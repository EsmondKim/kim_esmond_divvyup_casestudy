package teksystems.esmondkimcasestudy.database.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.dialect.function.TemplateRenderer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    //Other side of the ManyToOne in the user_roles table.  Sending one user out to many possible roles
    //in the user_roles table.

    //OneToMany: One user/waiter to many diners at one table in the diners table.
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Diner> diner;

    public User() {

    }

}

