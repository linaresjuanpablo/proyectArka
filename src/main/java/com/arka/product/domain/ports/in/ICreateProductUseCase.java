package com.arka.product.domain.ports.in;

import com.arka.product.domain.model.ProductModel;

public interface ICreateProductUseCase {

    ProductModel createProduct(ProductModel productModel);
}
