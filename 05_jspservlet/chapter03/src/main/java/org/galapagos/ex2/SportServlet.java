package org.galapagos.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SportServlet
 */
@WebServlet("/sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String[] sports = request.getParameterValues("sports");
		String sport1 = request.getParameter("sports");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		
		// 실제 내보내는 코드보다 앞에 적어줘야 함
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		System.out.println(sport1);
		System.out.println("age: " + age);
		Integer numAge;
		if(age != null && !age.isEmpty()) {
			numAge = Integer.parseInt(age);
		} else {	// 값입력 없는 경우!
			numAge = null;
		}
		
		System.out.println("age: " + numAge);
		
		out.print("<html><body>");
		if(sports != null) {
			for (String sport : sports) {
				out.print("좋아하는 운동2: " + sport + "<br>");
			}
		} else {
			out.println("좋아하는 운동 없음<br>");
		}
		out.print("성별: " + sex + "<br>");		
		out.print("</body></html>");
	}

}
