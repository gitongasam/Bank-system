package com.devsam.Banksystem.Controller;

import com.devsam.Banksystem.Entity.Customer;
import com.devsam.Banksystem.Entity.CustomerModel;
import com.devsam.Banksystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @PostMapping("/register")
    public Customer  saveCustomer(@RequestBody CustomerModel customerModel){
        Customer customer=new Customer();
        customer.setFirstName(customerModel.getFirstName());
        customer.setSecondName(customer.getSecondName());
        customer.setLastName(customerModel.getLastName());
        customer.setPassword(customerModel.getPassword());
        return customerRepository.save(customer);
    }
}
