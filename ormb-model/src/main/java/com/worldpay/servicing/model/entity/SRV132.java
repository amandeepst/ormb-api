package com.worldpay.servicing.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(SRV132Id.class)
public class SRV132 {

	@Id
	@NotNull
	@Column(name = "SA_TYPE_CD")
	private String subAccountCode;

	@Id
	@NotNull
	@Column(name = "DESCR")
	private String subAccountDescription;

	@Id
	@NotNull
	@Column(name = "CURRENCY_CD")
	private String currency;

	@NotNull
	@Column(name = "CIS_DIVISION")
	private String legalCounterpartyShortCode;

	@NotNull
	@Column(name = "DIV_DESCR")
	private String legalCounterpartyDescription;

	@Id
	@NotNull
	@Column(name = "LCP_ID")
	private String legalCounterparty;

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

	public String getLegalCounterpartyDescription() {
		return legalCounterpartyDescription;
	}

	public void setLegalCounterpartyDescription(String legalCounterpartyDescription) {
		this.legalCounterpartyDescription = legalCounterpartyDescription;
	}

	@Override
	public String toString() {
		return "SRV_132 [subAccountCode=" + subAccountCode + ", subAccountDescription=" + subAccountDescription
				+ ", currency=" + currency + ", legalCounterpartyShortCode=" + legalCounterpartyShortCode
				+ ", legalCounterpartyDescription=" + legalCounterpartyDescription + ", legalCounterparty="
				+ legalCounterparty + "]";
	}

}
