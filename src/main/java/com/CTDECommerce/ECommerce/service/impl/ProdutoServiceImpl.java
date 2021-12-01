package com.CTDECommerce.ECommerce.service.impl;

import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import com.CTDECommerce.ECommerce.model.repository.impl.ProductRepositoryImpl;
import com.CTDECommerce.ECommerce.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ECommerceService <ProductEntity>{

    @Autowired
    private ProductRepositoryImpl productRepository;



    @Override
    public ProductEntity salvar(ProductEntity productEntity) {
        ProductEntity product=productRepository.save(productEntity);
        return product;
    }

    @Override
    public List<ProductEntity> buscarTodos() {
        List<ProductEntity> products=productRepository.findAll();
        return products;
    }

    @Override
    public Optional<ProductEntity> buscarPorId(Long id) {
        Optional<ProductEntity> product=productRepository.findById(id);
        return product;
    }
}
