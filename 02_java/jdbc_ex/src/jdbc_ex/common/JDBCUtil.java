package jdbc_ex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	static Connection conn = null;
	static {
		try {
			// 오라클 JDBC
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String id = "jdbc_ex";
//			String password = "jdbc_ex";
//			conn = DriverManager.getConnection(url, id, password);

			// MySQL JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/glory_DB";
			String id = "glory";
			String password = "glory";
			conn = DriverManager.getConnection(url, id, password);

			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
