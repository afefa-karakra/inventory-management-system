package com.example.convoconvert.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
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

    @Column(name = "department", nullable = true)
    private String department;


    @Column(name = "Position", nullable = true)
    private String Position;

    @Column(name = "HireDate", nullable = true)
    private Date HireDate;

    @Column(name = "ShiftInformation", nullable = true)
    private String ShiftInformation;

    @Column(name = "AverageCallDuration", nullable = true)
    private Time AverageCallDuration;

    @Column(name = "Month", nullable = true)
    private Integer Month;

    @Column(name = "DateOfBirth", nullable = true)
    private Date DateOfBirth;

    @Column(name = "Age", nullable = true)
    private Integer Age;

    @Column(name = "Gender", nullable = true)
    private String Gender;

    @Column(name = "VacationsDays", nullable = true)
    private Integer VacationsDays;

    @Column(name = "Skils", nullable = true)
    private String Skils;

    @Column(name = "Feedback", nullable = true)
    private String Feedback;
}
