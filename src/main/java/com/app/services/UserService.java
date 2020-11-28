package com.app.services;

import com.app.dao.UserDao;
import com.app.model.Registration;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){
        return userDao.getUsers();
    }

    public String getFirstName(){
        return userDao.getUsers().get(0).getFirstName();
    }

    public void storeUser(Registration reg){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        reg.setPassword(encoder.encode(reg.getPassword()));
        userDao.storeUser(reg);
    }

    public List<User> getUserByPasswordAndLogin (User user){
        return userDao.getUsersByUsername(user);

       // BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
        //if (users.isEmpty() && encoder.matches(login.getpassword(), users.get(0).getPassword()))
// return users.get(0).getID();
        //}
        // return null;



    }

}
