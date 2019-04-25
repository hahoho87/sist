package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import common.DBconnect;
import vo.CustomerVO;
import vo.MovieVO;
import vo.PaymentVO;

public class BillingManageDAO {

	Statement stmt; // SQL 수행을 위한 객체
	ResultSet rs;
	PreparedStatement pstmt;
	CustomerVO cvo = null;
	MovieVO mvo = null;

	public BillingManageDAO() {
		try {
			stmt = DBconnect.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end 생성자

	public PaymentVO searchBookingNumber(int bookingNo) {
		String query = "SELECT * FROM payment WHERE booking_no = ?";
		PaymentVO pvo = null;
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query);
			pstmt.setInt(1, bookingNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { 
				pvo = new PaymentVO(); 
				pvo.setBookingNo(rs.getInt("booking_no"));
				pvo.setBookingDate(rs.getDate("booking_date"));
				pvo.setPaymentConfirm(rs.getString("payment_confirm"));
				return pvo;
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pvo;
	}

	public boolean billingManagement(int bookingNo, String paymentConfirm) {
		String query = "UPDATE payment SET payment_confirm = ? " + "WHERE booking_no = ?";
		
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query);
			
			pstmt.setInt(2, bookingNo);
			pstmt.setString(1, paymentConfirm);

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
	}// end update

}
