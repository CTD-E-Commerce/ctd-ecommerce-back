package com.CTDECommerce.ECommerce.service.impl;

import com.CTDECommerce.ECommerce.model.entities.CategoryEntity;
import com.CTDECommerce.ECommerce.model.repository.impl.CategoryRepositoryImpl;
import com.CTDECommerce.ECommerce.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ECommerceService<CategoryEntity> {

    @Autowired
    private CategoryRepositoryImpl categoryRepository;

    @Override
    public CategoryEntity salvar(CategoryEntity categoryEntity) {
        CategoryEntity category = categoryRepository.save(categoryEntity);
        return category;
    }

    @Override
    public List<CategoryEntity> buscarTodos() {
        return null;
    }

    @Override
    public Optional<CategoryEntity> buscarPorId(Long id) {
        return Optional.empty();
    }
}
