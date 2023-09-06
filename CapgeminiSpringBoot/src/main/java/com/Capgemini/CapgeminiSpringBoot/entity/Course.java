package com.Capgemini.CapgeminiSpringBoot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Basic
    @Column(name = "course_name", nullable = false, length = 45)
    private String courseName;
    @Basic
    @Column(name = "course_duration", nullable = false, length = 45)
    private String courseDuration;
    @Basic
    @Column(name = "course_description", nullable = false, length = 64)
    private String courseDescription;

    //hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId) && Objects.equals(courseName, course.courseName) && Objects.equals(courseDuration, course.courseDuration) && Objects.equals(courseDescription, course.courseDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, courseDuration, courseDescription);
    }

    //    toString
    @Override
    public String toString() {
        return "CourseRepo{" + "courseId=" + courseId + ", courseName='" + courseName + '\'' + ", courseDuration='" + courseDuration + '\'' + ", courseDescription='" + courseDescription + '\'' + '}';
    }

    public Course(String courseName, String courseDuration, String courseDescription, Instructor instructor) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
        this.instructor = instructor;
    }

    //  *-*  Every CourseRepo can combine a list of students
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "enrolled_in",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<Student> students = new HashSet<>();

    // one Instructor can have one of  many Courses
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id", nullable = false)
    private Instructor instructor;

    public void assignStudentToCourse(Student student) {
        this.students.add(student);
        student.getCourses().add(this);
    }

    public void removeStudentFromCours(Student student) {
        this.students.remove(student);
        student.getCourses().remove(this);
    }

    public void removeStudentFromCourse(Student student) {
    }
}
