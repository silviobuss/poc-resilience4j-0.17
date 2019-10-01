package com.buss.circuitbreaker.connnector;

import com.buss.circuitbreaker.exception.ConnectorException;
import com.buss.circuitbreaker.client.DateTimeClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
@Retry(name = "externalRequest")
@RateLimiter(name = "externalRequest")
@CircuitBreaker(name = "externalRequest", fallbackMethod = "fallback")
public class ExternalRequestConnector {

  private DateTimeClient dateTimeClient;

  public ExternalRequestConnector(DateTimeClient dateTimeClient) {
    this.dateTimeClient = dateTimeClient;
  }

  public String getCurrentDateTime() {
    return dateTimeClient.getCurrentDateTime();
  }

  public String fallback(ConnectorException ex) {
    return "Unavailable service.";
  }

  private String fallback(Throwable ex) {
    return "Recovered Throwable.";
  }
}
