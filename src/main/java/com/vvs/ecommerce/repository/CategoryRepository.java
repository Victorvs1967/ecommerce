package com.vvs.ecommerce.repository;

import com.vvs.ecommerce.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  Category findByCategoryName(String categoryName);
}
