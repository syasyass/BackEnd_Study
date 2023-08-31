package org.galapagos.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	static Connection conn = null;
	
	public static void connect(String driver, String url, String username, String password) throws Exception {
		// jdbc 드라이버 로드
		Class.forName(driver);
		
		// Connection
		conn = DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
