package com.CTDECommerce.ECommerce.controller;

import com.CTDECommerce.ECommerce.model.dto.ProductDTO;
import com.CTDECommerce.ECommerce.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping
    public ResponseEntity<ProductDTO> salvar(@RequestBody ProductDTO product){
        ProductDTO productDTO = produtoService.salvar(product);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<ProductDTO>>findAll(){
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductDTO> buscarPorId(@PathVariable Long id) {

        ProductDTO productDTO = produtoService.buscarPorId(id);
        return ResponseEntity.ok(productDTO);
    }
}
