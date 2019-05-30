

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/SingleUpload.do")
@MultipartConfig(location = "c://javawork", 
				 maxFileSize = 1024 * 100, 
				 maxRequestSize = -1, 
				 fileSizeThreshold = -1
				 )
	
public class SingleUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실제 업로드 경로 가져오기
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(context.getInitParameter("filepath"));
		System.out.println(uploadPath);
		
		Part part = request.getPart("photo");
		String file = part.getSubmittedFileName();
		part.write(uploadPath + file);
		request.setAttribute("filepath", uploadPath);
		request.setAttribute("filename", file);
		request.setAttribute("usernm", request.getParameter("usernm"));
		
		System.out.println("contentType : " + request.getContentType());
		System.out.println("contentDisposition : " 
							+ part.getHeader("Content-Disposition")	);
		System.out.println("usernm : " + request.getParameter("usernm"));
		System.out.println("photo : " + file);
		System.out.println("part.getName() : " + part.getName());
		System.out.println("part.getContentType() : " + part.getContentType());
		System.out.println("part.getSize() : " + part.getSize());
		
		String url = "work/fileUploadResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
