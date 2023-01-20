package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

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
    @PostMapping("/users")
    public ResponseEntity<User> createUser( @Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping ("hello-world/path-variable/{name}")
    public  HelloWorldBean callName (@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
    @GetMapping ("/users")
    public List<User> getAllUser(){
        return userDaoService.findAll();
    }
    @GetMapping ("/user/{id}")
    public  User getOneUser(@PathVariable int id ){
           User user =userDaoService.findOneByID(id);
           if ( user ==null){
               throw new UserNotFoundException( "can't id : "+id);
           }
        return user;
    }

    @DeleteMapping ("/user/{id}")
    public void  deleteUserById(@PathVariable int id ){
        userDaoService.deleteById(id);
    }



}
