package edu.practice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.practice.vo.EmpVO;

public class EmpDAO {

	Connection con; // DB 연결 객체
	Statement stmt; // SQL 수행을 위한 객체
	ResultSet rs;
	PreparedStatement pstmt;

	// 기본 생성자
	public EmpDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String user = "dev";
		String pwd = "qwerty123";

		try {
			Class.forName(driver); // JDBC 드라이버 로드
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
	}// end login

	public boolean delete(String id) {
		String query = "DELETE FROM emp WHERE employee_id = '" + id + "'";
		try {
			int result = stmt.executeUpdate(query); // 쿼리 실행
			if (result == 1) { // 잘 삭제가 되었으면
				con.commit(); // db에 반영
				return true; // true값 반환
			} else {
				con.rollback(); // 쿼리 실행 취소
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end delete

	public boolean insert(EmpVO evo) {
		String query = "INSERT INTO emp(employee_id, last_name, first_name, email, hire_date, job_id)"
				+ "VALUES(?, ?, ?, ?, SYSDATE, ?)";
		try {
			pstmt = con.prepareStatement(query); // 미리 쿼리를 설정
			pstmt.setInt(1, evo.getEmployeeId()); // 첫번째 물음표를 1로 설정하고 email을 받음
			pstmt.setString(2, evo.getLastName()); // 두번째 물음표를 2로 설정하고 id를 받음
			pstmt.setString(3, evo.getFirstName());
			pstmt.setString(4, evo.getEmail());
			pstmt.setString(5, evo.getJobId());
			int result = pstmt.executeUpdate(); // 쿼리 실행 (미리 설정해 놓은 pstmt로 쿼리 실행)
			if (result == 1) { // 변경 성공
				con.commit();
				return true; // true값 반환
			} else {
				con.rollback();
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end update

	public boolean update(int id, String email) {
		String query = "UPDATE emp SET email = ? " + "WHERE employee_id = ?";
		try {
			pstmt = con.prepareStatement(query); // 미리 쿼리를 설정
			pstmt.setString(1, email); // 첫번째 물음표를 1로 설정하고 email을 받음
			pstmt.setInt(2, id); // 두번째 물음표를 2로 설정하고 id를 받음

			int result = pstmt.executeUpdate(); // 쿼리 실행 (미리 설정해 놓은 pstmt로 쿼리 실행)
			if (result == 1) { // 변경 성공
				con.commit();
				return true; // true값 반환
			} else {
				con.rollback();
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end update
	
	
	public List<EmpVO> selectAll() {
		String query = "SELECT * FROM emp";
		EmpVO evo = null;
		List<EmpVO> empList = new ArrayList<EmpVO>();
		try {
			rs = stmt.executeQuery(query); // 쿼리 실행
			while (rs.next()) { // 쿼리 실행 결과가 있으면
				evo = new EmpVO(); // 객체 생성
				// rs의 값을 evo에 저장
				evo.setEmployeeId(rs.getInt("employee_id"));
				evo.setLastName(rs.getString("last_name"));
				evo.setEmail(rs.getString("email"));
				evo.setHireDate(rs.getDate("hire_date"));
				evo.setJobId(rs.getString("job_id"));
				empList.add(evo);
				System.out.println(empList.get(0));
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}// end select

	public EmpVO select(int id) {
		String query = "SELECT * FROM emp WHERE employee_id = ?";
		EmpVO evo = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery(); // 쿼리 실행
			if (rs.next()) { // 쿼리 실행 결과가 있으면
				evo = new EmpVO(); // 객체 생성
				// rs의 값을 evo에 저장
				evo.setEmployeeId(rs.getInt("employee_id"));
				evo.setLastName(rs.getString("last_name"));
				evo.setEmail(rs.getString("email"));
				evo.setHireDate(rs.getDate("hire_date"));
				evo.setJobId(rs.getString("job_id"));
				return evo;
			}
		} catch (SQLSyntaxErrorException e) {
			System.err.println("입력값에 오류가 있습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evo;
	}// end select
	
	public void close()	{
			try {
				if(rs != null)
				rs.close();
				if(pstmt != null)
					pstmt.close();
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	

}
