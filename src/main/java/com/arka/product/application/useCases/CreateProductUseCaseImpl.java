package com.arka.product.application.useCases;

import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.in.ICreateProductUseCase;
import com.arka.product.domain.ports.out.IProductRepositoryPort;
import com.arka.product.infrastruture.repository.IProductRepository;

public class CreateProductUseCaseImpl implements ICreateProductUseCase {

    private final IProductRepositoryPort iProductRepositoryPort;

    public CreateProductUseCaseImpl(CreateProductUseCaseImpl createProductUseCase){
        this.iProductRepositoryPort = createProductUseCase.iProductRepositoryPort;
    }

    @Override
    public ProductModel createProduct(ProductModel productModel) {
        return iProductRepositoryPort.save(productModel);
    }
}
