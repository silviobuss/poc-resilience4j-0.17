package com.buss.circuitbreaker.exception;

public class ConnectorException extends RuntimeException {

  public ConnectorException(String message, Throwable cause) {
    super(message, cause);
  }
}
