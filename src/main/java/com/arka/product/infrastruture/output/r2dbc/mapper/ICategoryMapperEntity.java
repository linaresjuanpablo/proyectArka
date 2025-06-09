package com.arka.product.infrastruture.output.r2dbc.mapper;

import com.arka.product.domain.model.CategoryModel;
import com.arka.product.infrastruture.output.r2dbc.entity.R2BrandEntity;
import com.arka.product.infrastruture.output.r2dbc.entity.R2CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICategoryMapperEntity {

    R2CategoryEntity r2CategoryEntity(CategoryModel categoryModel);
    CategoryModel categoryModel(R2CategoryEntity r2CategoryEntity);



}
