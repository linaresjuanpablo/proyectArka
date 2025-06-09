package com.arka.product.infrastruture.output.r2dbc.adapter;

import com.arka.product.domain.model.BrandModel;
import com.arka.product.domain.ports.out.IBrandRepositoryOutPort;
import com.arka.product.infrastruture.output.r2dbc.mapper.IBrandMapperEntity;
import com.arka.product.infrastruture.output.r2dbc.repository.IR2BrandRepository;
import com.arka.product.infrastruture.output.r2dbc.repository.IR2ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor

public class BrandAdapter implements IBrandRepositoryOutPort {

    private final IR2BrandRepository ir2BrandRepository;
    private final IBrandMapperEntity iBrandMapperEntity;

    @Override
    public Mono<BrandModel> save(BrandModel brandModel) {
        return ir2BrandRepository.save(iBrandMapperEntity.r2BrandEntity(brandModel))
                .map(iBrandMapperEntity::brandModel);

    }
}
