package com.CTDECommerce.ECommerce.model.repository.impl;

import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import com.CTDECommerce.ECommerce.model.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public abstract class ProductRepositoryImpl implements ProductRepository {
    @Query("select * from product inner join category on category.id = product.category_id where category.id=?1")
    public abstract ProductEntity findByCategory_id(Long category);


}
