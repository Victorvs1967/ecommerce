package com.vvs.ecommerce.controller;

import java.util.List;

import com.vvs.ecommerce.model.Category;
import com.vvs.ecommerce.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
  
  @Autowired
  private CategoryService categoryService;

  @GetMapping("/")
  public ResponseEntity<List<Category>> getCategories() {
    List<Category> body = categoryService.listCategories();
    return new ResponseEntity<>(body, HttpStatus.OK);
  }
  
}
