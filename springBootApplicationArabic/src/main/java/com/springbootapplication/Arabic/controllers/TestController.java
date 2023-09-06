package com.springbootapplication.Arabic.controllers;

import com.springbootapplication.Arabic.dao.AutowiredClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private AutowiredClass autowiredClass;
    @GetMapping("/test")

    public String main(){
        return this.autowiredClass.name();
    }


}
