package com.worldpay.servicing.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.worldpay.servicing.core.dao.SRV133Repository;
import com.worldpay.servicing.model.entity.SRV133;
import com.worldpay.servicing.model.entity.SRV133Request;
import com.worldpay.servicing.testutils.DefaultEntitiesMock;

@RunWith(MockitoJUnitRunner.class)
public class SRV133ServiceTest {

	private static final String SUCCESS_MSG = "There should be one pricing under the test case";
	private static final String EMPTY_MSG = "There should be Empty pricing under the test case";
	@Mock
	private SRV133Repository srv133Repository;

	@InjectMocks
	private SRV133ServiceImpl srv133ServiceImpl;

	private static String PER_ID_NBR = "TD000114";
	private static String PER_ID_NBR_1 = "TD0001145";
	private static final String SCLASS_VAL = "LOCALITY";
	private static final String CLASS_VAL = "PREMIUM";
	private static final String PRICEITEM_CD = "PRMCDL03";

	
	@Test
    public void checkByPerIdNbr() {
	 
	  when(srv133Repository.checkPerIdNbr(eq(PER_ID_NBR))).thenReturn(PER_ID_NBR);
      String perIdNbr = srv133ServiceImpl.checkPerIdNbr(PER_ID_NBR);
       assertTrue("perIdNbr Exists in DataBase", !perIdNbr.isEmpty());
       assertEquals(perIdNbr, PER_ID_NBR);
    }
	
	
	@Test
	public void testFindByPerIdNbr() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR).priceItemCd("").classVal("")
				.sClassVal("").build();
		SRV133 srv1 = DefaultEntitiesMock.populatePricing();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Arrays.asList(srv1));
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(SUCCESS_MSG, srv133.size() == 1);
		assertEquals(srv133.get(0).getPartyId(), PER_ID_NBR);
		verify(srv133Repository, times(1)).findByAll(srv133Request);
	}

	@Test
	public void testFindByPerIdNbrAndClassVal() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR).priceItemCd("").classVal(CLASS_VAL)
				.sClassVal("").build();
		SRV133 srv1 = DefaultEntitiesMock.populatePricing();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Arrays.asList(srv1));
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(SUCCESS_MSG, srv133.size() == 1);
		assertEquals(srv133.get(0).getPartyId(), PER_ID_NBR);
		verify(srv133Repository, times(1)).findByAll(srv133Request);
	}

	@Test
	public void testFindByPerIdNbrAndClassValAndSclassVal() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR).priceItemCd("").classVal(CLASS_VAL)
				.sClassVal(SCLASS_VAL).build();
		SRV133 srv1 = DefaultEntitiesMock.populatePricing();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Arrays.asList(srv1));
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(SUCCESS_MSG, srv133.size() == 1);
		assertEquals(srv133.get(0).getPartyId(), PER_ID_NBR);
		verify(srv133Repository, times(1)).findByAll(srv133Request);
	}

	@Test
	public void testFindByAll() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR).priceItemCd(PRICEITEM_CD)
				.classVal(CLASS_VAL).sClassVal(SCLASS_VAL).build();
		SRV133 srv1 = DefaultEntitiesMock.populatePricing();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Arrays.asList(srv1));
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(SUCCESS_MSG, srv133.size() == 1);
		assertEquals(srv133.get(0).getPartyId(), PER_ID_NBR);
		verify(srv133Repository, times(1)).findByAll(srv133Request);

	}

	@Test
	public void testFindByPerIdNbrAndSclassVal() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR).priceItemCd("").classVal("")
				.sClassVal(SCLASS_VAL).build();
		SRV133 srv1 = DefaultEntitiesMock.populatePricing();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Arrays.asList(srv1));
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(SUCCESS_MSG, srv133.size() == 1);
		assertEquals(srv133.get(0).getPartyId(), PER_ID_NBR);
		verify(srv133Repository, times(1)).findByAll(srv133Request);
	}

	@Test
	public void testFindByPerIdNbrAndSclassValAndPriceItem() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR).priceItemCd(PRICEITEM_CD)
				.classVal("").sClassVal(SCLASS_VAL).build();
		SRV133 srv1 = DefaultEntitiesMock.populatePricing();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Arrays.asList(srv1));
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(SUCCESS_MSG, srv133.size() == 1);
		assertEquals(srv133.get(0).getPartyId(), PER_ID_NBR);
		verify(srv133Repository, times(1)).findByAll(srv133Request);

	}

	@Test
	public void testFindByPerIdNbrAndClassValAndPriceItem() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR).priceItemCd(PRICEITEM_CD)
				.classVal(CLASS_VAL).sClassVal("").build();
		SRV133 srv1 = DefaultEntitiesMock.populatePricing();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Arrays.asList(srv1));
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(SUCCESS_MSG, srv133.size() == 1);
		assertEquals(srv133.get(0).getPartyId(), PER_ID_NBR);
		verify(srv133Repository, times(1)).findByAll(srv133Request);
	}

	@Test
	public void testFindByPerIdNbrAndPriceItemCd() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR).priceItemCd(PRICEITEM_CD)
				.classVal("").sClassVal("").build();
		SRV133 srv1 = DefaultEntitiesMock.populatePricing();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Arrays.asList(srv1));
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(SUCCESS_MSG, srv133.size() == 1);
		assertEquals(srv133.get(0).getPartyId(), PER_ID_NBR);
		verify(srv133Repository, times(1)).findByAll(srv133Request);
	}

	@Test
	public void testLoadInexistentPricing() {
		SRV133Request srv133Request = SRV133Request.builder().perIdNbr(PER_ID_NBR_1).priceItemCd("").classVal("")
				.sClassVal("").build();
		when(srv133Repository.findByAll(srv133Request)).thenReturn(Collections.EMPTY_LIST);
		List<SRV133> srv133 = srv133ServiceImpl.findByAll(srv133Request);
		assertTrue(EMPTY_MSG, srv133.isEmpty());
		verify(srv133Repository, times(1)).findByAll(srv133Request);

	}

}
