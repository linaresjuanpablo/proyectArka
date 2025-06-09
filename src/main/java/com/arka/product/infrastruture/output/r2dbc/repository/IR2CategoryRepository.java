package com.arka.product.infrastruture.output.r2dbc.repository;

import com.arka.product.infrastruture.output.r2dbc.entity.R2BrandEntity;
import com.arka.product.infrastruture.output.r2dbc.entity.R2CategoryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IR2CategoryRepository extends ReactiveCrudRepository<R2CategoryEntity, Long> {
}
