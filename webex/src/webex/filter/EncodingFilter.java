package webex.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {
	private String charset;

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodingFilter init()");
		charset = fConfig.getInitParameter("KR");
	}

	public void destroy() {
		System.out.println("EncodingFilter destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset=" + charset);
		System.out.println("EncodingFilter 한글 인코딩 완료");
		chain.doFilter(request, response);
	}

}
