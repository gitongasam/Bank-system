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
    public Sacco_User saveCustomer(@RequestBody Sacco_user_Model customerModel){
        Sacco_User customer=new Sacco_User();
        customer.setFirstName(customerModel.getFirstName());
        customer.setSecondName(customer.getSecondName());
        customer.setLastName(customerModel.getLastName());
//        customer.setRoles(customerModel.getRoles());
        customer.setPassword( passwordEncoder.encode(customerModel.getPassword()));
        return customerRepository.save(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus>login(@RequestBody Sacco_user_Model customerModel) throws Exception {
        Authentication authentication;
        try {
           authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customerModel.getLastName(),customerModel.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException e){
            throw new Exception("bad credentials");
        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getAllCustomer")
    public List<Sacco_User>  getAllCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/dashboard")
    public String getCustomer(){
        return "home page";
    }




}
