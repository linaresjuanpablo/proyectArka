package com.arka.product.application.useCases;

import com.arka.product.domain.exception.DataAccessException;
import com.arka.product.domain.exception.DuplicateResourceException;
import com.arka.product.domain.exception.ValidationException;
import com.arka.product.domain.model.CategoryModel;
import com.arka.product.domain.ports.in.ICategoryInPort;
import com.arka.product.domain.ports.out.ICategoryRepositoryOutPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j

public class CategoryUseCase implements ICategoryInPort {

    private final ICategoryRepositoryOutPort iCategoryRepositoryOutPort;
    private static final String ERR_NAME_EMPTY = "ERR_NAME_EMPTY";

    @Override
    public Mono<CategoryModel> createCategory(CategoryModel categoryModel) {
        return validateCategory(categoryModel)
                .flatMap(c ->{
                   c.setName(c.getName().toUpperCase());
                   return iCategoryRepositoryOutPort.save(c);
                })
                .onErrorResume(e ->{
                    if (e instanceof ValidationException || e instanceof DuplicateResourceException){
                        return Mono.error(e);
                    }
                    log.error("Error en el proceso de guardar una marca: {}",e.getMessage());
                    return Mono.error(new DataAccessException(ERR_NAME_EMPTY, "Error guardado marca: " + e.getMessage()));
                });
    }

    private Mono<CategoryModel> validateCategory(CategoryModel categoryModel){
        if (categoryModel.getName() == null || categoryModel.getName().isBlank()){
            return Mono.error(new ValidationException(ERR_NAME_EMPTY, "el nombre esta vacio"));
        }
        return Mono.just(categoryModel);
    }
}
