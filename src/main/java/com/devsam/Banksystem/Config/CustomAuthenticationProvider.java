package com.devsam.Banksystem.Config;

import com.devsam.Banksystem.Entity.Sacco_User;
import com.devsam.Banksystem.Repository.Sacco_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Sacco_Repository sacco_repository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String email= authentication.getName();
       String password= authentication.getCredentials().toString();
       Sacco_User sacco_user=sacco_repository.findByEmail(email).orElseThrow(()->
               new UsernameNotFoundException("user not found"));

       if (passwordEncoder.matches(password, sacco_user.getPassword())){
           return  new UsernamePasswordAuthenticationToken(email,password,new ArrayList<>());

       }else {
           throw new BadCredentialsException("Invalid Credentials");
       }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
