package com.arka.product.infrastruture.output.r2dbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;
@Data
@Table("product")

public class R2ProductEntity {
    @Id
    @Column( "id")
    private Long id;

    @Column("uuid")
    private UUID uuid;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("price")
    private Double price;

    @Column("sku")
    private String sku;

    @Column("quantity")
    private Integer quantity;

    @Column("id_brand")
    private Long id_brand;

    @Column("id_category")
    private Long id_category;
}
