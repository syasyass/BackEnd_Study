package org.galapagos.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartDeleteServlet
 */
@WebServlet("/cartdelete")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("장바구니 리스트");
		
		// 세션객체 얻기
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
			// login은 유지하고 카트 내용만 비우고 싶을 때
			// session.removeAttribute("product");
		} else {
			out.print("세션 없음" + "<br>");
		}
		out.print("<a href='product.html'>상품 선택 페이지</a><br>");
		out.print("</html></body>");
	}

}
