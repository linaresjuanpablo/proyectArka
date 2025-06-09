package com.arka.product.infrastruture.output.repository;

import com.arka.product.infrastruture.output.entity.BrandEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IBrandRepository extends ReactiveCrudRepository<BrandEntity, Long> {
}
