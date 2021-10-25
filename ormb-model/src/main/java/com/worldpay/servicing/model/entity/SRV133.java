package com.worldpay.servicing.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(SRV133Id.class)
public class SRV133 {

	@NotNull
	@Column(name = "RANK")
	private BigDecimal rank;

	@Id
	@NotNull
	@Column(name = "PRICE_ID")
	private String priceId;

	
	@NotNull
	@Column(name = "PARTY_ID")
	private String partyId;

	@Id
	@NotNull
	@Column(name = "CHARGE_TYPE")
	private String chargeType;

	
	@NotNull
	@Column(name = "CHARGE_TYPE_DESCR")
	private String chargeTypeDescr;

	@NotNull
	@Column(name = "PER_ITEM_RATE")
	private BigDecimal perItemRate;

	@NotNull
	@Column(name = "PERCENT_RATE")
	private BigDecimal percentRate;

	@Id
	@NotNull
	@Column(name = "START_DT")
	private Date startDate;

	@NotNull
	@Column(name = "END_DT")
	private Date endDate;
	
	@NotNull
	@Column(name = "currency_cd")
	private String currencycd;
	
	@NotNull
	@Column(name = "PRICE_CONFIG")
	private String priceConfig;

	
	
	public BigDecimal getRank() {
		return rank;
	}

	public void setRank(BigDecimal rank) {
		this.rank = rank;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getChargeTypeDescr() {
		return chargeTypeDescr;
	}

	public void setChargeTypeDescr(String chargeTypeDescr) {
		this.chargeTypeDescr = chargeTypeDescr;
	}

	public BigDecimal getPerItemRate() {
		return perItemRate;
	}

	public void setPerItemRate(BigDecimal perItemRate) {
		this.perItemRate = perItemRate;
	}

	public BigDecimal getPercentRate() {
		return percentRate;
	}

	public void setPercentRate(BigDecimal percentRate) {
		this.percentRate = percentRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPriceConfig() {
		return priceConfig;
	}

	public void setPriceConfig(String priceConfig) {
		this.priceConfig = priceConfig;
	}

	public String getCurrencycd() {
		return currencycd;
	}

	public void setCurrencycd(String currencycd) {
		this.currencycd = currencycd;
	}

	@Override
	public String toString() {
		return "SRV_133 [rank=" + rank + ", priceId=" + priceId + ", partyId=" + partyId + ", chargeType=" + chargeType
				+ ", chargeTypeDescr=" + chargeTypeDescr + ", perItemRate=" + perItemRate + ", percentRate="
				+ percentRate + ", startDate=" + startDate + ", endDate=" + endDate + ", currencycd=" + currencycd
				+ ", priceConfig=" + priceConfig + "]";
	}

	

}
