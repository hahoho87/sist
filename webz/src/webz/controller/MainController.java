package webz.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import webz.dao.MemberDao;
import webz.vo.MemberVO;

@WebServlet("/Main.do")
@MultipartConfig(location = "c://javawork", maxFileSize = 1024 * 100, maxRequestSize = -1, fileSizeThreshold = -1)

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String url; // 포워딩 페이지
	private MemberVO mvo;
	private MemberDao mdao;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		Connection con = (Connection) servletContext.getAttribute("con");
		mdao = new MemberDao(con);

		String flag = request.getParameter("flag");
		String userId = "";

		switch (flag) {
		case "i":
			insert(request);
			break;
		case "s":
			userId = request.getParameter("userId");
			mvo = mdao.select(userId);
			url = "member/userInfo.jsp";
			request.setAttribute("mvo", mvo);
			break;
		case "a":
			List<MemberVO> memberList = mdao.selectAll();
			url = "admin/userList.jsp";
			request.setAttribute("memberList", memberList);
			break;
		case "d":
			userId = request.getParameter("userId");
			boolean result = mdao.delete(userId);
			delete(request, result);
			break;
		case "uf":
			break;
		case "u":
			break;
		case "login":
			login(request, response);
			break;

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	//
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		// 리스너 context를 받아서 connection에 적용
		ServletContext servletContext = getServletContext();
		Connection con = (Connection) servletContext.getAttribute("con");

		mvo = new MemberVO(userId, userPw);
		// con을 MemberDao생성자에 추가
		mdao = new MemberDao(con);
		boolean result = mdao.loginChk(mvo); // DB 쿼리 실행 메서드 호출

		if (result == true) { // userMain.jsp로 이동
			HttpSession session = request.getSession();
			session.setAttribute("sid", userId);
			url = "member/userMain.jsp"; // url을 userMain.jsp로 지정
			if (userId.equals("admin")) {
				url = "admin/adminMain.jsp";
			}
		} else { // join03.jsp로 이동
			request.setAttribute("msg", "아이디 또는 비밀번호 불일치<br>다시 시도해 주세요");
			url = "common/join03.jsp"; // url을 join03.jsp로 지정
		}
	}

	// 회원 탈퇴 메서드
	public void delete(HttpServletRequest request, boolean result) {
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");

		if (sid.equals("admin")) { // sid가 admin인 경우

			if (result) {
				request.setAttribute("msg", "회원 삭제가 완료되었습니다");
			} else {
				request.setAttribute("msg", "회원 삭제에 실패했습니다.");
			}
			request.setAttribute("memberList", mdao.selectAll()); // 회원 목록을 요청 객체의 속성에 저장
			url = "member/userList.jsp";
		} else { // sid가 admin이 아닌 경우
			if (result) {
				request.setAttribute("msg", "회원 탈퇴가 완료되었습니다.");
				session.invalidate(); // 세션 무효화
				url = "common/join03.jsp"; // 첫 페이지로 이동
			} else {
				request.setAttribute("msg", "회원 탈퇴에 실패했습니다.");
				url = "member/userMain.jsp";
			}
		}
	}

	// 정보 수정 메서드
	public String update(HttpServletRequest request) {
		String photo = request.getParameter("photo");
		String photoBefore = request.getParameter("photoBefore");

		if (photo.trim().length() < 1 || photo == null) {
			photo = photoBefore;
		}

		MemberVO mvo = new MemberVO();
		// 생성자를 새로 만들어서 insert() 메서드처럼 사용해도 되고
		// setter를 불러서 아래처럼 처리해도 된다.
		mvo.setUserId(request.getParameter("userId"));
		mvo.setEmail1(request.getParameter("email1"));
		mvo.setEmail2(request.getParameter("email2"));
		mvo.setPhoto(request.getParameter("photo"));

		boolean result = mdao.update(mvo);

		if (result) {
			request.setAttribute("msg", "회원 정보가 수정되었습니다.");
			request.setAttribute("mvo", mvo);
			url = "member/userInfo.jsp";
		} else {
			request.setAttribute("msg", "회원 정보 수정이 실패했습니다.<br>다시 시도해 주세요.");
			url = "member/userInfoModify.jsp";
		}
		return url;
	}

	// 회원 가입
	public String insert(HttpServletRequest request) throws IOException, ServletException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userNm = request.getParameter("userNm");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String birthDate = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String photo = request.getParameter("photo");

		Part part = request.getPart("photo");
		String file = part.getSubmittedFileName();
		if (file.trim().length() < 1 || file == null) {
			photo = "user.png";
		} else {
			upload(request);
		}

		MemberVO mvo = new MemberVO(userId, userPw, userNm, email1, email2, birthDate, gender, photo, null);
		boolean result = mdao.insert(mvo); // DB 쿼리 실행 메서드 호출

		if (result == true) {
			request.setAttribute("msg", "회원가입이 완료되었습니다.<br>로그인 후 이용해 주세요");
			url = "common/join03.jsp";
		} else {
			request.setAttribute("msg", "회원가입에 실패하였습니다.<br>다시 시도해 주세요");
			url = "common/join02.jsp"; // url을 join02.jsp로 지정
		}
		return url;
	}

	public void upload(HttpServletRequest request) {
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(context.getInitParameter("filepath"));

		try {
			Part part = request.getPart("photo");
			String file = part.getSubmittedFileName();
			part.write(uploadPath + file);
			request.setAttribute("filepath", uploadPath);
			request.setAttribute("filename", file);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}
}
