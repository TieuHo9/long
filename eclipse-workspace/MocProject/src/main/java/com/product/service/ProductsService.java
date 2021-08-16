package com.product.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Products;
import com.product.Entity.exception.ProductsNotFoundException;
import com.product.repository.ProductsRepository;

@Service
public class ProductsService {
	private final ProductsRepository productsRepository;
	@Autowired
	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	public Products addProducts(Products products) {
		return productsRepository.save(products);
	}
	
	public List<Products> getProducts(){
		return StreamSupport
				.stream(productsRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Products getProducts(Long id) {
		return productsRepository.findById(id)
				.orElseThrow(() -> new ProductsNotFoundException(id));
	}
	
	public Products deleteProducts(Long id) {
		Products products = getProducts(id);
		productsRepository.delete(products);
		return products;
	}
	@Transactional
	public Products editProducts(Long id, Products products) {
		Products productsToEdit = getProducts(id);
		productsToEdit.setName(products.getName());
		//productsToEdit.setBrand_id(products.getBrand_id());
		productsToEdit.setPrice(products.getPrice());
		productsToEdit.setSize(products.getSize());
		productsToEdit.setStatus(products.getStatus());
		productsToEdit.setColor(products.getColor());
		return productsToEdit;
	}
}
