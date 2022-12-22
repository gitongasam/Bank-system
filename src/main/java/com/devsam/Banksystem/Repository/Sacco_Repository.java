package com.devsam.Banksystem.Repository;

import com.devsam.Banksystem.Entity.Sacco_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
@EnableJpaRepositories
public interface Sacco_Repository extends JpaRepository<Sacco_User,Long> {
    Optional<Sacco_User>findByLastName(String lastName);

}
