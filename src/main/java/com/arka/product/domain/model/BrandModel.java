package com.arka.product.domain.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)

public class BrandModel {

    private Long id;
    private String name;
}
