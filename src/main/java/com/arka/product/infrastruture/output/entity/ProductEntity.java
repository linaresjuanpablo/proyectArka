package com.arka.product.infrastruture.output.entity;

import com.arka.product.domain.model.ProductModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.util.UUID;


@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name = "product")
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
    private String quantity;



    public static ProductEntity fromDomainModel(ProductModel productModel){
        return new ProductEntity(productModel.getId(), productModel.getUuid(),productModel.getName(), productModel.getDescription(), productModel.getPrice(),
                productModel.getSku(), productModel.getQuantity());
    }
    public ProductModel toDomainModel(){
        return new ProductModel(id, uuid, name, description, price, sku, quantity);
    }





}
