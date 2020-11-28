package com.app.model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Registration {
    private String username;
    private String password;
    private String lastName;
    private String phone;
    //private String birthDate;
    private LocalDate birthDate;
    private String cardNr;
    private String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   // public String getBirthDate() {
    //    return birthDate;
   // }

   // public void setBirthDate(String birthDate) {
    //    this.birthDate = birthDate;
    //}
    public LocalDate getBirthDate() {
       return birthDate;
   }

    public void setBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
