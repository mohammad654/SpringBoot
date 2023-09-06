package com.ProjectApplication.crudSQL.controller;

import com.ProjectApplication.crudSQL.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderDao orderDao;

}
