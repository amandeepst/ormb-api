

  CREATE TABLE CI_CIS_DIV_CHAR
   (	"CIS_DIVISION" CHAR(5) NOT NULL, 
	"CHAR_TYPE_CD" CHAR(8) NOT NULL, 
	"EFFDT" DATE NOT NULL, 
	"CHAR_VAL" CHAR(16) DEFAULT ' ' NOT NULL, 
	"VERSION" NUMBER(5,0) DEFAULT 1 NOT NULL, 
	"ADHOC_CHAR_VAL" VARCHAR2(254) DEFAULT ' ' NOT NULL, 
	"CHAR_VAL_FK1" VARCHAR2(50) DEFAULT ' ' NOT NULL, 
	"CHAR_VAL_FK2" VARCHAR2(50) DEFAULT ' ' NOT NULL, 
	"CHAR_VAL_FK3" VARCHAR2(50) DEFAULT ' ' NOT NULL, 
	"CHAR_VAL_FK4" VARCHAR2(50) DEFAULT ' ' NOT NULL, 
	"CHAR_VAL_FK5" VARCHAR2(50) DEFAULT ' ' NOT NULL, 
	"ENABLED_FLG" CHAR(1)
   );

  ALTER TABLE CI_CIS_DIV_CHAR ADD PRIMARY KEY ("CIS_DIVISION", "CHAR_TYPE_CD", "EFFDT");

 
