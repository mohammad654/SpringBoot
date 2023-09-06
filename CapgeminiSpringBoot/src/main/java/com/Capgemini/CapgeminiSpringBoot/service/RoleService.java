package com.Capgemini.CapgeminiSpringBoot.service;

import com.Capgemini.CapgeminiSpringBoot.entity.Role;

public interface RoleService {
    Role loadRoleByName(String roleName);

    Role createRole(String roleName);

}
