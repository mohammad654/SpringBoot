package com.example.demo.controller;

import com.example.demo.model.TestEntity;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TestEntity> getAllTest() {
        return testService.findAll();
    }

    @GetMapping(value = "/test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestEntity> getTestById(@PathVariable Long id) {
        TestEntity testEntity = testService.findById(id).orElse(null);
        if (testEntity != null) {
            return ResponseEntity.ok(testEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestEntity> createTest(@RequestBody TestEntity testEntity) {
        TestEntity createdTest = testService.save(testEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTest);
    }

    @DeleteMapping(value = "/test/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        testService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
