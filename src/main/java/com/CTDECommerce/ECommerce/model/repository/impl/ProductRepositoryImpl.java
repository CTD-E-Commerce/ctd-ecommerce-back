package com.CTDECommerce.ECommerce.model.repository.impl;

import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import com.CTDECommerce.ECommerce.model.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class ProductRepositoryImpl implements ProductRepository {

    @Query("select p from product p where p.nome=?1")
    public abstract Optional<ProductEntity> findByName(String nameProduct);


}
