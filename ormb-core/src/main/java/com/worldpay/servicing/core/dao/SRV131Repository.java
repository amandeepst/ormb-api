package com.worldpay.servicing.core.dao;
import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV131Request;

@Monitored
@Repository
public interface SRV131Repository extends CrudRepository<SRV131, String> {

	String PERIDNBR = "SELECT dtl1.bill_id,                             																								     "+
			"     trim(dtl1.line_id) as line_id,                                                                                                                                     "+
			"     dtl1.line_amt,                                                                                                                                                     "+
			"     dtl1.unpaid_amt,                                                                                                                                                   "+
			"     dtl1.currency_cd,                                                                                                                                                  "+
			"     dt1.due_dt,                                                                                                                                                        "+
			"     dt1.banking_entry_status,                                                                                                                                          "+
			"     dt1.bank_entry_event_id,                                                                                                                                           "+
			"     dtl1.alt_bill_id,                                                                                                                                                  "+
			"     dtl1.bill_dt,                                                                                                                                                      "+
			"     dtl1.BILL_AMOUNT AS bill_amt,                                                                                                                                  	 "+
			"     dtl1.ACCT_TYPE as acct_nbr,                                                                                                                                        "+
			"     dtl1.ACCOUNT_DESCRIPTION AS acct_name,                                                                                                                             "+
			"     dtl1.PARTY_ID as per_id_nbr,                                                                                                                                       "+
			"     trim(dtl1.lcp) AS legal_counterparty,                                                                                                                        			 "+
			"     dtl1.LCP_DESCRIPTION AS legal_counterparty_name                                                                                                                    "+
			"	  FROM CM_BILL_PAYMENT_DTL_SNAPSHOT dtl1,                                                                                                                            "+
			"     cm_bill_due_dt dt1                                                                                                                                                 "+
			"	  WHERE dtl1.bill_id       = dt1.bill_id                                                                                                                             "+
			"     AND dtl1.line_id         = dt1.line_id                                                                                                                             "+
			"     AND trim(dtl1.CREDIT_NOTE_ID) is null                                                                                                                          "+
			"     AND NOT EXISTS(SELECT 1 FROM CI_BILL WHERE CR_NOTE_FR_BILL_ID=dtl1.bill_id)                                                                                        "+
			"     AND			                                                                                                                                                     "+
			"  		CASE			                                                                                                                                                 "+
			"  		WHEN banking_entry_status = 'OVERDUE'			                                                                                                                 "+
			"  		THEN to_date('01-JAN-01 00.00.00', 'DD-MON-YY HH24.MI.SS')			                                                                                             "+
			"  		ELSE dt1.pay_dt			                                                                                                                                         "+
			"		END =                                                                                                                                                  		     "+
			"     (SELECT MAX(                                                                                                                                                       "+
			"          CASE                                                                                                                                                          "+
			"               WHEN banking_entry_status = 'OVERDUE'                                                                                                                    "+
			"               THEN to_date('01-JAN-01 00.00.00', 'DD-MON-YY HH24.MI.SS')                                                                                               "+
			"               ELSE pay_dt                                                                                                                                              "+
			"          END)                                                                                                                                                          "+
			"     FROM cm_bill_due_dt dt2                                                                                                                                            "+
			"     WHERE dt1.bill_id    = dt2.bill_id                                                                                                                                 "+
			"          AND dt1.line_id = dt2.line_id 																																 "+
			"		AND dt2.banking_entry_status <> 'DEBT_MIGRATION'																												 "+
			"     )                                                                                                                                                                  "+
			"       AND dt1.banking_entry_status <> 'DEBT_MIGRATION'                                                                                                                 "+
			"     AND dtl1.party_id in (:#{#srv131Request.children})                                                                                                               	 "+
			"     AND dtl1.currency_cd   = (CASE WHEN TRIM(:#{#srv131Request.currency}) IS NULL THEN dtl1.currency_cd ELSE :#{#srv131Request.currency} END)                          "+
			"     AND trim(dtl1.lcp) = (CASE WHEN TRIM(:#{#srv131Request.legalCounterParty}) IS NULL THEN trim(dtl1.lcp) ELSE :#{#srv131Request.legalCounterParty} END)  						 "+
			"	  AND dtl1.BILL_DT  >= (CASE WHEN TRIM(:#{#srv131Request.billDateFrom}) IS NULL THEN dtl1.BILL_DT ELSE to_Date(:#{#srv131Request.billDateFrom} ,'YYYY-MM-DD') END)   "+
			" 	  AND dtl1.BILL_DT <= (CASE WHEN TRIM(:#{#srv131Request.billDateTo}) IS NULL THEN dtl1.BILL_DT ELSE to_Date(:#{#srv131Request.billDateTo} ,'YYYY-MM-DD') END)        "+
			" 	  AND dtl1.line_amt between :#{#srv131Request.billAmountFrom} and :#{#srv131Request.billAmountTo}                                                                    "+
			"   	  AND dtl1.alt_bill_id = (CASE WHEN TRIM(:#{#srv131Request.altBillId}) IS NULL THEN dtl1.alt_bill_id  ELSE :#{#srv131Request.altBillId} END)                     "+
			"   AND                                                                                                                                                                  "+
			"  CASE                                                                                                                                                                  "+
			"     WHEN TRIM(:#{#srv131Request.billPaymentStatus})  = 'UNPAID'                                                                                                        "+
			"     THEN 1                                                                                                                                                             "+
			"     WHEN TRIM(:#{#srv131Request.billPaymentStatus}) = 'PAID'                                                                                                           "+
			"     THEN 0                                                                                                                                                             "+
			"     ELSE 0                                                                                                                                                             "+
			"  END =                                                                                                                                                                 "+
			"  CASE                                                                                                                                                                  "+
			"    WHEN TRIM(:#{#srv131Request.billPaymentStatus}) IS NULL                                                                                                             "+
			"    THEN 0                                                                                                                                                              "+
			"   WHEN ((dtl1.pay_type   = 'CR'				                                                                                                                         "+
			"     AND dtl1.line_amt < 0)				                                                                                                                             "+
			"     OR (dtl1.pay_type = 'DR' AND                                                                                                                                       "+
			"     dtl1.line_amt > 0))                                                                                                                                                "+
			"    THEN 1                                                                                                                                                              "+
			"    ELSE 0                                                                                                                                                              "+
			"  END  " ;


	@Query(value = PERIDNBR, nativeQuery = true)
	List<SRV131> findByAll(@Param("srv131Request") SRV131Request srv131Request);
	
   String QUERY1=" SELECT DISTINCT(PER_ID_NBR) FROM CI_PER_ID  WHERE PER_ID_NBR IN(?1)";   
    
   @Query(value=QUERY1, nativeQuery=true)   
   List<String> checkPerIdNbr(List<String> perIdNbr);  
  
	
}
