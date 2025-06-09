package com.arka.product.domain.ports.out;

import com.arka.product.domain.model.CategoryModel;
import reactor.core.publisher.Mono;

public interface ICategoryRepositoryOutPort {
    Mono<CategoryModel> save (CategoryModel categoryModel);
}
