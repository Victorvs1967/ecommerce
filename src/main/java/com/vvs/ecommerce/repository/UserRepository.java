package com.vvs.ecommerce.repository;

import com.vvs.ecommerce.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
