package com.example.convoconvert.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Calls")

public class Calls implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CallsID")
    private long id;

    @Column(name = "FullName", nullable = false)
    private String FullName;

    @Column(name = "audioText", nullable = false)
    private String audioText;

    @Column(name = "date", nullable = true)
    private Date date;

    @Column(name = "TextEntities", nullable = true)
    private String TextEntities;

    @Column(name = "time", nullable = true)
    private Time time;

    @Column(name = "star", nullable = true)
    private boolean star;

    @Column(name = "status", nullable = true)
    private String status;

    @Column(name = "keywords", nullable = true)
    private String keywords;

    @Column(name = "nerTags", nullable = true)
    private String nerTags;

    @Column(name = "entityClasses", nullable = true)
    private String entityClasses;

    @Column(name = "Trash", nullable = true)
    private boolean Trash;

    @ManyToOne
    @JoinColumn(name = "FKemployeeId", referencedColumnName = "EmployeeID")
    private Employee employee;

}
