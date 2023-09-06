package com.ProjectApplication.crudSQL.dao;

import com.ProjectApplication.crudSQL.entity.ProductEntity;
import com.ProjectApplication.crudSQL.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDao {
    @Autowired
    private ProductRepo productRepo;
    public List<ProductEntity>  getAllProductsDao(){
        return this.productRepo.findAll();
    }
    public ProductEntity addProductDao(ProductEntity product){
        return this.productRepo.save(product);
    }

    public void deleteProductDao(Integer id){
         this.productRepo.deleteById(id);
    }


    public ProductEntity updateProductDao(ProductEntity product){
        return this.productRepo.save(product);
    }
    public ProductEntity getProductByBarCodeDao( String barcode){
        Optional<ProductEntity> o=Optional.ofNullable(this.productRepo.findProductByBarcode(barcode));
        return o.isPresent()?o.get():null ;
    }
    public ProductEntity getProductByIdDao( Integer id){
        Optional<ProductEntity> o=this.productRepo.findById(id);
        return o.isPresent()?o.get():null ;
    }
}
