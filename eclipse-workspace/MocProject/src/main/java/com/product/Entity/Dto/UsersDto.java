package com.product.Entity.Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.product.Entity.Users;

import lombok.Getter;
import lombok.Setter;

public class UsersDto {
	
	@Getter
	@Setter
	private Long id;
	private String username;
	private String password;
	private int phone;
	private String email;
	private String role;
	private String address;
	private List<OrdersDto> ordersDto = new ArrayList<>();
	public static UsersDto from(Users users) {
		UsersDto usersDto = new UsersDto();
		usersDto.setId(users.getId());
		usersDto.setUsername(users.getUsername());
		usersDto.setPassword(users.getPassword());
		usersDto.setEmail(users.getEmail());
		usersDto.setPhone(users.getPhone());
		usersDto.setRole(users.getRole());
		usersDto.setOrderDto(users.getOrders().stream().map(OrdersDto::from).collect(Collectors.toList()));
		return usersDto;
	}
	
	public List<OrdersDto> getOrderDto(){
		return ordersDto;
	}
	public void setOrderDto(List<OrdersDto> ordersDto) {
		this.ordersDto = ordersDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrdersDto> getOrdersDto() {
		return ordersDto;
	}

	public void setOrdersDto(List<OrdersDto> ordersDto) {
		this.ordersDto = ordersDto;
	}
	
	
	
}
