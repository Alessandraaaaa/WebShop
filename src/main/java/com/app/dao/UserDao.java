package com.app.dao;

import com.app.model.Registration;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeUser(Registration reg) {
        jdbcTemplate.update("INSERT INTO users (first_name, password, last_name, email, birth_date, card_nr, phone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)",
                reg.getUsername(), reg.getPassword(), reg.getLastName(),reg.getEmail(),getBirtday(reg.getBirthDate()),
                reg.getCardNr(),reg.getPhone());

    }

    private Date getBirtday(String date){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getUsers() {
        RowMapper<User> rowMapper = (rs, rowNumber) -> mapUser(rs);
        return jdbcTemplate.query("SELECT * FROM users", rowMapper);
    }

    private User mapUser(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setFirstName(rs.getString("first_name"));
        user.setPassword(rs.getString("password"));

        return user;

    }
    public List<User> getUsersByUsername(User user) {
        RowMapper<User> rowMapper = (rs, rowNumber) -> mapUser(rs);
        return jdbcTemplate.query("SELECT * FROM users where users.first_name = ?",
                new Object[] {user.getFirstName()} ,rowMapper);
    }
}
