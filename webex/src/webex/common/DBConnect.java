package webex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	private static Connection con;
	private DBConnect() { }
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String user = "dev";
		String pwd = "qwerty123";
		
		if(con == null) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, pwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void close() {
		try {
			if(con != null) 	con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, Statement stmt) {
		try {
			if(rs != null) 		rs.close();
			if(stmt != null) 	stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs, PreparedStatement pstmt) {
		try {
			if(rs != null) 		rs.close();
			if(pstmt != null) 	pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null) 	stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null) 	pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
