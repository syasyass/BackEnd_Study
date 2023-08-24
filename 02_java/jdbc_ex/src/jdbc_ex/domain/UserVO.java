package jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

	// private 멤버변수 선언
	private String id;
	private String password;
	private String name;
	private String role;
}
