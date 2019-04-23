package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.DBconnect;
import vo.CustomerVO;
import vo.MovieVO;

public class AdminDAO {
	Statement stmt; // SQL 수행을 위한 객체
	ResultSet rs;
	PreparedStatement pstmt;
	CustomerVO cvo = null;
	MovieVO	mvo = null;

	public AdminDAO() {
		try {
			stmt = DBconnect.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end 생성자

	public boolean login(String id, String pw) {
		String query = "SELECT * FROM admin " + "WHERE admin_id = '" + id + "' AND admin_pw = '" + pw + "'";
		try {
			rs = stmt.executeQuery(query); // 쿼리 실행
			if (rs.next()) { // 읽어 올 값이 있으면(로그인이 성공하면)
				return true;
			} else {
				return false;
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end login

	public List<CustomerVO> customerAll() {
		String query = "SELECT * FROM customers";
		
		List<CustomerVO> empList = new ArrayList<CustomerVO>();
		try {
			rs = stmt.executeQuery(query); // 쿼리 실행
			while (rs.next()) { // 쿼리 실행 결과가 있으면
				cvo = new CustomerVO(); // 객체 생성
				// rs의 값을 evo에 저장
				cvo.setCustomerNo(rs.getInt("customer_no"));
				cvo.setCustomerID(rs.getString("customer_id"));
				cvo.setCustomerName(rs.getString("customer_name"));
				cvo.setCustomerPhone(rs.getString("customer_phone_no"));
				cvo.setCustomerBirth(rs.getDate("customer_birth"));
				empList.add(cvo);
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}// end customerAll
	
	public List<MovieVO> movieSearch() {
		String query = "SELECT * FROM movie";
		CustomerVO cvo = null;
		List<MovieVO> movieList = new ArrayList<MovieVO>();
		try {
			rs = stmt.executeQuery(query); // 쿼리 실행
			while (rs.next()) { // 쿼리 실행 결과가 있으면
				mvo = new MovieVO(); // 객체 생성
				// rs의 값을 evo에 저장
				mvo.setMovieID(rs.getInt("movie_id"));
				mvo.setMovieTitle(rs.getString("movie_title"));
				mvo.setMovieOpenday(rs.getDate("movie_openday"));
				movieList.add(mvo);
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieList;
	}// end customerAll
	
	public boolean update(int id, String email) {
		String query = "UPDATE movie SET email = ? " + "WHERE employee_id = ?";
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query); // 미리 쿼리를 설정
			pstmt.setString(1, email); // 첫번째 물음표를 1로 설정하고 email을 받음
			pstmt.setInt(2, id); // 두번째 물음표를 2로 설정하고 id를 받음

			int result = pstmt.executeUpdate(); // 쿼리 실행 (미리 설정해 놓은 pstmt로 쿼리 실행)
			if (result == 1) { // 변경 성공
				DBconnect.getConnection().commit();
				return true; // true값 반환
			} else {
				DBconnect.getConnection().rollback();
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end update
	

}