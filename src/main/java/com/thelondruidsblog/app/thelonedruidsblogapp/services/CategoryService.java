package com.thelondruidsblog.app.thelonedruidsblogapp.services;

import com.thelondruidsblog.app.thelonedruidsblogapp.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    CategoryDto deleteCategory(Integer categoryId);

    List<CategoryDto> getCategories();

    CategoryDto getCategoryById(Integer categoryId);
}
