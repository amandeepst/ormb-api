package com.worldpay.servicing.core.dao;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.worldpay.servicing.model.entity.SRV132;

@Monitored
@Repository
public interface SRV132Repository extends CrudRepository<SRV132, String> {

	String PERIDNBR = "SELECT PER.PER_ID_NBR, trim(SA.SA_TYPE_CD) AS SA_TYPE_CD, SAL.DESCR, DIV.CIS_DIVISION, trim(DCHAR.CHAR_VAL) AS LCP_ID,  DIV.DESCR AS DIV_DESCR,  SA.CURRENCY_CD "
			+ " FROM CI_PER_ID PER, " + " CI_ACCT_PER APER, " + " CI_SA SA, "
			+ " CI_SA_TYPE_L SAL, " + " CI_CIS_DIVISION_L DIV, " + " CI_CIS_DIV_CHAR DCHAR "
			+ " WHERE APER.PER_ID      = PER.PER_ID " + " AND APER.ACCT_ID       = SA.ACCT_ID "
			+ " AND SA.SA_TYPE_CD      = SAL.SA_TYPE_CD " + " AND SAL.CIS_DIVISION   = DIV.CIS_DIVISION  "
			+ " AND DIV.CIS_DIVISION   = SA.CIS_DIVISION " + " AND DIV.CIS_DIVISION   = DCHAR.CIS_DIVISION "
			+ " AND PER.ID_TYPE_CD     = 'EXPRTYID' " + " AND DCHAR.CHAR_TYPE_CD = 'BOLE    ' "
			+ " AND trim(SA.SA_STATUS_FLG) in ('20','30')"
			+ " AND PER.PER_ID_NBR = ?1 ";

	@Query(value = PERIDNBR, nativeQuery = true)
	List<SRV132> findByPerIdNbr(String perIdNbr);

	String QUERY = " select 1  FROM CI_PER_ID  where PER_ID_NBR=?1 and rownum=1";

	@Query(value = QUERY, nativeQuery = true)
	String checkPerIdNbr(String perIdNbr);

}
