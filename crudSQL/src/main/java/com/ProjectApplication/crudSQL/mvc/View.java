package com.ProjectApplication.crudSQL.mvc;

import com.ProjectApplication.crudSQL.dao.ProductDao;

import com.ProjectApplication.crudSQL.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class View {

    @Autowired
    private ProductDao productDao;

    //Index Page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model md) {
        md.addAttribute("products", productDao.getAllProductsDao());
        return "index";
    }

    @PostMapping("/addPr")
//    http://localhost:8080/addPr
    public String addProductController(@ModelAttribute ProductEntity product) {
        productDao.addProductDao(product);
        return "redirect:/";
    }

    @PostMapping("/saveEdit")
//    http://localhost:8080/addPr
    public String editProductController(@ModelAttribute ProductEntity product) {
        productDao.addProductDao(product);
        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String add() {
        return "save";
    }

    @RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
    public String edit(@PathVariable("productId") int productId, Model md) {
//        productDao  product= productDao.getProductByIdDao(productId);
        md.addAttribute("product", productDao.getProductByIdDao(productId));
        return "edit";
    }

    @RequestMapping(value = "/view/{productId}", method = RequestMethod.GET)
    public String view(@PathVariable("productId") int productId, Model md  ) {
        md.addAttribute("product", productDao.getProductByIdDao(productId));
        return "view";
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String getId(@PathVariable("productId") int productId, Model md) {
        md.addAttribute("product", productDao.getProductByIdDao(productId));
        return "id";
    }

    @GetMapping("/delete/{productId}")
//    http://localhost:8080/products/delete?id=2
    public String deleteProductController(@PathVariable("productId") int productId) {
        this.productDao.deleteProductDao(productId);
        return "redirect:/";
    }


    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }


}
