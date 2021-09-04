package com.vvs.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.vvs.ecommerce.model.Category;
import com.vvs.ecommerce.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  
  @Autowired
  CategoryRepository categoryRepository;

  public List<Category> listCategories() {
    return categoryRepository.findAll();
  }

  public void createCategory(Category category) {
    categoryRepository.save(category);
  }

  public Category readCategory(String categoryName) {
    return categoryRepository.findByCategoryName(categoryName);
  }

  public Optional<Category> readCategory(Long categoryId) {
    return categoryRepository.findById(categoryId);
  }

  public void updateCategory(Long categoryId, Category newCategory) {
    Category category = categoryRepository.findById(categoryId).get();
    category.setCategoryName(newCategory.getCategoryName());
    category.setImageUrl(newCategory.getImageUrl());
    category.setDescription(category.getDescription());
    categoryRepository.save(category);
  }
}
