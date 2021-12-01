package com.CTDECommerce.ECommerce.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Category")
class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="category")
    private Set<ProductEntity> product=new HashSet<>();

}
