package org.galapagos.ex3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet(
		urlPatterns = { "/contextparam" }, 
		initParams = { 
				@WebInitParam(name = "pathDir", value = "E:/Temp", description = "파일업로드 경로"), 
				@WebInitParam(name = "userId", value = "seoa")
		})
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		
		String driver = sc.getInitParameter("driver");
		String dburl = sc.getInitParameter("dburl");
		String username = sc.getInitParameter("username");
		String password = sc.getInitParameter("password");
		
		System.out.println("getServletContext");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>getServletContext</h1>");
		out.println(driver + "<br>");
		out.println(dburl + "<br>");
		out.println(username + "<br>");
		out.println(password + "<br>");
		out.println("</body>");
		out.println("</html>");			
	}

}
