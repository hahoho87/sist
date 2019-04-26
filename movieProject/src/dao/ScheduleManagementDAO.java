package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.DBconnect;
import vo.CustomerVO;
import vo.MovieScheduleVO;
import vo.MovieVO;
import vo.MovieScheduleListVO;
import vo.MovieScheduleVO2;
import dao.MovieManageDAO;

public class ScheduleManagementDAO {
	Statement stmt; 
	ResultSet rs;
	PreparedStatement pstmt;
	CustomerVO cvo = null;
	MovieVO mvo = null;
	MovieScheduleVO msvo = null;
	MovieScheduleListVO mslvo = null;
	MovieScheduleVO2 msvo2 = null;
	MovieManageDAO movieManageDAO = null;

	public ScheduleManagementDAO() {
		try {
			stmt = DBconnect.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end 생성자

	public List<MovieVO> movieSearchList(String title) {
		String query = "SELECT ms.screen_no, ms.screen_date, " + "ms.screen_time, m.movie_id, m.movie_title "
				+ "FROM movie_schedule ms, movie m " + "WHERE ms.movie_id = m.movie_id";
		MovieVO mvo = null;
		List<MovieVO> movieList = new ArrayList<MovieVO>();

		try {
			pstmt = DBconnect.getConnection().prepareStatement(query);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();

			while (rs.next()) { // 쿼리 실행 결과가 있으면
				mvo = new MovieVO(); // 객체 생성
				mvo.setMovieID(rs.getInt("movie_id"));
				mvo.setMovieTitle(rs.getString("movie_title"));
				mvo.setMovieOpenday(rs.getString("movie_openday"));
				movieList.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieList;
	}

	public List<MovieScheduleListVO> movieScheduleList() {
		String query = "SELECT ms.screen_no, ms.screen_date, "
				     + "ms.screen_time, "
				     + "(ms.screen_time+(m.movie_running_time/1440)), " + "m.movie_id, m.movie_title "
				     + "FROM movie_schedule ms, movie m " + "WHERE ms.movie_id = m.movie_id "
				     + "ORDER BY 2";

		List<MovieScheduleListVO> scheduleList = new ArrayList<MovieScheduleListVO>();
		mslvo = new MovieScheduleListVO();

		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				mslvo = new MovieScheduleListVO();
				mslvo.setScreenNo(rs.getInt(1));
				mslvo.setScreenDate(rs.getDate(2));
				mslvo.setScreenTime(rs.getTime(3));
				mslvo.setScreenEndTime(rs.getTime(4));
				mslvo.setMovieID(rs.getInt(5));
				mslvo.setMovieTitle(rs.getString(6));
				scheduleList.add(mslvo);
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scheduleList;
	}

	public boolean scheduleResister(MovieScheduleVO2 msvo2) {
		String query = "INSERT INTO movie_schedule " 
					 + "VALUES(movie_schedule_seq.nextval, "
					 + "TO_DATE(?,'YY/MM/DD'), TO_DATE(?, 'HH24:MI'), ?)";
			try {
			pstmt = DBconnect.getConnection().prepareStatement(query);
			pstmt.setString(1, msvo2.getScreenDate());
			pstmt.setString(2, msvo2.getScreenTime());
			pstmt.setInt(3, msvo2.getMovieID());
			int result = pstmt.executeUpdate(); 
			if (result == 1) { 
				DBconnect.getConnection().commit();
				return true; 
			} else {
				DBconnect.getConnection().rollback();
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean movieScheduleUpdate(MovieScheduleVO2 msvo2) {
		String query = "UPDATE MOVIE_SCHEDULE "
	                 + "SET screen_date = TO_DATE( ? , 'YY/MM/DD'), "
	                 + "screen_time = TO_DATE( ?, 'HH24:MI') "
	                 + "WHERE screen_no = ? ";		
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query); // 미리 쿼리를 설정
			pstmt.setString(1, msvo2.getScreenDate());
			pstmt.setString(2, msvo2.getScreenTime());
			pstmt.setInt(3, msvo2.getScreenNo());
			int result = pstmt.executeUpdate(); 
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
	}

	public boolean scheduleDelete(int screenNo) {
		String query = "DELETE FROM movie_schedule WHERE screen_no = " + screenNo;
		try {
			int result = stmt.executeUpdate(query);
			if (result == 1) { 
				DBconnect.getConnection().commit();
				return true; 
			} else {
				DBconnect.getConnection().rollback(); 
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("예매가 완료된 영화는 상영 취소가 불가능합니다.");
			System.out.println();
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
