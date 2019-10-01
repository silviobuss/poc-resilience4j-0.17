package com.buss.circuitbreaker.resouce;

import com.buss.circuitbreaker.service.ExternalRequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/externalRequest")
public class ExternaRequestResource {

  private ExternalRequestService externalRequestService;

  public ExternaRequestResource(ExternalRequestService externalRequestService) {
    this.externalRequestService = externalRequestService;
  }

  @GetMapping("/date-time")
  public String dateTime() {
    return this.externalRequestService.getCurrentDateTime();
  }
}
