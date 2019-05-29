package webex.listener;

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
	
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			Context initContext = new InitialContext();
			Context context = (Context)initContext.lookup("java:comp/env/");
			DataSource ds = (DataSource)context.lookup("jdbc/oracle");
			
			con = ds.getConnection();
			if( con != null ) {
				System.out.println("con ok!");
				ServletContext servletContext = sce.getServletContext();
				servletContext.setAttribute("con", con);
			} else {
				System.out.println("con not ok!");
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
			if( con != null ) {
				con.close();
				System.out.println("con closed");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	System.out.println("DBCP closed");
    }
    
}
