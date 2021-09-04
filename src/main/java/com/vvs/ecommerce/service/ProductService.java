package com.vvs.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import com.vvs.ecommerce.dto.ProductDTO;
import com.vvs.ecommerce.model.Category;
import com.vvs.ecommerce.model.Product;
import com.vvs.ecommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepository productRepository;

  public List<ProductDTO> listProducts() {
    List<Product> products = productRepository.findAll();
    List<ProductDTO> productDtos = new ArrayList<>();
    for (Product product : products) {
      productDtos.add(new ProductDTO(product));
    }
    return productDtos;
  }

  public static Product getProductFromDto(ProductDTO productDto, Category category) {
    Product product = new Product();
    product.setCategory(category);
    product.setName(productDto.getName());
    product.setPrice(productDto.getPrice());
    product.setImageUrl(productDto.getImageUrl());
    product.setDescription(productDto.getDescription());
    return product;
  }

  public void addProduct(ProductDTO productDto, Category category) {
    Product product = getProductFromDto(productDto, category);
    productRepository.save(product);
  }

  public void updateProduct(Long productId, ProductDTO productDto, Category category) {
    Product product = getProductFromDto(productDto, category);
    product.setId(productId);
    productRepository.save(product);
  }
}
