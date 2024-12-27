package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;


@Controller
public class PageController {

    @Autowired
    private UserService userService;    

    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page handler");

        //sending data to view
        model.addAttribute("name", "Substring Technology");
        model.addAttribute("YoutubeChannel", "Learn code with Mishra");
        model.addAttribute("Githubrepo", "https://github.com/Jontyabhay");
        return "home";

    }

    //About Page
    @GetMapping("/about")
    public String aboutPage()
    {
        System.out.println("About page loading..");
        return "about";
    }

    //Servies Page
    @RequestMapping("/services")
    public String servicesPage()
    {
        System.out.println("Services page loading..");
        return "services";
    }

    //contact page

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    //login page
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //signup page
    @RequestMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        //userForm.setName("Abhay");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //processing register form
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm)
    {
        System.out.println("Processing registration");
        System.out.println(userForm);
        User user = User.builder().name(userForm.getName()).email(userForm.getEmail()).password(userForm.getPassword()).
        about(userForm.getAbout()).phoneNumber(userForm.getPhoneNumber()).build();
        User saveduser = userService.saveUser(user);
        System.out.println("User saved");
        return "redirect:/register";
    }
    
    
    
    

}
