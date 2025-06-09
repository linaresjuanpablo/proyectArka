package com.arka.product.domain.ports.in;

import com.arka.product.domain.model.BrandModel;
import reactor.core.publisher.Mono;

public interface IBrandInPort {

    Mono<BrandModel> createBrand(BrandModel brandModel);

}
