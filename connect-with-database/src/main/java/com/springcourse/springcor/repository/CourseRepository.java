package com.springcourse.springcor.repository;

import com.springcourse.springcor.entity.CourseEntity;
import com.springcourse.springcor.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
