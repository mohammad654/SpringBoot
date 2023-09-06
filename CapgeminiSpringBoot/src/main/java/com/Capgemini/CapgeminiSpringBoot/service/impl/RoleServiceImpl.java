package com.Capgemini.CapgeminiSpringBoot.service.impl;

import com.Capgemini.CapgeminiSpringBoot.Repository.RoleRepo;
import com.Capgemini.CapgeminiSpringBoot.entity.Role;
import com.Capgemini.CapgeminiSpringBoot.service.RoleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role loadRoleByName(String roleName) {
        return roleRepo.findByName(roleName);
    }

    @Override
    public Role createRole(String roleName) {
        return roleRepo.save(new Role(roleName));
    }
}
