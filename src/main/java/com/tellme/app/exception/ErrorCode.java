package com.tellme.app.exception;

public enum ErrorCode {
  INVALID_REQUEST("Invalid Request.");
  
  private String message;

  ErrorCode(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public String getValue() {
    return this.message;
  }

}
