package com.apiwp.utils;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.util.ClassUtils;

import com.apiwp.utils.mapper.SRV132Mapper;
import com.worldpay.servicing.model.entity.SRV132;


public class JdbcOperations {

  private final JdbcTemplate template;
  
  public JdbcOperations(JdbcTemplate template) {
    this.template = template;
  }

  public List<SRV132> selectGetAllMerchantSettlementGroups(String perIdNbr) {
    String PERIDNBR = "SELECT PER.PER_ID_NBR, trim(SA.SA_TYPE_CD) AS SA_TYPE_CD, SAL.DESCR, DIV.CIS_DIVISION, trim(DCHAR.CHAR_VAL) AS LCP_ID,  DIV.DESCR AS DIV_DESCR,  SA.CURRENCY_CD "
        + " FROM CI_PER_ID PER, " + " CI_ACCT_PER APER, " + " CI_SA SA, "
        + " CI_SA_TYPE_L SAL, " + " CI_CIS_DIVISION_L DIV, " + " CI_CIS_DIV_CHAR DCHAR "
        + " WHERE APER.PER_ID      = PER.PER_ID " + " AND APER.ACCT_ID       = SA.ACCT_ID "
        + " AND SA.SA_TYPE_CD      = SAL.SA_TYPE_CD " + " AND SAL.CIS_DIVISION   = DIV.CIS_DIVISION  "
        + " AND DIV.CIS_DIVISION   = SA.CIS_DIVISION " + " AND DIV.CIS_DIVISION   = DCHAR.CIS_DIVISION "
        + " AND PER.ID_TYPE_CD     = 'EXPRTYID' " + " AND DCHAR.CHAR_TYPE_CD = 'BOLE    ' "
        + " AND trim(SA.SA_STATUS_FLG) in ('20','30')"
        + " AND PER.PER_ID_NBR = '%s'";

    String sql = String.format(PERIDNBR, perIdNbr);

    List<SRV132> result = this.template.query(sql, new SRV132Mapper());
    return result;
  }

  public int countAll(String tableName) {
    String sql = String.format("SELECT count(*) FROM %s", tableName);
    return (Integer) this.queryForObject(sql, Integer.class);
  }

  public List<Map<String, Object>> selectAllWithWhereClause(String tableName, Map<String, String> whereClauses) {
    Map.Entry<String, String> firstWhereClause = whereClauses.entrySet().stream().findFirst().orElse(new AbstractMap.SimpleEntry<String,String>("",""));
    String sql = String
        .format(
            "SELECT * FROM %s WHERE %s='%s'",
            tableName, firstWhereClause.getKey(), firstWhereClause.getValue());
    List<Map<String, Object>> result = null;

    if (whereClauses.size() == 1) {
      result = this.queryForList(sql);
    }

    if (whereClauses.size() > 1) {
      result = this.queryForList(createSqlQueryWithWhereClause(sql, whereClauses, firstWhereClause));
    }

    return result;
  }

  public <T> List<T> query(String sql, Class<T> returnType, Object... params) {
    RowMapper<T> rowMapper =
        !String.class.equals(returnType) && !ClassUtils.isPrimitiveOrWrapper(returnType)
            ? new BeanPropertyRowMapper(returnType) : new SingleColumnRowMapper(returnType);
    return this.template.query(sql, params, (RowMapper) rowMapper);
  }

  public List<Map<String, Object>> queryForList(String sql, Object... params) {
    return this.template.queryForList(sql, params);
  }

  public <T> T queryForObject(String sql, Class<T> klass, Object... params) {
    return this.template.queryForObject(sql, klass, params);
  }

  private String createSqlQueryWithWhereClause(String baseQuery, Map<String, String> whereClauses,
      Entry<String, String> firstClause) {
    Map<String, String> clauses = new HashMap();
    for (Entry<String, String> whereClause : whereClauses.entrySet()) {
      if (whereClause.getKey().equals(firstClause.getKey())) {
        continue;
      }
      clauses.put(whereClause.getKey(), whereClause.getValue());
    }
    for (Entry<String, String> clause : clauses.entrySet()) {
      baseQuery = baseQuery + " and " + clause.getKey() + "='" + clause.getValue() + "'";
    }
    return baseQuery;
  }

}
