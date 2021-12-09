package com.CTDECommerce.ECommerce.controller;

import com.CTDECommerce.ECommerce.model.dto.CategoryDTO;
import com.CTDECommerce.ECommerce.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*", allowedHeaders="")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping("/buscartodos")
    public ResponseEntity<List<CategoryDTO>>findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/buscartodosname")
    public ResponseEntity<List<String>>findAllName(){
        return ResponseEntity.ok(categoryService.findAllStringCategory());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity findBYId(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.findById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        CategoryDTO categoryDTO = categoryService.findByNameCategory(name);
        return ResponseEntity.ok(categoryDTO);
    }
}
