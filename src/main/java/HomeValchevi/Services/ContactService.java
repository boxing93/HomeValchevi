package HomeValchevi.Services;

import HomeValchevi.Exceptions.AdressException;
import HomeValchevi.Repositories.EmailRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Iliya on 12.6.2017 г..
 */

@Service
public class ContactService implements EmailRepository {

    @Override
    public SimpleMailMessage constructSendMailFromUser(HttpServletRequest request) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("iliyaValchev93@gmail.com");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setSubject("Контакт от сайта на Къща Вълчеви");
        StringBuilder builder = new StringBuilder(64);
        simpleMailMessage.setText(builder.append("Съобщение: ").append(request.getParameter("message")).append(",от: ").append(request.getParameter("name")).append(",с имейл: ").append(request.getParameter("email")).toString());
        return simpleMailMessage;
    }

    @Override
    public SimpleMailMessage constructSendMailForSubscribe(HttpServletRequest httpServletRequest) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("iliyaValchev93@gmail.com");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setSubject("Абониран потребител за Къша Вълчеви");
        StringBuilder sb = new StringBuilder(64);
        simpleMailMessage.setText(sb.append("Нов потребител с имейл: ").append(httpServletRequest.getParameter("email")).append(" се е абонирал за Къща Вълчеви.").toString());
        return simpleMailMessage;
    }

    @Override
    public SimpleMailMessage constructSendMailForReservation(HttpServletRequest httpServletRequest) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("iliyaValchev93@gmail.com");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setSubject("Нова резервация за Къща Вълчеви");
        StringBuilder sb = new StringBuilder(64);
        simpleMailMessage.setText(sb.append("Нова резервация от: ").append(httpServletRequest.getParameter("email"))
                .append(" с телефон: ").append(httpServletRequest.getParameter("phone")).append(". Брой стаи: ").append(httpServletRequest.getParameter("number"))
                .append(", вид стаи: ").append(httpServletRequest.getParameter("room")).append(". Дата на пристигане: ")
                .append(httpServletRequest.getParameter("arrivalDate")).append(", дата на заминаване: ").append(httpServletRequest.getParameter("departureDate")).append(".\n").toString());
        simpleMailMessage.setText(sb.append("Легенда за вид стаи: \n").append("1: Двойна стая \n").append("2: Тройна стая \n")
                .append("3: Студио \n").append("4: Двойна стая + Студио \n").append("5: Тройна стая + Студио \n")
                .append("6: Двойна + Тройна Стая").toString());
        return simpleMailMessage;
    }

    @Override
    public Boolean emailValidator(String email) {
        boolean isValid = false;
        try {
            InternetAddress adress = new InternetAddress(email);
            adress.validate();
            isValid = true;
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("Now exception occured for: " + email);
        }
        return isValid;

    }
}
