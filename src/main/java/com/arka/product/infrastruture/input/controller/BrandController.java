package com.arka.product.infrastruture.input.controller;

import com.arka.product.domain.model.BrandModel;
import com.arka.product.domain.ports.in.IBrandInPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/brand")

public class BrandController {

    private final IBrandInPort iBrandInPort;
    public BrandController(IBrandInPort iBrandInPort){
        this.iBrandInPort = iBrandInPort;
    }

    @PostMapping
    public Mono<ResponseEntity<BrandModel>> createBrand(@RequestBody BrandModel brandModel){
        return iBrandInPort.createBrand(brandModel)
                .map(createBrand -> new ResponseEntity<>(createBrand, HttpStatus.CREATED));
    }
}
