package com.springcourse.springcor.controller;

import com.springcourse.springcor.dao.UserDao;
import com.springcourse.springcor.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
//    http://localhost:8080/users
    public Iterable<UserEntity> getAllUser() {
        return this.userDao.getAllUser();
    }

    @GetMapping("/getUserById")
//    http://localhost:8080/getUserById?id=12
    public Optional<UserEntity> getUserById(@RequestParam(name = "id") Integer userId) {
        return this.userDao.getUserById(userId);
    }

    //    . Get attributesFromEntity
    @GetMapping("/attributesFromEntity")
//    http://localhost:8080/getUserById?id=12
    public String attributesFromEntity(@RequestParam(name = "id") Integer userId) {
        Optional<UserEntity> userAttributesEntity = this.userDao.getUserById(userId);
        if (userAttributesEntity.isPresent()) {
            return "User name is : " + userAttributesEntity.get().getUsername() + " and Email is :" + userAttributesEntity.get().getEmail();
        } else {
            return "User ID not found!! ";
        }
    }

    @GetMapping("/deletedUserById")
//    http://localhost:8080/deletedUserById?id=11
    public String deleteUserById(@RequestParam(name = "id") Integer userId) {
        return this.userDao.deleteUserById(userId);
    }

    @PostMapping("save")
//    http://localhost:8080/save
//    {
//
//    "username": "wegklhwrlgnw",
//    "password": "jessica@123",
//    "email": "jessica@example.com"
//}
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return this.userDao.saveUser(userEntity);
    }

    @PostMapping("update")
//    http://localhost:8080/update
//    {
//    "userId": 12,
//    "username": "updated",
//    "password": "jessica@123",
//    "email": "jessica@example.com"
//}
    public UserEntity updateUser(@RequestBody UserEntity userEntity) {
        return this.userDao.saveUser(userEntity);
    }
//Query
@GetMapping("/queryAll")
//http://localhost:8080/queryAll
public List<UserEntity> queryAll() {
    return this.userDao.getAll();
}
@GetMapping("/queryId")
//http://localhost:8080/queryId?id=10

public UserEntity queryId(@RequestParam(name = "id") Integer userId ) {
    return this.userDao.getId(userId);
}
    @PostMapping("/restPass")
//    http://localhost:8080/restPass
    public void restPass(@RequestBody UserEntity userEntity) {
         this.userDao.setPassword(userEntity.getPassword(),userEntity.getUserId());
    }
    @GetMapping("/deleteQuery")
//    http://localhost:8080/deleteQuery?id=2
    public void deleteQuery(@RequestParam(name = "id") Integer userId) {
         this.userDao.deleteId(userId);
    }

    @GetMapping("/getAllNative")
//    http://localhost:8080/getAllNative
    public List<UserEntity> getAllNativeQuery() {
        return this.userDao.getAllNative();
    }
}
