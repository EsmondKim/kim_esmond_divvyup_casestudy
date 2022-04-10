package teksystems.esmondkimcasestudy.database.entity;

import lombok.Data;
import org.hibernate.dialect.function.TemplateRenderer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

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

    public User() {

    }

}

