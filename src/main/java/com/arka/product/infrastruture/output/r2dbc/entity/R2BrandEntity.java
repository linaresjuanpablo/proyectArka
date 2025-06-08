package com.arka.product.infrastruture.output.r2dbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("brand")

public class R2BrandEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;
}
