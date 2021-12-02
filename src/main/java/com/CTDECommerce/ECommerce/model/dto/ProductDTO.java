package com.CTDECommerce.ECommerce.model.dto;

import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;

    public ProductDTO() {
    }

    public ProductDTO(ProductEntity product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getName();
        this.description = product.getDescription();
        this.image = product.getImage();
    }

    public ProductDTO(Long id, String title, Double price, String category, String description, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;
    }
}
