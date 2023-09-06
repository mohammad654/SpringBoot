package com.ProjectApplication.crudSQL.controller;

import com.ProjectApplication.crudSQL.dao.ProductDao;
import com.ProjectApplication.crudSQL.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/products")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {
    @Autowired
    private ProductDao productDao;
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(Model md){
//        md.addAttribute("products", productDao.getAllProductsDao());
//        return "index";
//    }
    @GetMapping(value="/all" ,produces = "application/json")
//    http://localhost:8080/products/all
    public List<ProductEntity> getAllProductsController(){
        return this.productDao.getAllProductsDao();
    }
    @PostMapping("/add")
//    http://localhost:8080/products/add
    public ProductEntity addProductController(@RequestBody ProductEntity product){
        return this.productDao.addProductDao(product);
    }

//    @GetMapping("/delete")
////    http://localhost:8080/products/delete?id=2
//    public String deleteProductController(@RequestParam Integer id){
//        this.productDao.deleteProductDao(id);
//        return "Success";
//    }
//@GetMapping("/delete/{productId}")
//public String deleteProductController(@PathVariable Integer productId){
//    this.productDao.deleteProductDao(productId);
//    return "redirect:/";
//}

    @PostMapping("/update")
//    http://localhost:8080/products/update
//    {
//    "productId": 1,
//    "productName": "Upadte",
//    "productPrice": 55.2,
//    "barcode": "111"
//}
    public ProductEntity updateProductController(@RequestBody ProductEntity product){
        return this.productDao.updateProductDao(product);
    }
    @GetMapping("/barcode")
//    http://localhost:8080/products/barcode?barcode=111
    public ProductEntity getProductByBarCodeController(@RequestParam String barcode){
        return this.productDao.getProductByBarCodeDao(barcode);
    }
//    http://localhost:8080/products/id?id=1
    @GetMapping("/id")
    public ProductEntity getProductByIdController(@RequestParam Integer id){
        return this.productDao.getProductByIdDao(id);
    }


}