package com.arka.product.infrastruture.output.r2dbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("category")

public class R2CategoryEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;
}
