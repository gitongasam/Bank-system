package com.devsam.Banksystem.Config;

import com.devsam.Banksystem.Entity.Customer;
import com.devsam.Banksystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String lastName) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByLastName(lastName).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return  new org.springframework.security.core.userdetails.User(customer.getLastName(),customer.getPassword(),new ArrayList<>());
    }
}
