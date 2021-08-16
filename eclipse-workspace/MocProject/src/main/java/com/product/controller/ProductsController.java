package com.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.Products;
import com.product.Entity.Dto.ProductsDto;
import com.product.service.ProductsService;

@RestController
@RequestMapping("/product/")
public class ProductsController {
	
	private final ProductsService productsService;
	
	@Autowired
	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	@PostMapping
	public ResponseEntity<ProductsDto> addProducts(@RequestBody final ProductsDto productsDto){
		Products products = productsService.addProducts(Products.from(productsDto));
		return new ResponseEntity<>(ProductsDto.from(products), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProductsDto>> getProducts(){
		List<Products> products = productsService.getProducts();
		List<ProductsDto> productsDto = products.stream()
				.map(ProductsDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(productsDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductsDto> getProducts(@PathVariable final Long id){
		Products products = productsService.getProducts(id);
		return new ResponseEntity<>(ProductsDto.from(products), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductsDto> editProducts(@PathVariable final Long id, @RequestBody final ProductsDto productsDto){
		Products editedProducts = productsService.editProducts(id, Products.from(productsDto));
		return new ResponseEntity<>(ProductsDto.from(editedProducts), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProductsDto> deleteProducts(@PathVariable final Long id){
		Products products = productsService.deleteProducts(id);
		return new ResponseEntity<>(ProductsDto.from(products), HttpStatus.OK);
	}
}