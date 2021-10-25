@OrmbAPI @Srv130
Feature: Test scenarios for Srv130

  @GetMerchantBalance
  Scenario: Get Merchant Balance for a partyId
    Given I have the following partyId "PX000000021"
    And I create data for "CI_PER_ID"
      | PER_ID     | ID_TYPE_CD | PER_ID_NBR  | PRIM_SW | VERSION |
      | 9887591908 | EXPRTYID   | PX000000021 | Y       |       1 |
    And I create data for "CM_MERCH_LEDGER_ACCT"
      | PER_ID_NBR  | CIS_DIVISION | CURRENCY_CD | ACCT_NBR | ACCTBAL | SA_TYPE_CD | SA_BAL | UPLOAD_DTTM        | EXTRACT_FLG | EXTRACT_DTTM | ILM_DT    | ILM_ARCH_SW | TYPE |
      | PX000000021 |        00001 | GBP         | CHBK     |       0 | CHBK       |      0 | 19-DEC-19 11.45.48 | Y           | null         | sysdate-2 | Y           | null |
      | PX000000021 |        00001 | GBP         | CHRG     |   20.12 | CHRG       |  20.12 | 19-DEC-19 11.45.48 | Y           | null         | sysdate-2 | Y           | null |
      | PX000000021 |        00001 | GBP         | CRWD     |       0 | CRWD       |      0 | 19-DEC-19 11.45.48 | Y           | null         | sysdate-2 | Y           | null |
      | PX000000021 |        00001 | GBP         | FUND     |  -993.8 | FUND       | -993.8 | 19-DEC-19 11.45.48 | Y           | null         | sysdate-2 | Y           | null |
      | PX000000021 |        00001 | GBP         | CHRG     |   20.12 | RECR       |      0 | 19-DEC-19 11.45.48 | Y           | null         | sysdate-2 | Y           | null |
    When I want to get all Account balance for a partyId
    Then I get the following values in "merchantBalance" list with 5 entries and "getResponse" body:
      | partyId                      | PX000000021                  | PX000000021                  | PX000000021                  | PX000000021                  | PX000000021                  |
      | legalCounterparty            | PO1100000001                 | PO1100000001                 | PO1100000001                 | PO1100000001                 | PO1100000001                 |
      | legalCounterpartyShortCode   |                        00001 |                        00001 |                        00001 |                        00001 |                        00001 |
      | legalCounterpartyDescription | Worldpay (UK) Limited        | Worldpay (UK) Limited        | Worldpay (UK) Limited        | Worldpay (UK) Limited        | Worldpay (UK) Limited        |
      | currency                     | GBP                          | GBP                          | GBP                          | GBP                          | GBP                          |
      | accountType                  | CHBK                         | CHRG                         | CHRG                         | CRWD                         | FUND                         |
      | accountBalance               |                          0.0 |                        20.12 |                        20.12 |                          0.0 |                       -993.8 |
      | subAccountType               | CHBK                         | CHRG                         | RECR                         | CRWD                         | FUND                         |
      | subAccountDescription        | CHARGEBACKS                  | CHARGING                     | RECURRING CHARGES            | CARD REWARDS                 | FUNDING                      |
      | subAccountBalance            |                          0.0 |                        20.12 |                          0.0 |                          0.0 |                       -993.8 |
      | uploadDate                   | 2019-12-19T11:45:48.000+0000 | 2019-12-19T11:45:48.000+0000 | 2019-12-19T11:45:48.000+0000 | 2019-12-19T11:45:48.000+0000 | 2019-12-19T11:45:48.000+0000 |
 @negative_SRV130 @GetMerchantBalance1
       Scenario: Get Merchant Balance for a invalid partyId
        Given I have the following partyId "PX0000000211"
     	When I want to get all Account balance for a partyId
      	Then I get the status "NOT_FOUND"
 @negative_SRV130 @GetMerchantBalance2
       Scenario: Get Merchant Balance for a empty partyId
        Given I have the following partyId " "
     	When I want to get all Account balance for a partyId
      	Then I get the status "NOT_FOUND"
