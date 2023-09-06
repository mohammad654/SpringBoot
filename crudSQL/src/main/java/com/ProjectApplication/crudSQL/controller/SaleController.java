package com.ProjectApplication.crudSQL.controller;

import com.ProjectApplication.crudSQL.dao.SaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sales")
@RestController
public class SaleController {
    @Autowired
    private SaleDao saleDao;

}
