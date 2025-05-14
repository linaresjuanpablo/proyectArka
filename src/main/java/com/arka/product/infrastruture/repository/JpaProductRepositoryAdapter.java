package com.arka.product.infrastruture.repository;

import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.out.IProductRepositoryPort;
import com.arka.product.infrastruture.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component

public class JpaProductRepositoryAdapter implements IProductRepositoryPort {

    private final IProductRepository iProductRepository;

    public JpaProductRepositoryAdapter(IProductRepository iProductRepository){
        this.iProductRepository = iProductRepository;
    }
    @Override
    public ProductModel save(ProductModel productModel) {
        ProductEntity productEntity = ProductEntity.fromDomainModel(productModel);
        ProductEntity savedProductEntity = iProductRepository.save(productEntity);
        return savedProductEntity.toDomainModel();
    }
}
