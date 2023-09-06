package com.StartSpringBoot.Spring.Boot.repositories;

import com.StartSpringBoot.Spring.Boot.models.entity.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Sessions,Long> {
}
