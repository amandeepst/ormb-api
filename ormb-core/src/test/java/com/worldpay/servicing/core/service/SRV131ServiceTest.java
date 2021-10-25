
package com.worldpay.servicing.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.worldpay.servicing.core.dao.SRV131Repository;
import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV131Request;
import com.worldpay.servicing.testutils.DefaultEntitiesMock;

public class SRV131ServiceTest {

	private static final String SUCCESS_MSG = "There should be one Open Bills under the test case";
	private static final String EMPTY_MSG = "There should be Empty Open Bills under the test case";
	private static final String PER_ID_NBR = "PX10999999";
	@Mock
	private SRV131Repository srv131Repository;

	@InjectMocks
	private SRV131ServiceImpl srv131ServiceImpl;

	private List<String> OPEN_BILLS_ID_1 = new ArrayList(Arrays.asList("PX10999999"));

	public List<String> getOPEN_BILLS_ID_1() {
		return OPEN_BILLS_ID_1;
	}

	public void setOPEN_BILLS_ID_1(List<String> oPEN_BILLS_ID_1) {
		OPEN_BILLS_ID_1 = oPEN_BILLS_ID_1;
	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
    public void checkByPerIdNbr() {
       List<String> perIdNbr = srv131ServiceImpl.checkPerIdNbr(Arrays.asList(PER_ID_NBR));
       when(srv131Repository.checkPerIdNbr(eq(Arrays.asList(PER_ID_NBR)))).thenReturn(Arrays.asList(PER_ID_NBR));
       assertEquals(perIdNbr.size(), 0);
    }
	
	@Test
	public void testFindByPerIdNbr() {
		SRV131Request srv131Request = SRV131Request.builder().partyId(PER_ID_NBR).children(getOPEN_BILLS_ID_1())
				.currency("").legalCounterParty("").billDateFrom("").billDateTo("").build();
		SRV131 srv1 = DefaultEntitiesMock.populateMerchnatBills2();
		when(srv131Repository.findByAll(srv131Request)).thenReturn(Arrays.asList(srv1));

		List<SRV131> srv131 = srv131ServiceImpl.findByAll(srv131Request);
		assertTrue(SUCCESS_MSG, srv131.size() == 1);
		assertEquals(srv131.get(0).getPartyId(), getOPEN_BILLS_ID_1().get(0));
		verify(srv131Repository, times(1)).findByAll(srv131Request);

	}

	@Test
	public void testFindByBillDateFromAndBillDateTo() throws Exception {
		String billDateTo = "2019-09-10";
		String billDateFrom = "2019-09-08";
		SRV131Request srv131Request = SRV131Request.builder().partyId(PER_ID_NBR).children(getOPEN_BILLS_ID_1())
				.currency("").legalCounterParty("").billDateFrom(billDateFrom).billDateTo(billDateTo).build();
		SRV131 srv1 = DefaultEntitiesMock.populateMerchnatBills2();
		when(srv131Repository.findByAll(srv131Request)).thenReturn(Arrays.asList(srv1));

		List<SRV131> srv131 = srv131ServiceImpl.findByAll(srv131Request);
		assertTrue(SUCCESS_MSG, srv131.size() == 1);
		assertEquals(srv131.get(0).getPartyId(), getOPEN_BILLS_ID_1().get(0));
		verify(srv131Repository, times(1)).findByAll(srv131Request);

	}

	@Test
	public void testFindByPerIdNbrandBillDateTo() throws Exception {
		String billDateTo = "2019-09-10";
		SRV131Request srv131Request = SRV131Request.builder().partyId(PER_ID_NBR).children(getOPEN_BILLS_ID_1())
				.currency("").legalCounterParty("").billDateFrom("").billDateTo(billDateTo).build();
		SRV131 srv1 = DefaultEntitiesMock.populateMerchnatBills2();
		when(srv131Repository.findByAll(srv131Request)).thenReturn(Arrays.asList(srv1));
		List<SRV131> srv131 = srv131ServiceImpl.findByAll(srv131Request);
		assertTrue(SUCCESS_MSG, srv131.size() == 1);
		assertEquals(srv131.get(0).getPartyId(), getOPEN_BILLS_ID_1().get(0));
		verify(srv131Repository, times(1)).findByAll(srv131Request);

	}

	@Test
	public void testFindByPerIdNbrandBillDateFrom() throws Exception {
		String billDateFrom = "2019-09-08";
		SRV131Request srv131Request = SRV131Request.builder().partyId(PER_ID_NBR).children(getOPEN_BILLS_ID_1())
				.currency("").legalCounterParty("").billDateFrom(billDateFrom).billDateTo("").build();
		SRV131 srv1 = DefaultEntitiesMock.populateMerchnatBills2();
		when(srv131Repository.findByAll(srv131Request)).thenReturn(Arrays.asList(srv1));
		List<SRV131> srv131 = srv131ServiceImpl.findByAll(srv131Request);
		assertTrue(SUCCESS_MSG, srv131.size() == 1);
		assertEquals(srv131.get(0).getPartyId(), getOPEN_BILLS_ID_1().get(0));
		verify(srv131Repository, times(1)).findByAll(srv131Request);
	}

	@Test
	public void testFailureByWrongCurrency() {

		SRV131Request srv131Request = SRV131Request.builder().partyId(PER_ID_NBR).children(getOPEN_BILLS_ID_1())
				.currency("EUR").legalCounterParty("").billDateFrom("").billDateTo("").build();
		when(srv131Repository.findByAll(srv131Request)).thenReturn(Collections.EMPTY_LIST);
		List<SRV131> srv131 = srv131ServiceImpl.findByAll(srv131Request);
		assertTrue(EMPTY_MSG, srv131.isEmpty());
		verify(srv131Repository, times(1)).findByAll(srv131Request);

	}

	@Test
	public void testFailureByWrongLegalCounterParty() {

		SRV131Request srv131Request = SRV131Request.builder().partyId(PER_ID_NBR).children(getOPEN_BILLS_ID_1())
				.currency("").legalCounterParty("PO1100000002").billDateFrom("").billDateTo("").build();
		when(srv131Repository.findByAll(srv131Request)).thenReturn(Collections.EMPTY_LIST);
		List<SRV131> srv131 = srv131ServiceImpl.findByAll(srv131Request);
		assertTrue(EMPTY_MSG, srv131.isEmpty());
		verify(srv131Repository, times(1)).findByAll(srv131Request);

	}

	@Test
	public void testLoadInexistentOpenBills() {
		List<String> st = new ArrayList<>();
		st.add("SMTP00078");
		SRV131Request srv131Request = SRV131Request.builder().partyId("SMTP00078").children(st).currency("")
				.legalCounterParty("").billDateFrom("").billDateTo("").build();
		when(srv131Repository.findByAll(srv131Request)).thenReturn(Collections.EMPTY_LIST);
		List<SRV131> srv131 = srv131ServiceImpl.findByAll(srv131Request);
		assertTrue(EMPTY_MSG, srv131.isEmpty());
		verify(srv131Repository, times(1)).findByAll(srv131Request);

	}

	@Test
	public void testByAll() {
		String currency = "GBP";
		String legalCounterParty = "PO1100000001";
		String billDateTo = "2019-09-10";
		String billDateFrom = "2019-09-08";
		SRV131Request srv131Request = SRV131Request.builder().partyId(PER_ID_NBR).children(getOPEN_BILLS_ID_1())
				.currency(currency).legalCounterParty(legalCounterParty).billDateFrom(billDateFrom)
				.billDateTo(billDateTo).build();
		SRV131 srv1 = DefaultEntitiesMock.populateMerchnatBills2();
		when(srv131Repository.findByAll(srv131Request)).thenReturn(Arrays.asList(srv1));
		List<SRV131> srv131 = srv131ServiceImpl.findByAll(srv131Request);
		assertTrue(SUCCESS_MSG, srv131.size() == 1);
		assertEquals(srv131.get(0).getPartyId(), getOPEN_BILLS_ID_1().get(0));
		verify(srv131Repository, times(1)).findByAll(srv131Request);

	}

}
