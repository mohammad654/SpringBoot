package com.springcourse.springcor.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
    @GetMapping("/main")
//    http://localhost:8080/main
    public String getMainPage() {
        return "main";
    }
    @GetMapping("/about")
//    http://localhost:8080/about
    public String getAboutPage() {
        return "about";
    }
}
