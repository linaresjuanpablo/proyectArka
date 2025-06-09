package com.arka.product.domain.ports.in;

import com.arka.product.domain.model.CategoryModel;
import reactor.core.publisher.Mono;

public interface ICategoryInPort {

    Mono<CategoryModel> createCategory(CategoryModel categoryModel);
}
