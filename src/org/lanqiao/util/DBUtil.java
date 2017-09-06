package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static final String driver="oracle.jdbc.driver.OracleDriver";
	static final String user="scott";
	static final String password="123456";
	private static Connection conn;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
			Class.forName(driver);
			return conn=DriverManager.getConnection(url, user, password);
}
}