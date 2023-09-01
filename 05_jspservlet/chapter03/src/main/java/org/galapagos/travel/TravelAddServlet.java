package org.galapagos.travel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.galapagos.travel.vo.TravelVO;
import org.galapagos.travel.vo.TravelVO.TravelVOBuilder;

/**
 * Servlet implementation class TravelAddServlet
 */
@WebServlet("/travel_add")
public class TravelAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. form 데이터 추출
		request.setCharacterEncoding("UTF-8");
		
		String region = request.getParameter("region");
		String title = request.getParameter("title");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String description = request.getParameter("description");		
		
		// 2. VO로 변환
		TravelVO travelVO = TravelVO.builder()
				.region(region)
				.title(title)
				.address(address)
				.phone(phone)
				.description(description)
				.build();
		
		// 3. DAO로 DB에 저장
		
		
		
		// --------------------------------- 1 2 3까지가 Servlet의 역할
		// 4. 결과를 사용자에게 출력		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		System.out.println(region);
		System.out.println(title);
		System.out.println(address);
		System.out.println(phone);
		System.out.println(description);
		
		out.print(travelVO);
		
	}

}
