package jdbc_ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_ex.common.JDBCUtil;
import jdbc_ex.domain.UserVO;

public class UserDAO {
	// USERS 테이블 관련 SQL 명령어
	private String USER_LIST = "select * from users";
	private String USER_GET = "select * from users where id = ?";
	private String USER_INSERT = "insert into users values(?,?,?,?)";
	private String USER_UPDATE = "update users set name = ?, role = ? wheere id = ?";
	private String USER_DELETE = "delete users where id = ?";

	// 회원 등록
	public void insertUser(UserVO user) {
		Connection conn = JDBCUtil.getConnection();
		try (PreparedStatement stmt = conn.prepareStatement(USER_INSERT)) {
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원 목록 조회
	public List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<UserVO>();
		Connection conn = JDBCUtil.getConnection();
		try (PreparedStatement stmt = conn.prepareStatement(USER_LIST); ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	// 회원 정보 조회
	public UserVO getUser(String id) {
		Connection conn = JDBCUtil.getConnection();
		try (PreparedStatement stmt = conn.prepareStatement(USER_GET)) {
			stmt.setString(1, id);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					UserVO user = new UserVO();
					user.setId(rs.getString("ID"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setName(rs.getString("NAME"));
					user.setRole(rs.getString("ROLE"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 회원 수정
	public void updateUser(UserVO user) {
		Connection conn = JDBCUtil.getConnection();
		try (PreparedStatement stmt = conn.prepareStatement(USER_UPDATE)) {
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getRole());
			stmt.setString(3, user.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// USERS 테이블 관련 CRUD 메소드
	// 회원 삭제
	public void deleteUser(String id) {
		Connection conn = JDBCUtil.getConnection();
		try (PreparedStatement stmt = conn.prepareStatement(USER_DELETE)) {
			stmt.setString(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
