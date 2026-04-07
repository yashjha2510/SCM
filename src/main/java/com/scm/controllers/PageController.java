package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.UserForm;



@Controller
public class PageController {

    // home
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "yash jha");
        model.addAttribute("github", "https://github.com/yashjha2510");
        System.out.println("home page handler");
        return "home";
    }

    // about
    @RequestMapping("/about")
    public String about() {
        System.out.println("about controller called successfully");
        return "about";
    }
    
    // services
    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("services controller called successfully");
        return "services";
    }

    // contact
    @RequestMapping("/contact")
    public String contactPage() {
        System.out.println("contact controller called successfully");
        return "contact";
    }

    // login
    @RequestMapping("/login")
    public String loginPage() {
        System.out.println("login controller called successfully");
        return "login";
    }

    // register
    @RequestMapping("/register")
    public String registerPage(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        System.out.println("register controller called successfully");
        return "register";
    }

    // processing register
    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("processing registration");
        System.out.println(userForm);
        return "redirect:/register";
    }
}
