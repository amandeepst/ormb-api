@OrmbAPI @Srv132
Feature: Test scenarios for Srv132


    @GetSettlementGroupForPartyId
    Scenario: Get all merchant settlement groups for a partyId

		Given I have the following partyId "PO2602201903"
		And I create data for "CI_PER_ID"
			|PER_ID|ID_TYPE_CD|PER_ID_NBR|PRIM_SW|VERSION| 
			|3840962938|EXPRTYID|PO2602201903|Y|1|
		And I create data for "CI_ACCT_PER"
			|ACCT_ID|ACCT_REL_TYPE_CD|BILL_ADDR_SRCE_FLG|PER_ID|MAIN_CUST_SW|FIN_RESP_SW|THRD_PTY_SW|RECEIVE_COPY_SW|BILL_RTE_TYPE_CD|BILL_FORMAT_FLG|NBR_BILL_COPIES|VERSION|CUST_PO_ID|NOTIFY_SW|NAME_PFX_SFX|FX_SFX_FLG|QTE_RTE_TYPE_CD|RECV_QTE_SW|WEB_ACCESS_FLG| 
			|3843693511|MAIN    |PER |3840962938|Y|Y|N|Y|WPDOCUMK|D |1|1| |Y| |  |            |N|ALWD|
			|3846825457|MAIN    |PER |3840962938|Y|Y|N|Y|WPDOCUMK|D |1|1| |Y| |  |            |N|ALWD|
			|3847676091|MAIN    |PER |3840962938|Y|Y|N|Y|WPDOCUMK|D |1|1| |Y| |  |            |N|ALWD|
			|3848290977|MAIN    |PER |3840962938|Y|Y|N|Y|WPDOCUMK|D |1|1| |Y| |  |            |N|ALWD|
		And I create data for "CI_SA"
			|SA_ID|PROP_DCL_RSN_CD|PROP_SA_ID|CIS_DIVISION|SA_TYPE_CD|START_OPT_CD|START_DT|SA_STATUS_FLG|ACCT_ID|END_DT|OLD_ACCT_ID|CUST_READ_FLG|ALLOW_EST_SW|SIC_CD|CHAR_PREM_ID|TOT_TO_BILL_AMT|CURRENCY_CD|VERSION|SA_REL_ID|STRT_RSN_FLG|STOP_RSN_FLG|STRT_REQED_BY|STOP_REQED_BY|HIGH_BILL_AMT|INT_CALC_DT|CIAC_REVIEW_DT|BUS_ACTIVITY_DESC|IB_SA_CUTOFF_TM|IB_BASE_TM_DAY_FLG|ENRL_ID|SPECIAL_USAGE_FLG|PROP_SA_STAT_FLG|NBR_PYMNT_PERIODS|NB_RULE_CD|EXPIRE_DT|RENEWAL_DT|NB_APAY_FLG|SA_DATA_AREA|POLICY_ID| 
			|3843693384|            |          |00001|CHBK    |            |26-JAN-18 00.00.00|20|3843693511|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB())|              |
			|3846825384|            |          |00001|CHRG    |            |26-JAN-18 00.00.00|20|3846825457|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB())|              |
			|3846825416|            |          |00001|CHRG    |            |01-DEC-18 00.00.00|20|3846825457|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3846824161|            |          |00001|RECR    |            |01-DEC-18 00.00.00|20|3846825457|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3846824160|            |          |00001|CHRG    |            |01-DEC-18 00.00.00|70|3846825457|23-APR-19 00.00.00	| |N |N|        |          |0|GBP|4|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3846824165|            |          |00001|RECR    |            |01-DEC-18 00.00.00|70|3846825457|23-APR-19 00.00.00	| |N |N|        |          |0|GBP|4|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3846823846|            |          |00001|RECR    |            |26-JAN-18 00.00.00|20|3846825457|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3846825005|            |          |00001|CHRG    |            |01-MAY-19 00.00.00|20|3846825457|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3846820050|            |          |00001|RECR    |            |01-MAY-19 00.00.00|20|3846825457|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3846825803|            |          |00001|CHRG    |            |26-APR-19 00.00.00|70|3846825457|01-MAY-19 00.00.00	| |N |N|        |          |0|GBP|6|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3846828035|            |          |00001|RECR    |            |26-APR-19 00.00.00|70|3846825457|01-MAY-19 00.00.00	| |N |N|        |          |0|GBP|6|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3847676384|            |          |00001|CRWD    |            |26-JAN-18 00.00.00|20|3847676091|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3848290384|            |          |00001|FUND    |            |26-JAN-18 00.00.00|20|3848290977|null				| |N |N|        |          |0|GBP|3|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3848290633|            |          |00001|FUND    |            |13-APR-19 00.00.00|70|3848290977|29-APR-19 00.00.00	| |N |N|        |          |0|GBP|4|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3848290654|            |          |00001|FUND    |            |12-MAR-19 00.00.00|70|3848290977|12-APR-19 00.00.00	| |N |N|        |          |0|GBP|4|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3848296546|            |          |00001|FUND    |            |01-MAR-19 00.00.00|70|3848290977|11-MAR-19 00.00.00	| |N |N|        |          |0|GBP|1|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
			|3848290063|            |          |00001|FUND    |            |23-MAR-19 00.00.00|70|3848290977|29-APR-19 00.00.00	| |N |N|        |          |0|GBP|4|          |    |    | | |0|null|null| |null|  |            |    |  |0|        |null|null|    | EMPTY_CLOB()|              |
		When I want to get all merchantSettlementGroup for a partyId from UI
		Then I get the following values in "merchantSettlementGroup" list with 9 entries and "getResponse" body:
		|subAccountCode            	   |CHBK  				 	|CHRG			       |CHRG			      | RECR					| RECR					 |CHRG			    	 | RECR					  |CRWD			          |FUND                  |
		|subAccountDescription 		   |CHARGEBACKS  			|CHARGING   		   |CHARGING   		  	  | RECURRING CHARGES  		| RECURRING CHARGES  	 |CHARGING   		  	 | RECURRING CHARGES  	  |CARD REWARDS   	      |FUNDING   			 |
		|currency    				   |GBP  					|GBP 				   |GBP 				  | GBP 					| GBP 					 |GBP 				 	 | GBP 					  |GBP 				      |GBP 					 |	
		|legalCounterpartyShortCode    |00001 					|00001 				   |00001 				  | 00001					| 00001					 |00001 				 | 00001				  |00001			      |00001                 |
		|legalCounterpartyDescription  |Worldpay (UK) Limited	|Worldpay (UK) Limited |Worldpay (UK) Limited | Worldpay (UK) Limited	| Worldpay (UK) Limited	 |Worldpay (UK) Limited  | Worldpay (UK) Limited  |Worldpay (UK) Limited  |Worldpay (UK) Limited |
		|legalCounterparty   		   |PO1100000001         	|PO1100000001          |PO1100000001          | PO1100000001         	| PO1100000001         	 |PO1100000001           | PO1100000001           |PO1100000001           |PO1100000001          |
		
@negative_SRV132 @Srv132-1
       Scenario: Get Merchant Balance for a invalid partyId
        Given I have the following partyId "PO260220190311"
     	When I want to get all merchantSettlementGroup for a partyId from UI
      	Then I get the status "NOT_FOUND"
 @negative_SRV132 @Srv132
       Scenario: Get Merchant Balance for a empty partyId
        Given I have the following partyId " "
     	When I want to get all merchantSettlementGroup for a partyId from UI
      	Then I get the status "NOT_FOUND"		
		