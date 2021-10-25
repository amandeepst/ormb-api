package com.worldpay.servicing.model.entity;

import java.io.Serializable;

public class SRV130Id implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String partyId;
	private String accountType;
	private String subAccountType;
	private  String currency;
	private String legalCounterpartyShortCode;
	
	
	
    
	public String getLegalCounterpartyShortCode() {
		return legalCounterpartyShortCode;
	}

	public void setLegalCounterpartyShortCode(String legalCounterpartyShortCode) {
		this.legalCounterpartyShortCode = legalCounterpartyShortCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getSubAccountType() {
		return subAccountType;
	}

	public void setSubAccountType(String subAccountType) {
		this.subAccountType = subAccountType;
	}

}
