package com.product.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Orders;
import com.product.Entity.Users;
import com.product.Entity.exception.OrdersIsReadyException;
import com.product.Entity.exception.UsersNotFoundException;
import com.product.repository.UsersRepository;

@Service
public class UsersService {
	
	private final UsersRepository usersRepository;
	private final OrdersService ordersService;
	
	@Autowired
	public UsersService(UsersRepository usersRepository,OrdersService ordersService) {
		this.ordersService = ordersService;
		this.usersRepository = usersRepository;
	}
	
	public Users addUser(Users users) {
		return usersRepository.save(users);
	}
	
	public List<Users> getUser(){
		return StreamSupport
				.stream(usersRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Users deleteUser(Long id) {
		Users user = getUser(id);
		usersRepository.deleteById(id);
		return user;	
	}
	
	public Users getUser(Long id) {
		return usersRepository.findById(id)
				.orElseThrow(() -> new UsersNotFoundException(id));
	}
	@Transactional
	public Users editUser(Long id, Users user) {
		Users userToEdit = getUser(id);
		userToEdit.setUsername(user.getUsername());
		userToEdit.setPassword(user.getPassword());
		userToEdit.setPhone(user.getPhone());
		userToEdit.setAddress(user.getAddress());
		userToEdit.setEmail(user.getEmail());
		userToEdit.setRole(user.getRole());
		return userToEdit;
	}
	@Transactional
	public Users addOrderToUser(Long ordersId, Long usersId) {
		Users users = getUser(usersId);
		Orders orders = ordersService.getOrder(ordersId);
		if(Objects.nonNull(orders.getUser())) {
			throw new  OrdersIsReadyException(ordersId, orders.getUser().getId());
		}
		users.addOrder(orders);
		return users;
	}
	
	@Transactional
	public Users removeOrderFromUser(Long usersId, Long ordersId) {
		Users users = getUser(usersId);
		Orders orders = ordersService.getOrder(ordersId);
		users.removeOrder(orders);
		return users;
	}


	
}
