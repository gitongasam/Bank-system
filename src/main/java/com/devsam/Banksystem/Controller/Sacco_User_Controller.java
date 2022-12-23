package com.devsam.Banksystem.Controller;

import com.devsam.Banksystem.Entity.Sacco_User;
import com.devsam.Banksystem.Entity.Sacco_user_Model;
import com.devsam.Banksystem.Repository.Sacco_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Sacco_User_Controller {
    @Autowired
    private Sacco_Repository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/register")
    public Sacco_User saveCustomer(@RequestBody Sacco_user_Model userModel){
        Sacco_User user=new Sacco_User();
        user.setFirstName(userModel.getFirstName());
        user.setSecondName(user.getSecondName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPassword( passwordEncoder.encode(userModel.getPassword()));
        return customerRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus>login(@RequestBody Sacco_user_Model customerModel) throws Exception {
        Authentication authentication;
        try {
           authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customerModel.getEmail(),customerModel.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException e){
            throw new Exception("bad credentials");
        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/dashboard")
    public String getCustomer(){
        return "home page";
    }




}
