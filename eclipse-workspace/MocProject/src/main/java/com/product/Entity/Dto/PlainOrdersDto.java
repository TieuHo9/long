package com.product.Entity.Dto;

import com.product.Entity.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlainOrdersDto {
	private Long id;
	private String username;
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static PlainOrdersDto from(Users users) {
		PlainOrdersDto plainOrderDto = new PlainOrdersDto();
		plainOrderDto.setId(users.getId());
		plainOrderDto.setUsername(users.getUsername());
		return plainOrderDto;
		
	}
}
