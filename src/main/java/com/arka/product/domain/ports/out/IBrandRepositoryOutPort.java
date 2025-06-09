package com.arka.product.domain.ports.out;

import com.arka.product.domain.model.BrandModel;
import reactor.core.publisher.Mono;

public interface IBrandRepositoryOutPort {

    Mono<BrandModel> save(BrandModel brandModel);
}
