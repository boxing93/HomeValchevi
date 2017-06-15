package HomeValchevi.Model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Iliya on 11.6.2017 г..
 */
public class ContactModel {

    @NotEmpty
    @Length(min = 3, max = 30)
    private String name;

    @NotEmpty
    @Length(min = 3, max = 30)
    private String email;

    @NotEmpty
    @Length(min = 3, max = 30)
    private String message;

    public ContactModel(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public ContactModel() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
