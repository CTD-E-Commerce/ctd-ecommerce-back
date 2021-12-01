package com.CTDECommerce.ECommerce.model.dto;

import com.CTDECommerce.ECommerce.model.entities.CategoryEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(CategoryEntity category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
