package com.worldpay.servicing.web.controller;

import com.worldpay.servicing.core.service.SRV130Service;
import com.worldpay.servicing.model.entity.Balance;
import com.worldpay.servicing.model.entity.HeaderInfo;
import com.worldpay.servicing.model.entity.SRV130;
import com.worldpay.servicing.model.entity.SRV130JsonPojo;
import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ormb-apis/Ser130")
@Monitored
public class SRV130Controller {

  @Autowired
  private SRV130Service merchantBalanceservice;

  @GetMapping(path = "getMerchantBalance/params", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<SRV130JsonPojo> retrieveAllMerchantBalanaceById(
      @RequestParam(value = "perIdNbr") String perIdNbrParam) {
    SRV130JsonPojo srv130 = new SRV130JsonPojo();
    List<SRV130> entity = null;
    String perIdNbr = perIdNbrParam.trim();
    String count = merchantBalanceservice.checkPerIdNbr(perIdNbr);

    if (count != null) {

      entity = merchantBalanceservice.loadByPerIdNbr(perIdNbr);
      setHeader(entity, perIdNbr, srv130);
      return new ResponseEntity<>(srv130, HttpStatus.OK);
    } else {
      Balance balance = new Balance();
      srv130.setCallInfo(HeaderInfo.getHeaderOfMerchantBalanceService130(perIdNbr));
      srv130.setBalance(balance);
      return new ResponseEntity<>(srv130, HttpStatus.NOT_FOUND);
    }
  }

  private void setHeader(List<SRV130> entity, String perIdNbr, SRV130JsonPojo srv130) {
    Balance balance = new Balance();
    balance.setBalanceList(entity);
    srv130.setBalance(balance);
    srv130.setCallInfo(HeaderInfo.getHeaderOfMerchantBalanceService130(perIdNbr));

  }
}
