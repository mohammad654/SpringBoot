package com.springcourse.springcor.dao;

import com.springcourse.springcor.entity.CourseEntity;
import com.springcourse.springcor.entity.StudentEntity;
import com.springcourse.springcor.repository.CourseRepository;
import com.springcourse.springcor.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDao {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> getCourses() {
        return this.courseRepository.findAll();
    }
}
