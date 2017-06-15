package HomeValchevi.Entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Iliya on 11.6.2017 г..
 */

@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "room", nullable = false)
    private String room;

    @Column(name = "arrival_date", nullable = false)
    private String arrivalDate;

    @Column(name = "departure_date", nullable = false)
    private String departureDate;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    public BookingEntity(int number, String room, String arrivalDate, String departureDate, String phone, String email) {
        this.number = number;
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.phone = phone;
        this.email = email;
    }

    public BookingEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
