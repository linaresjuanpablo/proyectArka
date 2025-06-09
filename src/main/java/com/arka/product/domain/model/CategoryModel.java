package com.arka.product.domain.model;

import lombok.*;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)

public class CategoryModel {

    private Long id;
    private String name;
}
