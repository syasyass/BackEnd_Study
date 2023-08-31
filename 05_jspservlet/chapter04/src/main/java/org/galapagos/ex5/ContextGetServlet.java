package org.galapagos.ex5;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextGetServlet
 */
@WebServlet("/contextget")
public class ContextGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 속성값 얻기
		ServletContext sc = getServletContext();
		String name = (String) getServletContext().getAttribute("name");
		int age = (Integer) getServletContext().getAttribute("age");
		
		System.out.println("name: " + name);
		System.out.println("age: " + age);
	}

}
