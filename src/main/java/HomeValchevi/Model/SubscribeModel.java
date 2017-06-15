package HomeValchevi.Model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Iliya on 11.6.2017 г..
 */
public class SubscribeModel {

    @NotEmpty
    @Length(min = 5, max = 30)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
