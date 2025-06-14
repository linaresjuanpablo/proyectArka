package com.arka.product.domain.ports.out;

import com.arka.product.domain.model.ProductModel;
import reactor.core.publisher.Mono;

public interface IProductRepositoryPort {

    Mono<ProductModel> save(ProductModel productModel);
    Mono<ProductModel> findBySku(String sku);
}
