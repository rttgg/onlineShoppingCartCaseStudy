package com.roman.onlineshoppingcartcasestudy.model;


import lombok.NonNull;

import javax.validation.constraints.Email;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String userFirstName;

    @NonNull
    private String userLastName;

    @NonNull
    private String password;

    @NonNull
    @Email(message = "{errors.invalid_email}")
    @Column(unique = true)
    private String email;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn (name="ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;

    public UserAccount() {
    }

    public UserAccount(@NonNull String userFirstName, @NonNull String userLastName, @NonNull String password, @NonNull String email, List<Role> roles) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public UserAccount(Integer id, @NonNull String userFirstName, @NonNull String userLastName, @NonNull String password, @NonNull String email, List<Role> roles) {
        this.id = id;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
    public UserAccount(UserAccount userAccount) {
        this.userFirstName = userAccount.getUserFirstName();
        this.userLastName = userAccount.getUserLastName();
        this.password = userAccount.getPassword();
        this.email = userAccount.getEmail();
        this.roles = userAccount.getRoles();
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
