package com.product.Entity.exception;

import java.text.MessageFormat;

public class ProductsIdReadyException extends RuntimeException{
	public ProductsIdReadyException(final Long productsId, final Long brandId) {
		super(MessageFormat.format("products: {0} da san sang: {1}", productsId, brandId));
	}
}
