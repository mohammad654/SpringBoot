package com.Capgemini.CapgeminiSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HomeController {
    @GetMapping(value = "/")
    public String homePage() {
        return "home" ;
    }
//    @GetMapping(value = "/403")
//    public String notAuthorized() {
//        return "403";
//    }
}
