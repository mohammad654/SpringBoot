package com.StartSpringBoot.Spring.Boot.repositories;

import com.StartSpringBoot.Spring.Boot.models.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


}
