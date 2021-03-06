  

  CREATE TABLE CI_RC_MAP 
   (	"RC_MAP_ID" CHAR(10) NOT NULL, 
	"RS_CD" CHAR(8), 
	"EFFDT" DATE, 
	"RC_SEQ" NUMBER(3,0), 
	"DISPLAY_SEQ" NUMBER(3,0), 
	"TIERED_FLAG" CHAR(4), 
	"MAX_TIER" NUMBER(2,0), 
	"BUS_OBJ_CD" CHAR(30), 
	"VERSION" NUMBER(5,0) DEFAULT 1 NOT NULL, 
	"BO_DATA_AREA" CLOB
   );


  ALTER TABLE CI_RC_MAP ADD PRIMARY KEY ("RC_MAP_ID");

