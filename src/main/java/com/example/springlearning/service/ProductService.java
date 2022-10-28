package com.example.springlearning.service;

import com.example.springlearning.models.Product;
import com.example.springlearning.models.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProductService {
    ResponseEntity<ResponseObject> saveProduct(Map<String, Object> productData);
    List<Product> fetchAllProduct();
    ResponseEntity<ResponseObject> fetchProductById(Long id);
    ResponseEntity<ResponseObject> updateProduct(Map<String, Object> newProduct, Long id);
    ResponseEntity<ResponseObject> deleteProduct(Long id);
}
