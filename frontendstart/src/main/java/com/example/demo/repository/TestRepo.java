package com.example.demo.repository;
import com.example.demo.model.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepo extends CrudRepository<TestEntity, Long> {
//    Optional<TestEntity> findByName (String name);
}
