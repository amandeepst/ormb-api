package com.worldpay.servicing.core.dao;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldpay.servicing.model.entity.SRV133;
import com.worldpay.servicing.model.entity.SRV133Request;

@Monitored
@Repository
public interface SRV133Repository extends CrudRepository<SRV133, String>
{
	String PERIDNBR= "WITH per_item_rate_vw AS"
			+ "  (SELECT pc.price_asgn_id,"
			+ "    value_amt AS per_item_rate,"
			+ "    char_val"
			+ "  FROM ci_pricecomp pc,"
			+ "    ci_rc_map rcmap,"
			+ "    ci_rc_char rcchar"
			+ "  WHERE pc.rc_map_id = rcmap.rc_map_id"
			+ "  AND rcmap.rs_cd    = rcchar.rs_cd"
			+ "  AND rcmap.rc_seq   = rcchar.rc_seq"
			+ "  AND char_val      IN ('MSC_PI', 'M_PI', 'MIN_P_CHRG')"
			+ "  ),"
			+ "  percent_rate AS"
			+ "  (SELECT pc.price_asgn_id,"
			+ "    value_amt AS percent_rate,"
			+ "    char_val"
			+ "  FROM ci_pricecomp pc,"
			+ "    ci_rc_map rcmap,"
			+ "    ci_rc_char rcchar"
			+ "  WHERE pc.rc_map_id = rcmap.rc_map_id"
			+ "  AND rcmap.rs_cd    = rcchar.rs_cd"
			+ "  AND rcmap.rc_seq   = rcchar.rc_seq"
			+ "  AND char_val      IN ('MSC_PC', 'REB_PC', 'CST_PC')"
			+ "  ),"
			+ "  classifier AS"
			+ "  (SELECT priceitem_cd,"
			+ "    MAX(class_char)    AS class_char,"
			+ "    MAX(class_val)     AS class_val,"
			+ "    MAX(sclass_char)   AS sclass_char,"
			+ "    MAX(sclass_val)    AS sclass_val,"
			+ "    MAX(ttype_char)    AS ttype_char,"
			+ "    MAX(ttype_val)     AS ttype_val,"
			+ "    MAX(sinvoice_char) AS sinvoice_char,"
			+ "    MAX(sinvoice_val)  AS sinvoice_val"
			+ "  FROM"
			+ "    (SELECT priceitem_cd,"
			+ "      CASE"
			+ "        WHEN char_type_cd = 'CLASS'"
			+ "        THEN char_TYPE_CD"
			+ "        ELSE ' '"
			+ "      END class_char,"
			+ "      CASE"
			+ "        WHEN char_type_cd = 'CLASS'"
			+ "        THEN char_val"
			+ "        ELSE ' '"
			+ "      END class_val,"
			+ "      CASE"
			+ "        WHEN char_type_cd = 'SCLASS'"
			+ "        THEN char_TYPE_CD"
			+ "        ELSE ' '"
			+ "      END sclass_char,"
			+ "      CASE"
			+ "        WHEN char_type_cd = 'SCLASS'"
			+ "        THEN char_val"
			+ "        ELSE ' '"
			+ "      END sclass_val,"
			+ "      CASE"
			+ "        WHEN char_type_cd = 'TTYPE'"
			+ "        THEN char_TYPE_CD"
			+ "        ELSE ' '"
			+ "      END ttype_char,"
			+ "      CASE"
			+ "        WHEN char_type_cd = 'TTYPE'"
			+ "        THEN char_val"
			+ "        ELSE ' '"
			+ "      END ttype_val,"
			+ "      CASE"
			+ "        WHEN char_type_cd = 'SINVOICE'"
			+ "        THEN char_TYPE_CD"
			+ "        ELSE ' '"
			+ "      END sinvoice_char,"
			+ "      CASE"
			+ "        WHEN char_type_cd = 'SINVOICE'"
			+ "        THEN char_val"
			+ "        ELSE ' '"
			+ "      END sinvoice_val"
			+ "    FROM ci_priceitem_char"
			+ "    )"
			+ "  GROUP BY priceitem_cd"
			+ "  HAVING MAX(sinvoice_val) <> 'N/A             '"
			+ "  ) ,"
			+ "  CTE(pid,label) AS"
			+ "  (SELECT PER_ID2 AS pid,"
			+ "    1             AS label"
			+ "  FROM CI_PER_PER"
			+ "  WHERE PER_ID2 IN"
			+ "    (SELECT MIN(PER_ID) FROM CI_PER_ID WHERE PER_ID_NBR=:#{#srv133Request.perIdNbr}"
			+ "    )"
			+ "  UNION ALL"
			+ "  SELECT PER_ID1,"
			+ "    p2.label+1"
			+ "  FROM CI_PER_PER p1"
			+ "  INNER JOIN CTE p2"
			+ "  ON p1.PER_ID2=p2.pid"
			+ "  ),"
			+ "  rank AS"
			+ "  ( SELECT pid AS per_id, label AS rank FROM CTE"
			+ "  UNION"
			+ "  SELECT MIN(per_id) ,"
			+ "    1 AS rank"
			+ "  FROM ci_per_id"
			+ "  WHERE per_id_nbr = :#{#srv133Request.perIdNbr}"
			+ "  GROUP BY 1"
			+ "  )"
			+ " SELECT NVL(rank,1000)                     AS rank,"
			+ "  NVL(price_asgn_id,'9211453397')                           AS price_id,"
			+ "  NVL(per_id_nbr, :#{#srv133Request.perIdNbr})               AS party_id,"
			+ "  trim(NVL(child_charge_type,t22.priceitem_Cd)) AS charge_type,"
			+ "  CASE"
			+ "    WHEN trim(t3.class_val) = 'ACQUIRED'"
			+ "    THEN t5.descr"
			+ "      ||' - '"
			+ "      ||t4.descr"
			+ "    ELSE t5.descr"
			+ "  END                                              AS charge_type_descr,"
			+ "  NVL(per_item_rate,0)                             AS per_item_rate,"
			+ "  NVL(percent_rate,0)                              AS percent_rate,"
			+ "  NVL(start_dt,to_date('2019-01-19','YYYY-MM-DD')) AS start_dt,"
			+ "  end_dt,"
			+ "  NVL(currency_cd, party_currency) AS currency_cd,"
			+ "  CASE"
			+ "    WHEN NVL(per_id_nbr, 'N') = :#{#srv133Request.perIdNbr}"
			+ "    THEN 'PARTY'"
			+ "    WHEN per_id_nbr IS NULL"
			+ "    THEN 'GLOBAL'"
			+ "    ELSE'INHERITED'"
			+ "  END AS price_config"
			+ " FROM"
			+ "  (SELECT rank,"
			+ "    cp.price_asgn_id,"
			+ "    per.per_id_nbr,"
			+ "    child_charge_type,"
			+ "    per_item_rate,"
			+ "    percent_rate,"
			+ "    pa.start_dt,"
			+ "    pa.end_dt,"
			+ "    pa.price_currency_cd AS currency_cd,"
			+ "    MIN(rank) OVER (PARTITION BY child_charge_type) min_rank"
			+ "  FROM"
			+ "    (SELECT *"
			+ "    FROM"
			+ "      (SELECT price_asgn_id,"
			+ "        MAX(ctype)  AS cctype,"
			+ "        MAX(ttype)  AS tttype,"
			+ "        MAX(jtype)  AS jjtype,"
			+ "        MAX(ptype)  AS pptype,"
			+ "        MAX(autype) AS aautype,"
			+ "        MAX(atype)  AS aatype,"
			+ "        MAX(artype) AS aartype,"
			+ "        MAX(stype)  AS sstype"
			+ "      FROM"
			+ "        (SELECT pa.price_asgn_id,"
			+ "          CASE"
			+ "            WHEN price_parm_cd = 'CTYPE'"
			+ "            THEN price_parm_val"
			+ "            ELSE ' '"
			+ "          END ctype,"
			+ "          CASE"
			+ "            WHEN price_parm_cd = 'TTYPE'"
			+ "            THEN price_parm_val"
			+ "            ELSE ' '"
			+ "          END ttype,"
			+ "          CASE"
			+ "            WHEN price_parm_cd = 'JTYPE'"
			+ "            THEN price_parm_val"
			+ "            ELSE ' '"
			+ "          END jtype,"
			+ "          CASE"
			+ "            WHEN price_parm_cd = 'PTYPE'"
			+ "            THEN price_parm_val"
			+ "            ELSE ' '"
			+ "          END ptype,"
			+ "          CASE"
			+ "            WHEN price_parm_cd = 'AUTYPE'"
			+ "            THEN price_parm_val"
			+ "            ELSE ' '"
			+ "          END autype,"
			+ "          CASE"
			+ "            WHEN price_parm_cd = 'ATYPE'"
			+ "            THEN price_parm_val"
			+ "            ELSE ' '"
			+ "          END atype,"
			+ "          CASE"
			+ "            WHEN price_parm_cd = 'ARTYPE'"
			+ "            THEN price_parm_val"
			+ "            ELSE ' '"
			+ "          END artype,"
			+ "          CASE"
			+ "            WHEN price_parm_cd = 'STYPE'"
			+ "            THEN price_parm_val"
			+ "            ELSE ' '"
			+ "          END stype"
			+ "        FROM ci_priceasgn_parm parm,"
			+ "          ci_priceasgn pa,"
			+ "          ci_party party"
			+ "        WHERE parm.price_asgn_id = pa.price_asgn_id"
			+ "        AND party.party_uid      = pa.owner_id"
			+ "        AND party.party_id      IN"
			+ "          ( WITH CTE(pid) AS"
			+ "          (SELECT PER_ID2 AS pid"
			+ "          FROM CI_PER_PER"
			+ "          WHERE PER_ID2 IN"
			+ "            (SELECT PER_ID FROM CI_PER_ID WHERE PER_ID_NBR=:#{#srv133Request.perIdNbr}"
			+ "            )"
			+ "          UNION ALL"
			+ "          SELECT PER_ID1 FROM CI_PER_PER p1 INNER JOIN CTE p2 ON p1.PER_ID2=p2.pid"
			+ "          )"
			+ "        SELECT pid FROM CTE"
			+ "        UNION"
			+ "        SELECT per_id FROM ci_per_id WHERE per_id_nbr = :#{#srv133Request.perIdNbr}"
			+ "          )"
			+ "        )"
			+ "      GROUP BY price_asgn_id"
			+ "      ) t1,"
			+ "      (SELECT DISTINCT ctype ,"
			+ "        ttype,"
			+ "        jtype,"
			+ "        ptype,"
			+ "        auth_transaction_type,"
			+ "        auth_event,"
			+ "        internal_auth_response,"
			+ "        payment_scheme,"
			+ "        child_charge_type,"
			+ "        parent_charge_type"
			+ "      FROM cm_charge_type_map"
			+ "      ) t2"
			+ "    WHERE t1.cctype = t2.ctype"
			+ "    AND t1.tttype   = t2.ttype"
			+ "    AND t1.jjtype   = t2.jtype"
			+ "    AND t1.pptype   = t2.ptype"
			+ "    AND t1.aautype  = t2.auth_transaction_type"
			+ "    AND t1.aatype   = t2.auth_event"
			+ "    AND t1.aartype  = t2.internal_auth_response"
			+ "    AND t1.sstype   = t2.payment_scheme"
			+ "    ) cp"
			+ "  LEFT OUTER JOIN per_item_rate_vw pitem"
			+ "  ON cp.price_asgn_id = pitem.price_asgn_id"
			+ "  LEFT OUTER JOIN percent_rate perc"
			+ "  ON cp.price_asgn_id = perc.Price_asgn_id,"
			+ "    ci_priceasgn pa,"
			+ "    ci_party party,"
			+ "    ci_per_id per,"
			+ "    rank"
			+ "  WHERE pa.price_asgn_id = cp.price_asgn_id"
			+ "  AND pa.owner_id        = party.party_uid"
			+ "  AND party.party_id     = per.per_id"
			+ "  AND rank.per_id        = per.per_id"
			+ "  AND per.id_type_cd     = 'EXPRTYID'"
			+ "  ) t11"
			+ " RIGHT OUTER JOIN ci_priceitem t22"
			+ " ON trim(t22.priceitem_cd) = t11.child_charge_type,"
			+ "  classifier t3,"
			+ "  ci_char_val_l t4,"
			+ "  ci_char_val_l t5,"
			+ "  (SELECT DISTINCT adhoc_char_val AS party_currency"
			+ "  FROM ci_per_char"
			+ "  WHERE char_type_cd = 'PRCCY   '"
			+ "  AND per_id        IN"
			+ "    ( WITH CTE(pid) AS"
			+ "    (SELECT PER_ID2 AS pid"
			+ "    FROM CI_PER_PER"
			+ "    WHERE PER_ID2 IN"
			+ "      (SELECT MIN(PER_ID) FROM CI_PER_ID WHERE PER_ID_NBR=:#{#srv133Request.perIdNbr}"
			+ "      )"
			+ "    UNION ALL"
			+ "    SELECT PER_ID1 FROM CI_PER_PER p1 INNER JOIN CTE p2 ON p1.PER_ID2=p2.pid"
			+ "    )"
			+ "  SELECT pid FROM CTE"
			+ "  UNION"
			+ "  SELECT MIN(per_id) FROM ci_per_id WHERE per_id_nbr = :#{#srv133Request.perIdNbr}"
			+ "    )"
			+ "  ) t6"
			+ " WHERE trim(t22.priceitem_cd) = trim(t3.priceitem_cd)"
			+ " AND trim(t3.ttype_val)       = trim(t4.char_val)"
			+ " AND trim(t3.ttype_char)      = trim (t4.char_type_cd)"
			+ " AND trim(t3.sinvoice_val)    = trim(t5.char_val)"
			+ " AND trim(t3.sinvoice_char)   = trim(t5.char_type_cd)"
			+ " AND NVL(rank,1000)           = NVL(min_rank,1000)"
			+ " AND NOT EXISTS"
			+ "  (SELECT 1"
			+ "  FROM cm_charge_type_map t7"
			+ "  WHERE trim(t22.priceitem_cd) = t7.parent_charge_type"
			+ "  )"
			+ " AND trim(t3.class_val)= (CASE WHEN TRIM(:#{#srv133Request.classVal}) IS NULL THEN trim(t3.class_val) ELSE :#{#srv133Request.classVal} END)"
			+ " AND trim(t3.sclass_val)=  (CASE WHEN TRIM(:#{#srv133Request.sClassVal}) IS NULL THEN trim(t3.sclass_val) ELSE :#{#srv133Request.sClassVal} END)"
			+ " AND trim(t22.priceitem_cd)=  (CASE WHEN TRIM(:#{#srv133Request.priceItemCd}) IS NULL THEN trim(t22.priceitem_cd) ELSE :#{#srv133Request.priceItemCd} END)"
			;

	@Query(value=PERIDNBR,nativeQuery=true)
	List<SRV133> findByAll(@Param("srv133Request") SRV133Request srv133Request);
	
	String QUERY=" select 1  FROM CI_PER_ID  where PER_ID_NBR=?1 and rownum=1"; 
    
    @Query(value=QUERY, nativeQuery=true)   
    String checkPerIdNbr(String perIdNbr);
	
}
