

  CREATE TABLE  "CM_BILL_PAYMENT_DTL" 
   (	"PAY_DTL_ID" NUMBER(15,0) NOT NULL, 
	"UPLOAD_DTTM" DATE, 
	"PAY_DT" DATE, 
	"EXT_TRANSMIT_ID" CHAR(60), 
	"BILL_ID" CHAR(12) NOT NULL, 
	"LINE_ID" CHAR(12) NOT NULL, 
	"LINE_AMT" NUMBER(15,2) NOT NULL, 
	"PREV_UNPAID_AMT" NUMBER(15,2) NOT NULL, 
	"PAY_AMT" NUMBER(15,2) NOT NULL, 
	"UNPAID_AMT" NUMBER(15,2) NOT NULL, 
	"CURRENCY_CD" CHAR(3) NOT NULL, 
	"STATUS_CD" VARCHAR2(15) NOT NULL, 
	"PAY_TYPE" VARCHAR2(15) NOT NULL, 
	"ILM_DT" DATE DEFAULT TO_DATE('2000-01-01','YYYY-MM-DD') NOT NULL, 
	"ILM_ARCH_SW" CHAR(1) DEFAULT 'Y', 
	"OVERPAID" VARCHAR2(20), 
	"RECORD_STAT" VARCHAR2(20), 
	"STATUS_UPD_DTTM" DATE, 
	"MESSAGE_CAT_NBR" NUMBER(5,0) DEFAULT 0 NOT NULL, 
	"MESSAGE_NBR" NUMBER(5,0) DEFAULT 0 NOT NULL, 
	"ERROR_INFO" VARCHAR2(254) DEFAULT ' ' NOT NULL, 
	"EXT_SOURCE_CD" CHAR(30) DEFAULT ' ' NOT NULL
   ) ;


 ALTER TABLE  CM_BILL_PAYMENT_DTL ADD CONSTRAINT "PK_PAY_DTL" PRIMARY KEY ("PAY_DTL_ID");