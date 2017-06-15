package HomeValchevi.Repositories;

import org.springframework.mail.SimpleMailMessage;


import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by Iliya on 12.6.2017 г..
 */
public interface EmailRepository{

    SimpleMailMessage constructSendMailFromUser(HttpServletRequest httpServletRequest);

    SimpleMailMessage constructSendMailForSubscribe(HttpServletRequest httpServletRequest);

    SimpleMailMessage constructSendMailForReservation(HttpServletRequest httpServletRequest);

    Boolean emailValidator(String email);
}
