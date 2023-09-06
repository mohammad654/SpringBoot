package com.ProjectApplication.crudSQL.repository;

import com.ProjectApplication.crudSQL.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {
}
