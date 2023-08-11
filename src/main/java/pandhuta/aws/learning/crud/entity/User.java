package pandhuta.aws.learning.crud.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="firts_name")
    private String firtsName;

    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    // Default Construktor
    public User(){

    }

    public User(long id,
                String firtsName, String lastName, String email) {
        this.id = id;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
