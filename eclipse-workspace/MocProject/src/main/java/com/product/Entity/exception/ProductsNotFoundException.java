package com.product.Entity.exception;

import java.text.MessageFormat;

public class ProductsNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	public ProductsNotFoundException(final Long id) {
		super(MessageFormat.format("khong tim thay id" , id));
	}

}
