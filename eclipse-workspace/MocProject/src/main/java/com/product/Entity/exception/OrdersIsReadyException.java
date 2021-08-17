package com.product.Entity.exception;

import java.text.MessageFormat;

public class OrdersIsReadyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  OrdersIsReadyException(final Long ordersId, final Long userId) {
		super(MessageFormat.format("orders: {0} da san sang: {1}", ordersId, userId));
	}
}