package webex.dao;

import webex.vo.MemberVO;

//Data Access Object
public class MemberDao {

	public boolean loginChk(MemberVO mvo) {
		System.out.println("MemberDao.loginChk()");
		System.out.println("id : " + mvo.getUserId());
		System.out.println("pw : " + mvo.getUserPw());
		return true;
	}

	public boolean insert(MemberVO mvo) {
		// 회원가입 쿼리 실행
		return true;
	}
}
