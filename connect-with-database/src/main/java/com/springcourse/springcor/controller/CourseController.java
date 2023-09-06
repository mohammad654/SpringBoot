package com.springcourse.springcor.controller;

import com.springcourse.springcor.dao.CourseDao;
import com.springcourse.springcor.dao.StudentDao;
import com.springcourse.springcor.entity.CourseEntity;
import com.springcourse.springcor.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseDao courseDao;
    @GetMapping("/courses")
//    http://localhost:8080/students
    public List<CourseEntity> getAllCourses(){
        return this.courseDao.getCourses();
    }


}
