package com.StartSpringBoot.Spring.Boot.controllers;
//https://github.com/javaeplanet/Student-Application
import com.StartSpringBoot.Spring.Boot.models.entity.Student;
import com.StartSpringBoot.Spring.Boot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        Integer id=  studentService.saveStudent(student);
        return new ResponseEntity<String>("Student with'"+id+"' has been saved", HttpStatus.OK);
    }
    @PostMapping("/studentList")
    public ResponseEntity<List<Student>> getAllStudent(){
     List<Student> list=   studentService.getAllStudents();
     return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PostMapping("/studentId/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer id){
        Student studentID=   studentService.getStudentById(id);
        return new ResponseEntity<Student>(studentID,HttpStatus.OK);
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("studentId") Integer id,@RequestBody Student student){
        Student studentId=   studentService.getStudentById(id);
        studentId.setStudentName(student.getStudentName()); studentId.setStudentName(student.getStudentName());
        studentId.setSchool(student.getSchool());
            Integer studentUpdateId=studentService.saveStudent(studentId);
        return new ResponseEntity<String>("Student with'"+id+"' has been updated", HttpStatus.OK);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Integer id,@RequestBody Student student){
         studentService.deleteStudent(id);

        return new ResponseEntity<String>("Student with'"+id+"' has been deleted", HttpStatus.OK);
    }
}
