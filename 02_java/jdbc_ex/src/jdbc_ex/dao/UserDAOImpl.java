package jdbc_ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_ex.common.JDBCUtil;
import jdbc_ex.domain.UserVO;

public class UserDAOImpl implements UserDAO {
	// USERS 테이블 관련 SQL 명령어
	private String USER_LIST = "select * from users order by id";
	private String USER_GET = "select * from users where id = ?";

	private String USER_INSERT = "insert into users values(?,?,?,?)";
	private String USER_UPDATE = "update users set name = ?, role = ? where id = ?";
	private String USER_DELETE = "delete users where id = ?";

	// 커넥션 개체
	private Connection conn = JDBCUtil.getConnection(); // 중복 코드가 되므로 멤버 변수로 승격

	// 싱글톤Singleton 패턴
	private static UserDAOImpl dao = new UserDAOImpl();

	private UserDAOImpl() {
	}

	public static UserDAO getInstance() {
		return dao;
	}

	// 회원 등록
	@Override
	public void insertUser(UserVO user) {
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
	@Override
	public List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<UserVO>();
		try (PreparedStatement stmt = conn.prepareStatement(USER_LIST); ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				UserVO user = map(rs);
				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	// 회원 정보 조회
	@Override
	public UserVO getUser(String id) {
		try (PreparedStatement stmt = conn.prepareStatement(USER_GET)) {
			stmt.setString(1, id);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					// 한 행 정보를 이용해서 UserVO객체로 만듦
					return map(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ResultSet을 UserVO로 맵핑
	private UserVO map(ResultSet rs) throws SQLException {
		UserVO user = new UserVO();
		user.setId(rs.getString("ID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setName(rs.getString("NAME"));
		user.setRole(rs.getString("ROLE"));
		return user;
	}

	// 회원 수정
	@Override
	public void updateUser(UserVO user) {
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
	@Override
	public void deleteUser(String id) {
		try (PreparedStatement stmt = conn.prepareStatement(USER_DELETE)) {
			stmt.setString(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
