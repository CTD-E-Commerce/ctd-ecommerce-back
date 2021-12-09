package com.CTDECommerce.ECommerce.service.impl;

import com.CTDECommerce.ECommerce.model.dto.ProductDTO;
import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import com.CTDECommerce.ECommerce.model.repository.CategoryRepository;
import com.CTDECommerce.ECommerce.model.repository.ProductRepository;
import com.CTDECommerce.ECommerce.service.ECommerceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ECommerceService <ProductDTO> {
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<ProductDTO> findAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        LOG.info("Listando todos produtos.");
        return transformDTO(productEntities);
    }

    @Override
    public ProductDTO findById(Long id) {
        ProductDTO productDTO=new ProductDTO(productRepository.getById(id));
        LOG.info("Resultado da busca pelo produto com id " + id + ".");
        return productDTO;
    }

    public List<ProductDTO> findByCategory(String category){
       LOG.info("Iniciando buscar por todos produtos da caregoria " + category + ".");
       List<ProductEntity> productEntities = productRepository.findByCategoryName(category);
       LOG.info("Listando todos produtos da categoria " + category + ".");
       return transformDTO(productEntities);
    }

    public List<ProductDTO> newProducts(){
        LOG.info("Iniciando buscar por novidades");
        List<ProductDTO> allProducts = findAll();
        List<ProductDTO> newsList = new ArrayList<>();
        for (int i=0; i<6; i++) {
            int index=0;
            if (i !=0) {
                index = (i * 6) - 1;
            } else {
                index =30;
            }
            ProductDTO product = allProducts.get(index);
            newsList.add(product);
        }
        LOG.info("Listando novidades");
        return newsList;
    }

    public List<ProductDTO> bestSellersProducts(){
        LOG.info("Iniciando buscar por novidades");
        List<ProductDTO> allProducts = findAll();
        List<ProductDTO> newsList = new ArrayList<>();
        for (int i=0; i<6; i++) {
            int index=0;
            if (i !=0) {
                index = (i * 6) - 3;
            } else {
                index =29;
            }
            ProductDTO product = allProducts.get(index);
            newsList.add(product);
        }
        LOG.info("Listando mais vendidos");
        return newsList;
    }


    public List<ProductDTO> transformDTO(List<ProductEntity> productEntities){
        List<ProductDTO> productDTOList = new ArrayList<>();
        if (productEntities != null) {
            for (ProductEntity product : productEntities) {
                ProductDTO productDTO = new ProductDTO(product);
                productDTOList.add(productDTO);
            }
            LOG.info("Listando todos produtos.");
            return productDTOList;
        }
        LOG.info("Lista nula no banco de dados.");
        return null;
    }

}