package com.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Brand;

@Repository
public interface BrandRepository  extends CrudRepository<Brand, Long>{

}
