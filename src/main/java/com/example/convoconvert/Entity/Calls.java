package com.example.convoconvert.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "audioText", nullable = false)
    private String audioText;

    @Column(name = "date", nullable = true)
    private Date date;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerIdFK", referencedColumnName = "id")
    private Customer customer;*/
}
