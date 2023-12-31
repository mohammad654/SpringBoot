package com.Capgemini.CapgeminiSpringBoot.Repository;

import com.Capgemini.CapgeminiSpringBoot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
