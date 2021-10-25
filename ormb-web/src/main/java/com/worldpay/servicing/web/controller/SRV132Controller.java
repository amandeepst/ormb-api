package com.worldpay.servicing.web.controller;

import com.worldpay.servicing.core.service.SRV132Service;
import com.worldpay.servicing.model.entity.HeaderInfo;
import com.worldpay.servicing.model.entity.SRV132;
import com.worldpay.servicing.model.entity.SRV132JsonPojo;
import com.worldpay.servicing.model.entity.SettlementGroupList;
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
@RequestMapping("/ormb-apis/Ser132")
@Monitored
public class SRV132Controller {

  @Autowired
  private SRV132Service merchantsettlementService;

  @GetMapping(path = "/getMerchantSettlementGroup/params", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<SRV132JsonPojo> retrieveAllBalance(
      @RequestParam(value = "perIdNbr") String perIdNbrParam) {

    List<SRV132> entity = null;
    SettlementGroupList settlementGroupList = new SettlementGroupList();
    String perIdNbr = perIdNbrParam.trim();
    String count = merchantsettlementService.checkPerIdNbr(perIdNbr);
    SRV132JsonPojo srv132 = new SRV132JsonPojo();

    if (count == null) {
      entity = null;
      setHeader(entity, perIdNbr, srv132, settlementGroupList);
      settlementGroupList.setPartyId(perIdNbr);
      return new ResponseEntity<>(srv132, HttpStatus.NOT_FOUND);
    } else {
      entity = merchantsettlementService.loadByPerIdNbr(perIdNbr);
      settlementGroupList.setPartyId(perIdNbr.trim());
      setHeader(entity, perIdNbr, srv132, settlementGroupList);
      return new ResponseEntity<>(srv132, HttpStatus.OK);
    }

  }

  private void setHeader(List<SRV132> entity, String perIdNbr, SRV132JsonPojo srv132,
      SettlementGroupList settlementGroupList) {
    settlementGroupList.withSettlementGroup(entity);
    srv132.setSettlementGroupList(settlementGroupList);
    srv132.setCallInfo(HeaderInfo.getHeaderOfSettlementGroupService132(perIdNbr));
  }

}
