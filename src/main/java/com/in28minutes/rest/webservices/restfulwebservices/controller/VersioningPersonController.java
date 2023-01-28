package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.entity.Name;
import com.in28minutes.rest.webservices.restfulwebservices.entity.PersonV1;
import com.in28minutes.rest.webservices.restfulwebservices.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public  PersonV1 getFirstVersionPerson (){
        return  new PersonV1("Yêu Hồng Ngọc");
    }


    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionPerson (){
        return  new PersonV2(new Name("HONG ","NGOC"));
    }
}
