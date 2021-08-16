package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.Entity.Products; 
public interface ProductRepository extends JpaRepository<Products, Long> {

}

