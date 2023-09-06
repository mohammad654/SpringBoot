package com.Capgemini.CapgeminiSpringBoot.Repository;

import com.Capgemini.CapgeminiSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
