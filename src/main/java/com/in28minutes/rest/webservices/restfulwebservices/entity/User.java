package com.in28minutes.rest.webservices.restfulwebservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  Integer id;
    private  String name ;
    private LocalDate birthDate;
}
