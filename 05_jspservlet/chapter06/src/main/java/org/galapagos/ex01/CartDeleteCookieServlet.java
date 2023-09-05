package org.galapagos.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartDeleteCookieServlet
 */
@WebServlet("/cartdeletecookie")
public class CartDeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("장바구니 비웠음!!");
		
		//기존 쿠키 얻기
		Cookie [] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				c.setMaxAge(1); // 1초: 삭제 // 0은 시간제한 두지 않겠다는 의미. 브라우저 종료와 상관없이 항상 유지
				response.addCookie(c);
			}
		} else {
			out.print("장바구니 비었음<br>");
		}
		out.print("<a href='product.html'>상품 선택 페이지</a><br>");
		out.print("</html></body>");
	}

}
