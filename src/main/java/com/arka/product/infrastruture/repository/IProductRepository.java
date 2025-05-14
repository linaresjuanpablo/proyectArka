package com.arka.product.infrastruture.repository;

import com.arka.product.infrastruture.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}
