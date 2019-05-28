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

	// 회원 목록 출력
	public List<MemberVO> selectAll() {
		String query = "SELECT * FROM t_member";
		MemberVO mvo = null;
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			stmt = DBConnect.getConnection().createStatement();
			rs = stmt.executeQuery(query); // 쿼리 실행
			while (rs.next()) { // 쿼리 실행 결과가 있으면
				mvo = new MemberVO(); // 객체 생성
				// rs의 값을 mvo에 저장
				mvo.setUserId(rs.getString("user_id")); // 아이디
				mvo.setUserNm(rs.getString("user_nm")); // 이름
				mvo.setEmail1(rs.getString("email1")); // 이메일1
				mvo.setEmail2(rs.getString("email2")); // 이메일2
				memberList.add(mvo);
			}
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnect.close(rs, pstmt);
		return memberList;
	}

	// 회원 정보 조회
	public MemberVO select(String userId) {
		String query = "SELECT * FROM t_member " + "WHERE user_id = ?";
		MemberVO mvo = null;
		try {
			pstmt = DBConnect.getConnection().prepareStatement(query);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery(); // 쿼리 실행
			if (rs.next()) { // 쿼리 실행 결과가 있으면
				mvo = new MemberVO(); // 객체 생성
				// rs의 값을 mvo에 저장
				mvo.setUserId(rs.getString("user_id")); // 아이디
				mvo.setUserNm(rs.getString("user_nm")); // 이름
				mvo.setEmail1(rs.getString("email1")); // 이메일1
				mvo.setEmail2(rs.getString("email2")); // 이메일2
				mvo.setRegDate(rs.getDate("reg_date")); // 가입일자
				mvo.setBirthDate(rs.getString("birth_date")); // 생년월일
				mvo.setPhoto(rs.getString("photo")); // 사진
			}
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnect.close(rs, pstmt);
		return mvo;
	}// END select()

	// 회원 수정
	public boolean update(String userId, String email1, String email2) {
		String query = "UPDATE t_member SET email1 = ? " 
					 + "email2 = ? WHERE userId = ?";
		try {
			pstmt = DBConnect.getConnection().prepareStatement(query);
			pstmt.setString(1, email1); 
			pstmt.setString(2, email2);
			pstmt.setString(3, userId);

			int result = pstmt.executeUpdate(); 
			if (result == 1) { // 변경 성공
				DBConnect.getConnection().commit();
				return true; // true값 반환
			} else {
				DBConnect.getConnection().rollback();
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end update

	// 회원 삭제
	public boolean delete(String userId) {
		String query = "DELETE FROM t_member WHERE user_id = '" + userId + "'";
		try {
			stmt = DBConnect.getConnection().prepareStatement(query);
			int result = stmt.executeUpdate(query); // 쿼리 실행
			if (result == 1) { // 잘 삭제가 되었으면
				DBConnect.getConnection().commit(); // db에 반영
				return true; // true값 반환
			} else {
				DBConnect.getConnection().rollback(); // 쿼리 실행 취소
			}
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end delete()

	// 로그인 처리
	public boolean loginChk(MemberVO mvo) {
		String query = "SELECT * FROM t_member " + 
					   " WHERE user_id = ? " + " AND user_pw = ?";
		try {
			pstmt = DBConnect.getConnection().prepareStatement(query);
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserPw());
			rs = pstmt.executeQuery(); // 쿼리 실행
			if (rs.next()) { // 실행 결과가 있으면
				return true;// 로그인 성공
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// 회원가입
	public boolean insert(MemberVO mvo) {
		// 회원가입 쿼리 실행
		String query = "INSERT INTO t_member " + 
					   "VALUES(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

		try {
			pstmt = DBConnect.getConnection().prepareStatement(query); // 미리 쿼리를 설정
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserPw());
			pstmt.setString(3, mvo.getUserNm());
			pstmt.setString(4, mvo.getEmail1());
			pstmt.setString(5, mvo.getEmail2());
			pstmt.setString(6, mvo.getBirthDate());
			pstmt.setString(7, mvo.getGender());
			pstmt.setString(8, mvo.getPhoto());
			int result = pstmt.executeUpdate(); // 쿼리 실행 (미리 설정해 놓은 pstmt로 쿼리 실행)
			if (result == 1) { // 변경 성공
				DBConnect.getConnection().commit();
				return true; // true값 반환
			} else {
				DBConnect.getConnection().rollback();
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
