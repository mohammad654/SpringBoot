package com.springcourse.springcor.dao;


import com.springcourse.springcor.entity.UserEntity;
import com.springcourse.springcor.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDao {
    @Autowired
    private UserRepo userRepo;

    public List<UserEntity> getAllUser() {
        return this.userRepo.findAll();
    }

    public Optional<UserEntity> getUserById(Integer id) {
        return this.userRepo.findById(id);
    }

    public String deleteUserById(Integer id) {
        Optional<UserEntity> user = this.getUserById(id);
        if (user.isPresent()) {
            this.userRepo.deleteById(id);
            return "User is deleted.";
        } else {
            return "User not exists.";
        }
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return this.userRepo.save(userEntity);
    }

    public UserEntity updateUser(UserEntity userEntity) {
        Optional<UserEntity> user = this.getUserById(userEntity.getUserId());
        if (user.isPresent()) {
            return this.userRepo.save(userEntity);
        } else {
            return null;
        }
    }

    //Query
    public List<UserEntity> getAll() {
        return this.userRepo.getAll();
    }

    public UserEntity getId(Integer id) {
        return this.userRepo.getById(id);
    }

    public void setPassword(String password, Integer id) {
        this.userRepo.setPassword(password, id);
    }

    public void deleteId(Integer id) {
        this.userRepo.deleteByID(id);
    }

    public List<UserEntity> getAllNative() {
        return this.userRepo.getAllNativeQuery();
    }
}
    