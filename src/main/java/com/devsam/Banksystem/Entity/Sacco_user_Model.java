package com.devsam.Banksystem.Entity;

import lombok.Data;


@Data
public class Sacco_user_Model {
    private String firstName;
    private  String SecondName;
    private String lastName;
    private String roles;
    private String email;
    private String password;
}
