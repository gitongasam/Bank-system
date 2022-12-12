package com.devsam.Banksystem.Config;
import com.devsam.Banksystem.Entity.Sacco_User;
import com.devsam.Banksystem.Repository.Sacco_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private Sacco_Repository sacco_repository;
    @Override
    public UserDetails loadUserByUsername(String lastName) throws UsernameNotFoundException {
        Sacco_User customer = sacco_repository.findByLastName(lastName).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return  new org.springframework.security.core.userdetails.User(customer.getLastName(),customer.getPassword(),new ArrayList<>());
    }
}