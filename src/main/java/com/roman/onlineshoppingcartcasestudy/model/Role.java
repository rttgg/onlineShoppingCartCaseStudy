package com.roman.onlineshoppingcartcasestudy.model;

import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    @Column(unique = true)
    private String name;

    public Role(int id, String name, List<UserAccount> userAccounts) {
        this.id = id;
        this.name = name;
        this.userAccounts = userAccounts;
    }

    @ManyToMany(mappedBy = "roles")
    private List<UserAccount> userAccounts;

    public Role() {
    }

    public Role(String name, List<UserAccount> userAccounts) {
        this.name = name;
        this.userAccounts = userAccounts;
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", name='" + name + '\'' +
                ", userAccounts=" + userAccounts +
                '}';
    }

}