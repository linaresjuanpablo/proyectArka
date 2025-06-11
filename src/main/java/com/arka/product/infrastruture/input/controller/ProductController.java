package com.arka.product.infrastruture.input.controller;

//import com.arka.product.application.useCases.CreateProductUseCaseImpl;
import com.arka.product.domain.exception.ValidationException;
import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.in.ICreateProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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
    @PutMapping("/update")
    public Mono<ResponseEntity<ProductModel>> updateProduct(@RequestBody ProductModel productModel){
        return iCreateProductUseCase.updateproduct(productModel)
                .map(updated -> ResponseEntity.ok(updated))
                .onErrorResume(e ->{
                    if (e instanceof ValidationException){
                        return Mono.just(ResponseEntity.badRequest().build());
                    }
                    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
                });
    }

    @GetMapping("/name/{name}")
    public Mono<ResponseEntity<ProductModel>> getProductByName(@PathVariable String name){
        return iCreateProductUseCase.getProductByName(name)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> {
                    if (e instanceof ValidationException){
                        return Mono.just(ResponseEntity.notFound().build());
                    }
                    return Mono.error(e);
                });
    }

    @GetMapping("/brand/{brandName}")
    public Flux<ProductModel> getProductsByBrandName(@PathVariable String brandName){
        return iCreateProductUseCase.findByBrandName(brandName);
    }

}
