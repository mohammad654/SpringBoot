package com.springcourse.springcor.dao;

import com.springcourse.springcor.entity.StudentsAddressEntity;
import com.springcourse.springcor.repository.StudentAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAddressDao {
    @Autowired
    private StudentAddressRepository studentAddressRepository;

    public List<StudentsAddressEntity> getStudentsAddress() {
        return this.studentAddressRepository.findAll();
    }
}
