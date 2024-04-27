package com.example.convoconvert.DTO;

import java.sql.Date;
import java.sql.Struct;
import java.sql.Time;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.ConstructorParameters;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CallsDTO {

    private long id;
    private String audioText;
    private String TextEntities;
    private Time time;
    private Date date;
    private boolean star;
    private String status;
    private String keywords;
    private String nerTags;
    private String entityClasses;
    private boolean Trash;

}
