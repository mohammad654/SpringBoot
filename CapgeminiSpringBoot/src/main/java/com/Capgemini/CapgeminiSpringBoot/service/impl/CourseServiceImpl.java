package com.Capgemini.CapgeminiSpringBoot.service.impl;


import com.Capgemini.CapgeminiSpringBoot.Repository.CourseRepo;
import com.Capgemini.CapgeminiSpringBoot.Repository.InstructorRepo;
import com.Capgemini.CapgeminiSpringBoot.Repository.StudentRepo;
import com.Capgemini.CapgeminiSpringBoot.entity.Course;
import com.Capgemini.CapgeminiSpringBoot.entity.Instructor;
import com.Capgemini.CapgeminiSpringBoot.entity.Student;
import com.Capgemini.CapgeminiSpringBoot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired

    private InstructorRepo instructorRepo;
    @Autowired
    private StudentRepo studentRepo;

    public CourseServiceImpl(CourseRepo courseRepo, InstructorRepo instructorRepo, StudentRepo studentRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public Course loadCourseById(Long courseId) {
        return courseRepo.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course with id " + courseId + " Not Found"));
    }

    @Override
    public Course createCourse(String courseName, String courseDuration, String courseDescription, Long instructorId) {
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow(() -> new EntityNotFoundException("Instructor with id " + instructorId + " Not Found"));
        return courseRepo.save(new Course(courseName, courseDuration, courseDescription, instructor));
    }

    @Override
    public Course createOrUpdateCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> findCoursesByCourseName(String keyword) {
        return courseRepo.findCoursesByCourseNameContains(keyword);
    }

    @Override
    public void assignStudentToCourse(Long courseId, Long studentId) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " Not Found"));
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course with id " + courseId + " Not Found"));
        course.assignStudentToCourse(student);
    }

    @Override
    public List<Course> fetchAll() {
        return courseRepo.findAll();
    }

    @Override
    public List<Course> fetchCoursesForStudent(Long studentId) {
        return courseRepo.getCoursesByStudentId(studentId);
    }

    @Override
    public void removeCourse(Long courseId) {
        courseRepo.deleteById(courseId);
    }

}
