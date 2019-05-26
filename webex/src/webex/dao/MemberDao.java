package webex.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webex.common.DBConnect;
import webex.vo.MemberVO;

//Data Access Object
public class MemberDao {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;
	
	//회원 목록 출력
	public List<MemberVO> selectAll() {
		String query = "SELECT * FROM t_member";
		MemberVO mvo = null;
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try {
			stmt = DBConnect.getConnection().createStatement();
			rs = stmt.executeQuery(query);	//쿼리 실행
			while (rs.next()) {				//쿼리 실행 결과가 있으면
				mvo = new MemberVO();		//객체 생성
				//rs의 값을 mvo에 저장
				mvo.setUserId(rs.getString("user_id"));
				mvo.setUserNm(rs.getString("user_nm"));
				mvo.setEmail1(rs.getString("email1"));
				mvo.setEmail2(rs.getString("email2"));
				memberList.add(mvo);
			}
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnect.close(rs, stmt);
		return memberList;
	}//End selectAll()
	
	//회원 정보 조회
	public MemberVO select(String userId) {
		String query = "SELECT * FROM t_member " +
					   "WHERE user_id = ?";
		MemberVO mvo = null;
		
		try {
			pstmt = DBConnect.getConnection().prepareStatement(query);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			if (rs.next()) { 
				mvo = new MemberVO();
				
				mvo.setUserId(rs.getString("user_id"));
				mvo.setUserNm(rs.getString("user_nm"));
				mvo.setEmail1(rs.getString("email1"));
				mvo.setEmail2(rs.getString("email2"));
				mvo.setRegDate(rs.getDate("reg_date"));
				mvo.setBirthDate(rs.getString("birth_date"));
				mvo.setPhoto(rs.getString("photo"));
			}
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnect.close(rs, pstmt);
		return mvo;
	}//End select
	
	
	//회원 수정
	
	//회원 삭제
	
	//로그인 처리
	public boolean loginChk(MemberVO mvo) {
		String query = "SELECT * FROM t_member " + " WHERE user_id = ? "
	
				+ " AND user_pw = ?";
		 
		try {
			pstmt = DBConnect.getConnection().prepareStatement(query);
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserPw());
			rs = pstmt.executeQuery();
			if(rs.next()); {
				return true;
			}
			
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//회원 가입
	public boolean insert(MemberVO mvo) {
		
		return true;
		
	}
}
