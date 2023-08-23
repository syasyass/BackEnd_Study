package jdbc_ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_ex.common.JDBCUtil;

public class SelectUsesrTest {

	public static void main(String[] args) {
		String sql = "select * from users";

		try (Connection conn = JDBCUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
