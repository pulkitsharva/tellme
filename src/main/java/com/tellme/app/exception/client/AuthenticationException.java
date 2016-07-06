package com.tellme.app.exception.client;

import com.tellme.app.exception.ErrorCode;
import com.tellme.app.exception.TellmeAppException;

public class AuthenticationException extends TellmeAppException {

	private static final long serialVersionUID = 1L;

	public AuthenticationException(ErrorCode errorCode, Object... args) {
		super(errorCode, args);
	}

	public AuthenticationException(ErrorCode errorCode, Throwable underlyingException, Object... args) {
		super(errorCode, underlyingException, args);
	}

}
