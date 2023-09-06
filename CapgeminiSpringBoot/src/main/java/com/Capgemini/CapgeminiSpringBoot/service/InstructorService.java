package com.Capgemini.CapgeminiSpringBoot.service;

import com.Capgemini.CapgeminiSpringBoot.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor loadInstructorById(Long instructorId);

    List<Instructor> findInstructorsByName(String name);

    Instructor loadInstructorByEmail(String email);

    Instructor createInstructor(String firstName, String lastName, String summary, String email, String password);

    Instructor updateInstructor(Instructor instructor);

    List<Instructor> fetchInstructors();

    void removeInstructor(Long instructorId);
}
