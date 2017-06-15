package HomeValchevi.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Iliya on 31.5.2017 г..
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("view", "home/index");
        return "homeview";
    }

    @GetMapping("about")
    public String about(Model model) {
        model.addAttribute("view", "home/about");
        return "homeview";
    }

    @GetMapping("gallery")
    public String gallery(Model model) {
        model.addAttribute("view", "home/gallery");
        return "homeview";
    }

    @GetMapping("booking")
    public String booking(Model model) {
        model.addAttribute("view", "home/booking");
        return "homeview";
    }

    @GetMapping("contact")
    public String contact(Model model) {
        model.addAttribute("view", "home/contact");
        return "homeview";
    }

}
