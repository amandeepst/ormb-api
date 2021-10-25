package com.apiwp.utils.mapper;

import com.worldpay.servicing.model.entity.SRV132;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SRV132Mapper implements RowMapper<SRV132> {

  @Override
  public SRV132 mapRow(ResultSet rs, int rowNum) throws SQLException {
    SRV132 srv132 = new SRV132();
    srv132.setCurrency(rs.getString("CURRENCY_CD"));
    srv132.setLegalCounterparty(rs.getString("LCP_ID"));
    srv132.setLegalCounterpartyDescription(rs.getString("DIV_DESCR"));
    srv132.setLegalCounterpartyShortCode(rs.getString("CIS_DIVISION"));
    srv132.setSubAccountCode(rs.getString("SA_TYPE_CD"));
    srv132.setSubAccountDescription(rs.getString("DESCR"));
    return srv132;
  }
}
