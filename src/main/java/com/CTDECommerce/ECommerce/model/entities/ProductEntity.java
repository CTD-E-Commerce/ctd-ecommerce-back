package com.CTDECommerce.ECommerce.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private Double price;

    @Column(name="description")
    private String description;

    @Column(name="image")
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="category_id")
    private CategoryEntity categoryEntity;
}
