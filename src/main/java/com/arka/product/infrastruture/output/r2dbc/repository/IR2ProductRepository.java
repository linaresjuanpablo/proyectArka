package com.arka.product.infrastruture.output.r2dbc.repository;

import com.arka.product.infrastruture.output.entity.ProductEntity;
import com.arka.product.infrastruture.output.r2dbc.entity.R2ProductEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IR2ProductRepository extends ReactiveCrudRepository<R2ProductEntity, Long> {
    Mono<R2ProductEntity> findBySku(String sku);

    Mono<R2ProductEntity> findByNameIgnoreCase(String name);


    @Query("""
    SELECT p.* FROM product p
    JOIN brand b ON p.id_brand = b.id
    WHERE LOWER(b.name) = LOWER(:brandName)
""")
    Flux<R2ProductEntity> findByBrandIgnoreCase(String brand);


}
