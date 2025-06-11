package com.arka.product.domain.ports.in;

import com.arka.product.domain.exception.ValidationException;
import com.arka.product.domain.model.ProductModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreateProductUseCase {

    Mono<ProductModel> createProduct(ProductModel productModel);

    Mono<ProductModel> updateproduct(ProductModel productModel);

    Mono<ProductModel> getProductByName(String name);

    Flux<ProductModel> findByBrandName(String brand);
}
