package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorld {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/HellWorld")
    public String helloWorld (){

        return  "hi em";
    }
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean (){

        return  new HelloWorldBean("message");
    }

    @GetMapping ("hello-world/path-variable/{name}")
    public  HelloWorldBean callName (@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping ("/users")
    public List<User> getAllUser(){
        return ResponseEntity.created(201).body()
    }

    @GetMapping ("/user/{id}")
    public  User getOneUser(@PathVariable int id ){

        return userDaoService.findOneByID(id);
    }

    @PostMapping("/user")
    public User save(@RequestBody User user){

        return  userDaoService.add(user);
    }

}
