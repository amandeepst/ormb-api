
package com.worldpay.servicing.model.entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "billid",
    "lineId",
    "lineAmount",
    "unpaidAmount",
    "currency",
    "dueDate",
    "bankingEntryStatus",
    "latestBankingEntryEvent",
    "alternateBillId",
    "billDate",
    "billAmount",
    "accountType",
    "accountDescription",
    "partyId",
    "legalCounterparty",
    "legalCounterpartyDescription"
})
public class BillList {

    @JsonProperty("billid")
    private String billid;
    @JsonProperty("lineId")
    private String lineId;
    @JsonProperty("lineAmount")
    private String lineAmount;
    @JsonProperty("unpaidAmount")
    private String unpaidAmount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("dueDate")
    private String dueDate;
    @JsonProperty("bankingEntryStatus")
    private String bankingEntryStatus;
    @JsonProperty("latestBankingEntryEvent")
    private String latestBankingEntryEvent;
    @JsonProperty("alternateBillId")
    private String alternateBillId;
    @JsonProperty("billDate")
    private String billDate;
    @JsonProperty("billAmount")
    private String billAmount;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("accountDescription")
    private String accountDescription;
    @JsonProperty("partyId")
    private String partyId;
    @JsonProperty("legalCounterparty")
    private String legalCounterparty;
    @JsonProperty("legalCounterpartyDescription")
    private String legalCounterpartyDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("billid")
    public String getBillid() {
        return billid;
    }

    @JsonProperty("billid")
    public void setBillid(String billid) {
        this.billid = billid;
    }

    public BillList withBillid(String billid) {
        this.billid = billid;
        return this;
    }

    @JsonProperty("lineId")
    public String getLineId() {
        return lineId;
    }

    @JsonProperty("lineId")
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public BillList withLineId(String lineId) {
        this.lineId = lineId;
        return this;
    }

    @JsonProperty("lineAmount")
    public String getLineAmount() {
        return lineAmount;
    }

    @JsonProperty("lineAmount")
    public void setLineAmount(String lineAmount) {
        this.lineAmount = lineAmount;
    }

    public BillList withLineAmount(String lineAmount) {
        this.lineAmount = lineAmount;
        return this;
    }

    @JsonProperty("unpaidAmount")
    public String getUnpaidAmount() {
        return unpaidAmount;
    }

    @JsonProperty("unpaidAmount")
    public void setUnpaidAmount(String unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public BillList withUnpaidAmount(String unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
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

    public BillList withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @JsonProperty("dueDate")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("dueDate")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public BillList withDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @JsonProperty("bankingEntryStatus")
    public String getBankingEntryStatus() {
        return bankingEntryStatus;
    }

    @JsonProperty("bankingEntryStatus")
    public void setBankingEntryStatus(String bankingEntryStatus) {
        this.bankingEntryStatus = bankingEntryStatus;
    }

    public BillList withBankingEntryStatus(String bankingEntryStatus) {
        this.bankingEntryStatus = bankingEntryStatus;
        return this;
    }

    @JsonProperty("latestBankingEntryEvent")
    public String getLatestBankingEntryEvent() {
        return latestBankingEntryEvent;
    }

    @JsonProperty("latestBankingEntryEvent")
    public void setLatestBankingEntryEvent(String latestBankingEntryEvent) {
        this.latestBankingEntryEvent = latestBankingEntryEvent;
    }

    public BillList withLatestBankingEntryEvent(String latestBankingEntryEvent) {
        this.latestBankingEntryEvent = latestBankingEntryEvent;
        return this;
    }

    @JsonProperty("alternateBillId")
    public String getAlternateBillId() {
        return alternateBillId;
    }

    @JsonProperty("alternateBillId")
    public void setAlternateBillId(String alternateBillId) {
        this.alternateBillId = alternateBillId;
    }

    public BillList withAlternateBillId(String alternateBillId) {
        this.alternateBillId = alternateBillId;
        return this;
    }

    @JsonProperty("billDate")
    public String getBillDate() {
        return billDate;
    }

    @JsonProperty("billDate")
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public BillList withBillDate(String billDate) {
        this.billDate = billDate;
        return this;
    }

    @JsonProperty("billAmount")
    public String getBillAmount() {
        return billAmount;
    }

    @JsonProperty("billAmount")
    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public BillList withBillAmount(String billAmount) {
        this.billAmount = billAmount;
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

    public BillList withAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    @JsonProperty("accountDescription")
    public String getAccountDescription() {
        return accountDescription;
    }

    @JsonProperty("accountDescription")
    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public BillList withAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
        return this;
    }

    @JsonProperty("partyId")
    public String getPartyId() {
        return partyId;
    }

    @JsonProperty("partyId")
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public BillList withPartyId(String partyId) {
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

    public BillList withLegalCounterparty(String legalCounterparty) {
        this.legalCounterparty = legalCounterparty;
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

    public BillList withLegalCounterpartyDescription(String legalCounterpartyDescription) {
        this.legalCounterpartyDescription = legalCounterpartyDescription;
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

    public BillList withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

   
   
}
