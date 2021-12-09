package com.CTDECommerce.ECommerce.controller;

import com.CTDECommerce.ECommerce.model.dto.ProductDTO;
import com.CTDECommerce.ECommerce.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins="*", allowedHeaders="")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;


    @GetMapping("/buscartodos")
    public ResponseEntity<List<ProductDTO>> findAll(){

        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {

        ProductDTO productDTO = productService.findById(id);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> findbycategory(@PathVariable String category){
        List<ProductDTO> productDTO = productService.findByCategory(category);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/novidades")
    public ResponseEntity<List<ProductDTO>> newList(){
        return ResponseEntity.ok(productService.newProducts());
    }

    @GetMapping("/maisvendidos")
    public ResponseEntity<List<ProductDTO>> bestSellersList(){

        return ResponseEntity.ok(productService.bestSellersProducts());
    }

}
