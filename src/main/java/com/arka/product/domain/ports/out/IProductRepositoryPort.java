package com.arka.product.domain.ports.out;

import com.arka.product.domain.model.ProductModel;

public interface IProductRepositoryPort {

    ProductModel save(ProductModel productModel);
}
