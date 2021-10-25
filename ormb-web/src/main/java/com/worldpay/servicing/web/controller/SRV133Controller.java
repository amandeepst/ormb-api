package com.worldpay.servicing.web.controller;

import com.worldpay.servicing.core.service.SRV133Service;
import com.worldpay.servicing.model.entity.HeaderInfo;
import com.worldpay.servicing.model.entity.SRV133;
import com.worldpay.servicing.model.entity.SRV133JsonPojo;
import com.worldpay.servicing.model.entity.SRV133Request;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ormb-apis/Ser133")
@Monitored
public class SRV133Controller {

  @Autowired
  private SRV133Service pricingService;

  @GetMapping(path = "/getPricing/params", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<SRV133JsonPojo> retrievePricing(
      @RequestParam(value = "perIdNbr") String perIdNbr,
      @RequestParam(value = "classVal", required = false) Optional<String> classVal,
      @RequestParam(value = "sClassVal", required = false) Optional<String> sClassVal,
      @RequestParam(value = "priceItemCd", required = false) Optional<String> priceItemCd) {
    SRV133JsonPojo srv133 = new SRV133JsonPojo();
    List<SRV133> srv133List = new ArrayList<>();
    String count = pricingService.checkPerIdNbr(perIdNbr);
    if (count == null) {
      srv133List = null;
      srv133.setCallInfo(HeaderInfo.getHeaderOfPriceService133(perIdNbr));
      srv133.setPriceList(srv133List);
      return new ResponseEntity<>(srv133, HttpStatus.NOT_FOUND);
    } else {
      SRV133Request srv133Request = SRV133Request.builder().perIdNbr(perIdNbr).classVal(classVal.map(String::trim).orElse("")).sClassVal(
          sClassVal.map(String::trim).orElse("")).priceItemCd(priceItemCd.map(String::trim).orElse("")).build();
      srv133List = pricingService.findByAll(srv133Request);

    }

    srv133.setCallInfo(HeaderInfo.getHeaderOfPriceService133(perIdNbr));
    srv133.setPriceList(srv133List);
    return new ResponseEntity<>(srv133, HttpStatus.OK);
  }

  @InitBinder("perIdNbr")
  public void initBinder(WebDataBinder dataBinder) {

    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

  }
}
