package com.vvs.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.vvs.ecommerce.common.ApiResponse;
import com.vvs.ecommerce.dto.ProductDTO;
import com.vvs.ecommerce.model.Category;
import com.vvs.ecommerce.service.CategoryService;
import com.vvs.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
  
  @Autowired
  private ProductService productService;
  @Autowired
  private CategoryService categoryService;

  @GetMapping("/")
  public ResponseEntity<List<ProductDTO>> getProducts() {
    List<ProductDTO> body = productService.listProducts();
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDTO productDto) {
    Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
    if (optionalCategory.isPresent()) {
      return new ResponseEntity<>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
    }
    Category category = optionalCategory.get();
    productService.addProduct(productDto, category);
    return new ResponseEntity<>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
  }

  @PostMapping("/update/{productId}")
  public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Long productId, @RequestBody @Valid ProductDTO productDto) {
    Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
    if (!optionalCategory.isPresent()) {
      return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
    }
    Category category = optionalCategory.get();
    productService.updateProduct(productId, productDto, category);
    return new ResponseEntity<>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
  }
}
