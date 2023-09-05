package org.galapagos.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.galapagos.vo.User;

public class ListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("ListCommand 실행");
		
		List<User> list = new ArrayList<>();
		
		for(int i = 0; i <10 ; i++) {
			list.add(new User("hong"+i, "1234", "hong" + i + "@naver.com"));
		}
		
		// "users"라는 이름으로 request scope에 저장
		request.setAttribute("users", list);
		
		return "list"; // view 이름
	}

}
