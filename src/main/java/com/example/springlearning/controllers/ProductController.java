package com.example.springlearning.controllers;

import com.example.springlearning.models.Product;
import com.example.springlearning.models.ResponseObject;
import com.example.springlearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping ("/list")
    List<Product> fetchAllProduct() {
        return productService.fetchAllProduct();
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> saveProduct(@RequestBody Map<String, Object> productData) {
        return productService.saveProduct(productData);
    }

    @GetMapping("/get-id/{id}")
    ResponseEntity<ResponseObject> getProduct(@PathVariable("id") Long id) {
        return productService.fetchProductById(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Map<String, Object> newProduct, @PathVariable Long id) {
        return productService.updateProduct(newProduct, id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
