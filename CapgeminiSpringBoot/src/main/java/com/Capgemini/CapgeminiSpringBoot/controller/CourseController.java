package com.Capgemini.CapgeminiSpringBoot.controller;

import com.Capgemini.CapgeminiSpringBoot.entity.Course;
import com.Capgemini.CapgeminiSpringBoot.entity.Instructor;
import com.Capgemini.CapgeminiSpringBoot.service.CourseService;
import com.Capgemini.CapgeminiSpringBoot.service.InstructorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/courses")

@NoArgsConstructor
public class CourseController {
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    private CourseService courseService;
    @Autowired
    private InstructorService instructorService;

    @GetMapping(value = "/index")
    public String courses(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Course> courses = courseService.findCoursesByCourseName(keyword);
        model.addAttribute("listCourses", courses);
        model.addAttribute("keyword", keyword);
        return "course-views/courses";
    }

    @GetMapping(value = "/delete")
    public String deleteCourse(Long courseId, String keyword) {
        courseService.removeCourse(courseId);
        return "redirect:/courses/index?keyword=" + keyword;
    }

    @GetMapping(value = "/formUpdate")
    public String updateCourse(Model model, Long courseId) {
        Course course = courseService.loadCourseById(courseId);
        List<Instructor> instructors = instructorService.fetchInstructors();
        model.addAttribute("course", course);
        model.addAttribute("listInstructors", instructors);
        return "course-views/formUpdate";
    }

    @GetMapping(value = "/formCreate")
    public String formCourses(Model model) {
        List<Instructor> instructors = instructorService.fetchInstructors();
        model.addAttribute("listInstructors", instructors);
        model.addAttribute("course", new Course());
        return "course-views/formCreate";
    }

    @PostMapping(value = "/save")
    public String save(Course course) {
        courseService.createOrUpdateCourse(course);
        return "redirect:/courses/index";
    }
    @GetMapping(value = "/index/student")
    public String coursesForCurrentStudent(Model model) {
        Long studentId = 2L; // current student
        List<Course> subscribedCourses = courseService.fetchCoursesForStudent(studentId);
        List<Course> otherCourses = courseService.fetchAll().stream().filter(course -> !subscribedCourses.contains(course)).collect(Collectors.toList());
        model.addAttribute("listCourses", subscribedCourses);
        model.addAttribute("otherCourses", otherCourses);
        return "course-views/student-courses";
    }
    @GetMapping(value = "/enrollStudent")
    public String enrollCurrentStudentInCourse(Long courseId) {
        Long studentId = 2L;
        courseService.assignStudentToCourse(courseId, studentId);
        return "redirect:/courses/index/student";
    }
    @GetMapping(value = "/index/instructor")
    public String coursesForCurrentInstructor(Model model) {
        Long instructorId = 1L; // current Instructor
        Instructor instructor = instructorService.loadInstructorById(instructorId);
        model.addAttribute("listCourses", instructor.getCourses());
        return "course-views/instructor-courses";
    }
    @GetMapping(value = "/instructor")
//    http://localhost:8080/courses/instructor?instructorId=2
    public String coursesByInstructorId(Model model, Long instructorId) {
        Instructor instructor = instructorService.loadInstructorById(instructorId);
        model.addAttribute("listCourses", instructor.getCourses());
        return "course-views/instructor-courses";
    }
}
