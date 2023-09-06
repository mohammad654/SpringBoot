package com.SpringSecurity.Spring.Security.repository;

import com.SpringSecurity.Spring.Security.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUserName(String userName);
}
