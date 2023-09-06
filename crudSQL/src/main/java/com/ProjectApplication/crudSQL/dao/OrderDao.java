package com.ProjectApplication.crudSQL.dao;

import com.ProjectApplication.crudSQL.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDao {
    @Autowired
    private OrderRepo orderRepo;

}
