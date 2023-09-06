package com.Capgemini.CapgeminiSpringBoot.service;

import com.Capgemini.CapgeminiSpringBoot.entity.User;

public interface UserService {
    User loadUserByEmail(String email);

    User createUser(String email, String password);

    void assignRoleToUser(String email, String roleName);
}
