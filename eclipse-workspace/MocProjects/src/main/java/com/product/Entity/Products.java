package com.product.Entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.product.Entity.Dto.ProductsDto;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "product")
public class Products implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Brand brand;
	
	/*public static Products from(Products productsDto) {
		Products products = new Products();
		prodlocalhost:8080/product/ucts.set
	}*/
//	public int brandId;
	
	 @Column(name = "name") private String name;
	 
	 @Column(name = "price") private int price;
	  
	 //@Column(name = "brand_id") private int brand_id;
	 
	 @Column(name = "status") private String status;
	 
//	 @Column(name = "size") private String size;
	 
//	 @Column(name = "color") private String color;
	 
	
	public  Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	/*
	 * public int getBrand_id() { return brand_id; }
	 * 
	 * 
	 * public void setBrand_id(int brand_id) { this.brand_id = brand_id; }
	 */


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


//	public String getSize() {
//		return size;
//	}
//
//
//	public void setSize(String size) {
//		this.size = size;
//	}
//
//
//	public String getColor() {
//		return color;
//	}
//
//
//	public void setColor(String color) {
//		this.color = color;
//	}
	
//	public static Products from(ProductsDto productsDto) {
//		Products products = new Products();
//		products.setName(productsDto.getName());
//		// Ở entity ko gọi đc repo nên viết hàm này ở service luôn
//		products.setBrand(null);
////		products.brandId = productsDto.getBrand_id();
//		products.setPrice(productsDto.getPrice());
//		products.setStatus(productsDto.getStatus());
////		products.setSize(productsDto.getSize());
////		products.setColor(productsDto.getColor());
//		return products;
//	}


	public void add(Products products) {
		// TODO Auto-generated method stub
		
	}


	public void remove(Products products) {
		// TODO Auto-generated method stub
		
	}



}