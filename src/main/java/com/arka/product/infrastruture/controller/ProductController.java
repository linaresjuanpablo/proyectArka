package com.arka.product.infrastruture.controller;

import com.arka.product.application.services.ProductService;
import com.arka.product.domain.model.ProductModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductModel> createProduct (@RequestBody ProductModel productModel){
        ProductModel createdProduct = productService.createProduct(productModel);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

}
