package edu.practice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class EmpDao {

	Connection con; // DB 연결 객체
	Statement stmt; // SQL 수행을 위한 객체
	ResultSet rs;
	private String id;
	private String pw;

	// 기본 생성자
	public EmpDao() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "hr";
		String pwd = "1111";

		try {
			Class.forName(driver); // JDBC 드라이버 로드
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			System.out.println("con ok!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean login(String id, String email) {
		String query = "SELECT * FROM emp " + "WHERE employee_id = " + id + " AND email = '" + email + "'";
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
	}
	
	public boolean delete(String id)	{
		String query = "SELECT * FROM emp WHERE employee_id = 100";
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
	}
	
	
	
	
	
	
	
	
	
}
