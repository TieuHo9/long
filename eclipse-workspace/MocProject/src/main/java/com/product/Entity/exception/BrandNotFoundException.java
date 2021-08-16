package com.product.Entity.exception;

import java.text.MessageFormat;

public class BrandNotFoundException extends RuntimeException{
	/**
	 * 
	 */


	public BrandNotFoundException(final Long id) {
		super(MessageFormat.format("khong tim thay id" , id));
	}


}
