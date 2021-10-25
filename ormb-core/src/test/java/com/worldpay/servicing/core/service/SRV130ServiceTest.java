package com.worldpay.servicing.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.worldpay.servicing.core.dao.SRV130Repository;
import com.worldpay.servicing.model.entity.SRV130;
import com.worldpay.servicing.testutils.ModelUtils;

@RunWith(MockitoJUnitRunner.class)
public class SRV130ServiceTest {

	@Mock
	private SRV130Repository srv130Repository;

	@InjectMocks
	private SRV130ServiceImpl srv130ServiceImpl;

	private static String PER_ID_NBR_1 = "PO4000258437";
	private static String PER_ID_NBR_2 = "SMTP00078";
	private static String PER_ID_NBR_3 = "SMTP00079";

	@Before
	public void before() {

		SRV130 srv1 = ModelUtils.SRV130Builder.newMerchnt130().accountBalance(new BigDecimal(0)).accountType("CHRG")
				.currency("EUR").legalCounterparty("PO1100000002").legalCounterpartyDescription("Worldpay B.V.")
				.legalCounterpartyShortCode("00002").partyId("PO4000258437").subAccountBalance(new BigDecimal(0))
				.subAccountDescription("Recurring Charges").subAccountType("RECR").build();

		SRV130 srv2 = ModelUtils.SRV130Builder.newMerchnt130().accountBalance(new BigDecimal(0)).accountType("CHRG")
				.currency("EUR").legalCounterparty("PO1100000002").legalCounterpartyDescription("Worldpay B.V.")
				.legalCounterpartyShortCode("00002").partyId("SMTP00078").subAccountBalance(new BigDecimal(0))
				.subAccountDescription("Recurring Charges").subAccountType("RECR").build();

		when(srv130Repository.findByPerIdNbr(eq(PER_ID_NBR_1))).thenReturn(Arrays.asList(srv1));
		when(srv130Repository.findByPerIdNbr(eq(PER_ID_NBR_2))).thenReturn(Arrays.asList(srv2));
		when(srv130Repository.checkPerIdNbr(eq(PER_ID_NBR_1))).thenReturn(PER_ID_NBR_1);

	}
	
	@Test
	public void checkByPerIdNbr() {
	   String perIdNbr = srv130ServiceImpl.checkPerIdNbr(PER_ID_NBR_1);
	   assertTrue("perIdNbr Exists in DataBase", !perIdNbr.isEmpty());
	   assertEquals(perIdNbr, PER_ID_NBR_1);
	}
	
	@Test
	public void testFindByPerIdNbr() {

		List<SRV130> srv130 = srv130ServiceImpl.loadByPerIdNbr(PER_ID_NBR_1);
		assertTrue("There should be one Open Bills under the test case", srv130.size() == 1);
		assertEquals(srv130.get(0).getPartyId(), PER_ID_NBR_1);
		verify(srv130Repository, times(1)).findByPerIdNbr(ArgumentMatchers.eq(PER_ID_NBR_1));
	}
	
	@Test
	public void testFindByPerIdNbr2() {

		List<SRV130> srv130 = srv130ServiceImpl.loadByPerIdNbr(PER_ID_NBR_2);
		assertTrue("There should be one Open Bills under the test case", srv130.size() == 1);
		assertEquals(srv130.get(0).getPartyId(), PER_ID_NBR_2);
		verify(srv130Repository, times(1)).findByPerIdNbr(ArgumentMatchers.eq(PER_ID_NBR_2));
	}

	@Test
	public void testLoadInexistentMerchantBalance() {

		List<SRV130> srv130 = srv130ServiceImpl.loadByPerIdNbr(PER_ID_NBR_3);
		assertTrue("There should be Empty Open Bills under the test case", srv130.isEmpty());
		verify(srv130Repository, times(1)).findByPerIdNbr(ArgumentMatchers.eq(PER_ID_NBR_3));

	}

}
