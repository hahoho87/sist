package begin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "hr";
		String pwd = "1111";
		
		Connection con = null;	//DB 연결 객체
		Statement stmt = null;	//SQL 수행을 위한 객체
		ResultSet rs = null;
		
		try {
			Class.forName(driver);	//JDBC 드라이버 로드
			con = DriverManager.getConnection(url, user, pwd);			//데이터베이스 커넥션 구함
			stmt = con.createStatement();								//쿼리 실행을 위한 Statement 객체 생성
			String query = "SELECT * FROM regions WHERE region_id = 1"; //쿼리 작성
			rs = stmt.executeQuery(query);								//쿼리 실행
			while (rs.next()) {											//읽어 올 값이 있으면
				int id = rs.getInt("region_id");
				String name = rs.getString("region_name");
				System.out.println("id : " + id);
				System.out.println("name : " + name);
			}
			System.out.println("stmt ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	{
					rs.close();
				}
				if (stmt != null)	{
					stmt.close();										//Statement 종료
				}
				if (con != null)	{
					con.close();										//DB connection 종료
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
