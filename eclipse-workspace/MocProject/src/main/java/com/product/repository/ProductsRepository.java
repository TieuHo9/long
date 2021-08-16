package com.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long>{

}
