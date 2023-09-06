package com.Capgemini.CapgeminiSpringBoot;

import com.Capgemini.CapgeminiSpringBoot.Repository.*;
import com.Capgemini.CapgeminiSpringBoot.entity.Course;
import com.Capgemini.CapgeminiSpringBoot.entity.Instructor;
import com.Capgemini.CapgeminiSpringBoot.entity.Student;
import com.Capgemini.CapgeminiSpringBoot.entity.User;
import com.Capgemini.CapgeminiSpringBoot.service.*;
import com.Capgemini.CapgeminiSpringBoot.utility.OperationUtility;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CapgeminiSpringBootApplication {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private InstructorRepo instructorRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private RoleRepo roleRepo;


    public static void main(String[] args) {
        SpringApplication.run(CapgeminiSpringBootApplication.class, args);
    }
//implements CommandLineRunner
//    @Override
//    public void run(String... args) throws Exception {
//        OperationUtility.usersOperations(userRepo);
//        OperationUtility.rolesOperations(roleRepo);
//        OperationUtility.assignRolesToUsers(userRepo,roleRepo);
//        OperationUtility.instructorsOperations(userRepo,instructorRepo,roleRepo);
//        OperationUtility.studentsOperations(userRepo, studentRepo, roleRepo);
//        OperationUtility.coursesOperations(courseRepo,instructorRepo, studentRepo);

//    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private InstructorService instructorService;


    public static final String ADMIN = "Admin";
    public static final String INSTRUCTOR = "Instructor";
    public static final String STUDENT = "Student";

//    @Bean
//    CommandLineRunner starter(UserService userService,
//                              RoleService roleService, CourseService courseService, StudentService studentService
//            , InstructorService instructorService) {
//
//        return args -> {
//            User user1 = userService.createUser("user1@gmail.com", "pass1");
//            User user2 = userService.createUser("user2@gmail.com", "pass2");
//
//            roleService.createRole(ADMIN);
//            roleService.createRole(INSTRUCTOR);
//            roleService.createRole(STUDENT);
//
//            userService.assignRoleToUser(user1.getEmail(), ADMIN);
//            userService.assignRoleToUser(user1.getEmail(), INSTRUCTOR);
//            userService.assignRoleToUser(user2.getEmail(), STUDENT);
//
//            Instructor instructor1 = instructorService.createInstructor("instructor1FN", "instructor1LN", "Experienced Instructor", "instructorUser1@gmail.com", "pass1");
//            Instructor instructor2 = instructorService.createInstructor("instructor2FN", "instructor2LN", "Senior Instructor", "instructorUser2@gmail.com", "pass2");
//
//            Student student1 = studentService.createStudent("std1FN", "std1LN", "beginner", "stdUser1@gmail.com", "pass1");
//            Student student2 = studentService.createStudent("std2FN", "std2LN", "master degree", "stdUser2@gmail.com", "pass2");
//
//            Course course1 = courseService.createCourse("Spring Service", "2 Hours", "Master Spring Service", instructor1.getInstructorId());
//            Course course2 = courseService.createCourse("Spring Data JPA", "4 Hours", "Introduction to JPA", instructor2.getInstructorId());
//
//            courseService.assignStudentToCourse(course1.getCourseId(), student1.getStudentId());
//            courseService.assignStudentToCourse(course2.getCourseId(), student2.getStudentId());
//        };
//    }
@Bean
public LayoutDialect layoutDialect() {
    return new LayoutDialect();
}
}

