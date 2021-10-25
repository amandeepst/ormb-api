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

public class SRV130Test 
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
	public void testPerIdIsNUll()
	{
		SRV130 srv130 = createdefaultMerchantOpenBills();
	    srv130.setPartyId(null);
	    Boolean isConstraintViolation = validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "partyId");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	@Test
	public void testLegalCounterpartyIsNull() {

		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setLegalCounterparty(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "legalCounterparty");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testLegalCounterpartyShortCodeIsNull() {

		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setLegalCounterpartyShortCode(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "legalCounterpartyShortCode");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testLegalCounterpartyDescriptionIsNull() {

		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setLegalCounterpartyDescription(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "legalCounterpartyDescription");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testCurrencyCdIsNull() {

		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setCurrency(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "currency");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testAccountTypeIsNull() {

		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setAccountType(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "accountType");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testAccountBalanceIsNull() {

		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setAccountBalance(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "accountBalance");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testSubAccountTypeIsNull() 
	{
		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setSubAccountType(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "subAccountType");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testSubAccountDescriptionIsNull() {

		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setSubAccountDescription(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "subAccountDescription");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	
	@Test
	public void testSubAccountBalanceIsNull() {

		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setSubAccountBalance(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "subAccountBalance");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testUploadDateIsNull()
	{
		
		SRV130 srv130 = createdefaultMerchantOpenBills();
		srv130.setUploadDate(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv130, MAY_NOT_BE_NULL, "uploadDate");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	
    private SRV130 createdefaultMerchantOpenBills() 
	{
    	SRV130 srv130 = DefaultEntitiesMock.populateMerchnat130();
		srv130.setPartyId("PO4000258437");
		return srv130;
	}
	private Boolean validateConstraintViolation(SRV130 srv130, String violationExpectedMsg, String columnName) {
		Set<ConstraintViolation<SRV130>> violations = validator.validate(srv130);
		assertEquals(NOT_A_SINGLE_VIOLATION_MESSAGE,violations.size(),1);
		ConstraintViolation<SRV130> violation = violations.iterator().next();
		assertTrue(MESSAGE_IS_NOT_THE_ONE_EXPECTED,violation.getMessage().contains(violationExpectedMsg));
		assertEquals(NOT_THE_PROPERLY_COLUMN_NAME,columnName, violation.getPropertyPath().toString());
		return Boolean.TRUE;
	}
	
	

}
