package webex.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//web.xml에서 설정 하지 않고 annotation으로 사용할 수도 있다.
@WebFilter(urlPatterns = { "/member/*" }, initParams = { @WebInitParam(name = "memberCode", value = "1234") })
public class MemberFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MemberFilter init()@");
		System.out.println("Member code : " + fConfig.getInitParameter("memberCode"));
	}

	public void destroy() {
		System.out.println("MemberFilter destroy()@");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MemberFilter doFilter() - BEFORE @");
		chain.doFilter(request, response);
		System.out.println("MemberFilter doFilter() - AFTER @");
	}

}