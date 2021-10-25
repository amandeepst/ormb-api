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

public class SRV132Test 
{
	private static final String MAY_NOT_BE_NULL = "may not be null";
	private static final String NO_CONSTRAINT_VIOLATION = "There is no constraint violation";
    private static final String NOT_A_SINGLE_VIOLATION_MESSAGE = "Is not a single violation message";
	private static final String MESSAGE_IS_NOT_THE_ONE_EXPECTED = "The violation message is not the one expected";
	private static final String NOT_THE_PROPERLY_COLUMN_NAME = "Is not the properly column name";
	private static ValidatorFactory validatorFactory;
	private static Validator validator;
	
	@BeforeClass
	public static void createValidator() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@AfterClass
	public static void close() {
		validatorFactory.close();
	}
	@Test
	public void testSunAccountCodeIsNUll()
	{
		SRV132 srv132 = createdefaultMerchantOpenBills();
	    srv132.setSubAccountCode(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv132, MAY_NOT_BE_NULL, "subAccountCode");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	@Test
	public void testSubAccountDescriptionIsNUll()
	{
		SRV132 srv132 = createdefaultMerchantOpenBills();
	    srv132.setSubAccountDescription(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv132, MAY_NOT_BE_NULL, "subAccountDescription");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	@Test
	public void testCurrencyIsNUll()
	{
		SRV132 srv132 = createdefaultMerchantOpenBills();
	    srv132.setCurrency(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv132, MAY_NOT_BE_NULL, "currency");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	@Test
	public void testLegalCounterpartyShortCodeIsNUll()
	{
		SRV132 srv132 = createdefaultMerchantOpenBills();
	    srv132.setLegalCounterpartyShortCode(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv132, MAY_NOT_BE_NULL, "legalCounterpartyShortCode");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	@Test
	public void testLegalCounterpartyDescriptionIsNUll()
	{
		SRV132 srv132 = createdefaultMerchantOpenBills();
	    srv132.setLegalCounterpartyDescription(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv132, MAY_NOT_BE_NULL, "legalCounterpartyDescription");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	@Test
	public void testLegalCounterpartyIsNUll()
	{
		SRV132 srv132 = createdefaultMerchantOpenBills();
	    srv132.setLegalCounterparty(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv132, MAY_NOT_BE_NULL, "legalCounterparty");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
    
	
	private SRV132 createdefaultMerchantOpenBills() {

		SRV132 srv132 = DefaultEntitiesMock.populateMerchnatSettlement();
		//srv132.set
		return srv132;
	}
	private Boolean validateConstraintViolation(SRV132 srv132, String violationExpectedMsg, String columnName) {
		Set<ConstraintViolation<SRV132>> violations = validator.validate(srv132);
		assertEquals(NOT_A_SINGLE_VIOLATION_MESSAGE,violations.size(),1);
		ConstraintViolation<SRV132> violation = violations.iterator().next();
		assertTrue(MESSAGE_IS_NOT_THE_ONE_EXPECTED,violation.getMessage().contains(violationExpectedMsg));
		assertEquals(NOT_THE_PROPERLY_COLUMN_NAME,columnName, violation.getPropertyPath().toString());
		return Boolean.TRUE;
	}
}
