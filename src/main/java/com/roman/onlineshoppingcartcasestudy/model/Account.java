package com.roman.onlineshoppingcartcasestudy.model;


import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Account {
    public Account(String userName, @NonNull String password, @NonNull String email, @NonNull String position) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.position = position;
    }

    @Id
    private String userName;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private String position;

    public Account() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
