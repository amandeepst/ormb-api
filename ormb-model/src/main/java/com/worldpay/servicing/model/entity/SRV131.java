package com.worldpay.servicing.model.entity;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@IdClass(SRV131Id.class)
public class SRV131 {

	@Id
	@NotNull
	@Column(name = "BILL_ID")
	private String billid;

	@Id
	@NotNull
	@Column(name = "LINE_ID")
	private String lineId;

	@Id
	@NotNull
	@Column(name = "LINE_AMT")
	private BigDecimal lineAmount;

	@NotNull
	@Column(name = "UNPAID_AMT")
	private BigDecimal unpaidAmount;

	@NotNull
	@Column(name = "CURRENCY_CD")
	private String currency;

	@NotNull
	@Column(name = "DUE_DT")
	private Date dueDate;

	@NotNull
	@Column(name = "BANKING_ENTRY_STATUS")
	private String bankingEntryStatus;

	@Id
	@NotNull
	@Column(name = "BANK_ENTRY_EVENT_ID")
	private String latestBankingEntryEvent;

	@NotNull
	@Column(name = "ALT_BILL_ID")
	private String alternateBillId;

	@NotNull
	@Column(name = "BILL_DT")
	private Date billDate;

	@Id
	@NotNull
	@Column(name = "BILL_AMT")
	private BigDecimal billAmount;

	@NotNull
	@Column(name = "ACCT_NBR")
	private String accountType;

	@NotNull
	@Column(name = "ACCT_NAME")
	private String accountDescription;

	@NotNull
	@Column(name = "PER_ID_NBR")
	private String partyId;

	@NotNull
	@Column(name = "legal_counterparty")
	private String legalCounterparty;

	@NotNull
	@Column(name = "legal_counterparty_name")
	private String legalCounterpartyDescription;

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

	public BigDecimal getUnpaidAmount() {
		return unpaidAmount;
	}

	public void setUnpaidAmount(BigDecimal unpaidAmount) {
		this.unpaidAmount = unpaidAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getLatestBankingEntryEvent() {
		return latestBankingEntryEvent;
	}

	public void setLatestBankingEntryEvent(String latestBankingEntryEvent) {
		this.latestBankingEntryEvent = latestBankingEntryEvent;
	}

	public String getBankingEntryStatus() {
		return bankingEntryStatus;
	}

	public void setBankingEntryStatus(String bankingEntryStatus) {
		this.bankingEntryStatus = bankingEntryStatus;
	}

	public String getAlternateBillId() {
		return alternateBillId;
	}

	public void setAlternateBillId(String alternateBillId) {
		this.alternateBillId = alternateBillId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
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

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public String getLegalCounterparty() {
		return legalCounterparty;
	}

	public void setLegalCounterparty(String legalCounterparty) {
		this.legalCounterparty = legalCounterparty;
	}

	public String getLegalCounterpartyDescription() {
		return legalCounterpartyDescription;
	}

	public void setLegalCounterpartyDescription(String legalCounterpartyDescription) {
		this.legalCounterpartyDescription = legalCounterpartyDescription;
	}

	@Override
	public String toString() {
		return "SRV_131 [billid=" + billid + ", lineId=" + lineId + ", lineAmount=" + lineAmount + ", unpaidAmount="
				+ unpaidAmount + ", currency=" + currency + ", dueDate=" + dueDate + ", bankingEntryStatus="
				+ bankingEntryStatus + ", latestBankingEntryEvent=" + latestBankingEntryEvent + ", alternateBillId="
				+ alternateBillId + ", billDate=" + billDate + ", billAmount=" + billAmount + ", accountType="
				+ accountType + ", accountDescription=" + accountDescription + ", partyId=" + partyId
				+ ", legalCounterparty=" + legalCounterparty + ", legalCounterpartyDescription="
				+ legalCounterpartyDescription + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SRV131 srv131 = (SRV131) o;
		return Objects.equals(billid, srv131.billid) &&
				Objects.equals(lineId, srv131.lineId) &&
				Objects.equals(lineAmount, srv131.lineAmount) &&
				Objects.equals(unpaidAmount, srv131.unpaidAmount) &&
				Objects.equals(currency, srv131.currency) &&
				Objects.equals(dueDate, srv131.dueDate) &&
				Objects.equals(bankingEntryStatus, srv131.bankingEntryStatus) &&
				Objects.equals(latestBankingEntryEvent, srv131.latestBankingEntryEvent) &&
				Objects.equals(alternateBillId, srv131.alternateBillId) &&
				Objects.equals(billDate, srv131.billDate) &&
				Objects.equals(billAmount, srv131.billAmount) &&
				Objects.equals(accountType, srv131.accountType) &&
				Objects.equals(accountDescription, srv131.accountDescription) &&
				Objects.equals(partyId, srv131.partyId) &&
				Objects.equals(legalCounterparty, srv131.legalCounterparty) &&
				Objects.equals(legalCounterpartyDescription, srv131.legalCounterpartyDescription);
	}

	@Override
	public int hashCode() {
		return Objects
				.hash(billid, lineId, lineAmount, unpaidAmount, currency, dueDate, bankingEntryStatus,
						latestBankingEntryEvent, alternateBillId, billDate, billAmount, accountType,
						accountDescription, partyId, legalCounterparty, legalCounterpartyDescription);
	}
}
