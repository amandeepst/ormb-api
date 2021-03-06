  CREATE TABLE "CI_PER_CHAR" 
   (	"PER_ID" CHAR(10) NOT NULL, 
	"CHAR_TYPE_CD" CHAR(8) NOT NULL, 
	"CHAR_VAL" CHAR(16) DEFAULT ' ' , 
	"EFFDT" DATE NOT NULL, 
	"ADHOC_CHAR_VAL" VARCHAR2(254) DEFAULT ' ' , 
	"VERSION" NUMBER(5,0) DEFAULT 1 , 
	"CHAR_VAL_FK1" VARCHAR2(50) DEFAULT ' ' , 
	"CHAR_VAL_FK2" VARCHAR2(50) DEFAULT ' ' , 
	"CHAR_VAL_FK3" VARCHAR2(50) DEFAULT ' ' , 
	"CHAR_VAL_FK4" VARCHAR2(50) DEFAULT ' ' , 
	"CHAR_VAL_FK5" VARCHAR2(50) DEFAULT ' ' 
   ) ;

  ALTER TABLE CI_PER_CHAR ADD PRIMARY KEY (PER_ID, CHAR_TYPE_CD, EFFDT);
  
