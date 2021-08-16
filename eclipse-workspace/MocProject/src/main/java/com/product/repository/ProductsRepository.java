package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}
