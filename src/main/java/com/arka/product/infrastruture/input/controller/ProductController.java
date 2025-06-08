package com.arka.product.infrastruture.input.controller;

//import com.arka.product.application.useCases.CreateProductUseCaseImpl;
import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.in.ICreateProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")

public class ProductController {


    private final ICreateProductUseCase iCreateProductUseCase;
    public ProductController(ICreateProductUseCase iCreateProductUseCase){
        this.iCreateProductUseCase = iCreateProductUseCase;
    }

    @PostMapping
    public Mono<ResponseEntity<ProductModel>> createProduct (@RequestBody ProductModel productModel){
        return iCreateProductUseCase.createProduct(productModel)
                .map(createProduct -> new ResponseEntity<>(createProduct, HttpStatus.CREATED));

    }

}
