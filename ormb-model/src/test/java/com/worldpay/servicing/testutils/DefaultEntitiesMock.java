package com.worldpay.servicing.testutils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.worldpay.servicing.model.entity.SRV130;
import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV132;
import com.worldpay.servicing.model.entity.SRV133;

public class DefaultEntitiesMock {

	public static SRV133 populatePricing() {
		return ModelUtils.SRV133Builder.newPricing().rank(new BigDecimal("1")).priceId("6330015206")
				.partyId("TD000114").chargeType("PRMCDL03").chargeTypeDescr("MasterCard : Debit : Intra-regional : Refund")
				.perItemRate(new BigDecimal("1.08")).percentRate(new BigDecimal("0.008")).startDate(new Date())
				.endDate(null).priceConfig("PARTY").currencycd("GBP").build();

	}
	public static SRV133 populatePricing1() {
		return ModelUtils.SRV133Builder.newPricing().rank(new BigDecimal("11")).priceId("6240001716")
				.partyId("PO4000258437").chargeType("MADH0021").chargeTypeDescr("Lost/Stolen/Damaged Terminal Fee")
				.perItemRate(new BigDecimal("50")).percentRate(new BigDecimal("0")).startDate(new Date())
				.endDate(new Date()).priceConfig("EUR").currencycd("PARTY").build();

	} 
	
	public static SRV131 populateMerchnatBills1() {
		return ModelUtils.SRV131Builder.newMerchnatBalance().billid("103857233249").lineId("1")
				.lineAmount(new BigDecimal(300)).unpaidAmount(new BigDecimal(300)).currency("GBP")
				.dueDate(new Date()).bankingEntryStatus("DEBT_MIGRATION").latestBankingEntryEvent("2350102")
				.alternateBillId("1274").billDate(new Date()).billAmount(new BigDecimal(300)).accountType("FUND")
				.accountDescription("FUNDING").partyId("PX000000005").legalCounterparty("PO1100000001")
				.legalCounterpartyDescription("Worldpay (UK) Limited").build();

	}
	
	public static SRV131 populateMerchnatBills2(){
		return ModelUtils.SRV131Builder.newMerchnatBalance().billid("754780028733").lineId("1")
				.lineAmount(new BigDecimal(58)).unpaidAmount(new BigDecimal(48)).currency("GBP").dueDate(new Date())
				.bankingEntryStatus("RELEASED").latestBankingEntryEvent("30001234567").alternateBillId("1257")
				.billDate(new Date()).billAmount(new BigDecimal(58)).accountType("CHRG").accountDescription("CHARGING")
				.partyId("PX10999999").legalCounterparty("PO1100000001")
				.legalCounterpartyDescription("Worldpay (UK) Limited").build();
	}
	
	public static SRV132 populateMerchnatSettlement() {
		return ModelUtils.SRV132Builder.newMerchantSettlement().currency("EUR").legalCounterparty("PO1100000001")
				.legalCounterpartyDescription("Worldpay (UK) Limited").legalCounterpartyShortCode("00001")
				.subAccountCode("DRES").subAccountDescription("DYNAMIC RESERVES").build();

	}

	public static SRV130 populateMerchnat130() {
		return ModelUtils.SRV130Builder.newMerchnt130().accountBalance(new BigDecimal(0)).accountType("CHRG")
				.currency("EUR").legalCounterparty("PO1100000002").legalCounterpartyDescription("Worldpay B.V.")
				.legalCounterpartyShortCode("00002").partyId("PO4000258437").subAccountBalance(new BigDecimal(0))
				.subAccountDescription("Recurring Charges").subAccountType("RECR").uploadDate(new Date()).build();
	}
	
	/*
	 * public static List<String> PerIdList() { String arr[]=new String[]
	 * {"PX10999999","RG20001001","TD1000100301","PZ000000110","PO4000554341",
	 * "TD13500100201","PX000000020","TD2223","PO4000419716","PO4000419715"};
	 * List<String> PER_ID_NBR= Arrays.asList(arr); return PER_ID_NBR; }
	 */
	
}
