package com.worldpay.servicing.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.worldpay.servicing.testutils.DefaultEntitiesMock;

public class SRV133Test
{
	private static final String MAY_NOT_BE_NULL = "may not be null";
	private static final String NO_CONSTRAINT_VIOLATION = "There is no constraint violation";
    private static final String NOT_A_SINGLE_VIOLATION_MESSAGE = "Is not a single violation message";
	private static final String MESSAGE_IS_NOT_THE_ONE_EXPECTED = "The violation message is not the one expected";
	private static final String NOT_THE_PROPERLY_COLUMN_NAME = "Is not the properly column name";
	private static ValidatorFactory validatorFactory;
	private static Validator validator;
	
	@BeforeClass
	public static void createValidator() 
	{
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@AfterClass
	public static void close() {
		validatorFactory.close();
	}
	
	
	@Test
	public void testRankIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setRank(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "rank");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
		
    }
	
	@Test
	public void testPriceIdIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setPriceId(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "priceId");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	@Test
	public void testPartyIdIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setPartyId(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "partyId");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	@Test
	public void testChargeTypeIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setChargeType(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "chargeType");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	@Test
	public void testchargeTypeDescrIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setChargeTypeDescr(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "chargeTypeDescr");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	@Test
	public void testPerItemRateIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setPerItemRate(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "perItemRate");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	@Test
	public void testPercentRateIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setPercentRate(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "percentRate");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	@Test
	public void testStartDateIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setStartDate(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "startDate");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	@Test
	public void testEndDateIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setEndDate(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "endDate");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	@Test
	public void testCurrencyCdIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setCurrencycd(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "currencycd");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	@Test
	public void testPriceConfigIsNUll()
	{
		SRV133 srv133 = createdefaultMerchantOpenBills();
	    srv133.setPriceConfig(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv133, MAY_NOT_BE_NULL, "priceConfig");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	private SRV133 createdefaultMerchantOpenBills() {

		SRV133 srv133 = DefaultEntitiesMock.populatePricing1();
		srv133.setPartyId("PO4000258437");
		return srv133;
	}
	private Boolean validateConstraintViolation(SRV133 srv133, String violationExpectedMsg, String columnName) {
		Set<ConstraintViolation<SRV133>> violations = validator.validate(srv133);
		assertEquals(NOT_A_SINGLE_VIOLATION_MESSAGE, violations.size(), 1);
		ConstraintViolation<SRV133> violation = violations.iterator().next();
		assertTrue(MESSAGE_IS_NOT_THE_ONE_EXPECTED,violation.getMessage().contains(violationExpectedMsg));
		assertEquals(NOT_THE_PROPERLY_COLUMN_NAME,columnName, violation.getPropertyPath().toString());
		return Boolean.TRUE;
	}

}
