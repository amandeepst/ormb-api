package com.worldpay.servicing.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(SRV130Id.class)
public class SRV130 {
	@Id
	@NotNull
	@Column(name = "PER_ID_NBR")
	private String partyId;

	@NotNull
	@Column(name = "LCP")
	private String legalCounterparty;

	@Id
	@NotNull
	@Column(name = "CIS_DIVISION")
	private String legalCounterpartyShortCode;

	@Id
	@NotNull
	@Column(name = "LCP_DESCR")
	private String legalCounterpartyDescription;
	
	@Id
	@NotNull
	@Column(name = "CURRENCY_CD")
	private String currency;

	@Id
	@NotNull
	@Column(name = "ACCT_NBR")
	private String accountType;

	@NotNull
	@Column(name = "ACCTBAL")
	private BigDecimal accountBalance;

	@Id
	@NotNull
	@Column(name = "SA_TYPE_CD")
	private String subAccountType;
	
	@NotNull
	@Column(name = "SA_DESCR")
	private String subAccountDescription;


	@NotNull
	@Column(name = "SA_BAL")
	private BigDecimal subAccountBalance;

	@NotNull
	@Column(name = "UPLOAD_DTTM")
	private Date uploadDate;
	
		
	public String getLegalCounterpartyDescription() {
		return legalCounterpartyDescription;
	}

	public void setLegalCounterpartyDescription(String legalCounterpartyDescription) {
		this.legalCounterpartyDescription = legalCounterpartyDescription;
	}

	public String getSubAccountDescription() {
		return subAccountDescription;
	}

	public void setSubAccountDescription(String subAccountDescription) {
		this.subAccountDescription = subAccountDescription;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getLegalCounterpartyShortCode() {
		return legalCounterpartyShortCode;
	}

	public void setLegalCounterpartyShortCode(String legalCounterpartyShortCode) {
		this.legalCounterpartyShortCode = legalCounterpartyShortCode;
	}

	public String getLegalCounterparty() {
		return legalCounterparty;
	}

	public void setLegalCounterparty(String legalCounterparty) {
		this.legalCounterparty = legalCounterparty;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getSubAccountType() {
		return subAccountType;
	}

	public void setSubAccountType(String subAccountType) {
		this.subAccountType = subAccountType;
	}

	public BigDecimal getSubAccountBalance() {
		return subAccountBalance;
	}

	public void setSubAccountBalance(BigDecimal subAccountBalance) {
		this.subAccountBalance = subAccountBalance;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
	   this.uploadDate = uploadDate;
	   
	}

	@Override
	public String toString() {
		return "SRV_130 [partyId=" + partyId + ", legalCounterparty=" + legalCounterparty
				+ ", legalCounterpartyShortCode=" + legalCounterpartyShortCode + ", legalCounterpartyDescription="
				+ legalCounterpartyDescription + ", currency=" + currency + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + ", subAccountType=" + subAccountType
				+ ", subAccountDescription=" + subAccountDescription + ", subAccountBalance=" + subAccountBalance
				+ ", uploadDate=" + uploadDate + "]";
	}

	
}
