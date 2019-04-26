package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.DBconnect;
import vo.CustomerVO;
import vo.MovieScheduleVO;
import vo.MovieVO;
import vo.NowTicketVO;
import vo.TicketingVO;
import vo.HistoryVO;
import vo.MovieCancleVO;

public class MovieCancleDAO2 {

   Statement stmt; // SQL 수행을 위한 객체
   ResultSet rs;
   PreparedStatement pstmt;

   public boolean delete(int select) {
	      String query = "delete from ticketing where booking_no = " + select;
	      
	      try {
	    	  stmt = DBconnect.getConnection().createStatement();
	         int result = stmt.executeUpdate("delete from ticketing where booking_no = "+select); // 쿼리 실행
	         System.out.println(result); 
	         if (result == 1) { // 삭제 성공
	        	 
	            DBconnect.getConnection().commit(); // db 반영
	            System.out.println("영화 예매 취소완료.");
	            return true;
	         } else {
	            DBconnect.getConnection().rollback(); // 쿼리 실행 취소
	            System.err.println("영화 예매 취소 실패");
	         }
	      } catch (SQLSyntaxErrorException e) {
	         System.err.println("입력값에 오류가 있습니다.");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return false;
	   } // delete()
}