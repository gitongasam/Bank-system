package com.devsam.Banksystem.Entity;

import com.devsam.Banksystem.Enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Sacco_Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double balance;
    private Date createdAt;
    private AccountStatus accountStatus;
    @OneToOne
    private Sacco_User  sacco_user;
}
