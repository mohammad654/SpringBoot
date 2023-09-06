package com.StartSpringBoot.Spring.Boot;

import com.StartSpringBoot.Spring.Boot.models.entity.Employee;

public class Tester {

    public static void main(String[] args) {
        Employee employee = Employee.builder()
                .id(2)
                .lastName("")

                .build();


    }
}
