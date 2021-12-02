package com.CTDECommerce.ECommerce.service.impl;


import com.CTDECommerce.ECommerce.model.dto.ProductDTO;
import com.CTDECommerce.ECommerce.model.entities.CategoryEntity;
import com.CTDECommerce.ECommerce.model.entities.ProductEntity;
import com.CTDECommerce.ECommerce.model.repository.CategoryRepository;
import com.CTDECommerce.ECommerce.model.repository.ProductRepository;
import com.CTDECommerce.ECommerce.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ECommerceService <ProductDTO> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDTO salvar(ProductDTO productDTO) {
        ProductEntity product= new ProductEntity(productDTO);
        CategoryEntity category= categoryRepository.findByName(productDTO.getCategory());
        if(category==null){
            return null;
        }
        product.setCategoryEntity(category);


        productRepository.save(product);
        ProductDTO productDTO1=new ProductDTO(product);
        return productDTO1;
    }

    @Override
    public List<ProductDTO> buscarTodos() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return trasformardto(productEntities);
    }

    @Override
    public ProductDTO buscarPorId(Long id) {
        ProductDTO productDTO=new ProductDTO(productRepository.getById(id));

        return productDTO;
    }

   /* public ProductDTO busrcarPorCategoria(Long category){
        ProductEntity productEntities = productRepository.findByCat(category);

        ProductDTO productDTO= new ProductDTO(productEntities);
        return productDTO;
            //return trasformardto(productEntities);
    }*/


    public List<ProductDTO> trasformardto(List<ProductEntity> productEntities){
        List<ProductDTO> productDTOList = new ArrayList<>();
        if (productEntities != null) {
            for (ProductEntity product : productEntities) {
                ProductDTO productDTO = new ProductDTO(product);
                productDTOList.add(productDTO);
            }
            return productDTOList;
        }
        return null;

    }
}