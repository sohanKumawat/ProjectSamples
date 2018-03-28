package com.demo.slk.design.vedingmachine.exception;

public class NotSufficientChangeException extends RuntimeException {
	private static final long serialVersionUID = -4273251638668132439L;
	private String message;

	public NotSufficientChangeException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
