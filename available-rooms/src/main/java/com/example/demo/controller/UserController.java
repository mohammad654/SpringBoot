package com.example.demo.controller;

import com.example.demo.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {

    protected static final Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping(value = "/user", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getLoggedInUser(){

        return ResponseEntity.ok().body(new User());




    }
}
