CREATE TABLE CI_ACCT_NBR 
   (	ACCT_ID CHAR(10) NOT NULL, 
	ACCT_NBR_TYPE_CD CHAR(8) NOT NULL, 
	ACCT_NBR VARCHAR2(30) , 
	VERSION NUMBER(5,0) DEFAULT 1  NOT NULL, 
	PRIM_SW CHAR(1) DEFAULT ' ' NOT NULL
   ) ;

   ALTER TABLE CI_ACCT_NBR ADD PRIMARY KEY ("ACCT_ID", "ACCT_NBR_TYPE_CD");