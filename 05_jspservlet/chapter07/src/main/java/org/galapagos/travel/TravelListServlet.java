package org.galapagos.travel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TravelListServlet
 */
@WebServlet("/travel_list")
public class TravelListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] names = {
				"홍길동", "고길동", "김길동"
		};
		
		request.setAttribute("names", names);
		
		// JSP 이동
		RequestDispatcher dis = request.getRequestDispatcher("travel_list2.jsp");
		dis.forward(request, response);
		
	}

}
