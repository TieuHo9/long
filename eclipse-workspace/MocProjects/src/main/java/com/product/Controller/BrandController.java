package com.product.Controller;

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

import com.product.Entity.Brand;
import com.product.Entity.Dto.BrandDto;
import com.product.Service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@PostMapping
	public ResponseEntity<BrandDto> addBrand(@RequestBody final BrandDto brandDto){
		return new ResponseEntity<>(brandService.addBrand(brandDto), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<BrandDto>> getBrand(){
		List<Brand> brand = brandService.getBrand();
		List<BrandDto> brandDto = brand.stream().map(BrandDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(brandDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BrandDto> getBrand(@PathVariable final Long id){
		return new ResponseEntity<>(brandService.getBrand(id), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteBrand(@PathVariable final Long id){
		try {
			brandService.deleteBrand(id);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return new ResponseEntity<>("Delete success", null , HttpStatus.OK);

	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<BrandDto> editBrand(@PathVariable final Long id, @RequestBody final BrandDto brandDto){
		return new ResponseEntity<>(brandService.editBrand(id, brandDto), HttpStatus.OK);
		
	}
	
	@PostMapping(value = "{brandId}/products/{products}/add")
	public ResponseEntity<BrandDto> addProductsToBrand(@PathVariable final Long brandId,@PathVariable final Long productsId){
		return new ResponseEntity<>(brandService.addProductsToBrand(brandId, productsId), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{brandId}/products/{productsId}/remove")
	public ResponseEntity<BrandDto> removeProductsFromBrand(@PathVariable final Long brandId,@PathVariable final Long productsId){
		return new ResponseEntity<>(brandService.removeProductsFromBrand(brandId, productsId), HttpStatus.OK);
	}
	 
	
}