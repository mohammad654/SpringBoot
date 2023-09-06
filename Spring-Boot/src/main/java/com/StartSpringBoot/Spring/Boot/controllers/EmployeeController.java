package com.StartSpringBoot.Spring.Boot.controllers;

import ch.qos.logback.core.model.Model;
import com.StartSpringBoot.Spring.Boot.models.dto.dto.EmployeeDTO;
import com.StartSpringBoot.Spring.Boot.models.entity.Employee;
import com.StartSpringBoot.Spring.Boot.models.entity.User;
import com.StartSpringBoot.Spring.Boot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    EmployeeService employeeService1 = new EmployeeService();

//    @GetMapping("/get")
//    public Employee getUser(@RequestParam Integer id) {
//        return this.employeeService.getUser(id);
//    }
//DTO
    @GetMapping("/get")
    public EmployeeDTO getUser(@RequestParam Integer id) {
        return this.employeeService.getUser(id);
    }
    @GetMapping("")
    public List<Employee> getAll() {
        return this.employeeService.getAll();
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Integer id) {
         employeeService.delete(id);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }



}
