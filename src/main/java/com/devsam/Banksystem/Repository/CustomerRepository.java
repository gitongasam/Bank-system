package com.devsam.Banksystem.Repository;

import com.devsam.Banksystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer>findByLastName(String lastName);

}
