package com.app.services;

import com.app.dao.UserDao;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public Integer getUserId(User login) {
        List<User> users = userDao.getUsersByUsername(login);

        if (users.size() > 1) {
            System.out.println("There is more than 1 user with username: " + login.getFirstName());
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

        if (!users.isEmpty() && encoder.matches(login.getPassword(),
                users.get(0).getPassword())) {
            return users.get(0).getId();
        }
        return null;
    }
}
