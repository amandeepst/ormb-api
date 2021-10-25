@OrmbAPI @Srv133
Feature: Test scenarios for Srv133

@positive_Srv133
  Scenario Outline: Get Pricing for a partyId
    Given I have the following partyId "TD000114"
    And I create data for "CI_PARTY"
      | PARTY_UID  | PARTY_TYPE_FLG | PARTY_ID   | VERSION |
      | 6334768252 | PERS           | 6334930615 |       1 |
    And I create data for "CI_PER_ID"
      | PER_ID     | ID_TYPE_CD | PER_ID_NBR | PRIM_SW | VERSION |
      | 6334930615 | EXPRTYID   | TD000114   | Y       |       1 |
    And I create data for "CI_PER_CHAR"
      | PER_ID     | CHAR_TYPE_CD | CHAR_VAL | EFFDT              | ADHOC_CHAR_VAL | VERSION | CHAR_VAL_FK1 | CHAR_VAL_FK2 | CHAR_VAL_FK3 | CHAR_VAL_FK4 | CHAR_VAL_FK5 |
      | 6334930615 | PRCCY        |          | 18-JUL-19 00.00.00 | GBP            |       1 |              |              |              |              |              |
    And I create data for "CI_PRICECOMP"
      | PRICECOMP_ID | PRICE_ASGN_ID | VALUE_AMT | RC_MAP_ID  | VERSION | PRICECOMP_DISPLAY_SW | PRICECOMP_SEQNO |
      |   6332075001 |    6330015206 |      1.08 | 3397309087 |       2 | N                    |               0 |
      |   6332075002 |    6330015206 |     0.008 | 8606443130 |       2 | N                    |               0 |
    And I create data for "CI_PRICEASGN"
      | PRICE_ASGN_ID | OWNER_ID   | PA_OWNER_TYPE_FLG | START_DT           | END_DT | PRICEITEM_CD | TOU_CD | PRICE_CURRENCY_CD | PRICE_STATUS_FLAG | RS_CD    | BUS_OBJ_CD | VERSION | BO_DATA_AREA | PA_TYPE_FLAG | PRINT_IF_ZERO_SW | PA_USAGE_FLG | IGNORE_SW | DO_NOT_AGG_SW | SCHEDULE_CD | TXN_RATING_CRITERIA | ADV_PRC_SW | ELIGIBILITY_SW |
      |    6330015206 | 6334768252 | PRTY              | 14-JAN-20 00.00.00 | null   | PRLOCH       |        | GBP               | ACTV              | CHGPPIBL |            |       2 |              | RGLR         | Y                |              | N         | N             | DAILY       | AGTR                |            | N              |
    And I create data for "CI_PRICEASGN_PARM"
      | PRICE_ASGN_ID | PRICE_PARM_CD | PRICE_PARM_VAL   | OVERRIDE_PRIORITY_NUM | VERSION |
      |    6330015206 | TTYPE         | REFUND           |                     4 |       2 |
      |    6330015206 | CTYPE         | MASTERCARD DEBIT |                     5 |       2 |
      |    6330015206 | JTYPE         | INTRA-REGIONAL   |                     7 |       2 |
	When I want to get all pricing for a partyId and priceitem "<priceitem>" and ClassVal "<classVal>" and SclassVal " <sClassVal>"
    Then I get the following values in "merchantPricing" list with 1 entries and "getResponse" body:
      | rank            |                                            1 |
      | priceId         |                                   6330015206 |
      | partyId         | TD000114                                     |
      | chargeType      | PRMCDL03                                     |
      | chargeTypeDescr | MasterCard : Debit : Intra-regional : Refund |
      | perItemRate     |                                         1.08 |
      | percentRate     |                                        0.008 |
      | startDate       | 2020-01-14T00:00:00.000+0000                 |
      | endDate         | null                                         |
      | currencycd      | GBP                                          |
      | priceConfig     | PARTY                                        |
       	Examples:
    	|priceitem|classVal|sClassVal|
    	|PRMCDL03|  | |
@negative_Srv133 @Srv133-1
       Scenario: Get Pricing for a invalid partyId
        Given I have the following partyId "TD00011411"
     	When I want to get all pricing for a partyId and priceitem "PRMCDL03" and ClassVal " " and SclassVal " "
      	Then I get the status "NOT_FOUND"
