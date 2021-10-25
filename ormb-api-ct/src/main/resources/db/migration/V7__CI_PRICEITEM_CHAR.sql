
  CREATE TABLE  "CI_PRICEITEM_CHAR" 
   (	"PRICEITEM_CD" CHAR(30) NOT NULL, 
	"CHAR_TYPE_CD" CHAR(8) NOT NULL, 
	"EFFDT" DATE NOT NULL, 
	"ADHOC_CHAR_VAL" VARCHAR2(254), 
	"CHAR_VAL" CHAR(16), 
	"CHAR_VAL_FK1" VARCHAR2(50), 
	"CHAR_VAL_FK2" VARCHAR2(50), 
	"CHAR_VAL_FK3" VARCHAR2(50), 
	"CHAR_VAL_FK4" VARCHAR2(50), 
	"CHAR_VAL_FK5" VARCHAR2(50), 
	"SRCH_CHAR_VAL" VARCHAR2(254), 
	"VERSION" NUMBER(5,0) DEFAULT 1 NOT NULL
   ) ;

  ALTER TABLE  CI_PRICEITEM_CHAR ADD PRIMARY KEY ("PRICEITEM_CD", "CHAR_TYPE_CD", "EFFDT");
 
