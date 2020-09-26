package com.app.controllers;

import com.app.model.User;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("user" ,new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
       List<User> users= userService.getUserByPasswordAndLogin(user);
       Boolean exists = !CollectionUtils.isEmpty(users);
        model.addAttribute("exists", exists);
        return "loginSuccess";


    }



}
