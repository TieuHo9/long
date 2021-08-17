package com.product.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;
import com.product.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Brand;
import com.product.Entity.Products;
import com.product.Entity.exception.BrandNotFoundException;
import com.product.Entity.exception.ProductsIdReadyException;
import com.product.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private final BrandRepository brandRepository;
	@Autowired
	private final ProductsService productsService;
	
	@Autowired
	public BrandService(BrandRepository brandRepository, ProductsService productsService) {
		this.brandRepository = brandRepository;
		this.productsService = productsService;
	}
	
	public Brand addBrand(Brand brand) {
		return brandRepository.save(brand);
	}
	
	public List<Brand> getBrand(){
		return StreamSupport
				.stream(brandRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Brand deleteBrand(Long id) {
		Brand brand = getBrand(id); 
		brandRepository.deleteById(id);
		return brand;
	}
	
	public Brand getBrand(Long id) {
		// TODO Auto-generated method stub
		return brandRepository.findById(id)
				.orElseThrow(() -> new BrandNotFoundException(id));
	}
	@Transactional
	public Brand editBrand(Long id, Brand brand) {
		Brand brandToEdit = getBrand(id);
		brandToEdit.setName(brand.getName());
		return brandToEdit;
	}
	@Transactional
	public Brand addProductsToBrand(Long productsId, Long brandId) {
		Brand brand = getBrand(brandId);
		Products products = productsService.getProducts(productsId);
		if(Objects.nonNull(products.getBrand())) {
			throw new ProductsIdReadyException(productsId,
					products.getBrand().getId());	
		}
		brand.addProducts(products);
		return brand;
	}
	@Transactional
	public Brand removeProductsFromBrand(Long brandId, Long productsId) {
		Brand brand = getBrand(brandId);
		Products products = productsService.getProducts(productsId);
		brand.removeProducts(products);
		return brand;
	}
}
