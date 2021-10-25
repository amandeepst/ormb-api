package com.worldpay.servicing.core.dao;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.worldpay.servicing.model.entity.SRV130;


@Monitored
@Repository
public interface SRV130Repository extends CrudRepository<SRV130, String>{
	  
	
	String PERIDNBR=
    "         SELECT                                                                              " +
    "         query.per_id_nbr,                                                                   " +
    "         query.cis_division,                                                                 " +
    "         TRIM(t3.char_val) AS lcp,                                                           " +
    "         t4.descr AS lcp_descr,                                                              " +
    "         query.currency_cd,                                                                  " +
    "         query.acct_nbr,                                                                     " +
    "         query.acctbal,                                                                      " +
    "         TRIM(query.sa_type_cd) AS sa_type_cd,                                               " +
    "         t5.descr AS sa_descr,                                                               " +
    "         query.sa_bal,                                                                       " +
    "         query.upload_dttm                                                                   " +
    "         FROM                                                                                " +
    "         vwm_merch_acct_ledger_snapshot query,                                               " +
    "         ci_cis_div_char t3,                                                                 " +
    "         ci_cis_division_l t4,                                                               " +
    "         ci_sa_type_l t5                                                                     " +
    "         WHERE                                                                               " +
    "            query.cis_division = t4.cis_division                                             " +
    "         AND                                                                                 " +
    "             query.cis_division = t3.cis_division                                            " +
    "         AND                                                                                 " +
    "             t5.sa_type_cd = query.sa_type_cd                                                " +
    "         AND                                                                                 " +
    "             t5.cis_division = t3.cis_division                                               " +
    "         AND                                                                                 " +
    "             t3.char_type_cd = 'BOLE'                                                        " +
    "         AND                                                                                 " +
    "             QUERY.per_id_nbr = ?1";
	
	       @Query(value=PERIDNBR , nativeQuery=true)
	       List<SRV130> findByPerIdNbr(String perIdNbr);
	        
	      String QUERY=" select 1 FROM CI_PER_ID  where PER_ID_NBR=?1 and rownum=1";   
	    
	      @Query(value=QUERY, nativeQuery=true)   
	      String checkPerIdNbr(String perIdNbr);
	       
}
