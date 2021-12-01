package com.CTDECommerce.ECommerce.controller;

import com.CTDECommerce.ECommerce.model.dto.CategoryDTO;
import com.CTDECommerce.ECommerce.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;


    @PostMapping
    public ResponseEntity<CategoryDTO> salvar(@RequestBody CategoryDTO category){
        CategoryDTO categoryDTO = categoryService.salvar(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<CategoryDTO>>findAll(){
        return ResponseEntity.ok(categoryService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.buscarPorId(id);
        return ResponseEntity.ok(categoryDTO);
    }


}
