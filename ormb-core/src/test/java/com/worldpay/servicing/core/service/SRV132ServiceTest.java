package com.worldpay.servicing.core.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.worldpay.servicing.core.dao.SRV132Repository;
import com.worldpay.servicing.model.entity.SRV132;
import com.worldpay.servicing.testutils.ModelUtils;

@RunWith(MockitoJUnitRunner.class)
public class SRV132ServiceTest
{
	@Mock 
	private SRV132Repository srv132Repository;
	
	@InjectMocks
	private SRV132ServiceImpl srv132ServiceImpl;
	
	private static String PER_ID_NBR_1 = "PO4000258437";
	private static String PER_ID_NBR_2 = "SMTP00078";
	private static String PER_ID_NBR_3 = "SMTP00079";
	
	@Before
	public void before() 
	{
		 SRV132 srv1 = ModelUtils.SRV132Builder.newMerchantSettlement().currency("EUR").legalCounterparty("PO1100000001")
					.legalCounterpartyDescription("orldpay (UK) Limited").legalCounterpartyShortCode("00001").subAccountCode("DRES")
					.subAccountDescription("DYNAMIC RESERVES").build();
		 
		 SRV132 srv2 = ModelUtils.SRV132Builder.newMerchantSettlement().currency("EUR").legalCounterparty("PO1100000001")
					.legalCounterpartyDescription("orldpay (UK) Limited").legalCounterpartyShortCode("00001").subAccountCode("DRES")
					.subAccountDescription("DYNAMIC RESERVES").build();
		 
		   when(srv132Repository.findByPerIdNbr(eq(PER_ID_NBR_1))).thenReturn(Arrays.asList(srv1));
		   when(srv132Repository.findByPerIdNbr(eq(PER_ID_NBR_2))).thenReturn(Arrays.asList(srv2));
		   when(srv132Repository.checkPerIdNbr(eq(PER_ID_NBR_1))).thenReturn(PER_ID_NBR_1);
		
	}
	
	@Test
    public void checkByPerIdNbr() {
       String perIdNbr = srv132ServiceImpl.checkPerIdNbr(PER_ID_NBR_1);
       assertTrue("perIdNbr Exists in DataBase", !perIdNbr.isEmpty());
       assertEquals(perIdNbr, PER_ID_NBR_1);
    }
    
	
	@Test
	  public void testFindByPerIdNbr() {		
	    List<SRV132> srv132=srv132ServiceImpl.loadByPerIdNbr(PER_ID_NBR_1);
	    assertTrue("There should be one Open Bills under the test case", srv132.size()==1);
	    verify(srv132Repository, times(1)).findByPerIdNbr(ArgumentMatchers.eq(PER_ID_NBR_1));
	}
	
	@Test
	  public void testFindByPerIdNbr2() {		
	    List<SRV132> srv132=srv132ServiceImpl.loadByPerIdNbr(PER_ID_NBR_2);
	    assertTrue("There should be one Open Bills under the test case", srv132.size()==1);
	    verify(srv132Repository, times(1)).findByPerIdNbr(ArgumentMatchers.eq(PER_ID_NBR_2));
	}
	
	
	@Test
	public void testLoadInexistentMerchantSettlement() {	
		List<SRV132> srv132=srv132ServiceImpl.loadByPerIdNbr(PER_ID_NBR_3);
	    assertTrue("There should be Empty Open Bills under the test case", srv132.isEmpty());
	    verify(srv132Repository, times(1)).findByPerIdNbr(ArgumentMatchers.eq(PER_ID_NBR_3));
	
	}
	
}
