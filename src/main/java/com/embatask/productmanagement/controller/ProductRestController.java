package com.embatask.productmanagement.controller;

import com.embatask.productmanagement.domain.Product;
import com.embatask.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getByProductId(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }
}
