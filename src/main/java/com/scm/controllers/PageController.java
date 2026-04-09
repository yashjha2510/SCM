package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, Model model, HttpSession session) {
        System.out.println("processing registration");

        // validate form
        if (bindingResult.hasErrors()) {
            model.addAttribute("userForm", userForm);
            return "register";
        }

        if (userService.isUserExistsByEmail(userForm.getEmail())) {
            model.addAttribute("errorMessage", "Email is already registered.");
            model.addAttribute("userForm", userForm);
            return "register";
        }
        
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNum(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://img.freepik.com/free-vector/blue-circle-with-white-user_78370-4707.jpg?semt=ais_hybrid&w=740&q=80");

        User saveduser = userService.saveUser(user);
        System.out.println("saved user: " + saveduser);

        // building the message
        Message message = Message.builder().content("Registration successful! Please ").type(MessageType.blue).build();

        // add the message
        session.setAttribute("message", message);
        
        return "redirect:/register";
    }
}
