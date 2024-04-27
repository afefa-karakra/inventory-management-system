package com.example.convoconvert.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private long id;

    @Column(name = "FullName", nullable = false)
    private String FullName;

    @Column(name = "PhoneNumber", nullable = false)
    private int PhoneNumber;

    @Column(name = "IdentityNumber", nullable = true)
    private int IdentityNumber;

    @Column(name = "SecondNameNumber", nullable = true)
    private int SecondNameNumber;

    @Column(name = "Address", nullable = true)
    private String Address;

    @Column(name = "Email", nullable = true)
    private String Email;

    @Column(name = "DateOfBirth", nullable = true)
    private Date DateOfBirth;

    @Column(name = "Age", nullable = true)
    private Integer Age;

    @Column(name = "RegestarationDate", nullable = true)
    private Date RegestarationDate;

    @Column(name = "SubscriptionPlan", nullable = true)
    private String SubscriptionPlan;

    @Column(name = "CustomerType", nullable = true)
    private String CustomerType;

    @Column(name = "Gender", nullable = true)
    private String Gender;

    @Column(name = "AccountStatus", nullable = true)
    private String AccountStatus;


}
