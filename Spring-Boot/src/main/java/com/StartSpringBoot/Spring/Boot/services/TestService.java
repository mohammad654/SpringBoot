package com.StartSpringBoot.Spring.Boot.services;

import com.StartSpringBoot.Spring.Boot.models.entity.Test;
import com.StartSpringBoot.Spring.Boot.repositories.TestRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TestService {
    private TestRepo testRepo;

    @Autowired
    public void setEmployeeRepo(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    //    public void save(Employee employee) { this.employeeRepo.save(employee); }
    public Test save(Test test) {
        return this.testRepo.save(test);
    }

    public void delete(Integer id) {
        this.testRepo.deleteById(id);
    }



}
