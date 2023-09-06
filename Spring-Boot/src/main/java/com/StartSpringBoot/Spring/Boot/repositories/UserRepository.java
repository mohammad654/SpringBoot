package com.StartSpringBoot.Spring.Boot.repositories;

import com.StartSpringBoot.Spring.Boot.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
