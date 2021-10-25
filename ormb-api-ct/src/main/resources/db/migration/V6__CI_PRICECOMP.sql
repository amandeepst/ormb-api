

  CREATE TABLE CI_PRICECOMP
   (	"PRICECOMP_ID" CHAR(10) NOT NULL, 
	"PRICE_ASGN_ID" CHAR(10), 
	"VALUE_AMT" NUMBER(36,18), 
	"RC_MAP_ID" CHAR(10), 
	"VERSION" NUMBER(5,0) DEFAULT 1 NOT NULL, 
	"PRICECOMP_DISPLAY_SW" CHAR(1) DEFAULT 'Y', 
	"PRICECOMP_SEQNO" NUMBER(5,0)
   );


  ALTER TABLE CI_PRICECOMP ADD PRIMARY KEY ("PRICECOMP_ID");
  
  
 