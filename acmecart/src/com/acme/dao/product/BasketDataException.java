package com.acme.dao.product;

public class BasketDataException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NO_CART_ITEMS_FOUND =  "There are no Products in the Cart";

	public BasketDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BasketDataException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BasketDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BasketDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BasketDataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
