package HomeValchevi.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Iliya on 12.6.2017 г..
 */

public class AdressException extends Throwable {

    public AdressException(String message){
        message = "Wrong adress format!";
    }
}
