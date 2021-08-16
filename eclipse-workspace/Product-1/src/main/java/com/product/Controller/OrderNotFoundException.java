package com.product.Controller;

public class OrderNotFoundException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	OrderNotFoundException(Long id){
		super("khong tim duoc" +id);
	}
}


