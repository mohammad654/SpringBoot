package com.springcourse.springcor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long courseId;
    @Column(name = "student_id")
    private Long studentCId;
    @Column(name = "course_name")
    private String course;
    @Column(name = "course_description")
    private String description;
    //    OneToMany  DataBase
    @JsonBackReference
    @JoinColumn(name="student_id",insertable = false,updatable = false)

    @ManyToOne(fetch = FetchType.LAZY)
    private StudentEntity studentEntity;
    //   ManyToMany  DataBase
    @JsonManagedReference
   @OneToMany(mappedBy = "courseEntity")
    private List<StudentCourseEntity> studentCourseEntity;
}
