package com.CTDECommerce.ECommerce.model.repository;

import com.CTDECommerce.ECommerce.model.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {


    CategoryEntity findByName(String nameCategory);

}
