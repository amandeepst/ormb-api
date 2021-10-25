package com.worldpay.servicing.web.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.worldpay.servicing.core.service.SRV131Service;
import com.worldpay.servicing.model.entity.HeaderInfo;
import com.worldpay.servicing.model.entity.OpenBills;
import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV131Json;
import com.worldpay.servicing.model.entity.SRV131JsonPojo;
import com.worldpay.servicing.model.entity.SRV131Request;
import com.worldpay.servicing.model.util.DatesConversion;

@RestController
@RequestMapping("/ormb-apis/Ser131")
@Monitored
public class SRV131Controller {

	@Autowired
	private SRV131Service merchantOpenBillsService;
	
	public static final int NUMBER_OF_CYCLES = 999;

	@GetMapping(path = "/getMerchantOpenBills/params", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<SRV131JsonPojo> retrieveOpenBills(@RequestBody SRV131Json jsonRequest,
			@RequestParam(value = "currency", required = false) String currency,
			@RequestParam(value = "legalCounterParty", required = false) String legalCounterParty,
			@RequestParam(value = "billPaymentStatus", required = false) String billPaymentStatus,
			@RequestParam(value = "altBillId", required = false) String altBillId,
			@RequestParam(value = "billAmountFrom", required = false) String billAmountFrom,
			@RequestParam(value = "billAmountTo", required = false) String billAmountTo,
			@RequestParam(value = "billdateTo", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") @Valid LocalDate billDateTo,
			@RequestParam(value = "billdateFrom", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") @Valid LocalDate billDateFrom,
			BindingResult bindingResult) {
		
	
		List<SRV131> entity = new ArrayList<>();
		SRV131JsonPojo srv131 = new SRV131JsonPojo();
		OpenBills openbills = new OpenBills();
		int flag = 0;
		
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(srv131, HttpStatus.BAD_REQUEST);
		}
		else {

			List<String> finalList = new ArrayList<>();
			List<String> sublist = null;
			List<String> perIdNbr = jsonRequest.getChildren().parallelStream().unordered().distinct().collect(Collectors.toList());
			perIdNbr.replaceAll(String::trim);//trim children
			String partyId = jsonRequest.getPartyId().trim();
			
			perIdNbr.removeIf(x -> x.isEmpty() || x.equals(partyId));// remove empty from children or if contains partyId

			if(!partyId.isEmpty())
				perIdNbr.add(partyId);
			
			if (!perIdNbr.isEmpty()) {
				entity.clear();
				double size = perIdNbr.size();
				int loops = (int) Math.ceil(size / NUMBER_OF_CYCLES);
				for (int i = 0; i < loops && (loops > 0); i++) {
					int startIndex = i * NUMBER_OF_CYCLES;
					int endIndex = getEndIndex(i, loops, perIdNbr.size(), startIndex);
					sublist = perIdNbr.subList(startIndex, endIndex);
					finalList = merchantOpenBillsService.checkPerIdNbr(sublist);
					SRV131Request srv131Request = SRV131Request.builder().partyId(partyId).children(finalList)
							.currency(Optional.ofNullable(currency).orElse("").trim())
							.legalCounterParty(Optional.ofNullable(legalCounterParty).orElse("").trim())
							.billDateFrom(getBillDateString(billDateFrom))
							.billDateTo(getBillDateString(billDateTo))
							.altBillId(Optional.ofNullable(altBillId).orElse("").trim())
							.billPaymentStatus(Optional.ofNullable(billPaymentStatus).orElse("").trim())
							.billAmountFrom(new BigDecimal(Optional.ofNullable(billAmountFrom).orElse("-9999999999999").trim()))
							.billAmountTo(new BigDecimal(Optional.ofNullable(billAmountTo).orElse("9999999999999").trim()))
							.build();
				   
					flag = createPerIdList(srv131Request, srv131, openbills, entity, flag);
				}

			} else {
				return errorResponse(entity, openbills, srv131, finalList);
			}

			if (flag == 0) {
				return errorResponse(entity, openbills, srv131, finalList);
			}
			setHeaderData(finalList, entity, srv131, openbills);
			return new ResponseEntity<>(srv131, HttpStatus.OK);
		}
	}

		
	private String getBillDateString(@Valid LocalDate billDate) {
		if(billDate != null)
			return DatesConversion.convertLocalDateToString(billDate);
		return "";
	}

	private int getEndIndex(int i, int loops, int size, int startIndex) {
		return (i == loops - 1) ? size : (startIndex + NUMBER_OF_CYCLES);
	}

	private int createPerIdList(SRV131Request srv131Request, SRV131JsonPojo srv131, OpenBills openBills,
			List<SRV131> entity, int flag) {

		if (!srv131Request.getChildren().isEmpty()) {
			flag = 1;
			List<SRV131> dbResponse = merchantOpenBillsService.findByAll(srv131Request);
			if (dbResponse == null)
				srv131.setOpenBills(openBills);
			else
				entity.addAll(dbResponse);
		}
		return flag;

	}

	private void setHeaderData(List<String> perIdNbr, List<SRV131> srv131entity, SRV131JsonPojo srv131,
			OpenBills openbills) {
		openbills.setBillList(srv131entity);
		srv131.setOpenBills(openbills);
		srv131.setCallInfo(HeaderInfo.getHeaderOfProductService131(perIdNbr));

	}

	private ResponseEntity<SRV131JsonPojo> errorResponse(List<SRV131> entity, OpenBills openbills,
			SRV131JsonPojo srv131, List<String> finalList) {
		entity = null;
		openbills.setBillList(entity);
		srv131.setOpenBills(openbills);
		srv131.setCallInfo(HeaderInfo.getHeaderOfProductService131(finalList));
		return new ResponseEntity<>(srv131, HttpStatus.NOT_FOUND);
	}
	
}
