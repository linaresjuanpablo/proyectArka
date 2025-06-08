package com.arka.product.infrastruture.output.entity;

import com.arka.product.domain.model.ProductModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.util.UUID;


//@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name = "product")
@Builder
public class ProductEntity {


    @Id
    @Column("id")
    private long id;

    @Column("uuid")
    private UUID uuid;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column( "price")
    private Double price;

    @Column( "sku")
    private String sku;

    @Column("quantity")
    private Integer quantity;



    /*public static ProductEntity fromDomainModel(ProductModel productModel){
        return new ProductEntity(productModel.getId(), productModel.getUuid(),productModel.getName(), productModel.getDescription(), productModel.getPrice(),
                productModel.getSku(), productModel.getQuantity());
    }*/
    public static ProductEntity fromDomainModel(ProductModel productModel){
        return ProductEntity.builder()
                .id(productModel.getId())
                .uuid(productModel.getUuid())
                .name(productModel.getName())
                .description(productModel.getDescription())
                .price(productModel.getPrice())
                .sku(productModel.getSku())
                .quantity(productModel.getQuantity())
                .build();
    }

    public ProductModel toDomainModel(){
        return ProductModel.builder()
                .id(id)
                .uuid(uuid)
                .name(name)
                .description(description)
                .price(price)
                .sku(sku)
                .quantity(quantity)
                .id_brand(null)
                .id_category(null)
                .build();
    }

    /*public ProductModel toDomainModel(){
        return new ProductModel(id, uuid, name, description, price, sku, quantity);
    }*/





}
