package com.CTDECommerce.ECommerce.model.entities;

import com.CTDECommerce.ECommerce.model.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="avaliacao")
    private Double avaliacao;

    @Column(name="num_avaliacao")
    private Integer numaval;

    @Column(name="price")
    private Double price;

    @Column(name="shortdescription")
    private String shortdescription;

    @Column(name="fulldescription")
    private String fulldescription;

    @Column(name="image")
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="category_id")
    private CategoryEntity category;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String title, Double avaliacao, Integer numaval, Double price,
                         String shortdescription, String fulldescription, String image, CategoryEntity category) {
        this.id = id;
        this.title = title;
        this.avaliacao = avaliacao;
        this.numaval = numaval;
        this.price = price;
        this.shortdescription = shortdescription;
        this.fulldescription = fulldescription;
        this.image = image;
        this.category = category;
    }

    public ProductEntity(ProductDTO productDTO) {

        this.id = productDTO.getId();
        this.title = productDTO.getTitle();
        this.avaliacao = productDTO.getAvaliacao();
        this.numaval = productDTO.getNumaval();
        this.price = Double.parseDouble(productDTO.getPrice());
        this.shortdescription = productDTO.getShortdescription();
        this.fulldescription = productDTO.getFulldescription();
        this.image = productDTO.getImage();
    }
}
