package com.springcourse.springcor.dao;

import com.springcourse.springcor.entity.StudentEntity;
import com.springcourse.springcor.entity.UserEntity;
import com.springcourse.springcor.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentDao {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> getStudents() {
        return this.studentRepository.findAll();
    }

    public List<StudentEntity> getStudentsByLastName(String lastName) {
        return this.studentRepository.findAllByLastName(lastName);
    }

    public List<StudentEntity> findAllByLastNameAndFirstName(String firstName, String latsName) {
        return this.studentRepository.findAllByLastNameAndFirstName(firstName, latsName);
    }

    public List<StudentEntity> findAllByStart(String firstName) {
        return this.studentRepository.findAllByFirstNameStartingWith(firstName);
    }

    public List<StudentEntity> findAllByEnd(String firstName) {
        return this.studentRepository.findAllByFirstNameEndingWith(firstName);

    }

    public List<StudentEntity> findAllLike(String firstNameLike) {
        return this.studentRepository.findAllByFirstNameContaining(firstNameLike);
    }
    public List<StudentEntity> findAlDesc() {
        return this.studentRepository.findAllByOrderByFirstNameDesc();
    }
    public List<StudentEntity> findAlAsc() {
        return this.studentRepository.findAllByOrderByFirstNameAsc();
    }
    public List<StudentEntity> findAllSort() {
        return this.studentRepository.findAll(Sort.by(Sort.Direction.ASC,"lastName","firstName"));
    }
    public StudentEntity saveStudent(StudentEntity studentEntity) {
        return this.studentRepository.save(studentEntity);
    }
}
