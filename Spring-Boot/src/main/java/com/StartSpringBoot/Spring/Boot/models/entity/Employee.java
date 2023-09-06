package com.StartSpringBoot.Spring.Boot.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "employees")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeID")
    private Integer id;
    @Column(name = "first_name")

    private String firstName;
    @Column(name = "last_name")
    private String lastName;
//    @Transient
//    @JsonIgnore
    private double salary;
}
