package com.StartSpringBoot.Spring.Boot.services;

import com.StartSpringBoot.Spring.Boot.models.entity.Student;

import java.util.List;

public interface StudentService {
    public Integer saveStudent(Student student);
    public List<Student>  getAllStudents();

    public Student getStudentById(Integer studentId);
    public void deleteStudent(Integer studentId);

}
