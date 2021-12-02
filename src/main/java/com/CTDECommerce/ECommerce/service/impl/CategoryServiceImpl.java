package com.CTDECommerce.ECommerce.service.impl;

import com.CTDECommerce.ECommerce.model.dto.CategoryDTO;
import com.CTDECommerce.ECommerce.model.entities.CategoryEntity;
import com.CTDECommerce.ECommerce.model.repository.CategoryRepository;
import com.CTDECommerce.ECommerce.service.ECommerceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements ECommerceService<CategoryDTO> {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public CategoryDTO salvar(CategoryDTO categoryDTO) {
        CategoryEntity category= new CategoryEntity(categoryDTO);
        categoryRepository.saveAndFlush(category);
        CategoryDTO categoryDTO1=new CategoryDTO(category);
        LOG.info("Categoria criada com sucesso.");
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
            LOG.info("Listando todas as categoria.");
            return categoryDTOList;
        }
        LOG.info("Não exitem nenhuma categoria cadastrada no banco.");
        return null;
    }

    @Override
    public CategoryDTO buscarPorId(Long id) {
        CategoryDTO categoryDTO=new CategoryDTO(categoryRepository.getById(id));
        LOG.info("Resultado da busca pela categoria com o id " + id + ".");
        return categoryDTO;
    }

    public CategoryDTO buscarPorNome(String name) {
        CategoryDTO categoryDTO=new CategoryDTO(categoryRepository.findByName(name));
        LOG.info("Resultado da busca pela categoria " + name + ".");
        return categoryDTO;
    }

    public List<String> buscarTodosString() {
        LOG.info("Lista de categorias.");
        return categoryRepository.findAllName();
    }
}
