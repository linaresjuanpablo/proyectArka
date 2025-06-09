package com.arka.product.infrastruture.output.entity;

import com.arka.product.domain.model.BrandModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name = "brand")
@Builder

public class BrandEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    public static BrandEntity fronDomainModel(BrandModel brandModel){
        return BrandEntity.builder()
                .id(brandModel.getId())
                .name(brandModel.getName())
                .build();
    }

    public BrandModel toDomainModel(){
        return BrandModel.builder()
                .id(id)
                .name(name)
                .build();
    }
}
