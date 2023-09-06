package com.springbootapplication.Arabic.controllers;

import com.springbootapplication.Arabic.dao.RestRegistrationDTO;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @GetMapping("/RequestParam")
   // http://localhost:8080/RequestParam?name=Mohammad&id=875958723
    public String main(@RequestParam String name, @RequestParam Integer id) {
        return "RequestParam : your name is : " + name + " and id is : " + id;
    }

    @GetMapping("/PathVariable/{name}")
//      http://localhost:8080/PathVariable/Mohammad
    public String mainParam(@PathVariable String name) {
        return "PathVariable : your name is : " + name;
    }

    @PostMapping("/registrationDTO")
//    http://localhost:8080/registrationDTO
    public String registrationDTO(@RequestBody RestRegistrationDTO registrationDTOString) {
        return "name is : " + registrationDTOString.getUserName() + " Email is : " + registrationDTOString.getPassword() + " Password is : " + registrationDTOString.getPassword();
    }

    @PostMapping("/registrationDTO/data")
//    http://localhost:8080/registrationDTO/data
    public RestRegistrationDTO registrationDTOData(@RequestBody RestRegistrationDTO RegistrationDTOJSON) {
        return RegistrationDTOJSON;
    }


}
