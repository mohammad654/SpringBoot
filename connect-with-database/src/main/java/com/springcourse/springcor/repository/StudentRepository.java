package com.springcourse.springcor.repository;

import com.springcourse.springcor.entity.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findAllByLastName(String lastName);
    List<StudentEntity> findAllByFirstNameStartingWith(String firstName);
    List<StudentEntity> findAllByFirstNameEndingWith(String firstName);
    List<StudentEntity> findAllByFirstNameContaining(String firstNameLike);
    List<StudentEntity> findAllByLastNameAndFirstName(String firstName, String lastName);
    List<StudentEntity> findAllByOrderByFirstNameDesc();
    List<StudentEntity> findAllByOrderByFirstNameAsc();

}
