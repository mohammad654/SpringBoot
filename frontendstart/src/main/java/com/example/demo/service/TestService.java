package com.example.demo.service;

import com.example.demo.model.TestEntity;

import java.util.Optional;

public interface TestService {

    Iterable<TestEntity> findAll();
    Optional<TestEntity> findById(long id);
    TestEntity save(TestEntity testEntity);
    void deleteById( long id);
}
