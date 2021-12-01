package com.CTDECommerce.ECommerce.service.impl;

import com.CTDECommerce.ECommerce.model.repository.impl.ProductRepositoryImpl;

public class ProdutoServiceImpl {

    private final ProductRepositoryImpl productRepository;


    public ProdutoServiceImpl(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    public void teste(){
        productRepository.findByName("name");

    }
}
