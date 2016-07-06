package com.tellme.app.exception;

public class TellmeAppException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private ErrorCode errorCode;

  private Object[] messagePositionalArgs;

  private Throwable exception;

  public TellmeAppException(ErrorCode errorCode, Object... messagePositionalArgs) {
    this.errorCode = errorCode;
    this.messagePositionalArgs = messagePositionalArgs;
  }

  public TellmeAppException(ErrorCode errorCode, Throwable underlyingException,
      Object... messagePositionalArgs) {
    super(underlyingException);
    this.errorCode = errorCode;
    this.messagePositionalArgs = messagePositionalArgs;
    this.exception = underlyingException;
  }

  public TellmeAppException(Throwable underlyingException) {
    super(underlyingException);
    this.exception = underlyingException;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }

  public Object[] getMessagePositionalArgs() {
    return messagePositionalArgs;
  }

  public Throwable getException() {
    return exception;
  }

  public void setException(Throwable exception) {
    this.exception = exception;
  }

  public void setErrorCode(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public void setMessagePositionalArgs(Object[] messagePositionalArgs) {
    this.messagePositionalArgs = messagePositionalArgs;
  }


}
