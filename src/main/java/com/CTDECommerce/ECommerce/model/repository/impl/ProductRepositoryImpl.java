package com.CTDECommerce.ECommerce.model.repository.impl;

import com.CTDECommerce.ECommerce.model.entities.CategoryEntity;
import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import com.CTDECommerce.ECommerce.model.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public abstract class ProductRepositoryImpl implements ProductRepository {
    @Query("select obj from product obj where obj.name=?1")
    public abstract List<ProductEntity> findByCategoryName(String category);
}
