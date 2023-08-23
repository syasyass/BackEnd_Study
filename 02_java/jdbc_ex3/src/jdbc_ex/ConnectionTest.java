package jdbc_ex;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc_ex.common.JDBCUtil;

public class ConnectionTest {

	public static void main(String[] args) {
		try (Connection conn = JDBCUtil.getConnection()) {
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close();
		}
	}
}
