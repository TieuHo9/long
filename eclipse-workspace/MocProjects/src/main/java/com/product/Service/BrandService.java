package com.product.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Brand;
import com.product.Entity.Products;
import com.product.Entity.Dto.BrandDto;
import com.product.Entity.Exception.BrandNotFoundException;
import com.product.Entity.Exception.ProductsIdReadyEcception;
import com.product.Entity.Exception.ProductsNotFoundException;
import com.product.Repository.BrandRepository;
import com.product.Repository.ProductsRepository;


@Service
public class BrandService {
	@Autowired
	BrandRepository brandRepository;
	
	@Autowired
	ProductsRepository productRepository;
	
	public BrandDto addBrand(BrandDto brandDto) {
		Brand brand = new Brand();
		brand.setName(brandDto.getName());
		brand = brandRepository.save(brand);
		return BrandDto.from(brand);
	}
	
	public List<Brand> getBrand(){
		return StreamSupport
				.stream(brandRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	@Transactional
	public void deleteBrand(Long id) throws Exception{
		// Kiểm tra xem user đó có trong db ko, ko có thì ra lỗi luôn, ko cần xóa nữa
		brandRepository.findById(id).orElseThrow(() -> new Exception("this brand not found"));
		
		brandRepository.deleteById(id);
	}
	
	public BrandDto getBrand(Long id) {
		// Get brand
		Brand brand = brandRepository.findById(id)
				.orElseThrow(() -> new BrandNotFoundException(id));
		
		
		// Get list product of brand
//		List<Products> productList = productRepository.findByBrandId(brand.getId());
		
//		brand.setProducts(productList);
		
		return BrandDto.from(brand);
	}
	@Transactional
	public BrandDto editBrand(Long id, BrandDto brandDto) {
		Brand brandToEdit = brandRepository.findById(id).orElseThrow(() -> new BrandNotFoundException(id));
		brandToEdit.setName(brandDto.getName());
		brandToEdit = brandRepository.save(brandToEdit);
		return BrandDto.from(brandToEdit);
	}
	@Transactional
	public BrandDto addProductsToBrand(Long productsId, Long brandId) {
		Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new BrandNotFoundException(brandId));
		Products products = productRepository.findById(productsId).orElseThrow(() -> new ProductsNotFoundException(productsId));
		if(Objects.nonNull(products.getBrand())) {
			throw new ProductsIdReadyEcception(productsId,
					products.getBrand().getId());	
		}
		brand.addProducts(products);
		return BrandDto.from(brand);
	}
	@Transactional
	public BrandDto removeProductsFromBrand(Long brandId, Long productsId) {
		Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new BrandNotFoundException(brandId));
		Products products = productRepository.findById(productsId).orElseThrow(() -> new BrandNotFoundException(productsId));
		brand.removeProducts(products);
		return BrandDto.from(brand);
	}
}