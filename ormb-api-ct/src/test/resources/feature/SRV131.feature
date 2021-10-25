@OrmbAPI @Srv131
Feature: Test scenarios for Srv131

  @GetOpenBillsForPartyId
  Scenario Outline: Get all open bills for a partyId and invalid children 
    Given I have the following partyId "DEV000001"
    And I create data for "CI_BILL_CHAR"
      | BILL_ID      | CHAR_TYPE_CD | SEQ_NUM | VERSION | CHAR_VAL | ADHOC_CHAR_VAL             | CHAR_VAL_FK1 | CHAR_VAL_FK2 | CHAR_VAL_FK3 | CHAR_VAL_FK4 | CHAR_VAL_FK5 | SRCH_CHAR_VAL              |
      | 909196050498 | CM_RTTC      |       1 |       1 |          | 2019-08-22-06.26.44.000000 |              |              |              |              |              | 2019-08-22-06.26.44.000000 |
      | 909196050498 | RUN_TOT      |       1 |       1 |          |                        852 |              |          852 | 909960709108 | BASE_CHG     |              | MIGFUND                    |
      | 909196050498 | BILL_AMT     |       1 |       1 |          |                        852 |              |              |              |              |              |                        852 |
      | 909196184392 | BILL_AMT     |       1 |       1 |          |                        639 |              |              |              |              |              |                        639 |
      | 909196184392 | CM_RTTC      |       1 |       1 |          | 2019-08-22-06.19.39.000000 |              |              |              |              |              | 2019-08-22-06.19.39.000000 |
      | 909196184392 | RUN_TOT      |       1 |       1 |          |                        639 |              |          639 | 909961096615 | BASE_CHG     |              | MIGCHBK                    |
      | 909296385783 | BILL_AMT     |       1 |       1 |          |                        529 |              |              |              |              |              |                        529 |
      | 909296385783 | CM_RTTC      |       1 |       1 |          | 2019-08-22-06.19.44.000000 |              |              |              |              |              | 2019-08-22-06.19.44.000000 |
      | 909296385783 | RUN_TOT      |       1 |       1 |          |                        369 |              |          369 | 909963636294 | BASE_CHG     |              | MIGCHRG                    |
      | 909296385783 | RUN_TOT      |       2 |       1 |          |                        160 |              |          160 | 909963273729 | BASE_CHG     |              | MIGCHRG2                   |
    And I create data for "CI_PER_ID"
      | PER_ID     | ID_TYPE_CD | PER_ID_NBR | PRIM_SW | VERSION |
      | 9091621050 | EXPRTYID   | DEV000001  | Y       |       1 |
    And I create data for "CM_BILL_PAYMENT_DTL"
      | PAY_DTL_ID | UPLOAD_DTTM        | PAY_DT             | EXT_TRANSMIT_ID | BILL_ID      | LINE_ID | LINE_AMT | PREV_UNPAID_AMT | PAY_AMT | UNPAID_AMT | CURRENCY_CD | STATUS_CD     | PAY_TYPE | ILM_DT             | ILM_ARCH_SW | OVERPAID | RECORD_STAT   | STATUS_UPD_DTTM    | MESSAGE_CAT_NBR | MESSAGE_NBR | ERROR_INFO | EXT_SOURCE_CD |
      |       1009 | 22-AUG-19 06.32.21 | 22-AUG-19 06.32.21 | null            | 909196050498 |       1 |      852 |             852 |       0 |        852 | GBP         | MIGRATED_DEBT | DR       | 22-AUG-19 06.32.21 | Y           | null     | MIGRATED_DEBT | 22-AUG-19 06.32.21 |               0 |           0 |            |               |
      |       1010 | 22-AUG-19 06.32.21 | 22-AUG-19 06.32.21 | null            | 909196184392 |       1 |      639 |             639 |       0 |        639 | GBP         | MIGRATED_DEBT | DR       | 22-AUG-19 06.32.21 | Y           | null     | MIGRATED_DEBT | 22-AUG-19 06.32.21 |               0 |           0 |            |               |
      |       1005 | 22-AUG-19 06.32.20 | 22-AUG-19 06.32.20 | null            | 909296385783 |       1 |      529 |             529 |       0 |        529 | GBP         | MIGRATED_DEBT | DR       | 22-AUG-19 06.32.20 | Y           | null     | MIGRATED_DEBT | 22-AUG-19 06.32.20 |               0 |           0 |            |               |
    And I create data for "CM_BILL_DUE_DT"
      | BANK_ENTRY_EVENT_ID | BILL_ID      | DUE_DT             | IS_MERCH_BALANCED | UPLOAD_DTTM        | STATUS_UPD_DTTM | PAY_DT             | LINE_ID | BANKING_ENTRY_STATUS |
      |         20002385246 | 909196050498 | 13-AUG-19 00.00.00 | N                 | 22-AUG-19 06.32.21 | null            | 22-AUG-19 06.32.21 |       1 | DEBT_MIGRATION       |
      |         20002375245 | 909196184392 | 13-AUG-19 00.00.00 | N                 | 22-AUG-19 06.32.21 | null            | 22-AUG-19 06.32.21 |       1 | DEBT_MIGRATION       |
      |         20002365147 | 909296385783 | 13-AUG-19 00.00.00 | N                 | 22-AUG-19 06.32.20 | null            | 22-AUG-19 06.32.20 |       1 | DEBT_MIGRATION       |
    And I create data for "CI_BILL"
      | BILL_ID      | BILL_CYC_CD | WIN_START_DT | ACCT_ID    | BILL_STAT_FLG | BILL_DT            | DUE_DT             | CRE_DTTM           | COMPLETE_DTTM      | LATE_PAY_CHARGE_SW | LATE_PAY_CHARGE_DT | ALLOW_REOPEN_SW | VERSION | NEXT_CR_RVW_DT     | CR_NOTE_FR_BILL_ID | APAY_CRE_DT | APAY_AMT | ARCHIVE_SW | APAY_STOP_USER_ID | APAY_STOP_DTTM | APAY_STOP_AMT | APAY_STOP_CRE_DT | ADHOC_BILL_SW | GRP_REF_VAL  | TD_ENTRY_ID | TRIAL_BILL_ID | ILM_DT             | ILM_ARCH_SW | ALT_BILL_ID |
      | 909196050498 |             | null         | 9091468231 | C             | 13-AUG-19 00.00.00 | 22-AUG-19 00.00.00 | 22-AUG-19 06.26.40 | 13-AUG-19 00.00.00 | N                  | null               | N               |       4 | 22-AUG-19 00.00.00 |                    | null        |        0 | N          |                   | null           |             0 | null             | Y             | 891581313662 |             |               | 22-AUG-19 00.00.00 | N           |        1187 |
      | 909196184392 |             | null         | 9091061938 | C             | 13-AUG-19 00.00.00 | 22-AUG-19 00.00.00 | 22-AUG-19 06.19.35 | 13-AUG-19 00.00.00 | N                  | null               | N               |       4 | 22-AUG-19 00.00.00 |                    | null        |        0 | N          |                   | null           |             0 | null             | Y             | 891581313662 |             |               | 22-AUG-19 00.00.00 | N           |        1188 |
      | 909296385783 |             | null         | 9092785004 | C             | 13-AUG-19 00.00.00 | 22-AUG-19 00.00.00 | 22-AUG-19 06.19.43 | 13-AUG-19 00.00.00 | N                  | null               | N               |       4 | 22-AUG-19 00.00.00 |                    | null        |        0 | N          |                   | null           |             0 | null             | Y             | 891581313662 |             |               | 22-AUG-19 00.00.00 | N           |        1190 |
    And I create data for "CI_ACCT_PER"
      | ACCT_ID    | ACCT_REL_TYPE_CD | BILL_ADDR_SRCE_FLG | PER_ID     | MAIN_CUST_SW | FIN_RESP_SW | THRD_PTY_SW | RECEIVE_COPY_SW | BILL_RTE_TYPE_CD | BILL_FORMAT_FLG | NBR_BILL_COPIES | VERSION | CUST_PO_ID | NOTIFY_SW | NAME_PFX_SFX | FX_SFX_FLG | QTE_RTE_TYPE_CD | RECV_QTE_SW | WEB_ACCESS_FLG |
      | 9091061938 | MAIN             | PER                | 9091621050 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
      | 9091468231 | MAIN             | PER                | 9091621050 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
      | 9091638847 | MAIN             | PER                | 9091621050 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
      | 9092785004 | MAIN             | PER                | 9091621050 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
    And I create data for "CI_ACCT"
      | ACCT_ID    | BILL_CYC_CD | SETUP_DT           | CURRENCY_CD | ACCT_MGMT_GRP_CD | ALERT_INFO | BILL_AFTER_DT | PROTECT_CYC_SW | CIS_DIVISION | MAILING_PREM_ID | PROTECT_PREM_SW | COLL_CL_CD | CR_REVIEW_DT | POSTPONE_CR_RVW_DT | INT_CR_REVIEW_SW | CUST_CL_CD | BILL_PRT_INTERCEPT | NO_DEP_RVW_SW | BUD_PLAN_CD | VERSION | PROTECT_DIV_SW | ACCESS_GRP_CD | ACCT_DATA_AREA | EC_EXPIRY_SCHEDULE_CD | BILL_LEAD_DAYS | ACCT_USAGE_FLG | TRIAL_BILL_SW | REPRICING_SW | CRE_BY  | LAST_UPD_BY | CRE_DTTM           | LAST_UPD_DTTM      | PRODUCT_CD | DEFER_AUTO_PAY_DT | ACCR_CYC_CD | EXCL_ACCR_SW | RULE_APAY_SW | BO_STATUS_CD | STATUS_UPD_DTTM | BUS_OBJ_CD | BO_DATA_AREA | CLOSING_DT | DD_CR_SW |
      | 9091061938 | WPDY        | 06-DEC-18 00.00.00 | GBP         |                  |            | null          | N              |        00001 |                 | N               | WPOVERDUE  | null         | null               | N                | DUE 1      |                    | N             |             |       5 | N              | ***           | null   |                       |              0 | USAG           | N             | N            | SYSUSER | SYSUSER     | 21-AUG-19 11.08.56 | 21-AUG-19 11.08.56 |            | null              |             | N            | N            |              | null            |            |              | null       |          |
      | 9091468231 | WPDY        | 06-DEC-18 00.00.00 | GBP         |                  |            | null          | N              |        00001 |                 | N               | WPOVERDUE  | null         | null               | N                | DUE 1      |                    | N             |             |       6 | N              | ***           | null   |                       |              0 | USAG           | N             | N            | SYSUSER | SYSUSER     | 21-AUG-19 11.08.56 | 21-AUG-19 11.08.56 |            | null              |             | N            | N            |              | null            |            |              | null       |          |
      | 9091638847 | WPDY        | 06-DEC-18 00.00.00 | GBP         |                  |            | null          | N              |        00001 |                 | N               | WPOVERDUE  | null         | null               | N                | DUE 1      |                    | N             |             |       5 | N              | ***           | null   |                       |              0 | USAG           | N             | N            | SYSUSER | SYSUSER     | 21-AUG-19 11.08.56 | 21-AUG-19 11.08.56 |            | null              |             | N            | N            |              | null            |            |              | null       |          | 
    	|9092785004	 | WPDY				 | 06-DEC-18 00.00.00 | GBP					|          				 |            |	null					| N							 | 				00001 |          				| N								|	WPOVERDUE  | null					| null							 | N								| DUE 1   	 |    	 						  | N							|	 		        |				5 | N 						 | *** 	         | null		|												|			         0 | USAG						| N							| N						 | SYSUSER | SYSUSER 		 | 21-AUG-19 11.08.56 | 21-AUG-19 11.08.56 |            |null								|             | N            | N            |              | null						 |            | 						 | null				| 				 |
    And I create data for "CI_ACCT_NBR"
      | ACCT_ID    | ACCT_NBR_TYPE_CD | ACCT_NBR           | VERSION | PRIM_SW |
      | 9091061938 | C1_F_ANO         | DEV000001_CHBK_GBP |       1 | Y       |
      | 9092785004 | C1_F_ANO         | DEV000001_CHRG_GBP |       1 | Y       |
      | 9091638847 | C1_F_ANO         | DEV000001_CRWD_GBP |       1 | Y       |
      | 9091468231 | C1_F_ANO         | DEV000001_FUND_GBP |       1 | Y       |
      | 9091061938 | ACCTTYPE         | CHBK               |       1 | N       |
      | 9091468231 | ACCTTYPE         | FUND               |       1 | N       |
      | 9091638847 | ACCTTYPE         | CRWD               |       1 | N       |
      | 9092785004 | ACCTTYPE         | CHRG               |       1 | N       |
    When I have the following open bills for above party id and below paramters are "<currency>" "<billdateTo>" "<billdateFrom>" "<legalCounterParty>" "<altBillId>" "<billAmountFrom>" "<billAmountTo>" "<billPaymentStatus>"
  		|DEV00000111|
  		|PO7000161800|
    Then I get the following values in "openBills" list with 3 entries and "getResponse" body:
 		| billid                       |                 909196050498|                 909196184392 |                 909296385783 |
      	| lineId                       |                            1|                           1 	|                            1 |
      	| lineAmount                   |                       852.0 |                        639.0 |                        529.0 |
      	| unpaidAmount                 |                       852.0 |                        639.0 |                        529.0 |
      	| currency                     | GBP                         | GBP                          | GBP                          |
      	| dueDate                      | 2019-08-13T00:00:00.000+0000| 2019-08-13T00:00:00.000+0000 | 2019-08-13T00:00:00.000+0000 |
      	| bankingEntryStatus           | DEBT_MIGRATION              | DEBT_MIGRATION               | DEBT_MIGRATION               |
      	| latestBankingEntryEvent      |                  20002385246|                  20002375245 |                  20002365147 |
      	| alternateBillId              |                         1187|                         1188 |                         1190 |
     	| billDate                     | 2019-08-13T00:00:00.000+0000| 2019-08-13T00:00:00.000+0000 | 2019-08-13T00:00:00.000+0000 |
      	| billAmount                   |                          852|                          639 |                          529 |
      	| accountType                  | FUND                        | CHBK                         | CHRG                         |
      	| accountDescription           | FUNDING                     | CHARGEBACKS                  | CHARGING                     |
      	| partyId                      | DEV000001                   | DEV000001                    | DEV000001                    |
      	| legalCounterparty            | PO1100000001                | PO1100000001                 | PO1100000001                 |
      	| legalCounterpartyDescription | Worldpay (UK) Limited       | Worldpay (UK) Limited        | Worldpay (UK) Limited        |
      Examples:      		
     		|currency|billdateTo|billdateFrom|legalCounterParty|altBillId|billPaymentStatus|billAmountFrom|billAmountTo|
     		|GBP|2019-08-13|2019-08-13|PO1100000001| |PAID |0 |1000 |
     		|GBP|2019-08-14|2019-08-13|PO1100000001| |UNPAID |0 |1000 |
     		|GBP|2019-08-14|2019-08-13|PO1100000001| | |300.45 |1000 |
     		|GBP|2019-08-13|2019-08-13|PO1100000001|1187| |0 |1000 |
     		

 @negative_SRV131 @Srv131-1
       Scenario: Get all open bills for  a invalid partyId
        Given I have the following partyId "DEV00000111"
      	Then I want get the status Code NOT_FOUND
  @negative_SRV131 @Srv131-2
       Scenario: Get all open bills for a empty partyId
        Given I have the following partyId " "
      	Then I want get the status Code NOT_FOUND
  @negative_SRV131 @Srv131-3      
       Scenario: Get all open bills for a  partyId having no account balance and Invalid Children partyId 
        Given I have the following partyId "PO7000161800"
        And I create data for "CI_PER_ID"
      		| PER_ID     | ID_TYPE_CD | PER_ID_NBR  | PRIM_SW | VERSION |
      		| 4353623129 | EXPRTYID   | PO7000161800| Y      |       2 |
		And I create data for "CI_ACCT"
			|ACCT_ID|BILL_CYC_CD|SETUP_DT|CURRENCY_CD|ACCT_MGMT_GRP_CD|ALERT_INFO|BILL_AFTER_DT|PROTECT_CYC_SW|CIS_DIVISION|MAILING_PREM_ID|PROTECT_PREM_SW|COLL_CL_CD|CR_REVIEW_DT|POSTPONE_CR_RVW_DT|INT_CR_REVIEW_SW|CUST_CL_CD|BILL_PRT_INTERCEPT|NO_DEP_RVW_SW|BUD_PLAN_CD|VERSION|PROTECT_DIV_SW|ACCESS_GRP_CD|ACCT_DATA_AREA|EC_EXPIRY_SCHEDULE_CD|BILL_LEAD_DAYS|ACCT_USAGE_FLG|TRIAL_BILL_SW|REPRICING_SW|CRE_BY|LAST_UPD_BY|CRE_DTTM|LAST_UPD_DTTM|PRODUCT_CD|DEFER_AUTO_PAY_DT|ACCR_CYC_CD|EXCL_ACCR_SW|RULE_APAY_SW|BO_STATUS_CD|STATUS_UPD_DTTM|BUS_OBJ_CD|BO_DATA_AREA|CLOSING_DT|DD_CR_SW|
			|4355573974| |01-JAN-2018 00.00.00|GBP|          | |null|N|00001|          |N|WPOVERDUE |null|null|N|DUE 1   |        |N|        |8|N|***         | EMPTY_CLOB()|            |0|USAG|N|N|SYSUSER|SYSUSER|06-AUG-2018 06.46.00|20-SEP-2019 18.18.10| |null| |N|N|            |null|                              | |null| |
			|4356654139| |01-JAN-2018 00.00.00|GBP|          | |null|N|00001|          |N|WPOVERDUE |null|null|N|DUE 1   |        |N|        |7|N|***         | EMPTY_CLOB()|            |0|USAG|N|N|SYSUSER|SYSUSER|06-AUG-2018 06.46.00|20-SEP-2019 18.18.10| |null| |N|N|            |null|                              | |null| |
			|4359137286| |01-JAN-2018 00.00.00|GBP|          | |null|N|00001|          |N|WPOVERDUE |null|null|N|DUE 1   |        |N|        |10|N|***         | EMPTY_CLOB()|           |0|USAG|N|N|SYSUSER|SYSUSER|06-AUG-2018 06.46.00|20-SEP-2019 18.18.10| |null| |N|N|            |null|                              | |null| |
			|4359623507| |01-JAN-2018 00.00.00|GBP|          | |null|N|00001|          |N|WPOVERDUE |null|null|N|DUE 1   |        |N|        |7|N|***         | EMPTY_CLOB()|            |0|USAG|Y|N|SYSUSER|SYSUSER|06-AUG-2018 06.46.00|20-SEP-2019 18.18.10| |null| |N|N|            |null|                              | |null| |	   
		 And I create data for "CI_ACCT_PER"
     		| ACCT_ID    | ACCT_REL_TYPE_CD | BILL_ADDR_SRCE_FLG | PER_ID     | MAIN_CUST_SW | FIN_RESP_SW | THRD_PTY_SW | RECEIVE_COPY_SW | BILL_RTE_TYPE_CD | BILL_FORMAT_FLG | NBR_BILL_COPIES | VERSION | CUST_PO_ID | NOTIFY_SW | NAME_PFX_SFX | FX_SFX_FLG | QTE_RTE_TYPE_CD | RECV_QTE_SW | WEB_ACCESS_FLG |
      		| 4355573974 | MAIN             | PER                | 4353623129 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
      		| 4356654139 | MAIN             | PER                | 4353623129 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
      		| 4359137286 | MAIN             | PER                | 4353623129 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
     		| 4359623507 | MAIN             | PER                | 4353623129 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
		And I create data for "CI_ACCT_NBR"
			|ACCT_ID|ACCT_NBR_TYPE_CD|ACCT_NBR|VERSION|PRIM_SW|
			|4355573974|C1_F_ANO|PO7000161800_CHBK_GBP|1|Y|
			|4356654139|C1_F_ANO|PO7000161800_CHRG_GBP|1|Y|
			|4359137286|C1_F_ANO|PO7000161800_CRWD_GBP|1|Y|
			|4359623507|C1_F_ANO|PO7000161800_FUND_GBP|1|Y|			
     	When I have the following open bills for above party id and below paramters are " " " " " " " " " " " " " " " "    	  	
     			|DEV00000111|
  				|PO7000161800|
      	Then I get the following values in "openBills" list with 0 entries and "getResponse" body:
   			|billid                                |
			|lineId                                |
			|lineAmount                            |
			|unpaidAmount                          |
			|currency                              |
			|dueDate                               |
			|bankingEntryStatus                    |
			|latestBankingEntryEvent               |
			|alternateBillId                       |
			|billDate                              |
			|billAmount                            |
			|accountType                           |
			|accountDescription                    |
			|partyId                               |
			|legalCounterparty                     |
			|legalCounterpartyDescription          |     
