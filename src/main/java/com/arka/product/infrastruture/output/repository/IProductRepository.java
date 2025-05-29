package com.arka.product.infrastruture.output.repository;

import com.arka.product.infrastruture.output.entity.ProductEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {
}
