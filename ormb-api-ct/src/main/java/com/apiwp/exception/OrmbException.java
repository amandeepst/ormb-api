package com.apiwp.exception;

public class OrmbException extends RuntimeException {

  public OrmbException(String message) {
    super(message);
  }

  public OrmbException(String message, Throwable e) {
    super(message, e);
  }
}
