package com.product.Controller;

public class BranchNotFoundException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	BranchNotFoundException(Long id){
		super("khong tim duoc" +id);
	}
}
