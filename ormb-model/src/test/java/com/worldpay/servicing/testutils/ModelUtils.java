package com.worldpay.servicing.testutils;

import java.math.BigDecimal;
import java.util.Date;

import com.worldpay.servicing.model.entity.SRV130;
import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV132;
import com.worldpay.servicing.model.entity.SRV133;

public class ModelUtils {

	private ModelUtils() {
		// empty private constructor
	}

	public static class SRV130Builder {
		private String partyId;
		private String legalCounterparty;
		private String legalCounterpartyShortCode;
		private String legalCounterpartyDescription;
		private String currency;
		private String accountType;
		private BigDecimal accountBalance;
		private String subAccountType;
		private String subAccountDescription;
		private BigDecimal subAccountBalance;
		private Date uploadDate;

		public SRV130Builder legalCounterpartyDescription(String legalCounterpartyDescription) {
			this.legalCounterpartyDescription = legalCounterpartyDescription;
			return this;
		}

		public SRV130Builder subAccountDescription(String subAccountDescription) {
			this.subAccountDescription = subAccountDescription;
			return this;
		}

		public SRV130Builder partyId(String partyId) {
			this.partyId = partyId;
			return this;
		}

		public SRV130Builder legalCounterpartyShortCode(String legalCounterpartyShortCode) {
			this.legalCounterpartyShortCode = legalCounterpartyShortCode;
			return this;
		}

		public SRV130Builder legalCounterparty(String legalCounterparty) {
			this.legalCounterparty = legalCounterparty;
			return this;
		}

		public SRV130Builder currency(String currency) {
			this.currency = currency;
			return this;
		}

		public SRV130Builder accountType(String accountType) {
			this.accountType = accountType;
			return this;
		}

		public SRV130Builder accountBalance(BigDecimal accountBalance) {
			this.accountBalance = accountBalance;
			return this;
		}

		public SRV130Builder subAccountBalance(BigDecimal subAccountBalance) {
			this.subAccountBalance = subAccountBalance;
			return this;
		}

		public SRV130Builder subAccountType(String subAccountType) {
			this.subAccountType = subAccountType;
			return this;
		}

		public SRV130Builder uploadDate(Date uploadDate) {
			this.uploadDate = uploadDate;
			return this;
		}

		public static SRV130Builder newMerchnt130() {
			return new SRV130Builder();
		}

		public SRV130 build() {
			SRV130 sr = new SRV130();
			sr.setAccountBalance(accountBalance);
			sr.setAccountType(accountType);
			sr.setCurrency(currency);
			sr.setLegalCounterparty(legalCounterparty);
			sr.setLegalCounterpartyDescription(legalCounterpartyDescription);
			sr.setSubAccountType(subAccountType);
			sr.setSubAccountBalance(subAccountBalance);
			sr.setSubAccountDescription(subAccountDescription);
			sr.setUploadDate(uploadDate);
			sr.setCurrency(currency);
			sr.setPartyId(partyId);
			sr.setLegalCounterpartyShortCode(legalCounterpartyShortCode);
			return sr;
		}
	}

	public static class SRV133Builder {
		private BigDecimal rank;
		private String priceId;
		private String partyId;
		private String chargeType;
		private String chargeTypeDescr;
		private BigDecimal perItemRate;
		private BigDecimal percentRate;
		private Date startDate;
		private Date endDate;
		private String currencycd;
		private String priceConfig;

		public SRV133Builder rank(BigDecimal rank) {
			this.rank = rank;
			return this;
		}

		public SRV133Builder priceId(String priceId) {
			this.priceId = priceId;
			return this;
		}

		public SRV133Builder partyId(String partyId) {
			this.partyId = partyId;
			return this;
		}

		public SRV133Builder chargeType(String chargeType) {
			this.chargeType = chargeType;
			return this;
		}

		public SRV133Builder chargeTypeDescr(String chargeTypeDescr) {
			this.chargeTypeDescr = chargeTypeDescr;
			return this;
		}

		public SRV133Builder perItemRate(BigDecimal perItemRate) {
			this.perItemRate = perItemRate;
			return this;
		}

		public SRV133Builder percentRate(BigDecimal percentRate) {
			this.percentRate = percentRate;
			return this;
		}

		public SRV133Builder startDate(Date startDate) {
			this.startDate = startDate;
			return this;
		}

		public SRV133Builder endDate(Date endDate) {
			this.endDate = endDate;
			return this;
		}

		public SRV133Builder priceConfig(String priceConfig) {
			this.priceConfig = priceConfig;
			return this;
		}

		public SRV133Builder currencycd(String currencycd) {
			this.currencycd = currencycd;
			return this;
		}

		public static SRV133Builder newPricing() {
			return new SRV133Builder();
		}

		public SRV133 build() {
			SRV133 sr = new SRV133();
			sr.setChargeType(chargeType);
			sr.setChargeTypeDescr(chargeTypeDescr);
			sr.setCurrencycd(currencycd);
			sr.setEndDate(endDate);
			sr.setPartyId(partyId);
			sr.setPercentRate(percentRate);
			sr.setPerItemRate(perItemRate);
			sr.setPriceConfig(priceConfig);
			sr.setPriceId(priceId);
			sr.setRank(rank);
			sr.setStartDate(startDate);
			return sr;
		}

	}

