package com.arka.product.application.useCases;

import com.arka.product.domain.exception.DataAccessException;
import com.arka.product.domain.exception.DuplicateResourceException;
import com.arka.product.domain.exception.ValidationException;
import com.arka.product.domain.model.BrandModel;
import com.arka.product.domain.ports.in.IBrandInPort;
import com.arka.product.domain.ports.out.IBrandRepositoryOutPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j

public class BrandUseCase implements IBrandInPort {

    private final IBrandRepositoryOutPort iBrandRepositoryOutPort;

    private static final String ERR_NAME_EMPTY = "ERR_NAME_EMPTY";

    @Override
    public Mono<BrandModel> createBrand(BrandModel brandModel) {
        return validateBrand(brandModel)
                .flatMap(b ->{
                    b.setName(b.getName().toUpperCase());
                    return iBrandRepositoryOutPort.save(b);
                })
                .onErrorResume(e ->{
                    if (e instanceof ValidationException || e instanceof DuplicateResourceException){
                        return Mono.error(e);
                    }
                    log.error("Error en el proceso de guardar una marca: {}", e.getMessage());
                    return Mono.error(new DataAccessException(ERR_NAME_EMPTY, "Error guardando marca: " + e.getMessage()));
                });
    }

    private Mono<BrandModel> validateBrand(BrandModel brandModel){
        if (brandModel.getName() == null || brandModel.getName().isBlank()){
            return Mono.error(new ValidationException(ERR_NAME_EMPTY, "El nombre esta vacio"));
        }
        return Mono.just(brandModel );
    }
}
