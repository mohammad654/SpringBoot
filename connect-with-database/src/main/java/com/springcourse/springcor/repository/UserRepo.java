package com.springcourse.springcor.repository;

import com.springcourse.springcor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    //    Query
    @Query(value = "SELECT t FROM UserEntity t")
    List<UserEntity> getAll();

    @Query(value = "SELECT t FROM UserEntity t WHERE t.id=:id")
    UserEntity getById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE UserEntity t SET t.password=:password WHERE t.id=:id")
    void setPassword(String password, Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM UserEntity t WHERE t.id=:id")
    void deleteByID(Integer id);

    @Query(value = "select * from users order by id desc",nativeQuery = true)
    List<UserEntity> getAllNativeQuery();
}
