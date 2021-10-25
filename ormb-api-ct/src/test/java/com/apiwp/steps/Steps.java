package com.apiwp.steps;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.apiwp.exception.OrmbException;
import com.apiwp.utils.DbOpeartionUtils;
import com.apiwp.utils.Environment;
import com.apiwp.utils.JdbcOperations;
import com.apiwp.utils.RequestService;
import com.apiwp.utils.ResponseTypes;
import com.apiwp.utils.ScenarioContext;
import com.apiwp.utils.TestContext;
import com.worldpay.servicing.model.entity.SRV130;
import com.worldpay.servicing.model.entity.SRV130JsonPojo;
import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV131Json;
import com.worldpay.servicing.model.entity.SRV131JsonPojo;
import com.worldpay.servicing.model.entity.SRV132;
import com.worldpay.servicing.model.entity.SRV132JsonPojo;
import com.worldpay.servicing.model.entity.SRV133;
import com.worldpay.servicing.model.entity.SRV133JsonPojo;

import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

@ContextConfiguration(classes = { TestContext.class })
public class Steps {

	private static final Logger logger = LoggerFactory.getLogger(Steps.class);

	private final ScenarioContext scenarioContext;

	private final StepsUtils stepsUtils;

	private final JdbcOperations jdbcOperations;

	@Autowired
	private RequestService requestService;

	public Steps(ScenarioContext scenarioContext, StepsUtils stepsUtils,
			@Autowired @Qualifier("ormbInMem") JdbcOperations ormbCisadm) {
		this.stepsUtils = stepsUtils;
		scenarioContext.reset();
		this.scenarioContext = scenarioContext;
		this.jdbcOperations = ormbCisadm;
	}

	@Autowired
	private Environment environment;

	@Given("I have the following partyId {string}")
	public void setPartyId(String partyId) {
		this.scenarioContext.setNamedValue("partyId", partyId.trim());
	}

// *******generic method for insertion and deletion******

	@And("I create data for \"([^\"]*)\"$")
	public void gettable(String tableName, DataTable dt)
			throws ClassNotFoundException, SQLException, ParseException, InterruptedException {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		DbOpeartionUtils.deletionUsingDataTable(list, tableName);
	}

// *****Execute the API URI Steps ********** 

	@When("I want to get all merchantSettlementGroup for a partyId from UI")
	public void getMerchantSettlementGroup() {
		String url = environment.getUrl() + ":" + environment.getPort() + "/" + "ormb-web" + "/ormb-apis/Ser132/"
				+ "getMerchantSettlementGroup/params?perIdNbr="
				+ this.scenarioContext.getNamedValue("partyId", String.class);
		logger.info("API URL =" + url);
		RestTemplate restTemplate = new RestTemplate();

		try {
			scenarioContext.setNamedValue("getResponse",
					restTemplate.getForObject(url, ResponseTypes.MERCHANTSETTLEMENTGROUP.getResponseTypeClass()));
		} catch (HttpClientErrorException ex) {
			scenarioContext.setNamedValue("getResponse", ex.getStatusCode());
		}
	}

	@When("I want to get all Account balance for a partyId")
	public void getMerchantBalance() {
		String url = environment.getUrl() + ":" + environment.getPort() + "/" + "ormb-web" + "/ormb-apis/Ser130/"
				+ "getMerchantBalance/params?perIdNbr=" + this.scenarioContext.getNamedValue("partyId", String.class);
		logger.info("URL for account balance =" + url);
		RestTemplate restTemplate = new RestTemplate();

		try {
			scenarioContext.setNamedValue("getResponse",
					restTemplate.getForObject(url, ResponseTypes.MERCHANTBALANCE.getResponseTypeClass()));
		} catch (HttpClientErrorException ex) {
			scenarioContext.setNamedValue("getResponse", ex.getStatusCode());
		}
	}

	@When("I want to get all pricing for a partyId and priceitem \"([^\"]*)\" and ClassVal \"([^\"]*)\" and SclassVal \"([^\"]*)\"$")
	public void getpricing(String priceitem, String classval, String sclassval) {
		String url = environment.getUrl() + ":" + environment.getPort() + "/" + "ormb-web" + "/ormb-apis/Ser133/"
				+ "getPricing/params?perIdNbr=" + this.scenarioContext.getNamedValue("partyId", String.class)
				+ "&priceItemCd=" + priceitem + "&classVal=" + classval + "&sClassVal=" + sclassval;
		logger.info("URL for pricing =" + url);
		RestTemplate restTemplate = new RestTemplate();

		try {
			scenarioContext.setNamedValue("getResponse",
					restTemplate.getForObject(url, ResponseTypes.MERCHANTPRICING.getResponseTypeClass()));
		} catch (HttpClientErrorException ex) {
			scenarioContext.setNamedValue("getResponse", ex.getStatusCode());
		}
	}

