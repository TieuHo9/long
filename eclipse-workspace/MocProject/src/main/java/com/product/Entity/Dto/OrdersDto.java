package com.product.Entity.Dto;

import java.time.LocalDate;
import java.util.Objects;

import com.product.Entity.Orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDto {
	private Long id;
	private int phone;
	private String address;
	private LocalDate time;
	private int total;
	private int ship;
	private int finalprice;
	private String Status;
	
	private PlainOrdersDto plainOrderDto;

	public static OrdersDto from(Orders orders) {
		OrdersDto ordersDto = new OrdersDto();
		ordersDto.setId(orders.getId());
		ordersDto.setPhone(orders.getPhone());
		ordersDto.setAddress(orders.getAddress());
		ordersDto.setTime(orders.getTime());
		ordersDto.setTotal(orders.getTotal());
		ordersDto.setShip(orders.getShip());
		ordersDto.setFinalprice(orders.getFinalprice());
		ordersDto.setStatus(orders.getStatus());
		if(Objects.nonNull(orders.getUser())){
			ordersDto.setPlainOrderDto(PlainOrdersDto.from(orders.getUser()));
		}
		return ordersDto;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getShip() {
		return ship;
	}

	public void setShip(int ship) {
		this.ship = ship;
	}

	public int getFinalprice() {
		return finalprice;
	}

	public void setFinalprice(int finalprice) {
		this.finalprice = finalprice;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public PlainOrdersDto getPlainOrderDto() {
		return plainOrderDto;
	}

	public void setPlainOrderDto(PlainOrdersDto plainOrderDto) {
		this.plainOrderDto = plainOrderDto;
	}
	
}
