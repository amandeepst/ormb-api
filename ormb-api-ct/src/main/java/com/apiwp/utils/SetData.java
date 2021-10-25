/*
 * package com.apiwp.utils;
 * 
 * import java.io.File; import java.io.FileNotFoundException;
 * 
 * import java.sql.PreparedStatement; import java.sql.SQLException; import
 * java.util.Scanner;
 * 
 * 
 * 
 * public class SetData {
 * 
 * @Autowired private Environment environment;
 * 
 * @Autowired private DataSource ormbCisadmDS;
 * 
 * 
 * 
 * public void readdatasheet(String file) throws FileNotFoundException,
 * ClassNotFoundException, SQLException {
 * 
 * 
 * java.sql.Connection jdbcConnection =Connection.getConnection();
 * 
 * String fileextension = ".sql"; String filepath = "/";
 * System.out.println("File path =testdata "+filepath+file+fileextension); File
 * datafile = new File(filepath+file+fileextension); Scanner sc = null; String
 * query = ""; int sqlLineNumber = 0; sc = new Scanner(datafile); while
 * (sc.hasNextLine()) { sqlLineNumber++; String s = sc.nextLine();
 * //System.out.println("String s =  "+sc.hasNextLine());
 * 
 * if ((s.length() > 0) && (s.charAt(s.length() - 1) == ';')) { query =
 * query.concat(s.substring(0, s.length() - 1));
 * System.out.println("Query = "+query); PreparedStatement preparedStmt = null;
 * try {
 * 
 * preparedStmt =jdbcConnection.prepareStatement(query); preparedStmt.execute();
 * preparedStmt.close(); } catch (SQLException e) {
 * System.out.println("Data clean up script has error at line number " +
 * sqlLineNumber); System.out.println(e.getMessage()); //System.exit(0); } query
 * = ""; //isDataCleaned = true; } else if (s.length() == 0) { query =
 * query.concat(""); } else if ((s.length() > 0) && (s.charAt(s.length() - 1) !=
 * ';')) { query = query.concat(s).concat(" "); } }
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * }
 */