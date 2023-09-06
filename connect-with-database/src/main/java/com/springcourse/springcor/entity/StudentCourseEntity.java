package com.springcourse.springcor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "studentcourses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseEntity {
@Transient
    private String course;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long StudentCourseEntityId;
    @Column(name = "student_id")
    private Long studentCId;
    @Column(name = "course_id")
    private Long courseId;

    //    OneToMany  DataBase
    @JsonBackReference
    @ManyToOne
    @JoinColumn( name="student_id",insertable = false,updatable = false)
    private StudentEntity studentEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn( name="course_id",insertable = false,updatable = false)
    private CourseEntity courseEntity;
    public String getCourse() {
        return this.courseEntity.getCourse();
    }
}
