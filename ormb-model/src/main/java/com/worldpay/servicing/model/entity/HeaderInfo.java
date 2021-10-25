package com.worldpay.servicing.model.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.worldpay.servicing.model.util.RandomIDGenerator;

public class HeaderInfo {

	protected HeaderInfo() {

	}

	private static final String DATE_FORMAT = "dd-MMM-yy HH.mm.ss";

	public static CallInfo getHeaderOfMerchantBalanceService130(String perId) {

		CallInfo callinfo = new CallInfo();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDateTime now = LocalDateTime.now();
		callinfo.setCreationDate(dtf.format(now));
		callinfo.setCallId(RandomIDGenerator.getNumber(perId));
		callinfo.setCallType("getMerchantBalance");
		callinfo.setDescription("This service provides Merchant account and sub account balance information");
		return callinfo;
	}

	public static CallInfo getHeaderOfProductService131(List<String> perId) {
		CallInfo callinfo = new CallInfo();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDateTime now = LocalDateTime.now();
		callinfo.setCreationDate(dtf.format(now));
		callinfo.setCallId(RandomIDGenerator.getNumber1(perId));
		callinfo.setCallType("getMerchantBalance");
		callinfo.setDescription("This service provides the open bills for a given Merchant");
		return callinfo;
	}

	public static CallInfo getHeaderOfSettlementGroupService132(String perId) {

		CallInfo callinfo = new CallInfo();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDateTime now = LocalDateTime.now();
		callinfo.setCreationDate(dtf.format(now));
		callinfo.setCallId(RandomIDGenerator.getNumber(perId));
		callinfo.setCallType("getMerchantSettlementGroup");
		callinfo.setDescription("This service provides the list of all settlement groups for a given Merchant");
		return callinfo;
	}

	public static CallInfo getHeaderOfPriceService133(String perId) {

		CallInfo callinfo = new CallInfo();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDateTime now = LocalDateTime.now();
		callinfo.setCreationDate(dtf.format(now));
		callinfo.setCallId(RandomIDGenerator.getNumber(perId));
		callinfo.setCallType("getPricing");
		callinfo.setDescription("This service provides the prices applicable to a given Merchant");
		return callinfo;
	}

}
