package com.Capgemini.CapgeminiSpringBoot.service.impl;

import com.Capgemini.CapgeminiSpringBoot.Repository.CourseRepo;
import com.Capgemini.CapgeminiSpringBoot.Repository.InstructorRepo;
import com.Capgemini.CapgeminiSpringBoot.Repository.UserRepo;
import com.Capgemini.CapgeminiSpringBoot.entity.Course;
import com.Capgemini.CapgeminiSpringBoot.entity.Instructor;
import com.Capgemini.CapgeminiSpringBoot.entity.User;
import com.Capgemini.CapgeminiSpringBoot.service.CourseService;
import com.Capgemini.CapgeminiSpringBoot.service.InstructorService;
import com.Capgemini.CapgeminiSpringBoot.service.UserService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepo instructorRepo;
    private CourseService courseService;
    private UserService userService;

    public InstructorServiceImpl(InstructorRepo instructorRepo, CourseService courseService, UserService userService) {
        this.instructorRepo = instructorRepo;
        this.courseService = courseService;
        this.userService = userService;
    }

    @Override
    public Instructor loadInstructorById(Long instructorId) {
        return instructorRepo.findById(instructorId).orElseThrow(() -> new EntityNotFoundException("Instructor with id " + instructorId + " Not Found"));
    }

    @Override
    public List<Instructor> findInstructorsByName(String name) {
        return instructorRepo.findInstructorsByName(name);
    }

    @Override
    public Instructor loadInstructorByEmail(String email) {
        return instructorRepo.findInstructorByEmail(email);
    }

    @Override
    public Instructor createInstructor(String firstName, String lastName, String summary, String email, String password) {
//        User user = userRepo.createUser(email, password);
        User user = userService.createUser(email, password);
        userService.assignRoleToUser(email, "Instructor");
        return instructorRepo.save(new Instructor(firstName, lastName, summary, user));
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<Instructor> fetchInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public void removeInstructor(Long instructorId) {
        Instructor instructor = loadInstructorById(instructorId);
        for (Course course : instructor.getCourses()) {
            courseService.removeCourse(course.getCourseId());
        }
        instructorRepo.deleteById(instructorId);
    }

}
