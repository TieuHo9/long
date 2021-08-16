package com.product.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.product.Entity.Dto.BrandDto;

import lombok.Data;

@Data
@Entity
@Table(name = "branch")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id")
	
	private List<Products> products = new ArrayList<>();
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public void addProducts(Products products) {
		
	}

	public void removeProducts(Products products) {
		// TODO Auto-generated method stub
		
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public static Brand from(BrandDto brandDto) {
		Brand brand = new Brand();
		brand.setName(brandDto.getName());
		return brand;
	}
	
}
