package com.demo.slk.design.vedingmachine.exception;

public class SoldOutException extends RuntimeException {
	private static final long serialVersionUID = -7211475688838164110L;
	private String message;

	public SoldOutException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
