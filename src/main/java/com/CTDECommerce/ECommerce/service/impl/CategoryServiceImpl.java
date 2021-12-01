package com.CTDECommerce.ECommerce.service.impl;

import com.CTDECommerce.ECommerce.model.dto.CategoryDTO;
import com.CTDECommerce.ECommerce.model.entities.CategoryEntity;
import com.CTDECommerce.ECommerce.model.repository.CategoryRepository;
import com.CTDECommerce.ECommerce.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ECommerceService<CategoryDTO> {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public CategoryDTO salvar(CategoryDTO categoryDTO) {
        CategoryEntity category= new CategoryEntity(categoryDTO);
        categoryRepository.saveAndFlush(category);
        CategoryDTO categoryDTO1=new CategoryDTO(category);
        return categoryDTO1;
    }

    @Override
    public List<CategoryDTO> buscarTodos() {
        List<CategoryEntity> categorylist = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        if (categorylist != null){
            for (CategoryEntity categoryEntity : categorylist){
                CategoryDTO categoryDTO = new CategoryDTO(categoryEntity);
                categoryDTOList.add(categoryDTO);
            }
            return categoryDTOList;
        }
        return null;
    }

    @Override
    public CategoryDTO buscarPorId(Long id) {
        CategoryDTO categoryDTO=new CategoryDTO(categoryRepository.getById(id));

        return categoryDTO;
    }
}
