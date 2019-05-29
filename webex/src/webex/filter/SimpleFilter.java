package webex.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/SimpleFilter")
public class SimpleFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("SimpleFilter init()");
	}

	public void destroy() {
		System.out.println("SimpleFilter destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SimpleFilter doFilter - before");
		chain.doFilter(request, response);
		System.out.println("SimpleFilter doFilter - after");
	}

}
