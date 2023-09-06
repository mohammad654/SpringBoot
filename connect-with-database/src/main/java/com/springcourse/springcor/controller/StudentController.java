package com.springcourse.springcor.controller;

import com.springcourse.springcor.dao.StudentDao;
import com.springcourse.springcor.entity.StudentEntity;
import com.springcourse.springcor.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "api")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentDao studentDao;
    @GetMapping("/students")
//    http://localhost:8080/students
    public List<StudentEntity> getAllStudents(){
        return this.studentDao.getStudents();
    }
    @GetMapping("/getByLastName")
//    http://localhost:8080/getByLastName?lastName=Brown
    public List<StudentEntity> getByLastName(String lastName){
        return this.studentDao.getStudentsByLastName(lastName);
    }
    @GetMapping("/findAllByLastNameAndFirstName")
//    http://localhost:8080/getByLastName?firstName=Olivia&lastName=Brown
    public List<StudentEntity> findAllByLastNameAndFirstName(@RequestParam String firstName, String lastName){
        return this.studentDao.findAllByLastNameAndFirstName(firstName,lastName);
    }
    @GetMapping("/findAllByFirstNameStart")
//    http://localhost:8080/findAllByFirstNameStart?firstName=s
    public List<StudentEntity> findAllStart(@RequestParam String firstName){
        return this.studentDao.findAllByStart(firstName);
    }
    @GetMapping("/findAllByFirstNameEnd")
//    http://localhost:8080/findAllByFirstNameEnd?firstName=e
    public List<StudentEntity> findAllByFirstNameEnd(@RequestParam String firstName){
        return this.studentDao.findAllByEnd(firstName);
    }
    @GetMapping("/findAllByFirstNameContaining")
//    http://localhost:8080/findAllByFirstNameContaining?firstNameLike=ew
    public List<StudentEntity> findAllFirstNameContaining(@RequestParam String firstNameLike){
        return this.studentDao.findAllLike(firstNameLike);
    }
    @GetMapping("/findAllByOrderByAsc")
//    http://localhost:8080/findAllByOrderByAsc
    public List<StudentEntity> findAllByAsc(){
        return this.studentDao.findAlAsc();
    }
    @GetMapping("/findAllByOrderByDesc")
//    http://localhost:8080/findAllByOrderByDesc
    public List<StudentEntity> findAllByDesc(){
        return this.studentDao.findAlDesc();
    }
    @GetMapping("/findAllSort")
//    http://localhost:8080/findAllSort
    public List<StudentEntity> findAllSort(){
        return this.studentDao.findAllSort();
    }
    @PostMapping("/saveStudent")
    public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity) {
        return this.studentDao.saveStudent(studentEntity);
    }

}
