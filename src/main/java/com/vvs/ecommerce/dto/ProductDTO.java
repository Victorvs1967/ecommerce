package com.vvs.ecommerce.dto;

import javax.validation.constraints.NotNull;

import com.vvs.ecommerce.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
  
  private Long id;
  @NotNull
  @NotNull
  private String name;
  @NotNull
  private double price;
  @NotNull
  private String imageUrl;
  private String description;
  @NotNull
  private Long categoryId;

  public ProductDTO(Product product) {
    this.setId(product.getId());
    this.setName(product.getName());
    this.setPrice(product.getPrice());
    this.setImageUrl(product.getImageUrl());
    this.setDescription(product.getDescription());
    this.setCategoryId(product.getCategory().getId());
  }

}
