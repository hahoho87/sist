package begin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import begin.util.Pet;

//Data Access Object
public class RegionsDAO {
	// 넘겨받은 regionID에 해당하는 레코드 하나를 반환
	public Regions selectOne(int regionId) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "hr";
		String pwd = "1111";

		Connection con = null; // DB 연결 객체
		Statement stmt = null; // SQL 수행을 위한 객체
		ResultSet rs = null;
		Regions r = null;
		r = new Regions();
		try {
			Class.forName(driver); // JDBC 드라이버 로드
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			String query = "SELECT * FROM regions WHERE region_id =" + regionId;
			rs = stmt.executeQuery(query); // 쿼리 실행
			if (rs.next()) { // 읽어 올 값이 있으면
				// Regions 클래스의 객체에 저장
				r.setRegionID(rs.getInt("region_id"));
				r.setRegionName(rs.getString("region_name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return r;
	}

	// Regions 테이블의 모든 목록을 반환
	public List<Regions> selectAll() {
		// 1. 쿼리 수정
		// 2. 4칸짜리 arraylist 객체 (자식타입으로)
		List<Regions> list = new ArrayList<Regions>();
		// 3. while문을 돌면서 region 객체가 하나씩 만들어지면서 출력
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "hr";
		String pwd = "1111";

		Connection con = null; // DB 연결 객체
		Statement stmt = null; // SQL 수행을 위한 객체
		ResultSet rs = null;

		try {
			Class.forName(driver); // JDBC 드라이버 로드
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			String query = "select * from regions";
			rs = stmt.executeQuery(query); // 쿼리 실행

			while (rs.next()) { // 읽어 올 값이 없을 때 까지
				// Regions 클래스의 객체에 저장
				Regions r = new Regions();
				r.setRegionID(rs.getInt("region_id"));
				r.setRegionName(rs.getString("region_name"));
				list.add(r);
				System.out.println(r);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

}
