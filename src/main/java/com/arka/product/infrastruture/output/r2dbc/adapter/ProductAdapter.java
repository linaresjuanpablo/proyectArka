package com.arka.product.infrastruture.output.r2dbc.adapter;

import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.out.IProductRepositoryPort;
import com.arka.product.infrastruture.output.r2dbc.mapper.IProductMapperEntity;
import com.arka.product.infrastruture.output.r2dbc.repository.IR2ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor

public class ProductAdapter implements IProductRepositoryPort {

    private final IR2ProductRepository ir2ProductRepository;
    private final IProductMapperEntity iProductMapperEntity;


    @Override
    public Mono<ProductModel> save(ProductModel productModel) {
        return ir2ProductRepository.save(iProductMapperEntity.r2Entity(productModel))
                .map(iProductMapperEntity::prodModel);
    }

    @Override
    public Mono<ProductModel> findBySku(String sku) {
        return null;
    }
}
