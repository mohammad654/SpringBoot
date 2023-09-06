package com.ProjectApplication.crudSQL.dao;

import com.ProjectApplication.crudSQL.repository.SaleReo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleDao {
    @Autowired
    private SaleReo saleReo;
}
