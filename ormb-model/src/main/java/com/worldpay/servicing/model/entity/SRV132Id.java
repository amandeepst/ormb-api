package com.worldpay.servicing.model.entity;

import java.io.Serializable;

public class SRV132Id implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subAccountCode;
	private String subAccountDescription;
	private String legalCounterparty;
	private  String currency;
	
    
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSubAccountCode() {
		return subAccountCode;
	}

	public void setSubAccountCode(String subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public String getSubAccountDescription() {
		return subAccountDescription;
	}

	public void setSubAccountDescription(String subAccountDescription) {
		this.subAccountDescription = subAccountDescription;
	}

	public String getLegalCounterparty() {
		return legalCounterparty;
	}

	public void setLegalCounterparty(String legalCounterparty) {
		this.legalCounterparty = legalCounterparty;
	}

}
