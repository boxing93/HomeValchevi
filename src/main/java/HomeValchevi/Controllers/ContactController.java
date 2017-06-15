package HomeValchevi.Controllers;

import HomeValchevi.Entity.ContactEntity;
import HomeValchevi.Model.ContactModel;
import HomeValchevi.Repositories.ContactRepository;
import HomeValchevi.Repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Iliya on 12.6.2017 г..
 */
@Controller
public class ContactController extends ContactModel {

    @Autowired
    private ContactRepository contact;

    @Autowired
    private EmailRepository email;

    @Autowired
    private JavaMailSender javaMailSender;


    @PostMapping("/contact")
    public ModelAndView contact(ContactModel contactModel, Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String emails = request.getParameter("email");
        String messages = request.getParameter("message");
        ContactEntity contactEntity = new ContactEntity(
                contactModel.getEmail(),
                contactModel.getMessage(),
                contactModel.getName()
        );
        model.addAttribute("view", "home/contact");
        if(!email.emailValidator(emails)){
            return new ModelAndView("homeview", "message3", "Има проблем с имейла Ви, моля опитайте отново!");
        }
        if (contactModel.getEmail().isEmpty() || contactModel.getName().isEmpty() || contactModel.getMessage().isEmpty()) {
            return new ModelAndView("homeview", "message2", "Моля попълнете всички полета!");

        } else {
            SimpleMailMessage mail = email.constructSendMailFromUser(request);
            javaMailSender.send(mail);
            contact.saveAndFlush(contactEntity);
            return new ModelAndView("homeview", "message", "Вашето запитване е изпратено успешно!");
        }
    }
}
