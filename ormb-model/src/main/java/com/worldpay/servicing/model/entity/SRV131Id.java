package com.worldpay.servicing.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SRV131Id implements Serializable {

	private static final long serialVersionUID = 1L;
	private String billid;
	private String lineId;
	private BigDecimal lineAmount;
	private String latestBankingEntryEvent;
	private BigDecimal billAmount;

	public String getLatestBankingEntryEvent() {
		return latestBankingEntryEvent;
	}

	public void setLatestBankingEntryEvent(String latestBankingEntryEvent) {
		this.latestBankingEntryEvent = latestBankingEntryEvent;
	}

	public String getBillid() {
		return billid;
	}

	public void setBillid(String billid) {
		this.billid = billid;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public BigDecimal getLineAmount() {
		return lineAmount;
	}

	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

}
