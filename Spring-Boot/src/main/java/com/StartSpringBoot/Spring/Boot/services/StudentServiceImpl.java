package com.StartSpringBoot.Spring.Boot.services;

import com.StartSpringBoot.Spring.Boot.models.entity.Student;
import com.StartSpringBoot.Spring.Boot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Integer saveStudent(Student student) {
        return studentRepository.save(student).getStudentId();
    }

    @Override
    public List<Student> getAllStudents() {
        return ( List<Student> ) studentRepository.findAll();
        //   StudentRepository
        //     return  studentRepository.findAll(student);
    }


    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
