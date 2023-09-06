package com.StartSpringBoot.Spring.Boot.services;

import com.StartSpringBoot.Spring.Boot.models.dto.dto.EmployeeDTO;
import com.StartSpringBoot.Spring.Boot.models.entity.Employee;
import com.StartSpringBoot.Spring.Boot.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {
    private EmployeeRepo employeeRepo;

    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

//    public Employee getUser(Integer id) {
//        Optional<Employee> emp = employeeRepo.findById(id);
//        return emp.orElse(new Employee());
//        // return emp.orElse(null);
//        //      if (emp.isPresent()){
////          return emp.get();
////       }
////        return null;
//    }

//    TDO
    public EmployeeDTO getUser(Integer id) {
        Optional<Employee> emp = this.employeeRepo.findById(id);
        if (emp.isPresent())
            return EmployeeDTO.fromEntityToDto(emp.get());
        else
            return null;
    }

//    public void save(Employee employee) { this.employeeRepo.save(employee); }
    public Employee save(Employee employee) {
        return this.employeeRepo.save(employee);
    }

    public void delete(Integer id) {
        this.employeeRepo.deleteById(id);
    }
    public Employee update(Employee employee) {
        return this.employeeRepo.save(employee);
    }

    public List<Employee> getAll() {
        return this.employeeRepo.findAll();
    }
}
