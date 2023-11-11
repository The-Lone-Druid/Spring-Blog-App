package com.thelondruidsblog.app.thelonedruidsblogapp.controllers;

import com.thelondruidsblog.app.thelonedruidsblogapp.payloads.CategoryDto;
import com.thelondruidsblog.app.thelonedruidsblogapp.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDTO) {
        CategoryDto createdCategory = categoryService.createCategory(categoryDTO);

        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@Valid @PathVariable Integer categoryId) {
        CategoryDto category = categoryService.getCategoryById(categoryId);

        return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = categoryService.getCategories();

        return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto updateDTO, @Valid @PathVariable Integer categoryId) {
        CategoryDto updatedCategory = categoryService.updateCategory(updateDTO, categoryId);

        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }


    @DeleteMapping("{categoryId}")
    public ResponseEntity<CategoryDto> deleteCategory(@Valid @PathVariable Integer categoryId) {
        CategoryDto updatedCategory = categoryService.deleteCategory(categoryId);

        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }
}
