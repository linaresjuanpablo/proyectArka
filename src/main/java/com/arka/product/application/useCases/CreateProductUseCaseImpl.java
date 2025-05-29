package com.arka.product.application.useCases;

import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.in.ICreateProductUseCase;
import com.arka.product.domain.ports.out.IProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
@Component
@RequiredArgsConstructor

public class CreateProductUseCaseImpl implements ICreateProductUseCase {

    private final IProductRepositoryPort iProductRepositoryPort;



    @Override
    public Mono<ProductModel> createProduct(ProductModel productModel) {
        return iProductRepositoryPort.save(productModel);
    }
}
