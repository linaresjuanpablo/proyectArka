package com.arka.product.infrastruture.output.r2dbc.repository;

import com.arka.product.infrastruture.output.r2dbc.entity.R2BrandEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IR2BrandRepository extends ReactiveCrudRepository<R2BrandEntity, Long> {

}
