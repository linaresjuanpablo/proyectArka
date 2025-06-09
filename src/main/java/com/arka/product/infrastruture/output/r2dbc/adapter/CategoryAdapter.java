package com.arka.product.infrastruture.output.r2dbc.adapter;

import com.arka.product.domain.model.CategoryModel;
import com.arka.product.domain.ports.out.ICategoryRepositoryOutPort;
import com.arka.product.infrastruture.output.r2dbc.mapper.ICategoryMapperEntity;
import com.arka.product.infrastruture.output.r2dbc.repository.IR2CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor

public class CategoryAdapter implements ICategoryRepositoryOutPort {

    private final IR2CategoryRepository ir2CategoryRepository;
    private final ICategoryMapperEntity iCategoryMapperEntity;

    @Override
    public Mono<CategoryModel> save(CategoryModel categoryModel) {
        return ir2CategoryRepository.save(iCategoryMapperEntity.r2CategoryEntity(categoryModel))
                .map(iCategoryMapperEntity::categoryModel);
    }
}
