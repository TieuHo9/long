package com.product.Entity.Dto;

import java.util.Objects;

import com.product.Entity.Products;

import lombok.Data;

@Data
public class ProductsDto {
	private Long id;
	private String name;
	private int price;
	private String status;
	private String size;
	private String color;
	
	private PlainProductsDto plainProductsDto;	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public static ProductsDto from(Products products) {
		ProductsDto productsDto = new ProductsDto();
		productsDto.setId(products.getId());
		productsDto.setName(products.getName());
		productsDto.setPrice(products.getPrice());
		productsDto.setStatus(products.getStatus());
		productsDto.setSize(products.getSize());
		productsDto.setColor(products.getColor());
		if(Objects.nonNull(products.getBrand())) {
			productsDto.setPlainProductsDto(PlainProductsDto.from(products.getBrand()));;
		}
		return productsDto;
	}



	public PlainProductsDto getPlainProductsDto() {
		return plainProductsDto;
	}



	public void setPlainProductsDto(PlainProductsDto plainProductsDto) {
		this.plainProductsDto = plainProductsDto;
	}
}
