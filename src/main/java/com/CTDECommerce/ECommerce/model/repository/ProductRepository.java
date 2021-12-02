package com.CTDECommerce.ECommerce.model.repository;

import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity ,Long> {
    ProductEntity findByCategory_id(Long category_id);
}
