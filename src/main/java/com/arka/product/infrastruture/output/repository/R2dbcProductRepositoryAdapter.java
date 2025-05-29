/*package com.arka.product.infrastruture.output.repository;

import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.out.IProductRepositoryPort;
import com.arka.product.infrastruture.output.entity.ProductEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component

public class R2dbcProductRepositoryAdapter implements IProductRepositoryPort {

    private final IProductRepository iProductRepository;
    public R2dbcProductRepositoryAdapter(IProductRepository iProductRepository){
        this.iProductRepository = iProductRepository;
    }
    @Override
    public Mono<ProductModel> save(ProductModel productModel){
        ProductEntity productEntity = ProductEntity.fromDomainModel(productModel);
        return iProductRepository.save(productEntity)
                .map(ProductEntity::toDomainModel);
    }


}*/
