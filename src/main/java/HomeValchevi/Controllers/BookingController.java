package HomeValchevi.Controllers;

import HomeValchevi.Entity.BookingEntity;
import HomeValchevi.Model.BookingModel;
import HomeValchevi.Repositories.BookingRepository;
import HomeValchevi.Repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Iliya on 11.6.2017 г..
 */

@Controller
public class BookingController {


    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/booking")
    public ModelAndView reservation(BookingModel booking, Model model, HttpServletRequest request) {
        BookingEntity reservation = new BookingEntity(
                booking.getNumber(),
                booking.getRoom(),
                booking.getArrivalDate(),
                booking.getDepartureDate(),
                booking.getPhone(),
                booking.getEmail()
        );
        model.addAttribute("view", "home/booking");


        if(!emailRepository.emailValidator(booking.getEmail())){
            return new ModelAndView("homeview", "message3", "Има проблем с имейла Ви, моля опитайте отново!");
        }
        if (booking.getNumber() == 0 || Integer.parseInt(booking.getRoom()) == 0
                || booking.getArrivalDate() == "" || booking.getDepartureDate() == ""
                || booking.getPhone() == "" || booking.getEmail() == "") {
            return new ModelAndView("homeview", "message2", "Моля, попълнете всички полета!");
        } else {
            this.bookingRepository.saveAndFlush(reservation);
            SimpleMailMessage mail = this.emailRepository.constructSendMailForReservation(request);
            mailSender.send(mail);
            return new ModelAndView("homeview", "message", "Вашата резервация е направена, очаквайте потвърждение чрез Вашия имейл или телефон!");
        }
    }



}
