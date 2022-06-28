package com.roman.onlineshoppingcartcasestudy.model;

import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String adminEmail;

    @ManyToMany(mappedBy = "roles")
    private List<UserAccount> userAccounts;

    public Role() {
    }

    public Role(int id, @NonNull String adminEmail, List<UserAccount> userAccounts) {
        this.id = id;
        this.adminEmail = adminEmail;
        this.userAccounts = userAccounts;
    }

    public Role(@NonNull String adminEmail, List<UserAccount> userAccounts) {
        this.adminEmail = adminEmail;
        this.userAccounts = userAccounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", adminEmail='" + adminEmail + '\'' +
                ", userAccounts=" + userAccounts +
                '}';
    }
}
