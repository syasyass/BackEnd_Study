package org.galapagos.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartSaveCookieServlet
 */
@WebServlet("/cartsavecookie")
public class CartSaveCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//입력 파라미터 얻기
		String product = request.getParameter("product");
		
		//기존 쿠키 얻기
		Cookie[] cookies = request.getCookies();
		Cookie c = null;
		if(cookies == null || cookies.length == 0) { //쿠키가 없는 경우
			System.out.println("쿠키 없음");
			c = new Cookie("product", product);
		} else {
			System.out.println(Arrays.toString(cookies));
			c = new Cookie("product" + ( cookies.length+1 ) , product);
		}
		
		//쿠키를 응답처리
		c.setMaxAge(60*60); // 단위는 초,  60*60 --> 1시간
		response.addCookie(c);		
		
		out.print("<html><body>");
		out.print("Product 추가");
		//out.print("<a href='cartbasketcookie'>장바구니 보기</a>");
		out.print("<a href="+response.encodeURL("cartbasketcookie")+">장바구니 보기</a><br>");
		out.print("<a href='product.html'>상품 선택 페이지</a><br>");
		out.print("</html></body>");	
	}
}
