package com.springcourse.springcor.controller;

import com.springcourse.springcor.dao.CourseDao;
import com.springcourse.springcor.dao.StudentAddressDao;
import com.springcourse.springcor.entity.CourseEntity;
import com.springcourse.springcor.entity.StudentsAddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentAddressController {
    @Autowired
    private StudentAddressDao studentAddressDao;
    @GetMapping("/address")
//    http://localhost:8080/students
    public List<StudentsAddressEntity> getAllStudentsAddress(){
        return this.studentAddressDao.getStudentsAddress();
    }


}
