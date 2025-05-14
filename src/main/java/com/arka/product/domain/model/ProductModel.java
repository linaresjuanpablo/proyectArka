package com.arka.product.domain.model;

import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class ProductModel {

    private long id;

    private UUID uuid;

    private String name;

    private String description;

    private Double price;

    private String sku;

    private String quantity;


}
