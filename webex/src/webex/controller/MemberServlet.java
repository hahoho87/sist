package webex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webex.dao.MemberDao;
import webex.vo.MemberVO;

@WebServlet("/Member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String url;	//포워딩 페이지
	private MemberVO mvo;	
	private MemberDao mdao;
	
	@Override
	public void init() throws ServletException {
		mdao = new MemberDao();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		String userId = "";
		
		switch (flag) {
		case "i": insert(request);	//회원가입 메서드 - insert() 호출
			break;
		case "s": //회원정보 조회 메서드 - select() 호출
			userId = request.getParameter("userId");
			mvo = mdao.select(userId);
			url = "member/userInfo.jsp";	//결과를 출력할 페이지
			request.setAttribute("mvo", mvo);
			break;
		case "a": //회원 목록 보기 메서드 - selectAll() 호출
			List<MemberVO> memberList = mdao.selectAll();
			url = "member/userList.jsp";	//결과를 출력할 페이지
			request.setAttribute("memberList", memberList);
			break;
		case "d": //회원 삭제(탈퇴) 메서드  - delete() 호출
			break;
		case "u": //회원 정보 수정 메서드 - update() 호출
			break;
		}
		
		//RequestDispatcher를 이용하여 지정된 url로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	//회원정보 조회 메서드 - 
	public String select(HttpServletRequest request) {
		
		return url;
	}
	
	//회원가입 메서드
	public String insert(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userNm = request.getParameter("userNm");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String birthDate = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String photo = request.getParameter("photo");
		if(photo.trim().length() < 1 || photo == null) {
			photo = "";
		}
		
		MemberVO mvo = new MemberVO(userId, userPw, userNm, email1, email2, birthDate, gender, photo, null);
		MemberDao mdao = new MemberDao();
		boolean result = mdao.insert(mvo);	//DB 쿼리 실행 메서드 호출
//		String url = "";
		
		if(result == true) {	//join03.jsp로 이동
			//요청 객체의 msg 속성에 회원 가입 완료 메시지 설정
			request.setAttribute("msg", "회원가입이 완료되었습니다.<br>로그인 후 이용해 주세요");
			url = "member/join03.jsp";	//url을 join03.jsp로 지정
		} else {				//join02.jsp로 이동
			//요청 객체의 msg 속성에 회원 가입 실패 메시지 설정
			request.setAttribute("msg", "회원가입에 실패하였습니다.<br>다시 시도해 주세요");
			url = "member/join02.jsp";	//url을 join02.jsp로 지정
		}
		return url;
	}

}









