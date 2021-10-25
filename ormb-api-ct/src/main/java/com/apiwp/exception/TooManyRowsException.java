package com.apiwp.exception;

public class TooManyRowsException extends RuntimeException {

  public TooManyRowsException(String message) {
    super(message);
  }

  public TooManyRowsException(String message, Throwable e) {
    super(message, e);
  }
}
