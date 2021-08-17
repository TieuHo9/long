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

import com.product.Entity.Users;
import com.product.Entity.Dto.UsersDto;
import com.product.service.UsersService;

@RestController
@RequestMapping("/users/")
public class UsersController {

	private final UsersService usersService;
	
	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@PostMapping
	public ResponseEntity<UsersDto> adduser(@RequestBody final UsersDto usersDto){
		Users users = usersService.addUser(Users.from(usersDto));
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<UsersDto>> getUser(){
		List<Users> user = usersService.getUser();
		List<UsersDto> usersDto = user.stream().map(UsersDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(usersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsersDto> getUser(@PathVariable final Long id){
		Users users = usersService.getUser(id);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UsersDto> deleteUser(@PathVariable final Long id){
		Users users = usersService.deleteUser(id);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsersDto> editUser(@PathVariable final Long id, @RequestBody final UsersDto userDto){
		Users users = usersService.editUser(id, Users.from(userDto));
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	
	@PostMapping(value = "{userId}/orders/{ordersId}/add")
	public ResponseEntity<UsersDto> addOrderToUser(@PathVariable final Long usersId, @PathVariable final Long oredersId){
		Users users = usersService.removeOrderFromUser(usersId, oredersId);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{userId}/orders/{ordersId}/remove")
	public ResponseEntity<UsersDto> removeOrderToUser(@PathVariable final Long usersId, @PathVariable final Long oredersId){
		Users users = usersService.removeOrderFromUser(usersId, oredersId);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
}
