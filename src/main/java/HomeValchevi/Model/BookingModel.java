package HomeValchevi.Model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Iliya on 11.6.2017 г..
 */

public class BookingModel {

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 3)
    private int number;

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 25)
    private String room;

    @NotEmpty
    @Length(min = 3, max = 30)
    private String arrivalDate;

    @NotEmpty
    @Length(min = 3, max = 30)
    private String departureDate;

    @NotEmpty
    @Length(min = 5, max = 20)
    private String phone;

    @NotEmpty
    @NotNull
    @Length(min = 5, max = 40)
    private String email;

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
