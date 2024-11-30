package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
    @GetMapping("/home")
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
    public String register() {
        return "register";
    }
    
    
    
    

}
