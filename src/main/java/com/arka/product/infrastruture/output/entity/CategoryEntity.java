package com.arka.product.infrastruture.output.entity;

import com.arka.product.domain.model.CategoryModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name = "category")
@Builder

public class CategoryEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    public static CategoryEntity fromDomainModel(CategoryModel categoryModel){
        return CategoryEntity.builder()
                .id(categoryModel.getId())
                .name(categoryModel.getName())
                .build();
    }
    public CategoryModel toDomainModel(){
        return CategoryModel.builder()
                .id(id)
                .name(name)
                .build();
    }
}
