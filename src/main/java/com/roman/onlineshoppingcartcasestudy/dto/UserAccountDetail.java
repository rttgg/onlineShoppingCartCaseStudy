package com.roman.onlineshoppingcartcasestudy.dto;

import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UserAccountDetail extends UserAccount implements UserDetails {
//    public UserAccountDetail(Optional<UserAccount> userAccount) {
//
//    }
    public UserAccountDetail(UserAccount userAccount) {
        super(userAccount);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authGroupList = new ArrayList<>();
        super.getRoles().forEach(role -> {
            authGroupList.add(new SimpleGrantedAuthority(role.getName()));
        });

        return authGroupList;
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return getPassword();
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
