package HomeValchevi.Controllers;

import HomeValchevi.Entity.SubscribeEntity;
import HomeValchevi.Model.SubscribeModel;
import HomeValchevi.Repositories.EmailRepository;
import HomeValchevi.Repositories.SubscribeRepository;
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
public class SubscribeController {

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/subscribe")
    public ModelAndView subscribe(SubscribeModel subscribe, HttpServletRequest request, Model model){
        String emails = request.getParameter("email");
        SubscribeEntity subEntity = new SubscribeEntity(
                subscribe.getEmail()
        );
        model.addAttribute("view", "home/index");
        if(emailRepository.emailValidator(emails)){
            SimpleMailMessage mail = this.emailRepository.constructSendMailForSubscribe(request);
            mailSender.send(mail);
            this.subscribeRepository.saveAndFlush(subEntity);
            return new ModelAndView("homeview","messagesub","Вие се абонирахте успешно!");
        }else{
            return new ModelAndView("homeview","messagesub2","Има проблем с имейла Ви, моля опитайте отново!");
        }

    }
}