@negative_SRV131 @Srv131-4      
       Scenario Outline: Get all open bills for a partyId with soft parameters
        Given I have the following partyId "DEV000001"
   And I create data for "CI_BILL_CHAR"
      | BILL_ID      | CHAR_TYPE_CD | SEQ_NUM | VERSION | CHAR_VAL | ADHOC_CHAR_VAL             | CHAR_VAL_FK1 | CHAR_VAL_FK2 | CHAR_VAL_FK3 | CHAR_VAL_FK4 | CHAR_VAL_FK5 | SRCH_CHAR_VAL              |
      | 909196050498 | CM_RTTC      |       1 |       1 |          | 2019-08-22-06.26.44.000000 |              |              |              |              |              | 2019-08-22-06.26.44.000000 |
      | 909196050498 | RUN_TOT      |       1 |       1 |          |                        852 |              |          852 | 909960709108 | BASE_CHG     |              | MIGFUND                    |
      | 909196050498 | BILL_AMT     |       1 |       1 |          |                        852 |              |              |              |              |              |                        852 |
      | 909196184392 | BILL_AMT     |       1 |       1 |          |                        639 |              |              |              |              |              |                        639 |
      | 909196184392 | CM_RTTC      |       1 |       1 |          | 2019-08-22-06.19.39.000000 |              |              |              |              |              | 2019-08-22-06.19.39.000000 |
      | 909196184392 | RUN_TOT      |       1 |       1 |          |                        639 |              |          639 | 909961096615 | BASE_CHG     |              | MIGCHBK                    |
      | 909296385783 | BILL_AMT     |       1 |       1 |          |                        529 |              |              |              |              |              |                        529 |
      | 909296385783 | CM_RTTC      |       1 |       1 |          | 2019-08-22-06.19.44.000000 |              |              |              |              |              | 2019-08-22-06.19.44.000000 |
      | 909296385783 | RUN_TOT      |       1 |       1 |          |                        369 |              |          369 | 909963636294 | BASE_CHG     |              | MIGCHRG                    |
      | 909296385783 | RUN_TOT      |       2 |       1 |          |                        160 |              |          160 | 909963273729 | BASE_CHG     |              | MIGCHRG2                   |
    And I create data for "CI_PER_ID"
      | PER_ID     | ID_TYPE_CD | PER_ID_NBR | PRIM_SW | VERSION |
      | 9091621050 | EXPRTYID   | DEV000001  | Y       |       1 |
    And I create data for "CM_BILL_PAYMENT_DTL"
      | PAY_DTL_ID | UPLOAD_DTTM        | PAY_DT             | EXT_TRANSMIT_ID | BILL_ID      | LINE_ID | LINE_AMT | PREV_UNPAID_AMT | PAY_AMT | UNPAID_AMT | CURRENCY_CD | STATUS_CD     | PAY_TYPE | ILM_DT             | ILM_ARCH_SW | OVERPAID | RECORD_STAT   | STATUS_UPD_DTTM    | MESSAGE_CAT_NBR | MESSAGE_NBR | ERROR_INFO | EXT_SOURCE_CD |
      |       1009 | 22-AUG-19 06.32.21 | 22-AUG-19 06.32.21 | null            | 909196050498 |       1 |      852 |             852 |       0 |        852 | GBP         | MIGRATED_DEBT | DR       | 22-AUG-19 06.32.21 | Y           | null     | MIGRATED_DEBT | 22-AUG-19 06.32.21 |               0 |           0 |            |               |
      |       1010 | 22-AUG-19 06.32.21 | 22-AUG-19 06.32.21 | null            | 909196184392 |       1 |      639 |             639 |       0 |        639 | GBP         | MIGRATED_DEBT | DR       | 22-AUG-19 06.32.21 | Y           | null     | MIGRATED_DEBT | 22-AUG-19 06.32.21 |               0 |           0 |            |               |
      |       1005 | 22-AUG-19 06.32.20 | 22-AUG-19 06.32.20 | null            | 909296385783 |       1 |      529 |             529 |       0 |        529 | GBP         | MIGRATED_DEBT | DR       | 22-AUG-19 06.32.20 | Y           | null     | MIGRATED_DEBT | 22-AUG-19 06.32.20 |               0 |           0 |            |               |
    And I create data for "CM_BILL_DUE_DT"
      | BANK_ENTRY_EVENT_ID | BILL_ID      | DUE_DT             | IS_MERCH_BALANCED | UPLOAD_DTTM        | STATUS_UPD_DTTM | PAY_DT             | LINE_ID | BANKING_ENTRY_STATUS |
      |         20002385246 | 909196050498 | 13-AUG-19 00.00.00 | N                 | 22-AUG-19 06.32.21 | null            | 22-AUG-19 06.32.21 |       1 | DEBT_MIGRATION       |
      |         20002375245 | 909196184392 | 13-AUG-19 00.00.00 | N                 | 22-AUG-19 06.32.21 | null            | 22-AUG-19 06.32.21 |       1 | DEBT_MIGRATION       |
      |         20002365147 | 909296385783 | 13-AUG-19 00.00.00 | N                 | 22-AUG-19 06.32.20 | null            | 22-AUG-19 06.32.20 |       1 | DEBT_MIGRATION       |
    And I create data for "CI_BILL"
      | BILL_ID      | BILL_CYC_CD | WIN_START_DT | ACCT_ID    | BILL_STAT_FLG | BILL_DT            | DUE_DT             | CRE_DTTM           | COMPLETE_DTTM      | LATE_PAY_CHARGE_SW | LATE_PAY_CHARGE_DT | ALLOW_REOPEN_SW | VERSION | NEXT_CR_RVW_DT     | CR_NOTE_FR_BILL_ID | APAY_CRE_DT | APAY_AMT | ARCHIVE_SW | APAY_STOP_USER_ID | APAY_STOP_DTTM | APAY_STOP_AMT | APAY_STOP_CRE_DT | ADHOC_BILL_SW | GRP_REF_VAL  | TD_ENTRY_ID | TRIAL_BILL_ID | ILM_DT             | ILM_ARCH_SW | ALT_BILL_ID |
      | 909196050498 |             | null         | 9091468231 | C             | 13-AUG-19 00.00.00 | 22-AUG-19 00.00.00 | 22-AUG-19 06.26.40 | 13-AUG-19 00.00.00 | N                  | null               | N               |       4 | 22-AUG-19 00.00.00 |                    | null        |        0 | N          |                   | null           |             0 | null             | Y             | 891581313662 |             |               | 22-AUG-19 00.00.00 | N           |        1187 |
      | 909196184392 |             | null         | 9091061938 | C             | 13-AUG-19 00.00.00 | 22-AUG-19 00.00.00 | 22-AUG-19 06.19.35 | 13-AUG-19 00.00.00 | N                  | null               | N               |       4 | 22-AUG-19 00.00.00 |                    | null        |        0 | N          |                   | null           |             0 | null             | Y             | 891581313662 |             |               | 22-AUG-19 00.00.00 | N           |        1188 |
      | 909296385783 |             | null         | 9092785004 | C             | 13-AUG-19 00.00.00 | 22-AUG-19 00.00.00 | 22-AUG-19 06.19.43 | 13-AUG-19 00.00.00 | N                  | null               | N               |       4 | 22-AUG-19 00.00.00 |                    | null        |        0 | N          |                   | null           |             0 | null             | Y             | 891581313662 |             |               | 22-AUG-19 00.00.00 | N           |        1190 |
    And I create data for "CI_ACCT_PER"
      | ACCT_ID    | ACCT_REL_TYPE_CD | BILL_ADDR_SRCE_FLG | PER_ID     | MAIN_CUST_SW | FIN_RESP_SW | THRD_PTY_SW | RECEIVE_COPY_SW | BILL_RTE_TYPE_CD | BILL_FORMAT_FLG | NBR_BILL_COPIES | VERSION | CUST_PO_ID | NOTIFY_SW | NAME_PFX_SFX | FX_SFX_FLG | QTE_RTE_TYPE_CD | RECV_QTE_SW | WEB_ACCESS_FLG |
      | 9091061938 | MAIN             | PER                | 9091621050 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
      | 9091468231 | MAIN             | PER                | 9091621050 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
      | 9091638847 | MAIN             | PER                | 9091621050 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
      | 9092785004 | MAIN             | PER                | 9091621050 | Y            | Y           | N           | Y               | WPDOCUMK         | D               |               1 |       1 |            | Y         |              |            |                 | N           | ALWD           |
    And I create data for "CI_ACCT"
      | ACCT_ID    | BILL_CYC_CD | SETUP_DT           | CURRENCY_CD | ACCT_MGMT_GRP_CD | ALERT_INFO | BILL_AFTER_DT | PROTECT_CYC_SW | CIS_DIVISION | MAILING_PREM_ID | PROTECT_PREM_SW | COLL_CL_CD | CR_REVIEW_DT | POSTPONE_CR_RVW_DT | INT_CR_REVIEW_SW | CUST_CL_CD | BILL_PRT_INTERCEPT | NO_DEP_RVW_SW | BUD_PLAN_CD | VERSION | PROTECT_DIV_SW | ACCESS_GRP_CD | ACCT_DATA_AREA | EC_EXPIRY_SCHEDULE_CD | BILL_LEAD_DAYS | ACCT_USAGE_FLG | TRIAL_BILL_SW | REPRICING_SW | CRE_BY  | LAST_UPD_BY | CRE_DTTM           | LAST_UPD_DTTM      | PRODUCT_CD | DEFER_AUTO_PAY_DT | ACCR_CYC_CD | EXCL_ACCR_SW | RULE_APAY_SW | BO_STATUS_CD | STATUS_UPD_DTTM | BUS_OBJ_CD | BO_DATA_AREA | CLOSING_DT | DD_CR_SW |
      | 9091061938 | WPDY        | 06-DEC-18 00.00.00 | GBP         |                  |            | null          | N              |        00001 |                 | N               | WPOVERDUE  | null         | null               | N                | DUE 1      |                    | N             |             |       5 | N              | ***           | null   |                       |              0 | USAG           | N             | N            | SYSUSER | SYSUSER     | 21-AUG-19 11.08.56 | 21-AUG-19 11.08.56 |            | null              |             | N            | N            |              | null            |            |              | null       |          |
      | 9091468231 | WPDY        | 06-DEC-18 00.00.00 | GBP         |                  |            | null          | N              |        00001 |                 | N               | WPOVERDUE  | null         | null               | N                | DUE 1      |                    | N             |             |       6 | N              | ***           | null   |                       |              0 | USAG           | N             | N            | SYSUSER | SYSUSER     | 21-AUG-19 11.08.56 | 21-AUG-19 11.08.56 |            | null              |             | N            | N            |              | null            |            |              | null       |          |
      | 9091638847 | WPDY        | 06-DEC-18 00.00.00 | GBP         |                  |            | null          | N              |        00001 |                 | N               | WPOVERDUE  | null         | null               | N                | DUE 1      |                    | N             |             |       5 | N              | ***           | null   |                       |              0 | USAG           | N             | N            | SYSUSER | SYSUSER     | 21-AUG-19 11.08.56 | 21-AUG-19 11.08.56 |            | null              |             | N            | N            |              | null            |            |              | null       |          | 
    	|9092785004	 | WPDY				 | 06-DEC-18 00.00.00 | GBP					|          				 |            |	null					| N							 | 				00001 |          				| N								|	WPOVERDUE  | null					| null							 | N								| DUE 1   	 |    	 						  | N							|	 		        |				5 | N 						 | *** 	         | null		|												|			         0 | USAG						| N							| N						 | SYSUSER | SYSUSER 		 | 21-AUG-19 11.08.56 | 21-AUG-19 11.08.56 |            |null								|             | N            | N            |              | null						 |            | 						 | null				| 				 |
    And I create data for "CI_ACCT_NBR"
      | ACCT_ID    | ACCT_NBR_TYPE_CD | ACCT_NBR           | VERSION | PRIM_SW |
      | 9091061938 | C1_F_ANO         | DEV000001_CHBK_GBP |       1 | Y       |
      | 9092785004 | C1_F_ANO         | DEV000001_CHRG_GBP |       1 | Y       |
      | 9091638847 | C1_F_ANO         | DEV000001_CRWD_GBP |       1 | Y       |
      | 9091468231 | C1_F_ANO         | DEV000001_FUND_GBP |       1 | Y       |
      | 9091061938 | ACCTTYPE         | CHBK               |       1 | N       |
      | 9091468231 | ACCTTYPE         | FUND               |       1 | N       |
      | 9091638847 | ACCTTYPE         | CRWD               |       1 | N       |
      | 9092785004 | ACCTTYPE         | CHRG               |       1 | N       |
    When I have the following open bills for above party id and below paramters are "<currency>" "<billdateTo>" "<billdateFrom>" "<legalCounterParty>" "<altBillId>" "<billAmountFrom>" "<billAmountTo>" "<billPaymentStatus>"
  		|TD10001200401|
  		|PX000000020001|
    Then I get the following values in "openBills" list with 3 entries and "getResponse" body:
 		| billid                       |                 909196050498|                 909196184392 |                 909296385783 |
      	| lineId                       |                            1|                           1 	|                            1 |
      	| lineAmount                   |                       852.0 |                        639.0 |                        529.0 |
      	| unpaidAmount                 |                       852.0 |                        639.0 |                        529.0 |
      	| currency                     | GBP                         | GBP                          | GBP                          |
      	| dueDate                      | 2019-08-13T00:00:00.000+0000| 2019-08-13T00:00:00.000+0000 | 2019-08-13T00:00:00.000+0000 |
      	| bankingEntryStatus           | DEBT_MIGRATION              | DEBT_MIGRATION               | DEBT_MIGRATION               |
      	| latestBankingEntryEvent      |                  20002385246|                  20002375245 |                  20002365147 |
      	| alternateBillId              |                         1187|                         1188 |                         1190 |
     	| billDate                     | 2019-08-13T00:00:00.000+0000| 2019-08-13T00:00:00.000+0000 | 2019-08-13T00:00:00.000+0000 |
      	| billAmount                   |                          852|                          639 |                          529 |
      	| accountType                  | FUND                        | CHBK                         | CHRG                         |
      	| accountDescription           | FUNDING                     | CHARGEBACKS                  | CHARGING                     |
      	| partyId                      | DEV000001                   | DEV000001                    | DEV000001                    |
      	| legalCounterparty            | PO1100000001                | PO1100000001                 | PO1100000001                 |
      	| legalCounterpartyDescription | Worldpay (UK) Limited       | Worldpay (UK) Limited        | Worldpay (UK) Limited        |
      Examples:      		
     		|currency|billdateTo|billdateFrom|legalCounterParty|altBillId|billPaymentStatus|billAmountFrom|billAmountTo|
     		|GBP|2019-08-13|2019-08-13|PO1100000001| |PAID |0 |1000 |
     		|GBP|2019-08-14|2019-08-13|PO1100000001| |UNPAID |0 |1000 |
     		|GBP|2019-08-14|2019-08-13|PO1100000001| | |300.45 |1000 |
     		|GBP|2019-08-13|2019-08-13|PO1100000001|1187| |0 |1000 |
     		
     		

      
      
      
      
