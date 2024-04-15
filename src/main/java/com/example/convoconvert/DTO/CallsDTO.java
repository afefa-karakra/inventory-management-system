package com.example.convoconvert.DTO;

import java.util.Date;


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
    private Date date;

}