@negative_Srv133 @Srv133-2
       Scenario: Get Pricing for a empty partyId
        Given I have the following partyId " "
     	When I want to get all pricing for a partyId and priceitem "PRMCDL03" and ClassVal " " and SclassVal " "
      	Then I get the status "NOT_FOUND"
@positive_Srv133 @Srv133-3
  Scenario Outline: Get Pricing for a partyId
    Given I have the following partyId "TD000114"
    And I create data for "CI_PARTY"
      | PARTY_UID  | PARTY_TYPE_FLG | PARTY_ID   | VERSION |
      | 6334768252 | PERS           | 6334930615 |       1 |
    And I create data for "CI_PER_ID"
      | PER_ID     | ID_TYPE_CD | PER_ID_NBR | PRIM_SW | VERSION |
      | 6334930615 | EXPRTYID   | TD000114   | Y       |       1 |
    And I create data for "CI_PER_CHAR"
      | PER_ID     | CHAR_TYPE_CD | CHAR_VAL | EFFDT              | ADHOC_CHAR_VAL | VERSION | CHAR_VAL_FK1 | CHAR_VAL_FK2 | CHAR_VAL_FK3 | CHAR_VAL_FK4 | CHAR_VAL_FK5 |
      | 6334930615 | PRCCY        |          | 18-JUL-19 00.00.00 | GBP            |       1 |              |              |              |              |              |
    And I create data for "CI_PRICECOMP"
      | PRICECOMP_ID | PRICE_ASGN_ID | VALUE_AMT | RC_MAP_ID  | VERSION | PRICECOMP_DISPLAY_SW | PRICECOMP_SEQNO |
      |   6332075001 |    6330015206 |      1.08 | 3397309087 |       2 | N                    |               0 |
      |   6332075002 |    6330015206 |     0.008 | 8606443130 |       2 | N                    |               0 |
    And I create data for "CI_PRICEASGN"
      | PRICE_ASGN_ID | OWNER_ID   | PA_OWNER_TYPE_FLG | START_DT           | END_DT | PRICEITEM_CD | TOU_CD | PRICE_CURRENCY_CD | PRICE_STATUS_FLAG | RS_CD    | BUS_OBJ_CD | VERSION | BO_DATA_AREA | PA_TYPE_FLAG | PRINT_IF_ZERO_SW | PA_USAGE_FLG | IGNORE_SW | DO_NOT_AGG_SW | SCHEDULE_CD | TXN_RATING_CRITERIA | ADV_PRC_SW | ELIGIBILITY_SW |
      |    6330015206 | 6334768252 | PRTY              | 14-JAN-20 00.00.00 | null   | PRLOCH       |        | GBP               | ACTV              | CHGPPIBL |            |       2 |              | RGLR         | Y                |              | N         | N             | DAILY       | AGTR                |            | N              |
    And I create data for "CI_PRICEASGN_PARM"
      | PRICE_ASGN_ID | PRICE_PARM_CD | PRICE_PARM_VAL   | OVERRIDE_PRIORITY_NUM | VERSION |
      |    6330015206 | TTYPE         | REFUND           |                     4 |       2 |
      |    6330015206 | CTYPE         | MASTERCARD DEBIT |                     5 |       2 |
      |    6330015206 | JTYPE         | INTRA-REGIONAL   |                     7 |       2 |
    When I want to get all pricing for a partyId and priceitem "<priceitem>" and ClassVal "<classVal>" and SclassVal " <sClassVal>"
    Then I get the following values in "merchantPricing" list with 1 entries and "getResponse" body:
      | rank            |                                            1 |
      | priceId         |                                   6330015206 |
      | partyId         | TD000114                                     |
      | chargeType      | PRMCDL03                                     |
      | chargeTypeDescr | MasterCard : Debit : Intra-regional : Refund |
      | perItemRate     |                                         1.08 |
      | percentRate     |                                        0.008 |
      | startDate       | 2020-01-14T00:00:00.000+0000                 |
      | endDate         | null                                         |
      | currencycd      | GBP                                          |
      | priceConfig     | PARTY                                        |
 	Examples:
    	|priceitem|classVal|sClassVal|
    	|PRMCDL03| PREMIUM |LOCALITY|
    	
    	
