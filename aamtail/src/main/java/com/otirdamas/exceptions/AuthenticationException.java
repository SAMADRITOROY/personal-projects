package com.otirdamas.exceptions;

public class AuthenticationException extends Exception {
	
	private static final long serialVersionUID = -1371619636791498845L;

	public AuthenticationException() {
		super();
	}
	
	public AuthenticationException(String message) {
        super(message);
    }
	
}
