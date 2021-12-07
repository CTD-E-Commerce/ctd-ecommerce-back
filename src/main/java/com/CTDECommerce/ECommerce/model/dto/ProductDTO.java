package com.CTDECommerce.ECommerce.model.dto;

import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String title;
    private Double avaliacao;
    private Integer numaval;
    private String price;
    private String category;
    private String shortdescription;
    private String fulldescription;
    private String image;

    public ProductDTO() {
    }

    public ProductDTO(ProductEntity product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.avaliacao = product.getAvaliacao();
        this.numaval = product.getNumaval();
        this.price = String.format("%.2f", product.getPrice());
        this.category = product.getCategory().getName();
        this.shortdescription = product.getShortdescription();
        this.fulldescription = product.getFulldescription();
        this.image = product.getImage();
    }

    public ProductDTO(Long id, String title, Double avaliacao, Integer numaval, String price, String category,
                      String shortdescription, String fulldescription, String image) {
        this.id = id;
        this.title = title;
        this.avaliacao = avaliacao;
        this.numaval = numaval;
        this.price = price;
        this.category = category;
        this.shortdescription = shortdescription;
        this.fulldescription = fulldescription;
        this.image = image;
    }
}
