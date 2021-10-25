
package com.worldpay.servicing.model.entity;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "partyId", "legalCounterparty", "legalCounterpartyShortCode", "legalCounterpartyDescription",
		"currency", "accountType", "accountBalance", "subAccountType", "subAccountDescription", "subAccountBalance",
		"uploadDate" })
public class BalanceList {

	@JsonProperty("partyId")
	private String partyId;
	@JsonProperty("legalCounterparty")
	private String legalCounterparty;
	@JsonProperty("legalCounterpartyShortCode")
	private String legalCounterpartyShortCode;
	@JsonProperty("legalCounterpartyDescription")
	private String legalCounterpartyDescription;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("accountType")
	private String accountType;
	@JsonProperty("accountBalance")
	private String accountBalance;
	@JsonProperty("subAccountType")
	private String subAccountType;
	@JsonProperty("subAccountDescription")
	private String subAccountDescription;
	@JsonProperty("subAccountBalance")
	private String subAccountBalance;
	@JsonProperty("uploadDate")
	private String uploadDate;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("partyId")
	public String getPartyId() {
		return partyId;
	}

	@JsonProperty("partyId")
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public BalanceList withPartyId(String partyId) {
		this.partyId = partyId;
		return this;
	}

	@JsonProperty("legalCounterparty")
	public String getLegalCounterparty() {
		return legalCounterparty;
	}

	@JsonProperty("legalCounterparty")
	public void setLegalCounterparty(String legalCounterparty) {
		this.legalCounterparty = legalCounterparty;
	}

	public BalanceList withLegalCounterparty(String legalCounterparty) {
		this.legalCounterparty = legalCounterparty;
		return this;
	}

	@JsonProperty("legalCounterpartyShortCode")
	public String getLegalCounterpartyShortCode() {
		return legalCounterpartyShortCode;
	}

	@JsonProperty("legalCounterpartyShortCode")
	public void setLegalCounterpartyShortCode(String legalCounterpartyShortCode) {
		this.legalCounterpartyShortCode = legalCounterpartyShortCode;
	}

	public BalanceList withLegalCounterpartyShortCode(String legalCounterpartyShortCode) {
		this.legalCounterpartyShortCode = legalCounterpartyShortCode;
		return this;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BalanceList withCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	@JsonProperty("accountType")
	public String getAccountType() {
		return accountType;
	}

	@JsonProperty("accountType")
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BalanceList withAccountType(String accountType) {
		this.accountType = accountType;
		return this;
	}

	@JsonProperty("legalCounterpartyDescription")
	public String getLegalCounterpartyDescription() {
		return legalCounterpartyDescription;
	}

	@JsonProperty("legalCounterpartyDescription")
	public void setLegalCounterpartyDescription(String legalCounterpartyDescription) {
		this.legalCounterpartyDescription = legalCounterpartyDescription;
	}

	public BalanceList withlegalCounterpartyDescription(String legalCounterpartyDescription) {
		this.legalCounterpartyDescription = legalCounterpartyDescription;
		return this;
	}

	@JsonProperty("subAccountDescription")
	public String getSubAccountDescription() {
		return subAccountDescription;
	}

	@JsonProperty("subAccountDescription")
	public void setSubAccountDescription(String subAccountDescription) {
		this.subAccountDescription = subAccountDescription;
	}

	public BalanceList withsubAccountDescription(String subAccountDescription) {
		this.subAccountDescription = subAccountDescription;
		return this;
	}

	@JsonProperty("accountBalance")
	public String getAccountBalance() {
		return accountBalance;
	}

	@JsonProperty("accountBalance")
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public BalanceList withAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
		return this;
	}

	@JsonProperty("subAccountType")
	public String getSubAccountType() {
		return subAccountType;
	}

	@JsonProperty("subAccountType")
	public void setSubAccountType(String subAccountType) {
		this.subAccountType = subAccountType;
	}

	public BalanceList withSubAccountType(String subAccountType) {
		this.subAccountType = subAccountType;
		return this;
	}

	@JsonProperty("subAccountBalance")
	public String getSubAccountBalance() {
		return subAccountBalance;
	}

	@JsonProperty("subAccountBalance")
	public void setSubAccountBalance(String subAccountBalance) {
		this.subAccountBalance = subAccountBalance;
	}

	public BalanceList withSubAccountBalance(String subAccountBalance) {
		this.subAccountBalance = subAccountBalance;
		return this;
	}

	@JsonProperty("uploadDate")
	public String getUploadDate() {
		return uploadDate;
	}

	@JsonProperty("uploadDate")
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public BalanceList withUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
