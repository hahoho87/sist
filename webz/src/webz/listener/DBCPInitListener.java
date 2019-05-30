package webz.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;


@WebListener
public class DBCPInitListener implements ServletContextListener {
	private Connection con;

	public void contextInitialized(ServletContextEvent sce) {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context context = (Context)initContext.lookup("java:comp/env/");
			DataSource ds = (DataSource)context.lookup("jdbc/oracle");
			
			con = ds.getConnection();
			
			if( con != null ) {
				ServletContext servletContext = sce.getServletContext();
				servletContext.setAttribute("con", con);
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
