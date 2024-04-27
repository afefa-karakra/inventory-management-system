package com.example.convoconvert.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private long id;
    private int PhoneNumber;
    private String FullName;
    private int IdentityNumber;
    private int SecondNameNumber;
    private String Address;
    private String Email;
    private String department;
    private String Position;
    private Date HireDate;
    private String ShiftInformation;
    private Time AverageCallDuration;
    private Integer Month;
    private Date DateOfBirth;
    private Integer Age;
    private String Gender;
    private Integer VacationsDays;
    private String Skils;
    private String Feedback;
}
