package com.vvs.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String categoryName;
  @NotNull
  private String imageUrl;
  private String description;

  public Category(String categoryName, String imageUrl) {
    this.categoryName = categoryName;
    this.imageUrl = imageUrl;
  }

}
