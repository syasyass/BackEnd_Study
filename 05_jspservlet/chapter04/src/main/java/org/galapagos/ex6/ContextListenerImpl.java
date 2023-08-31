package org.galapagos.ex6;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.galapagos.common.JDBCUtil;

/**
 * Application Lifecycle Listener implementation class ContextListenerImpl
 *
 */
@WebListener
public class ContextListenerImpl implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("웹 어플리케이션 제거");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹 어플리케이션 초기화");
    	
    	ServletContext sc = sce.getServletContext();
		
		String driver = sc.getInitParameter("driver");
		String dburl = sc.getInitParameter("dburl");
		String username = sc.getInitParameter("username");
		String password = sc.getInitParameter("password");
		
		// JDBC 연결
		try {
			JDBCUtil.connect(driver, dburl, username, password);
			System.out.println("DB 연결 성공");			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }	
}
