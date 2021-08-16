package com.product.Controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.Products;
import com.product.Repository.ProductRepository;
@RestController
@RequestMapping("/api/")
public class ProductsController {
	private final ProductRepository productres;
	ProductsController(ProductRepository productres){
		this.productres = productres;
	}
	
	@GetMapping("/products/")
	List<Products> all(){
		return productres.findAll();
	}
	
	@PostMapping("/products/")
	Products newProducts(@RequestBody Products newProducts) {
		return productres.save(newProducts);
	}
	
	@GetMapping("/products/{id}")
	Products one(@PathVariable Long id) {
		return productres.findById(id)
				.orElseThrow(() -> new ProductsNotFoundException(id));
	}
	
	@PutMapping("/products/{id}")
	Products replaceProducts(@RequestBody Products newProducts, @PathVariable Long id) {
		return productres.findById(id)
				.map(products ->{
					products.setName(newProducts.getName());
					products.setBrand_id(newProducts.getBrand_id());
					//products.setCate_id(newProducts.getCate_id());
					products.setColor(newProducts.getColor());
					
					products.setPrice(newProducts.getPrice());
					products.setSize(newProducts.getSize());
					products.setStatus(newProducts.getStatus());
					return productres.save(products);
				})
				.orElseGet(() ->{
					newProducts.setId(id);
					return productres.save(newProducts);
				
				});
	}
	@DeleteMapping("/products/{id}")
		void deleteProducts(@PathVariable Long id) {
			productres.deleteById(id);
		}
	
	
}
