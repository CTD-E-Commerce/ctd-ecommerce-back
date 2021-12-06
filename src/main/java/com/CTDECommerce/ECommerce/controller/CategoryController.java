package com.CTDECommerce.ECommerce.controller;

import com.CTDECommerce.ECommerce.model.dto.CategoryDTO;
import com.CTDECommerce.ECommerce.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> salvar(@RequestBody CategoryDTO category) {
        List<CategoryDTO> categoryDTOList = categoryService.buscarTodos();
        CategoryDTO categoryDTO1 = null;
        for (CategoryDTO categoryDTO : categoryDTOList) {
            if (category.getName().equals(categoryDTO.getName())) {
                return null;
            }
        }

        categoryDTO1 = categoryService.salvar(category);
        return ResponseEntity.ok(categoryDTO1);
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<CategoryDTO>>findAll(){
        return ResponseEntity.ok(categoryService.buscarTodos());
    }

    @GetMapping("/buscartodosname")
    public ResponseEntity<List<String>>findAllName(){
        return ResponseEntity.ok(categoryService.buscarTodosString());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.buscarPorId(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity buscarPorName(@PathVariable String name) {
        CategoryDTO categoryDTO = categoryService.buscarPorNome(name);
        return ResponseEntity.ok(categoryDTO);
    }
}
