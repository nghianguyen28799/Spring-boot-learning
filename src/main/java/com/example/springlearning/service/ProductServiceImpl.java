package com.example.springlearning.service;

import com.example.springlearning.models.Product;
import com.example.springlearning.models.ResponseObject;
import com.example.springlearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<ResponseObject> saveProduct(Map<String, Object> productData) {
        Product product = new Product();
        product.setProductName((String) productData.get("product"));
        product.setProductYear((Integer) productData.get("year"));
        product.setPrice((Double) productData.get("price"));
        product.setUrl((String) productData.get("url"));

        Product foundProducts = productRepository.findByProductName(product.getProductName().trim());

        if(foundProducts != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Product name already token", "")
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert product successfully", productRepository.save(product))
        );
    }

    @Override
    public List<Product> fetchAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> fetchProductById(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if(foundProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query product sucessfully", foundProduct)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ResponseObject("ok", "Cannot find product with id = " + id, "")
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateProduct(Map<String, Object> newProduct, Long id) {
        Optional<Product> updatedProduct = productRepository.findById(id)
                .map(product -> {
                    product.setProductName((String) newProduct.get("product"));
                    product.setProductYear((Integer) newProduct.get("year"));
                    product.setPrice((Double) newProduct.get("price"));
                    product.setUrl((String) newProduct.get("url"));
                    return productRepository.save(product);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Updated Product successfully", updatedProduct)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if(!exists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find product to delete", "")
            );
        }
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "This product deleted successfully", "")
        );
    }
}
