package com.product.Controller;

class ProductsNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ProductsNotFoundException(Long id){
		super("khong tin thatsan pham" +id);
	}
}
