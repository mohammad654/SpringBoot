package com.springcourse.springcor.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String user;
    @Column(name = "is_active")
    private String isActive;
    //    OneToOne  DataBase
    @JsonManagedReference
    @OneToOne(mappedBy = "studentEntity")
    private StudentsAddressEntity studentsAddressEntity;

    //    OneToMany  DataBase
    @JsonManagedReference
    @OneToMany(mappedBy = "studentEntity")
    private List<CourseEntity> courseEntities;
    //   ManyToMany  DataBase
    @JsonManagedReference
    @OneToMany(mappedBy = "studentEntity")
    private List<StudentCourseEntity> studentCourseEntity;

}
