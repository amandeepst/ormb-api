
  CREATE TABLE CI_CIS_DIVISION_L 
   (	"CIS_DIVISION" CHAR(5) NOT NULL, 
	"LANGUAGE_CD" CHAR(3) NOT NULL, 
	"VERSION" NUMBER(5,0) DEFAULT 1 NOT NULL, 
	"DESCR" VARCHAR2(60) DEFAULT ' ' NOT NULL
   );

  ALTER TABLE CI_CIS_DIVISION_L ADD PRIMARY KEY ("CIS_DIVISION", "LANGUAGE_CD");