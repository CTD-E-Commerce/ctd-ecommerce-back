package com.CTDECommerce.ECommerce.model.repository;

import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity ,Long> {
}
