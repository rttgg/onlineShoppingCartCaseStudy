package com.roman.onlineshoppingcartcasestudy.security;

import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserAccountDetail implements UserDetails {
//    public UserAccountDetail(Optional<UserAccount> userAccount) {
//
//    }

    public AppUserAccountDetail(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    UserAccount userAccount;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authGroupList = new ArrayList<>();
        userAccount.getRoles().stream().map(role -> authGroupList.add(new SimpleGrantedAuthority(role.getName())));

        return authGroupList;
    }

    @Override
    public String getUsername() {
        return userAccount.getEmail();
    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}