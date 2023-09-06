package com.example.demo.service;

import com.example.demo.model.TestEntity;
import com.example.demo.repository.TestRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {
    private TestRepo testRepository;

    public TestServiceImpl(TestRepo testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Iterable<TestEntity> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Optional<TestEntity> findById(long id) {
        return testRepository.findById(id);
    }

    @Override
    public TestEntity save(TestEntity testEntity) {
        return testRepository.save(testEntity);
    }

    @Override
    public void deleteById(long id) {
        testRepository.deleteById(id);
    }
}
