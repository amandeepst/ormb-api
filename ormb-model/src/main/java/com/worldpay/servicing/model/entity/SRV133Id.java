package com.worldpay.servicing.model.entity;

import java.io.Serializable;
import java.util.Date;


public class SRV133Id implements Serializable {

	private static final long serialVersionUID = 1L;
	private String chargeType;
	private String priceId;
	private Date startDate;
	
	
	
	
	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	

}
