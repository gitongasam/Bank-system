package com.devsam.Banksystem.Repository;

import com.devsam.Banksystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