	public static class SRV131Builder {
		private String billid;
		private String lineId;
		private BigDecimal lineAmount;
		private BigDecimal unpaidAmount;
		private String currency;
		private Date dueDate;
		private String bankingEntryStatus;
		private String latestBankingEntryEvent;
		private String alternateBillId;
		private Date billDate;
		private BigDecimal billAmount;
		private String accountType;
		private String accountDescription;
		private String partyId;
		private String legalCounterparty;
		private String legalCounterpartyDescription;

		public SRV131Builder billid(String billid) {
			this.billid = billid;
			return this;
		}

		public SRV131Builder lineId(String lineId) {
			this.lineId = lineId;
			return this;
		}

		public SRV131Builder lineAmount(BigDecimal lineAmount) {
			this.lineAmount = lineAmount;
			return this;
		}

		public SRV131Builder unpaidAmount(BigDecimal unpaidAmount) {
			this.unpaidAmount = unpaidAmount;
			return this;
		}

		public SRV131Builder currency(String currency) {
			this.currency = currency;
			return this;
		}

		public SRV131Builder dueDate(Date dueDate) {
			this.dueDate = dueDate;
			return this;
		}

		public SRV131Builder latestBankingEntryEvent(String latestBankingEntryEvent) {
			this.latestBankingEntryEvent = latestBankingEntryEvent;
			return this;
		}

		public SRV131Builder bankingEntryStatus(String bankingEntryStatus) {
			this.bankingEntryStatus = bankingEntryStatus;
			return this;
		}

		public SRV131Builder alternateBillId(String alternateBillId) {
			this.alternateBillId = alternateBillId;
			return this;
		}

		public SRV131Builder billDate(Date billDate) {
			this.billDate = billDate;
			return this;
		}

		public SRV131Builder billAmount(BigDecimal billAmount) {
			this.billAmount = billAmount;
			return this;
		}

		public SRV131Builder partyId(String partyId) {
			this.partyId = partyId;
			return this;
		}

		public SRV131Builder accountType(String accountType) {
			this.accountType = accountType;
			return this;
		}

		public SRV131Builder accountDescription(String accountDescription) {
			this.accountDescription = accountDescription;
			return this;
		}

		public SRV131Builder legalCounterparty(String legalCounterparty) {
			this.legalCounterparty = legalCounterparty;
			return this;
		}

		public SRV131Builder legalCounterpartyDescription(String legalCounterpartyDescription) {
			this.legalCounterpartyDescription = legalCounterpartyDescription;
			return this;
		}

		public static SRV131Builder newMerchnatBalance() {
			return new SRV131Builder();
		}

		public SRV131 build() {
			SRV131 sr = new SRV131();
			sr.setAccountDescription(accountDescription);
			sr.setAccountType(accountType);
			sr.setAlternateBillId(alternateBillId);
			sr.setBankingEntryStatus(bankingEntryStatus);
			sr.setBillAmount(billAmount);
			sr.setBillDate(billDate);
			sr.setBillid(alternateBillId);
			sr.setCurrency(currency);
			sr.setDueDate(dueDate);
			sr.setLatestBankingEntryEvent(latestBankingEntryEvent);
			sr.setLegalCounterparty(legalCounterparty);
			sr.setLegalCounterpartyDescription(legalCounterpartyDescription);
			sr.setLineAmount(lineAmount);
			sr.setLineId(lineId);
			sr.setPartyId(partyId);
			sr.setUnpaidAmount(unpaidAmount);
			sr.setBillid(billid);
			return sr;

		}
	}

	public static class SRV132Builder {

		private String subAccountCode;
		private String subAccountDescription;
		private String currency;
		private String legalCounterpartyShortCode;
		private String legalCounterpartyDescription;
		private String legalCounterparty;

		public SRV132Builder subAccountCode(String subAccountCode) {
			this.subAccountCode = subAccountCode;
			return this;
		}

		public SRV132Builder subAccountDescription(String subAccountDescription) {
			this.subAccountDescription = subAccountDescription;
			return this;
		}

		public SRV132Builder legalCounterpartyShortCode(String legalCounterpartyShortCode) {
			this.legalCounterpartyShortCode = legalCounterpartyShortCode;
			return this;
		}

		public SRV132Builder legalCounterparty(String legalCounterparty) {
			this.legalCounterparty = legalCounterparty;
			return this;
		}

		public SRV132Builder currency(String currency) {
			this.currency = currency;
			return this;
		}

		public SRV132Builder legalCounterpartyDescription(String legalCounterpartyDescription) {
			this.legalCounterpartyDescription = legalCounterpartyDescription;
			return this;
		}

		public static SRV132Builder newMerchantSettlement() {
			return new SRV132Builder();
		}

		public SRV132 build() {
			SRV132 sr = new SRV132();
			sr.setCurrency(currency);
			sr.setLegalCounterparty(legalCounterparty);
			sr.setLegalCounterpartyDescription(legalCounterpartyDescription);
			sr.setLegalCounterpartyShortCode(legalCounterpartyShortCode);
			sr.setSubAccountCode(subAccountCode);
			sr.setSubAccountDescription(subAccountDescription);
			return sr;
		}

	}

}
