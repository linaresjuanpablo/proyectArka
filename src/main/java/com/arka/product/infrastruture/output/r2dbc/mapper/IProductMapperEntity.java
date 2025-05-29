package com.arka.product.infrastruture.output.r2dbc.mapper;


import com.arka.product.domain.model.ProductModel;
import com.arka.product.infrastruture.output.r2dbc.entity.R2ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapperEntity {

    R2ProductEntity r2Entity(ProductModel productModel);

    ProductModel prodModel(R2ProductEntity r2ProductEntity);


}
