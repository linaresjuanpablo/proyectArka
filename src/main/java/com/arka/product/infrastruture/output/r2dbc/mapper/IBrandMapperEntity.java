package com.arka.product.infrastruture.output.r2dbc.mapper;

import com.arka.product.domain.model.BrandModel;
import com.arka.product.infrastruture.output.r2dbc.entity.R2BrandEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface IBrandMapperEntity {

    R2BrandEntity r2BrandEntity(BrandModel brandModel);

    BrandModel brandModel(R2BrandEntity r2BrandEntity);

}
