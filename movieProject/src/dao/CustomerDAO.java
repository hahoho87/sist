package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import common.DBconnect;
import vo.CustomerVO;

public class CustomerDAO {

	Statement stmt; 
	ResultSet rs;	
	PreparedStatement pstmt;

	public CustomerDAO() {
		try {
			stmt = DBconnect.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end 생성자

	public boolean login(String id, String pw) {
		String query = "SELECT * FROM customers " + "WHERE customer_id = '" + id + "' AND customer_pw = '" + pw + "'";
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

	
	  public boolean insert(CustomerVO cvo) {
	      String query = 
	            "INSERT INTO customers(customer_no, customer_id, " +
	                            "customer_pw, customer_name, " +
	                          "customer_phone_no, customer_birth) " + 
	            "VALUES(customer_seq.NEXTVAL, ?, ?, ?, ?, ?)";
	      try {
	         pstmt = DBconnect.getConnection().prepareStatement(query);
	         pstmt.setString(1, cvo.getCustomerID());
	         pstmt.setString(2, cvo.getCustomerPW());
	         pstmt.setString(3, cvo.getCustomerName());
	         pstmt.setString(4, cvo.getCustomerPhone());
	         pstmt.setString(5, cvo.getCustomerBirth());
	         int result = pstmt.executeUpdate(); 
	         if(result == 1) {   
	        	 DBconnect.getConnection().commit();
	            return true;      
	         } else {
	        	 DBconnect.getConnection().rollback();
	         }
	      } catch(SQLSyntaxErrorException e) {
	         System.err.println("입력값에 오류가 있습니다.");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return false;
	   }//end insert
}









