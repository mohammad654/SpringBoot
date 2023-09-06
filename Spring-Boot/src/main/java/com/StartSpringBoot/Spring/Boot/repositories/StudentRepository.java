package com.StartSpringBoot.Spring.Boot.repositories;

import com.StartSpringBoot.Spring.Boot.models.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {
//    List<Student> findAll(Student student);
}
