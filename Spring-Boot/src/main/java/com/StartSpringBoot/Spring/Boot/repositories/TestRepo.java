package com.StartSpringBoot.Spring.Boot.repositories;
import com.StartSpringBoot.Spring.Boot.models.entity.Speakers;
import com.StartSpringBoot.Spring.Boot.models.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TestRepo extends JpaRepository<Test,Integer> {

}
