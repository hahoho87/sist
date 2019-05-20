

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String usernm = request.getParameter("usernm");
		//index.html에서 querystring usernm의 값을 usernm에 저장
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>HELLOServlet.do</title></head>");
		out.println("<body><h3>Hello Servlet!~</h3>");
		out.println("	<p>이름 : " + usernm + "</p></body>");
		//클라이언트 데이터는 request 객체에 담겨서 온다
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String usernm = req.getParameter("usernm");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>HELLOServlet.do</title></head>");
		out.println("<body><h3>Hello POST!~</h3>");
		out.println("	<p>이름 : "+ usernm + "</p></body>");
		out.println("</html>");
	}



}
