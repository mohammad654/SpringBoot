package com.ProjectApplication.crudSQL.repository;

import com.ProjectApplication.crudSQL.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepo extends JpaRepository<ProductEntity,Integer> {
    ProductEntity findProductByBarcode(String barcode);

}
