package webex.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SimpleListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Simplistener contextInitialized()");
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("Simplistener sessionCreated()");
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("Simplistener requestInitialized()");
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("Simplistener requestDestroyed()");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Simplistener sessionDestroyed()");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Simplistener contextDestroyed()");
	}

}
