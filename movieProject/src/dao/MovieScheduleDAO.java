package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.DBconnect;
import vo.MovieScheduleVO;

public class MovieScheduleDAO {

	int movieID ;
	Statement stmt; // SQL 수행을 위한 객체
	ResultSet rs; // SELECT 결과 저장 객체
	PreparedStatement pstmt; // SQL 수행을 위한 객체

	public MovieScheduleDAO() {
		try {
			stmt = DBconnect.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end 생성자

	public List<MovieScheduleVO> date(int movieID) {
		String query1 = "select screen_date from movie_schedule where movie_id = ?";
//		MovieScheduleVO msvo = null;
		List<MovieScheduleVO> mslist = new ArrayList<MovieScheduleVO>(); // 객체 생성
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query1);
			pstmt.setInt(1, movieID);

			rs = pstmt.executeQuery(); // 쿼리 실행
			
			while (rs.next()) { // 쿼리 실행 결과가 있으면
				MovieScheduleVO msvo = new MovieScheduleVO();
				// rs의 값을 msvo에 저장
				msvo.setScreenDate(rs.getDate("Screen_date"));
//				System.out.println("rsok");
				
				mslist.add(msvo);
				
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("notok");
		return mslist;
	}
	
	
	public List<MovieScheduleVO> time(String input) {
		
		
		
		String query = "select screen_time from (select * from movie_schedule where movie_id = ?) "
											   + "where screen_date = ?";

		List<MovieScheduleVO> mslist = new ArrayList<MovieScheduleVO>(); // 객체 생성
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query);
			pstmt.setInt(1, movieID);
			pstmt.setString(2, input);

			rs = pstmt.executeQuery(); 
			
			while (rs.next()) { 
				MovieScheduleVO msvo = new MovieScheduleVO();
				msvo.setScreenTime(rs.getDate("Screen_time"));

				mslist.add(msvo);
				
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("notok");
		return mslist;
	}
	

}


















