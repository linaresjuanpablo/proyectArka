package com.arka.product.infrastruture.input.controller;

import com.arka.product.domain.model.CategoryModel;
import com.arka.product.domain.ports.in.ICategoryInPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/category")

public class CategoryController {
    private final ICategoryInPort iCategoryInPort;
    public CategoryController(ICategoryInPort iCategoryInPort){
        this.iCategoryInPort = iCategoryInPort;
    }

    @PostMapping
    public Mono<ResponseEntity<CategoryModel>> createCategory(@RequestBody CategoryModel categoryModel){
        return iCategoryInPort.createCategory(categoryModel)
                .map(createCategory -> new ResponseEntity<>(createCategory, HttpStatus.CREATED));
    }
}
