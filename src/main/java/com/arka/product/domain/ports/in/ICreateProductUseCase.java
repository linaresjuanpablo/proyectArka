package com.arka.product.domain.ports.in;

import com.arka.product.domain.model.ProductModel;
import reactor.core.publisher.Mono;

public interface ICreateProductUseCase {

    Mono<ProductModel> createProduct(ProductModel productModel);
}
