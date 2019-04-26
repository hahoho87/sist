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

public class MovieCancleDAO {

   Statement stmt; // SQL 수행을 위한 객체
   ResultSet rs;
   PreparedStatement pstmt;

   public  List<MovieCancleVO> moviecancleList() {
         String query =  
           "select c.booking_no, a.movie_title, to_date(b.screen_date, 'YY/MM/DD') "
           + "from movie a, movie_schedule b, ticketing c"
           + " where a.movie_id = b.movie_id"
           + " and b.screen_no = c.screen_no"
           + " and screen_date > sysdate ";
         
      
         List<MovieCancleVO> moviecancleList = new ArrayList<MovieCancleVO>();

         MovieCancleVO cvo = null;
         try {
        	
            stmt = DBconnect.getConnection().createStatement();
            rs = stmt.executeQuery(query); // 쿼리 실행
          
            while (rs.next()) { // 쿼리 실행 결과가 있으면
               //tvo = new TicketingVO(); // 객체 생성
               // rs의 값을 evo에 저장
               cvo = new MovieCancleVO();
               cvo.setBookingNO(rs.getInt(1));
               cvo.setMovieTitle(rs.getString(2));
               cvo.setScreenDate(rs.getString(3).substring(0,10));
   
               moviecancleList.add(cvo);
            }
         } catch (SQLSyntaxErrorException e) {
            System.err.println("입력값에 오류가 있습니다.");
         } catch (SQLException e) {
            e.printStackTrace();
         }
         return moviecancleList;
      }// end customerAll


}