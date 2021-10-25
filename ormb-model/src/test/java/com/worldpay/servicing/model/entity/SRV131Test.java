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
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.worldpay.servicing.testutils.DefaultEntitiesMock;

@RunWith(MockitoJUnitRunner.class)
public class SRV131Test 
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
		SRV131 srv131 = createdefaultMerchantOpenBills();
	    srv131.setPartyId(null);
	    Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "partyId");
	    assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);
    }
	
	@Test
	public void testBillIdIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setBillid(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "billid");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	@Test
	public void testLineAmtIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setLineAmount(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "lineAmount");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testUnpaidAmtIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setUnpaidAmount(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "unpaidAmount");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testCurrencyCdIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setCurrency(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "currency");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testDueDateIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setDueDate(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "dueDate");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testBankEntryEventIdIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setLatestBankingEntryEvent(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "latestBankingEntryEvent");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testBankingEntryStatusIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setBankingEntryStatus(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "bankingEntryStatus");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testBillDateIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setBillDate(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "billDate");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testBillAmtIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setBillAmount(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "billAmount");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testAcctDescriptionIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setAccountDescription(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "accountDescription");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}

	@Test
	public void testAcctTypeIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setAccountType(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "accountType");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	
	@Test
	public void testLineIdIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setLineId(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "lineId");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	
	@Test
	public void testAlternateIdIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setAlternateBillId(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "alternateBillId");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	
	@Test
	public void testLegalCounterPartyIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setLegalCounterparty(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "legalCounterparty");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	
	@Test
	public void testLegalCounterPartyDescrIsNull() {

		SRV131 srv131 = createdefaultMerchantOpenBills();
		srv131.setLegalCounterpartyDescription(null);
		Boolean isConstraintViolation =validateConstraintViolation(srv131, MAY_NOT_BE_NULL, "legalCounterpartyDescription");
		assertTrue(NO_CONSTRAINT_VIOLATION, isConstraintViolation);

	}
	
	
	private SRV131 createdefaultMerchantOpenBills() {

		SRV131 srv131 = DefaultEntitiesMock.populateMerchnatBills1();
		srv131.setPartyId("PO4000214155");
		return srv131;
	}
	private Boolean validateConstraintViolation(SRV131 srv131, String violationExpectedMsg, String columnName) {
		Set<ConstraintViolation<SRV131>> violations = validator.validate(srv131);
		assertEquals(NOT_A_SINGLE_VIOLATION_MESSAGE,violations.size(),1);
		ConstraintViolation<SRV131> violation = violations.iterator().next();
		assertTrue(MESSAGE_IS_NOT_THE_ONE_EXPECTED,violation.getMessage().contains(violationExpectedMsg));
		assertEquals(NOT_THE_PROPERLY_COLUMN_NAME,columnName, violation.getPropertyPath().toString());
		return Boolean.TRUE;
	}
}
