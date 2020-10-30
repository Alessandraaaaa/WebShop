package com.app.controllers;

import com.app.model.User;
import com.app.services.LoginService;
import com.app.services.UserService;
import com.app.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private CurrentUser currentUser;

    @GetMapping("/logout")
    public String logoutUser(HttpSession session){
        if (currentUser.getId() != null){
            session.invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        if (currentUser.getId() != null){
            model.addAttribute("id", currentUser.getId());
            return "loginSuccess";
        }
        model.addAttribute("user" ,new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
       Integer userId= loginService.getUserId(user);

       if (!StringUtils.isEmpty(userId)) {
           currentUser.setId(userId);
           model.addAttribute("id", currentUser.getId());
           return "loginSuccess";
       }
       return "login";

    }
}