	@When ("I have the following open bills for above party id and below paramters are {string} {string} {string} {string} {string} {string} {string} {string}")
	public void getOpenBills(String currency, String billdateTo , String billdateFrom ,String legalCounterParty, String altBillId, 
			String billAmountFrom,String billAmountTo,String billPaymentStatus,List<String> children)  {
		String url = environment.getUrl() + ":" + environment.getPort() + "/" + "ormb-web" + "/ormb-apis/Ser131/"
				+ "getMerchantOpenBills/params?"+"currency="+currency+"&billdateTo="+billdateTo+"&billdateFrom="+billdateFrom+"&legalCounterParty="+legalCounterParty
				+"&altBillId"+altBillId+"&billAmountFrom"+billAmountFrom+"&billAmountTo"+billAmountTo+"&billPaymentStatus"+billPaymentStatus;
			logger.info("API URL = " + url);
		RestTemplate restTemplate = requestService.getRestTemplate();

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Accept", "application/json");
			headers.add("Content-type", "application/json");
			SRV131Json json = new SRV131Json();
			json.setPartyId(scenarioContext.getNamedValue("partyId", String.class));
			json.setChildren(children);
			ResponseEntity<SRV131JsonPojo> response = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity(json, headers), ResponseTypes.OPENBILLS.getResponseTypeClass());

			if (response.getStatusCode() == HttpStatus.OK) {
				scenarioContext.setNamedValue("getResponse", response.getBody());
			} else {
				Assert.fail("HTTP Status is not 200 OK");
			}

		} catch (HttpClientErrorException ex) {
			scenarioContext.setNamedValue("getResponse", ex.getStatusCode());
		}
	}

