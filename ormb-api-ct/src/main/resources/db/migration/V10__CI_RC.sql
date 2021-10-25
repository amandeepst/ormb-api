
  CREATE TABLE  "CI_RC" 
   (	"RS_CD" CHAR(8) NOT NULL, 
	"EFFDT" DATE NOT NULL, 
	"RC_SEQ" NUMBER(3,0) NOT NULL, 
	"BF_CD" CHAR(8) DEFAULT ' ' NOT NULL, 
	"TMAP_REL_TYPE_CD" CHAR(12) DEFAULT ' ' NOT NULL, 
	"RC_STEP_ALG_CD" CHAR(12) DEFAULT ' ' NOT NULL, 
	"RC_VAL_ALG_CD" CHAR(12) DEFAULT ' ' NOT NULL, 
	"RC_TYPE_FLG" CHAR(2) DEFAULT ' ' NOT NULL, 
	"SEASONAL_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"SEASON_START_MMDD" CHAR(4) DEFAULT ' ' NOT NULL, 
	"SEASON_END_MMDD" CHAR(4) DEFAULT ' ' NOT NULL, 
	"VAL_TYPE_FLG" CHAR(2) DEFAULT ' ' NOT NULL, 
	"VAL_SRC_FLG" CHAR(2) DEFAULT ' ' NOT NULL, 
	"VAL" NUMBER(36,18) DEFAULT 0 NOT NULL, 
	"VAL_RC_SEQ" NUMBER(3,0) DEFAULT 0, 
	"STEPPED_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"STEP_LOW_VAL" NUMBER(36,18) DEFAULT 0 NOT NULL, 
	"STEP_HIGH_VAL" NUMBER(36,18) DEFAULT 0 NOT NULL, 
	"STEP_RC_SEQ" NUMBER(3,0) DEFAULT 0 NOT NULL, 
	"PRORATE_METHOD_FLG" CHAR(4) DEFAULT ' ' NOT NULL, 
	"UOM_CD" CHAR(4) DEFAULT ' ' NOT NULL, 
	"TOU_CD" CHAR(8) DEFAULT ' ' NOT NULL, 
	"SQI_CD" CHAR(8) DEFAULT ' ' NOT NULL, 
	"MSR_PEAK_QTY_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"ITEM_TYPE_CD" CHAR(8) DEFAULT ' ' NOT NULL, 
	"PRT_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"DST_ID" CHAR(10) DEFAULT ' ' NOT NULL, 
	"ERR_IF_NO_VAL_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"STATISTICAL_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"CALC_ONLY_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"RESULT_TYPE_FLG" CHAR(2) DEFAULT ' ' NOT NULL, 
	"PRT_IF_ZERO_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"RC_AMT_ALG_CD" CHAR(12) DEFAULT ' ' NOT NULL, 
	"INTV_PF_REL_TYP_CD" CHAR(12) DEFAULT ' ' NOT NULL, 
	"CRE_BILL_LN_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"VERSION" NUMBER(5,0) DEFAULT 1 NOT NULL, 
	"RC_AUDIT_ALG" CHAR(12) DEFAULT ' ' NOT NULL, 
	"SQ_DRV_SW" CHAR(1) DEFAULT ' ' NOT NULL, 
	"RND_TYPE_FLG" CHAR(4) DEFAULT ' ' NOT NULL, 
	"RND_PRECISION_LVL" NUMBER(36,18) DEFAULT 0 NOT NULL, 
	"FCPO_RULE_FLG" CHAR(4) DEFAULT ' ' NOT NULL, 
	"TOU_MAP_ID" CHAR(12) DEFAULT ' ' NOT NULL, 
	"ALLOW_CURR_CONV" CHAR(1) DEFAULT 'N' NOT NULL
   );

  

ALTER TABLE   CI_RC ADD PRIMARY KEY ("RS_CD", "EFFDT", "RC_SEQ");