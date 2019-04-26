package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.DBconnect;
import vo.CustomerVO;
import vo.MovieVO;

public class AdminDAO {
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	CustomerVO cvo = null;
	MovieVO mvo = null;

	public AdminDAO() {
		try {
			stmt = DBconnect.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end 생성자

	public boolean login(String id, String pw) {
		String query = "SELECT * FROM admin " + "WHERE admin_id = '" + id + "' AND admin_pw = '" + pw + "'";
		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) { 
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
			rs = stmt.executeQuery(query); 
			while (rs.next()) { 
				cvo = new CustomerVO();
				cvo.setCustomerNo(rs.getInt("customer_no"));
				cvo.setCustomerID(rs.getString("customer_id"));
				cvo.setCustomerName(rs.getString("customer_name"));
				cvo.setCustomerPhone(rs.getString("customer_phone_no"));
				cvo.setCustomerBirth(rs.getString("customer_birth").substring(0,10));
				empList.add(cvo);
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}// end customerAll

	public boolean billingManagement(int bookingNo, String paymentConfirm) {
		String query = "UPDATE payment SET payment_confirm = ? " + "WHERE booking_no = ?";
		try {
			pstmt = DBconnect.getConnection().prepareStatement(query); 
			pstmt.setString(1, paymentConfirm); 
			pstmt.setInt(2, bookingNo); 
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
	}// end update
	
	
	
	
	
	
}
