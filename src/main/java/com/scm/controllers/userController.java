package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/user")
public class userController {
    @GetMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }
    @GetMapping(value = "/profile")
    public String userProfile() {
        return "user/profile";
    }
    
    

}
