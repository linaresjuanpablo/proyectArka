package com.arka.product.infrastruture.entity;

import com.arka.product.domain.model.ProductModel;
import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name = "product")
public class ProductEntity {

//    public ProductEntity(long id, UUID uuid, String name, String description, Double price, String sku, String quantity) {
//        this.id = id;
//        this.uuid = uuid;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.sku = sku;
//        this.quantity = quantity;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "sku")
    private String sku;

    @Column(name = "quantity")
    private String quantity;



    public static ProductEntity fromDomainModel(ProductModel productModel){
        return new ProductEntity(productModel.getId(), productModel.getUuid(),productModel.getName(), productModel.getDescription(), productModel.getPrice(),
                productModel.getSku(), productModel.getQuantity());
    }
    public ProductModel toDomainModel(){
        return new ProductModel(id, uuid, name, description, price, sku, quantity);
    }





}
