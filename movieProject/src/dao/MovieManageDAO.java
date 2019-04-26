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
import vo.MovieVO;

public class MovieManageDAO {
	Statement stmt; // SQL 수행을 위한 객체
	ResultSet rs;
	PreparedStatement pstmt;
	CustomerVO cvo = null;
	MovieVO mvo = null;

	public MovieManageDAO() {
		try {
			stmt = DBconnect.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end 생성자

	public List<MovieVO> movieSearchList(String title) {
		String query = "SELECT * FROM movie WHERE movie_title = ?";
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

	public MovieVO movieSelect(int movieNo) {
		String query = "SELECT * FROM movie WHERE movie_id = ?";
		MovieVO mvo = null;
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query);
			pstmt.setInt(1, movieNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mvo = new MovieVO();
				mvo.setMovieID(rs.getInt("movie_id"));
				mvo.setMovieTitle(rs.getString("movie_title"));
				mvo.setMovieDirector(rs.getString("movie_director"));
				mvo.setMovieActor(rs.getString("movie_actor"));
				mvo.setMovieAge(rs.getInt("movie_Age"));
				mvo.setMovieOpenday(rs.getString("movie_openday"));
				mvo.setMovieRunningTime(rs.getInt("movie_running_time"));
				mvo.setMovieSummary(rs.getString("movie_summary"));
				return mvo;
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mvo;
	}

	public boolean movieRegist(MovieVO mvo) {
		String query = "INSERT INTO movie " + "VALUES(movie_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query); // 미리 쿼리를 설정
			pstmt.setString(1, mvo.getMovieTitle()); // 첫번째 물음표를 1로 설정하고 email을 받음
			pstmt.setString(2, mvo.getMovieDirector()); // 두번째 물음표를 2로 설정하고 id를 받음
			pstmt.setString(3, mvo.getMovieActor());
			pstmt.setInt(4, mvo.getMovieAge());
			pstmt.setString(5, mvo.getMovieOpenday());
			pstmt.setInt(6, mvo.getMovieRunningTime());
			pstmt.setString(7, mvo.getMovieSummary());

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
	}// end movieRegist

	public boolean movieDelete(int movieID) {
		String query = "DELETE FROM movie WHERE movie_id = " + movieID;
		try {
			int result = stmt.executeUpdate(query);
			if (result == 1) { // 잘 삭제가 되었으면
				DBconnect.getConnection().commit();// db에 반영
				return true; // true값 반환
			} else {
				DBconnect.getConnection().rollback(); // 쿼리 실행 취소
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("현재 상영중인 영화는 삭제가 불가능합니다.");
			System.out.println();
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end delete

	public boolean movieUpdate(MovieVO mvo) {
		String query = "UPDATE movie SET movie_title = ?, movie_director = ?, "
				+ "movie_actor = ?, movie_age = ?, movie_openday = ?, " 
				+ "movie_running_time = ?, movie_summary = ? "
				+ "WHERE movie_id = ?";
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query); // 미리 쿼리를 설정
			pstmt.setString(1, mvo.getMovieTitle()); // 첫번째 물음표를 1로 설정하고 email을 받음
			pstmt.setString(2, mvo.getMovieDirector()); // 두번째 물음표를 2로 설정하고 id를 받음
			pstmt.setString(3, mvo.getMovieActor());
			pstmt.setInt(4, mvo.getMovieAge());
			pstmt.setString(5, mvo.getMovieOpenday());
			pstmt.setInt(6, mvo.getMovieRunningTime());
			pstmt.setString(7, mvo.getMovieSummary());
			pstmt.setInt(8, mvo.getMovieID());
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
	}
}
