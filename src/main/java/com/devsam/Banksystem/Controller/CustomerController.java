package com.devsam.Banksystem.Controller;

import com.devsam.Banksystem.Entity.Customer;
import com.devsam.Banksystem.Entity.CustomerModel;
import com.devsam.Banksystem.Repository.CustomerRepository;
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

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/register")
    public Customer  saveCustomer(@RequestBody CustomerModel customerModel){
        Customer customer=new Customer();
        customer.setFirstName(customerModel.getFirstName());
        customer.setSecondName(customer.getSecondName());
        customer.setLastName(customerModel.getLastName());
        customer.setPassword( passwordEncoder.encode(customerModel.getPassword()));
        return customerRepository.save(customer);
    }

    @PostMapping("login")
    public ResponseEntity<HttpStatus>login(@RequestBody CustomerModel customerModel) throws Exception {
        Authentication authentication;
        try {
           authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customerModel.getLastName(),customerModel.getPassword()));
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