//************Validation Step******

	@Then("I get the following values in {string} list with {int} entries and {string} body:")
	public void verifyGetResponseBody(String type, int nrOfEntities, String responseType,
			@Transpose DataTable responseBody) {

		Object ormbResponse = scenarioContext.getNamedValue(responseType, stepsUtils.getResponseType(type));

		switch (type) {
		case "openBills":
			List<SRV131> openBillsListActual = ((SRV131JsonPojo) ormbResponse).getOpenBills().getBillList();

			if (nrOfEntities != openBillsListActual.size()) {
				Assert.fail("Number of expected open bills does not match the number returned!");
			}
			if (openBillsListActual.size() == 0) {
				Assert.assertEquals(nrOfEntities, openBillsListActual.size());

			}
			List<SRV131> openBillsListExpected = new ArrayList<>();
			openBillsListExpected.addAll(responseBody.asList(SRV131.class));

			for (SRV131 openBill : openBillsListActual) {
				if (openBillsListExpected.contains(openBill)) {
					openBillsListExpected.remove(openBill);
					continue;
				} else {
					throw new OrmbException(
							"SRV131 Open Bill list does not match the expected values! Data for bill with id: "
									+ openBill.getBillid() + " does not correspond.");
				}
			}
			break;

		case "merchantBalance":
			List<SRV130> merchantBalanceListActual = ((SRV130JsonPojo) ormbResponse).getBalance().getBalanceList();

			if (nrOfEntities != merchantBalanceListActual.size()) {
				Assert.fail("Number of expected ACCOUNTS does not match the number returned!");
			}
			if (merchantBalanceListActual.size() == 0) {
				Assert.assertEquals(nrOfEntities, merchantBalanceListActual.size());

			}
			List<SRV130> merchantBalanceListExpected = new ArrayList<>();
			merchantBalanceListExpected.addAll(responseBody.asList(SRV130.class));
			logger.info("merchantBalanceListExpected--------" + merchantBalanceListExpected);
			logger.info("merchant balance list actual --------" + merchantBalanceListActual);

			for (SRV130 Balance : merchantBalanceListActual) {
				if ((merchantBalanceListExpected.toString()).contains(Balance.toString())) {
					merchantBalanceListExpected.remove(Balance);
					continue;
				} else {
					throw new OrmbException("SRV130  " + Balance.getAccountType() + " does not correspond.");
				}
			}
			break;

		case "merchantPricing":
			List<SRV133> merchantPricingListActual = ((SRV133JsonPojo) ormbResponse).getPriceList();
			if (nrOfEntities != merchantPricingListActual.size()) {
				Assert.fail("Number of expected ACCOUNTS does not match the number returned!");
			}
			if (merchantPricingListActual.size() == 0) {
				Assert.assertEquals(nrOfEntities, merchantPricingListActual.size());

			}
			List<SRV133> merchantPricingListExpected = new ArrayList<>();
			merchantPricingListExpected.addAll(responseBody.asList(SRV133.class));
			logger.info("merchantPricingListExpected--------" + merchantPricingListExpected);
			logger.info("merchantPricingListActual--------" + merchantPricingListActual);
			Assert.assertEquals(merchantPricingListExpected.toString(), merchantPricingListActual.toString());

			if ((merchantPricingListExpected.toString()).contains(merchantPricingListActual.toString())) {
				merchantPricingListExpected.remove(merchantPricingListActual);

			} else {
				throw new OrmbException("SRV133 " + merchantPricingListActual + " does not correspond.");
			}

			break;

		case "merchantSettlementGroup":

			List<SRV132> merchantSettlementGroupActual = (((SRV132JsonPojo) ormbResponse).getSettlementGroupList()
					.getSettlementGroup());

			if (nrOfEntities != merchantSettlementGroupActual.size()) {
				Assert.fail("Number of expected return does not match the number returned!");
			}
			List<SRV132> merchantSettlementGroupExpected = new ArrayList<>();
			merchantSettlementGroupExpected.addAll(responseBody.asList(SRV132.class));
			logger.info("merchantSettlementGroupExpected--------" + merchantSettlementGroupExpected);
			logger.info("merchantSettlementGroupActual ---" + merchantSettlementGroupActual);
			Assert.assertEquals(merchantSettlementGroupExpected.toString(), merchantSettlementGroupActual.toString());

			if ((merchantSettlementGroupExpected.toString()).contains(merchantSettlementGroupActual.toString())) {
				merchantSettlementGroupExpected.remove(merchantSettlementGroupActual);

			} else {
				throw new OrmbException("SRV132" + merchantSettlementGroupActual + " does not correspond.");
			}
			break;
		}
	}

	@Then("I want to compare the two merchantSettlementGroup results")
	public void verifyMerchantSettlementGroupUiAndDbResults() {
		SRV132JsonPojo uiFullResponse = (SRV132JsonPojo) scenarioContext.getNamedValue("getMerchantSettlementGroupUI",
				ResponseTypes.MERCHANTSETTLEMENTGROUP.getResponseTypeClass());

		List<SRV132> uiResponseList = uiFullResponse.getSettlementGroupList().getSettlementGroup();

		List<SRV132> dbResponseList = (List<SRV132>) scenarioContext.getNamedValue("getMerchantSettlementGroupDB",
				List.class);

		if (uiResponseList.size() != dbResponseList.size()) {
			Assert.fail(
					"Number of settlement groups from UI does not match the number of returned settlement groups from DB!");
		}

		for (int i = 0; i < uiResponseList.size(); i++) {
			if (dbResponseList.contains(uiResponseList.get(i))) {
				Assert.fail("The list of settlement groups returned from UI does not match the list returned from DB!");
			}
		}
	}

	@Then("I get the status {string}")
	public void getStatus(String statuscode) {

		Object statusCode = scenarioContext.getNamedValue("getResponse", Object.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, statusCode);
	}

	@Then("I want get the status Code NOT_FOUND")
	public void getOpenBillsStatus() {
		String url = environment.getUrl() + ":" + environment.getPort() + "/" + "ormb-web" + "/ormb-apis/Ser131/"
				+ "getMerchantOpenBills/params";
		logger.info("API URL = " + url);
		RestTemplate restTemplate = requestService.getRestTemplate();

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Accept", "application/json");
			headers.add("Content-type", "application/json");

			SRV131Json json = new SRV131Json();
			json.setPartyId(scenarioContext.getNamedValue("partyId", String.class));
			json.setChildren(Collections.EMPTY_LIST);
			ResponseEntity<SRV131JsonPojo> response = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity(json, headers), ResponseTypes.OPENBILLS.getResponseTypeClass());
			if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
				Assert.assertEquals("404_NOT_FOUND", HttpStatus.NOT_FOUND, response.getStatusCode());
			} else {
				Assert.fail("HTTP Status code is not 404 NOT_FOUND");

			}

		} catch (HttpClientErrorException ex) {
			scenarioContext.setNamedValue("getResponse", ex.getStatusCode());
		}
	}

}