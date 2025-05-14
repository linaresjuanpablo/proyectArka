package com.arka.product.application.services;

import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.in.ICreateProductUseCase;
import com.arka.product.domain.ports.out.IProductRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ICreateProductUseCase {

    private final IProductRepositoryPort iProductRepositoryPort;
    public ProductService(IProductRepositoryPort iProductRepositoryPort){
        this.iProductRepositoryPort = iProductRepositoryPort;
    }

    @Override
    public ProductModel createProduct(ProductModel productModel) {
        return iProductRepositoryPort.save(productModel);
    }
}
