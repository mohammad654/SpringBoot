package com.Capgemini.CapgeminiSpringBoot.service.impl;

import com.Capgemini.CapgeminiSpringBoot.Repository.RoleRepo;
import com.Capgemini.CapgeminiSpringBoot.Repository.UserRepo;
import com.Capgemini.CapgeminiSpringBoot.entity.Role;
import com.Capgemini.CapgeminiSpringBoot.entity.User;
import com.Capgemini.CapgeminiSpringBoot.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public User loadUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User createUser(String email, String password) {
        return userRepo.save(new User(email, password));
    }

    @Override
    public void assignRoleToUser(String email, String roleName) {
        User user = loadUserByEmail(email);
        Role role = roleRepo.findByName(roleName);
        user.assignRoleToUser(role);
    }
}
