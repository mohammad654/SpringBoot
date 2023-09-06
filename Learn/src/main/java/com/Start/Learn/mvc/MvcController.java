package com.Start.Learn.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
    // http://localhost:9090/account
    @GetMapping("/account")
    public String homePage() {
        System.out.println("Inside homePage");
        return "index";
    }
    @GetMapping("/test")
    public String testPage() {
        System.out.println("Inside testPage");
        return "test";
    }
}
