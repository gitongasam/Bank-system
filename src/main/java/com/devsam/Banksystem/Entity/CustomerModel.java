package com.devsam.Banksystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerModel {
    private String Id;
    private String firstName;
    private  String SecondName;
    private String lastname;
    private String password;
}
