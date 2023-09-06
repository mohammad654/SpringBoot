package com.springcourse.springcor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "studentsaddress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentsAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentAddressId;
    @Column(name = "student_id")
    private Long studentCId;
    @Column(name = "address")
    private String studentAddress;
    //    OneToOne  DataBase
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private StudentEntity studentEntity;
}
