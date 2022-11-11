package com.devsam.Banksystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private String firstName;
    private  String SecondName;
    private String lastname;
    private String password;
}
