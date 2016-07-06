package com.tellme.app.exception;

public class InvalidRequestException extends ClientException {

  public InvalidRequestException(ErrorCode errorCode, Object... args) {
    super(errorCode, args);
  }

  public InvalidRequestException(ErrorCode errorCode, Throwable underlyingException, Object... args) {
    super(errorCode, underlyingException, args);
  }

}
