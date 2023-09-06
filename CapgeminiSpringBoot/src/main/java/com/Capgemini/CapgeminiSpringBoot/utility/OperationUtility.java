package com.Capgemini.CapgeminiSpringBoot.utility;

import com.Capgemini.CapgeminiSpringBoot.Repository.*;
import com.Capgemini.CapgeminiSpringBoot.entity.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class OperationUtility {
    public static void usersOperations(UserRepo userRepo) {
        createUsers(userRepo);
        //  updateUser(userRepo);
        //  deleteUser(userRepo);
        //  fetchUsers(userRepo);
    }

    private static void createUsers(UserRepo userRepo) {
        User user1 = new User("user1@gmail.com", "pass1");
        userRepo.save(user1);
        User user2 = new User("user2@gmail.com", "pass2");
        userRepo.save(user2);
        User user3 = new User("user3@gmail.com", "pass3");
        userRepo.save(user3);
        User user4 = new User("user4@gmail.com", "pass4");
        userRepo.save(user4);
    }

    private static void updateUser(UserRepo userRepo) {
        User user = userRepo.findById(2L).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        user.setEmail("newEmail@gmail.com");
        userRepo.save(user);
    }

    private static void deleteUser(UserRepo userRepo) {
        User user = userRepo.findById(3L).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        userRepo.delete(user);
    }


    private static void fetchUsers(UserRepo userRepo) {
        userRepo.findAll().forEach(user -> System.out.println(user.toString()));
    }
//Roles


    public static void rolesOperations(RoleRepo roleRepo) {
        createRoles(roleRepo);
        //   updateRole(roleRepo);
        //   deleteRole(roleRepo);
        //   fetchRole(roleRepo);
    }

    private static void createRoles(RoleRepo roleRepo) {
        Role role1 = new Role("Admin");
        roleRepo.save(role1);
        Role role2 = new Role("Instructor");
        roleRepo.save(role2);
        Role role3 = new Role("Student");
        roleRepo.save(role3);
    }

    private static void updateRole(RoleRepo roleRepo) {
        Role role = roleRepo.findById(1L).orElseThrow(() -> new EntityNotFoundException("Role Not Found"));
        role.setName("NewAdmin");
        roleRepo.save(role);
    }

    private static void deleteRole(RoleRepo roleRepo) {
        roleRepo.deleteById(2L);
    }

    private static void fetchRole(RoleRepo roleRepo) {
        roleRepo.findAll().forEach(role -> System.out.println(role.toString()));
    }

    public static void assignRolesToUsers(UserRepo userRepo, RoleRepo roleRepo) {
        Role role = roleRepo.findByName("Admin");
        if (role == null) throw new EntityNotFoundException("Role Not Found");
        List<User> users = userRepo.findAll();
        users.forEach(user -> {
            user.assignRoleToUser(role);
            userRepo.save(user);
        });
    }
//instructorsOperations


    public static void instructorsOperations(UserRepo userRepo, InstructorRepo instructorRepo, RoleRepo roleRepo) {
        createInstructors(userRepo, instructorRepo, roleRepo);
//        updateInstructor(instructorRepo);
//        removeInstructor(instructorRepo);
//        fetchInstructors(instructorRepo);
    }

    private static void createInstructors(UserRepo userRepo, InstructorRepo instructorRepo, RoleRepo roleRepo) {
        Role role = roleRepo.findByName("Instructor");
        if (role == null) throw new EntityNotFoundException("Role Not Found");

        User user1 = new User("instructorUser1@gmail.com", "pass1");
        user1.assignRoleToUser(role);
        userRepo.save(user1);
        Instructor instructor1 = new Instructor("instructor1FN", "instructor1LN", "Experienced Instructor", user1);
        instructorRepo.save(instructor1);

        User user2 = new User("instructorUser2@gmail.com", "pass2");
        user2.assignRoleToUser(role);
        userRepo.save(user2);
        Instructor instructor2 = new Instructor("instructor2FN", "instructor2LN", "Senior Instructor", user2);
        instructorRepo.save(instructor2);

    }

    private static void updateInstructor(InstructorRepo instructorRepo) {
        Instructor instructor = instructorRepo.findById(1L).orElseThrow(() -> new EntityNotFoundException("Instructor Not Found"));
        instructor.setSummary("Certified Instructor");
        instructorRepo.save(instructor);
    }

    private static void removeInstructor(InstructorRepo instructorRepo) {
        instructorRepo.deleteById(2L);
    }

    private static void fetchInstructors(InstructorRepo instructorRepo) {
        instructorRepo.findAll().forEach(instructor -> System.out.println(instructor.toString()));
    }

    public static void studentsOperations(UserRepo userRepo, StudentRepo studentRepo, RoleRepo roleRepo) {
        createStudents(userRepo, studentRepo, roleRepo);
        // updateStudent(studentRepo);
        // removeStudent(studentRepo);
        // fetchStudents(studentRepo);
    }

    private static void createStudents(UserRepo userRepo, StudentRepo studentRepo, RoleRepo roleRepo) {
        Role role = roleRepo.findByName("Student");
        if (role == null) throw new EntityNotFoundException("Role Not Found");

        User user1 = new User("stdUser1@gmail.com", "pass1");
        user1.assignRoleToUser(role);
        userRepo.save(user1);
        Student student1 = new Student("student1FN", "student1LN", "master", user1);
        studentRepo.save(student1);

        User user2 = new User("stdUser2@gmail.com", "pass2");
        user2.assignRoleToUser(role);
        userRepo.save(user2);
        Student student2 = new Student("student2FN", "student2LN", "Phd", user2);
        studentRepo.save(student2);
    }

    private static void updateStudent(StudentRepo studentRepo) {
        Student student = studentRepo.findById(2L).orElseThrow(() -> new EntityNotFoundException("Student Not Found"));
        student.setFirstName("updatedStdFN");
        student.setLastName("updatedStdLN");
        studentRepo.save(student);
    }

    private static void removeStudent(StudentRepo studentRepo) {
        studentRepo.deleteById(2L);
    }

    private static void fetchStudents(StudentRepo studentRepo) {
        studentRepo.findAll().forEach(student -> System.out.println(student.toString()));
    }

    public static void coursesOperations(CourseRepo courseRepo, InstructorRepo instructorRepo, StudentRepo studentRepo) {
//         createCourses(courseRepo, instructorRepo);
        // updateCourse(courseRepo);
        // deleteCourse(courseRepo);
        // fetchCourses(courseRepo);
         assignStudentsToCourse(courseRepo, studentRepo);
//        fetchCoursesForStudent(courseRepo);
    }

    private static void createCourses(CourseRepo courseRepo, InstructorRepo instructorRepo) {
        Instructor instructor = instructorRepo.findById(1L).orElseThrow(() -> new EntityNotFoundException("Instructor Not Found"));

        Course course1 = new Course("Hibernate", "5 Hours", "Introduction to Hibernate", instructor);
        courseRepo.save(course1);
        Course course2 = new Course("Spring Data JPA", "10 Hours", "Master Spring Data JPA", instructor);
        courseRepo.save(course2);
    }

    private static void updateCourse(CourseRepo courseRepo) {
        Course course = courseRepo.findById(1L).orElseThrow(() -> new EntityNotFoundException("CourseRepo Not Found"));
        course.setCourseDuration("20 Hours");
        courseRepo.save(course);
    }

    private static void deleteCourse(CourseRepo courseRepo) {
        courseRepo.deleteById(2L);
    }

    private static void fetchCourses(CourseRepo courseRepo) {
        courseRepo.findAll().forEach(course -> System.out.println(course.toString()));
    }

    private static void assignStudentsToCourse(CourseRepo courseRepo, StudentRepo studentRepo) {
        Optional<Student> student1 = studentRepo.findById(1L);
        Optional<Student> student2 = studentRepo.findById(2L);
        Course course = courseRepo.findById(1L).orElseThrow(() -> new EntityNotFoundException("CourseRepo Not Found"));

        student1.ifPresent(course::assignStudentToCourse);
        student2.ifPresent(course::assignStudentToCourse);
        courseRepo.save(course);
    }

    private static void fetchCoursesForStudent(CourseRepo courseRepo) {
        courseRepo.getCoursesByStudentId(1L).forEach(course -> System.out.println(course.toString()));
    }

}
