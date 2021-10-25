package com.apiwp.utils;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DbOpeartionUtils {

	private static final Logger logger = LoggerFactory.getLogger(DbOpeartionUtils.class);
	private static Map<String, Integer> columnDataMap = new HashMap<>(16,0.75f);
	private static Map<String,String> insertionMap;
	private static Map<String,String> deletionMap;
	static {
		 insertionMap = new HashMap<>(); 
		 insertionMap.put("CI_PER_ID", "INSERT INTO CI_PER_ID  VALUES(?,?,?,?,?)");
		 insertionMap.put("CM_MERCH_LEDGER_ACCT", "INSERT INTO CM_MERCH_LEDGER_ACCT  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 insertionMap.put("CI_BILL_CHAR","INSERT INTO CI_BILL_CHAR  VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
		 insertionMap.put("CM_BILL_PAYMENT_DTL","INSERT INTO CM_BILL_PAYMENT_DTL  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 insertionMap.put("CM_BILL_DUE_DT","INSERT INTO CM_BILL_DUE_DT  VALUES(?,?,?,?,?,?,?,?,?)");
		 insertionMap.put("CI_BILL","INSERT INTO CI_BILL  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 insertionMap.put("CI_ACCT_PER","INSERT INTO CI_ACCT_PER  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 insertionMap.put("CI_ACCT","INSERT INTO CI_ACCT  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 insertionMap.put("CI_ACCT_NBR","INSERT INTO CI_ACCT_NBR  VALUES(?,?,?,?,?)");
		 insertionMap.put("CI_SA","INSERT INTO CI_SA  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 insertionMap.put("CI_PARTY","INSERT INTO CI_PARTY  VALUES(?,?,?,?)");
		 insertionMap.put("CI_PER_CHAR","INSERT INTO CI_PER_CHAR  VALUES(?,?,?,?,?,?,?,?,?,?,?)");
	     insertionMap.put("CI_PRICECOMP", "INSERT INTO CI_PRICECOMP VALUES(?,?,?,?,?,?,?)");   	 
	     insertionMap.put("CI_PRICEASGN", "INSERT INTO CI_PRICEASGN VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");   	
	     insertionMap.put("CI_PRICEASGN_PARM", "INSERT INTO CI_PRICEASGN_PARM VALUES(?,?,?,?,?)");
	     
		 deletionMap = new HashMap<>(); 		
		 deletionMap.put("CI_PER_ID", "DELETE FROM CI_PER_ID WHERE ID_TYPE_CD =? and PER_ID =?");
		 deletionMap.put("CM_MERCH_LEDGER_ACCT", "DELETE FROM CM_MERCH_LEDGER_ACCT WHERE CIS_DIVISION =? and CURRENCY_CD =? and PER_ID_NBR =? and SA_TYPE_CD =? and UPLOAD_DTTM =?");
		 deletionMap.put("CI_BILL_CHAR","DELETE FROM CI_BILL_CHAR WHERE BILL_ID =? and CHAR_TYPE_CD =? and SEQ_NUM =?");
		 deletionMap.put("CM_BILL_PAYMENT_DTL","DELETE FROM CM_BILL_PAYMENT_DTL WHERE PAY_DTL_ID =?");
		 deletionMap.put("CM_BILL_DUE_DT","DELETE FROM CM_BILL_DUE_DT WHERE BANK_ENTRY_EVENT_ID =? and BILL_ID =? and LINE_ID =? and UPLOAD_DTTM =?");
		 deletionMap.put("CI_BILL","DELETE FROM CI_BILL WHERE BILL_ID =?");
		 deletionMap.put("CI_ACCT_PER","DELETE FROM CI_ACCT_PER WHERE ACCT_ID =? and PER_ID =?");
		 deletionMap.put("CI_ACCT","DELETE FROM CI_ACCT WHERE ACCT_ID =?");
		 deletionMap.put("CI_ACCT_NBR","DELETE FROM CI_ACCT_NBR WHERE ACCT_ID =? and ACCT_NBR_TYPE_CD =?");
		 deletionMap.put("CI_SA","DELETE FROM CI_SA WHERE SA_ID =?");
		 deletionMap.put("CI_PARTY","DELETE FROM CI_PARTY WHERE PARTY_UID =?");
		 deletionMap.put("CI_PER_CHAR","DELETE FROM CI_PER_CHAR WHERE CHAR_TYPE_CD =? and EFFDT =? and PER_ID =?");	
		 deletionMap.put("CI_PRICECOMP", "DELETE FROM CI_PRICECOMP WHERE PRICECOMP_ID =?");
		 deletionMap.put("CI_PRICEASGN", "DELETE FROM CI_PRICEASGN WHERE PRICE_ASGN_ID =?");
		 deletionMap.put("CI_PRICEASGN_PARM", "DELETE FROM CI_PRICEASGN_PARM WHERE PRICE_ASGN_ID =? and PRICE_PARM_CD =?");
	}
	
	protected DbOpeartionUtils() {
		super();
	}
	
	private static void fetchMetaData(java.sql.Connection con, String tableName) throws SQLException {
		DatabaseMetaData dbMetaData = con.getMetaData();
		ResultSet rsColumns = dbMetaData.getColumns(null, null, tableName, null);
		while (rsColumns.next()) {
			columnDataMap.put(rsColumns.getString("COLUMN_NAME"), rsColumns.getInt("DATA_TYPE"));
		}
	}

	public static void insertionUsingDataTable(List<Map<String, String>> list, String tableName)
			throws ClassNotFoundException, SQLException, ParseException {
		if (!list.isEmpty()) {
			java.sql.Connection con = Connection.getConnection();

			String query = insertionMap.get(tableName);
			logger.info(String.format("INSERTION IN ---------> %s", tableName));
				try(PreparedStatement ps = con.prepareStatement(query)){
				con.setAutoCommit(false);
				for (int i = 0; i < list.size(); i++) {
					int p = 0;
					setInsertionPreparedStatementParameters(list, ps, p, i);
					ps.addBatch();
					ps.clearParameters();
				}
				int result[]=ps.executeBatch();
				logger.info(Arrays.toString(result));
				con.commit();
				con.setAutoCommit(true);

			} catch (Exception e) {
				String error = "ERROR IN " + tableName + " INSERTION --------->" + e.getMessage();
				logger.error(error);
				con.rollback();
			}
			
		}
	}

	private static void setInsertionPreparedStatementParameters(List<Map<String, String>> list, PreparedStatement ps,
			int p, int i) throws SQLException, ParseException {
		
		for (Map.Entry<String, String> rowMap : list.get(i).entrySet()) {
			if (columnDataMap.get(rowMap.getKey()) == 93  ) {//for oracle it is 93
				ps.setTimestamp(++p, getSQLTimestamp(rowMap.getValue()));
			} 
			else if(columnDataMap.get(rowMap.getKey()) == 91) {
				ps.setDate(++p, getSQLDate(rowMap.getValue()));
			}
			 else if (columnDataMap.get(rowMap.getKey()) == 3) {
				if (rowMap.getValue().trim().equals("null"))
					ps.setNull(++p, Types.DOUBLE);
				else
					ps.setDouble(++p, Double.valueOf(rowMap.getValue()));
			} else {
				if (rowMap.getValue().trim().length() == 0)
					ps.setString(++p, " ");
				else
					ps.setString(++p, rowMap.getValue());
			}
		}
	}

	public static void deletionUsingDataTable(List<Map<String, String>> list, String tableName)
			throws ClassNotFoundException, SQLException, ParseException {
		if (!list.isEmpty()) {
			java.sql.Connection con =  Connection.getConnection();
			DatabaseMetaData meta = con.getMetaData();
			ResultSet rs = meta.getPrimaryKeys(null, null, tableName);
			fetchMetaData(con, tableName);
			java.util.List<String> columnList = new java.util.ArrayList<>();
			logger.info(String.format("DELETION IN ---------> %s", tableName));
			while (rs.next()) {
				String columnName = rs.getString("COLUMN_NAME");
				columnList.add(columnName);
			}
			
			String query = deletionMap.get(tableName);
			
			try (PreparedStatement ps =  con.prepareStatement(query)) {
				con.setAutoCommit(false);
				for (Map<String, String> rowMap : list) {
					int p = 0;
					setDeletionPreparedStatementParameters(rowMap, columnList, ps, p);
					ps.addBatch();
					ps.clearParameters();
				}
				int result[]=ps.executeBatch();
				logger.info(Arrays.toString(result));
				con.commit();
				con.setAutoCommit(true);

			} catch (Exception e) {
				String error = "ERROR IN " + tableName + " DELETION -------> " + e.getMessage();
				logger.error(error);
				con.rollback();
			} 
			insertionUsingDataTable(list, tableName);
		} else {
			String msg = "EMPTY DATATABLE ------->" + tableName;
			logger.info(msg);
		}
	}

	private static void setDeletionPreparedStatementParameters(Map<String, String> rowMap, List<String> columnList,
			PreparedStatement ps, int p) throws SQLException, ParseException {
		
		for (String columnName : columnList) {
			if (rowMap.containsKey(columnName)) {
				if (columnDataMap.get(columnName.toUpperCase()) == 93) {
					ps.setTimestamp(++p, getSQLTimestamp(rowMap.get(columnName)));
				}
				else if(columnDataMap.get(columnName.toUpperCase()) == 91) {
					ps.setDate(++p, getSQLDate(rowMap.get(columnName)));
				}
				else if (columnDataMap.get(columnName.toUpperCase()) == 3) {
					if (rowMap.get(columnName).trim().equals("null"))
						ps.setNull(++p, Types.DOUBLE);
					else
						ps.setDouble(++p, Double.valueOf(rowMap.get(columnName)));
				}else {
					ps.setObject(++p, rowMap.get(columnName).trim());
				}
			}
		}

	}

	public static java.sql.Timestamp getSQLTimestamp(String date) throws ParseException {
		if (date.trim().equals("null"))
			return null;
		else if (date.trim().equals("sysdate-2")) {
			return java.sql.Timestamp.valueOf(LocalDateTime.now().minusDays(3));
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH.mm.ss");
		java.util.Date utilDate = formatter.parse(date);
		return new Timestamp(utilDate.getTime());
	}
	public static java.sql.Date getSQLDate(String date) throws ParseException {
		if (date.trim().equals("null"))
			return null;
		else if (date.trim().equals("sysdate-2")) {
			return java.sql.Date.valueOf(LocalDateTime.now().minusDays(3).toLocalDate());
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH.mm.ss");
		java.util.Date utilDate = formatter.parse(date);
		
		return new java.sql.Date(utilDate.getTime());
	}
}
