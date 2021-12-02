package com.CTDECommerce.ECommerce.service.impl;


import com.CTDECommerce.ECommerce.model.dto.ProductDTO;
import com.CTDECommerce.ECommerce.model.entities.CategoryEntity;
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
public class ProdutoServiceImpl implements ECommerceService <ProductDTO> {
    private static final Logger LOG = LoggerFactory.getLogger(ProdutoServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDTO salvar(ProductDTO productDTO) {
        ProductEntity product= new ProductEntity(productDTO);
        CategoryEntity category= categoryRepository.findByName(productDTO.getCategory());
        if(category==null){
            LOG.info("Não existe essa categoria.");
            return null;
        }
        product.setCategory(category);


        productRepository.save(product);
        ProductDTO productDTO1=new ProductDTO(product);
        LOG.info("Produto criado com sucesso.");
        return productDTO1;
    }

    @Override
    public List<ProductDTO> buscarTodos() {
        List<ProductEntity> productEntities = productRepository.findAll();
        LOG.info("Listando todos produtos.");
        return trasformardto(productEntities);
    }

    @Override
    public ProductDTO buscarPorId(Long id) {
        ProductDTO productDTO=new ProductDTO(productRepository.getById(id));
        LOG.info("Resultado da busca pelo produto com id " + id + ".");
        return productDTO;
    }

   public ProductDTO buscarPorCategoria(Long category){
       LOG.info("Iniciando buscar por todos produtos da caregoria " + category + ".");
        ProductEntity productEntities = productRepository.findByCategory(category);
       LOG.info("Tratando dados do banco de dados.");
        ProductDTO productDTO= new ProductDTO(productEntities);
       LOG.info("Listando todos produtos da categoria " + category + ".");
        return productDTO;
            //return trasformardto(productEntities);
    }


    public List<ProductDTO> trasformardto(List<ProductEntity> productEntities){
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