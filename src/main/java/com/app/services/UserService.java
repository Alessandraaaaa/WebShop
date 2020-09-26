package com.app.services;

import com.app.dao.UserDao;
import com.app.model.Registration;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public String getFirstName(){
        return userDao.getUsers().get(0).getFirstName();
    }

    public void storeUser(Registration reg){
        userDao.storeUser(reg);
    }

    public List<User> getUserByPasswordAndLogin (User user){
        return userDao.getUsersByUsernameAndPassword(user);


    }

}
