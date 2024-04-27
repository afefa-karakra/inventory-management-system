package com.example.convoconvert.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private long id;
    private int PhoneNumber;
    private String FullName;
    private int IdentityNumber;
    private int SecondNameNumber;
    private String Address;
    private String Email;
    private Date DateOfBirth;
    private Integer Age;
    private Date RegestarationDate;
    private String SubscriptionPlan;
    private String CustomerType;
    private String Gender;
    private String AccountStatus;

}
