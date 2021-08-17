package com.product.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Orders;
import com.product.Entity.exception.OrdersNotFoundException;
import com.product.repository.OrdersRepository;

@Service
public class OrdersService {

	private final OrdersRepository ordersRepository;
	@Autowired
	public OrdersService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}
	
	public Orders addOrder(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	public List<Orders> getOrder(){
		return StreamSupport
				.stream(ordersRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Orders getOrder(Long id) {
		return ordersRepository.findById(id)
				.orElseThrow(() -> new OrdersNotFoundException(id));
	}
	
	public Orders deleteOrder(Long id) {
		Orders orders = getOrder(id);
		ordersRepository.delete(orders);
		return orders;
	}
	
	@Transactional
	public Orders editOrder(Long id, Orders orders) {
		Orders ordersToEdit = getOrder(id);
		ordersToEdit.setAddress(orders.getAddress());
		ordersToEdit.setPhone(orders.getPhone());
		ordersToEdit.setTotal(orders.getTotal());
		ordersToEdit.setShip(orders.getShip());
		ordersToEdit.setFinalprice(orders.getFinalprice());
		ordersToEdit.setStatus(orders.getStatus());
		ordersToEdit.setTime(orders.getTime());
		return ordersToEdit;
	}
	
}
