package com.devsam.Banksystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class CustomerModel {
    private String firstName;
    private  String SecondName;
    private String lastName;
    private String password;
}
