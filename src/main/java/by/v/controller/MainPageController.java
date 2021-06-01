package by.v.controller;

import by.v.entity.InputMessage;
import by.v.mail.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {
    @Autowired
    EmailSender emailSender;

    @GetMapping("/")
    public String mainPageViev(ModelMap model) {
        model.addAttribute("message", new InputMessage());
        return "index";
    }

    @PostMapping("/")
    public String sendMessage(@ModelAttribute("message") InputMessage message) {
        emailSender.setInputMessage(message);
        new Thread(emailSender).start();
        return "redirect:/";
    }
}
