package com.dsalgo.exceptions;

public final class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4018695465219793903L;

	private String message;

	public CustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
