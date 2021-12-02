package com.CTDECommerce.ECommerce.model.entities;

import com.CTDECommerce.ECommerce.model.dto.CategoryDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    /*@OneToMany(fetch = FetchType.EAGER)
    private Set<ProductEntity> product=new HashSet<>();
*/
    public CategoryEntity() {
    }

    public CategoryEntity(Long id, String name) {
        this.id = id;
        this.name = name;
        //this.product = product;
    }

    public CategoryEntity(CategoryDTO categoryDTO){
        this.id= categoryDTO.getId();
        this.name= categoryDTO.getName();
    }
}
