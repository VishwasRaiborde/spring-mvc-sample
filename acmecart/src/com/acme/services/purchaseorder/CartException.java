package com.acme.services.purchaseorder;

public class CartException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "Uable to Save Cart" ;

	public CartException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CartException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CartException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CartException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
