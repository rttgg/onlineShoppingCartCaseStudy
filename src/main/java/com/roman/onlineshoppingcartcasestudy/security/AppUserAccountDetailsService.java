package com.roman.onlineshoppingcartcasestudy.security;

import com.roman.onlineshoppingcartcasestudy.model.UserAccount;
import com.roman.onlineshoppingcartcasestudy.repository.UserAccountRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AppUserAccountDetailsService implements UserDetailsService {

    UserAccountRepo userAccountRepo;

    @Autowired
    public AppUserAccountDetailsService(UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserAccount> userAccount = userAccountRepo.findByEmail(email);
        userAccount.orElseThrow(() -> new UsernameNotFoundException("user not Found"));
       return new AppUserAccountDetail(userAccount.get());
    }
}
