package com.arka.product.infrastruture.output.r2dbc.repository;

import com.arka.product.infrastruture.output.entity.ProductEntity;
import com.arka.product.infrastruture.output.r2dbc.entity.R2ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IR2ProductRepository extends ReactiveCrudRepository<R2ProductEntity, Long> {
    Mono<R2ProductEntity> findBySku(String sku);


}
