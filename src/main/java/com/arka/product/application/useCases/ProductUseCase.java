package com.arka.product.application.useCases;

import com.arka.product.domain.exception.DataAccessException;
import com.arka.product.domain.exception.DuplicateResourceException;
import com.arka.product.domain.exception.ValidationException;
import com.arka.product.domain.model.ProductModel;
import com.arka.product.domain.ports.in.ICreateProductUseCase;
import com.arka.product.domain.ports.out.IProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ap.shaded.freemarker.core.ReturnInstruction;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j

public class ProductUseCase  implements ICreateProductUseCase {

    //private final ICreateProductUseCase iCreateProductUseCase;
    private final IProductRepositoryPort iProductRepositoryPort;

    private static final Integer NAME_MIN_LENGTH = 3;
    private static final String ERR_SKU_INVALID = "ERR_EMAIL_INVALID";
    private static final String ERR_PRODUCT_EXISTS = "ERR_PRODUCT_EXISTS";
    private static final String ERR_PRICE_INVALID = "ERR_PHONE_INVALID";
    private static final String ERR_NAME_INVALID = "ERR_NAME_INVALID";
    //private static final String ERR_ID_INVALID = "ERR_ID_INVALID";
    //private static final String ERR_PASSWORD_EMPTY = "ERR_PASSWORD_EMPTY";
    //private static final String ERR_USER_REGISTRATION = "ERR_USER_REGISTRATION";


    @Override
    public Mono<ProductModel> createProduct(ProductModel productModel) {
        return validateProduct(productModel)
                .map(p -> {
                    p.setName(p.getName().toUpperCase());
                    p.setUuid(UUID.randomUUID());
                    return p;
                })
                .flatMap(iProductRepositoryPort::save)
                .onErrorResume(e-> {
                    if (e instanceof ValidationException || e instanceof DuplicateResourceException){
                        return Mono.error(e);
                    }
                    log.error("Error en el proceso de guardar un producto: {}", e.getMessage());
                    return Mono.error(new DataAccessException(ERR_PRODUCT_EXISTS, "Error registrando producto: " + e.getMessage()));

                });
    }

    private Mono<ProductModel> validateProduct(ProductModel productModel){
        if (productModel.getName() == null || productModel.getName().length() < NAME_MIN_LENGTH){
            return Mono.error(new ValidationException(ERR_NAME_INVALID, "El nombre de producto es invalido"));
        }

    if (productModel.getPrice() == null || productModel.getPrice() <= 0) {
        return Mono.error(new ValidationException(ERR_PRICE_INVALID, "El precio debe ser mayor a 0"));
    }

    if (productModel.getSku() == null || productModel.getSku().isBlank()) {
        return Mono.error(new ValidationException(ERR_SKU_INVALID, "El SKU no puede estar vacío"));
    }

    return iProductRepositoryPort.findBySku(productModel.getSku())
                .flatMap(existing -> {
                    log.warn("Ya existe un producto con el SKU: {}", productModel.getSku());
                    return Mono.<ProductModel>error(
                            new DuplicateResourceException(ERR_PRODUCT_EXISTS, "Ya existe un producto con ese SKU"));
                })
            .switchIfEmpty(Mono.just(productModel));


    }

}
