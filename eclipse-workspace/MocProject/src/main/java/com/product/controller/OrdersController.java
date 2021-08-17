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

import com.product.Entity.Orders;
import com.product.Entity.Dto.OrdersDto;
import com.product.service.OrdersService;

@RestController
@RequestMapping("/orders/")
public class OrdersController {

	private final OrdersService ordersService;
	
	@Autowired
	public OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	@PostMapping
	public ResponseEntity<OrdersDto> addOrder(@RequestBody final OrdersDto ordersDto){
		Orders orders = ordersService.addOrder(Orders.from(ordersDto));
		return new ResponseEntity<>(OrdersDto.from(orders), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<OrdersDto>> getOrder(){
		List<Orders> orders = ordersService.getOrder();
		List<OrdersDto> ordersDto = orders.stream().map(OrdersDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(ordersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdersDto> getOrder(@PathVariable final Long id){
		Orders orders = ordersService.getOrder(id);
		return new ResponseEntity<>(OrdersDto.from(orders), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<OrdersDto> editOrder(@PathVariable final Long id, @RequestBody final OrdersDto ordersDto){
		Orders editedOrder = ordersService.editOrder(id, Orders.from(ordersDto));
		return new ResponseEntity<>(OrdersDto.from(editedOrder), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<OrdersDto> deleteOrder(@PathVariable final Long id){
		Orders orders = ordersService.deleteOrder(id);
		return new ResponseEntity<>(OrdersDto.from(orders), HttpStatus.OK);
	}
}
