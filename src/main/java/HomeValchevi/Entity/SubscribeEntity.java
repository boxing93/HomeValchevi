package HomeValchevi.Entity;

import javax.persistence.*;

/**
 * Created by Iliya on 11.6.2017 г..
 */

@Entity
@Table(name = "subscribe_emails")
public class SubscribeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    public SubscribeEntity(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
