

  CREATE TABLE "CI_BILL" 
   (	"BILL_ID" CHAR(12) NOT NULL, 
	"BILL_CYC_CD" CHAR(4) DEFAULT ' ' NOT NULL, 
	"WIN_START_DT" DATE, 
	"ACCT_ID" CHAR(10) DEFAULT ' ' NOT NULL, 
	"BILL_STAT_FLG" CHAR(2) DEFAULT ' ' NOT NULL, 
	"BILL_DT" DATE, 
	"DUE_DT" DATE, 
	"CRE_DTTM" DATE, 
	"COMPLETE_DTTM" DATE, 
	"LATE_PAY_CHARGE_SW" CHAR(1) DEFAULT ' ', 
	"LATE_PAY_CHARGE_DT" DATE , 
	"ALLOW_REOPEN_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"VERSION" NUMBER(5,0) DEFAULT 1 NOT NULL, 
	"NEXT_CR_RVW_DT" DATE, 
	"CR_NOTE_FR_BILL_ID" CHAR(12) DEFAULT ' ' NOT NULL, 
	"APAY_CRE_DT" DATE, 
	"APAY_AMT" NUMBER(15,2) DEFAULT 0 NOT NULL, 
	"ARCHIVE_SW" CHAR(1) DEFAULT 'N' NOT NULL, 
	"APAY_STOP_USER_ID" CHAR(8) DEFAULT ' ' NOT NULL,  
	"APAY_STOP_DTTM" DATE, 
	"APAY_STOP_AMT" NUMBER(15,2) DEFAULT 0 NOT NULL, 
	"APAY_STOP_CRE_DT" DATE , 
	"ADHOC_BILL_SW" CHAR(1) DEFAULT 'N' NOT NULL, 
	"GRP_REF_VAL" VARCHAR2(20) DEFAULT ' ' NOT NULL, 
	"TD_ENTRY_ID" CHAR(14) DEFAULT ' ', 
	"TRIAL_BILL_ID" CHAR(12) DEFAULT ' ', 
	"ILM_DT" DATE DEFAULT trunc(current_date), 
	"ILM_ARCH_SW" CHAR(1) DEFAULT 'N', 
	"ALT_BILL_ID" VARCHAR2(30) DEFAULT ' ' NOT NULL
   ) ;

 ALTER TABLE "CI_BILL" ADD PRIMARY KEY ("BILL_ID");
