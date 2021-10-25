package com.apiwp.utils;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.jdbc.OraclePreparedStatement;

public class InsertionPOC1 {

	private static final Logger logger = LoggerFactory.getLogger(InsertionPOC1.class);
	private static Map<String, Integer> columnDataMap = new HashMap<>();
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
	}
	
	protected InsertionPOC1() {
		super();
	}
	
	private static void fetchMetaData(java.sql.Connection con, String tableName, String dbName) throws SQLException {
		DatabaseMetaData dbMetaData = con.getMetaData();
		ResultSet rsColumns = dbMetaData.getColumns(dbName, null, tableName, "%");

		while (rsColumns.next()) {
			columnDataMap.put(rsColumns.getString("COLUMN_NAME"), rsColumns.getInt("DATA_TYPE"));
		}
	}

	public static void insertionUsingDataTable(List<Map<String, String>> list, String tableName)
			throws ClassNotFoundException, SQLException, ParseException {

		if (!list.isEmpty()) {

			java.sql.Connection con = Connection.getConnection();
			
			String query = insertionMap.get(tableName);
			
			try (PreparedStatement ps = con.prepareStatement(query)) {
				con.setAutoCommit(false);
				for (int i = 0; i < list.size(); i++) {
					int p = 0;
					setInsertionPreparedStatementParameters(list, ps, p, i);
					ps.addBatch();
					ps.clearParameters();
				}
				ps.executeBatch();
				con.commit();
				con.setAutoCommit(true);

			} catch (Exception e) {
				String error = "ERROR IN " + tableName + " INSERTION --------->" + e.getMessage();
				logger.error(error);
				con.rollback();
			} finally {
				con.close();
			}

		}

	}

	private static void setInsertionPreparedStatementParameters(List<Map<String, String>> list, PreparedStatement ps,
			int p, int i) throws SQLException, ParseException {
		for (Map.Entry<String, String> rowMap : list.get(i).entrySet()) {
			if (columnDataMap.get(rowMap.getKey()) == 93) {
				ps.setTimestamp(++p, getSQLDate(rowMap.getValue()));

			} else if (columnDataMap.get(rowMap.getKey()) == 1 || columnDataMap.get(rowMap.getKey()) == 12) {
				if (rowMap.getValue().trim().length() == 0)
					ps.setString(++p, " ");
				else
					ps.setString(++p, rowMap.getValue());
			} else if (columnDataMap.get(rowMap.getKey()) == 3) {
				if (rowMap.getValue().trim().equals("null"))
					ps.setNull(++p, Types.DOUBLE);
				else
					ps.setDouble(++p, Double.valueOf(rowMap.getValue()));
			} else {
				ps.setString(++p, rowMap.getValue());
			}
		}

	}

	public static void deletionUsingDataTable(List<Map<String, String>> list, String tableName)
			throws ClassNotFoundException, SQLException, ParseException {

		if (!list.isEmpty()) {
			java.sql.Connection con =  Connection.getConnection();
			DatabaseMetaData meta = con.getMetaData();
			ResultSet rs = meta.getPrimaryKeys("cdb2_rmb_app.worldpaytd.local", null, tableName);
			fetchMetaData(con, tableName, "cdb2_rmb_app.worldpaytd.local");
			
			java.util.List<String> columnList = new java.util.ArrayList<>();

			while (rs.next()) {
				String columnName = rs.getString("COLUMN_NAME");
				columnList.add(columnName);
			}
			String query = deletionMap.get(tableName);
			
			try (OraclePreparedStatement ps = (OraclePreparedStatement) con.prepareStatement(query)) {

				con.setAutoCommit(false);
				for (Map<String, String> rowMap : list) {
					int p = 0;
					setDeletionPreparedStatementParameters(rowMap, columnList, ps, p);
					ps.addBatch();
					ps.clearParameters();

				}
				ps.executeBatch();
				con.commit();
				con.setAutoCommit(true);

			} catch (Exception e) {
				String error = "ERROR IN " + tableName + " DELETION -------> " + e.getMessage();
				logger.error(error);
				con.rollback();
			} finally {
				con.close();
			}
			insertionUsingDataTable(list, tableName);
		} else {
			String msg = "EMPTY DATATABLE ------->" + tableName;
			logger.info(msg);
		}
	}

	private static void setDeletionPreparedStatementParameters(Map<String, String> rowMap, List<String> columnList,
			OraclePreparedStatement ps, int p) throws SQLException, ParseException {
		for (String columnName : columnList) {
			if (rowMap.containsKey(columnName)) {
				if (columnDataMap.get(columnName.toUpperCase()) == 1
						|| columnDataMap.get(columnName.toUpperCase()) == 12) {
					ps.setFixedCHAR(++p, rowMap.get(columnName).trim());
				} else if (columnDataMap.get(columnName.toUpperCase()) == 93) {
					ps.setTimestamp(++p, getSQLDate(rowMap.get(columnName)));
				} else {
					ps.setObject(++p, rowMap.get(columnName).trim());
				}
			}
		}

	}

	public static java.sql.Timestamp getSQLDate(String date) throws ParseException {
		if (date.trim().equals("null"))
			return null;
		else if (date.trim().equals("sysdate-2")) {
			LocalDate localDate = LocalDate.now();
			return new java.sql.Timestamp(java.sql.Date.valueOf(localDate).getTime());
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH.mm.ss");
		java.util.Date utilDate = formatter.parse(date);
		return new Timestamp(utilDate.getTime());
	}
}
