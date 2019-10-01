package com.buss.circuitbreaker.service;

import com.buss.circuitbreaker.connnector.ExternalRequestConnector;
import org.springframework.stereotype.Service;

@Service
public class ExternalRequestService {

  private final ExternalRequestConnector externalRequestConnector;

  public ExternalRequestService(ExternalRequestConnector externalRequestConnector) {
    this.externalRequestConnector = externalRequestConnector;
  }

  public String getCurrentDateTime() {
    return this.externalRequestConnector.getCurrentDateTime();
  }
}
