package com.app.controllers;

import com.app.model.User;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestUserController {
    @Autowired
    UserService userService;

    @CrossOrigin

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();

    }

  //  @CrossOrigin
    //@GetMapping("/getUsername")
    //public String getUsername(){
      //  return
    //}
}
