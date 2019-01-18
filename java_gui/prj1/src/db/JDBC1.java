package db;
import java.sql.*;
public class JDBC1 {
	public static void main(String[] args) {
		// 접속 정보
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// 연결 객체
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from emp";
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. JDBC 드라이버 로딩 성공!!!");
			// 2. 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2. 연결 성공!!!");
			// 3. 명령 준비
			psmt = conn.prepareStatement(sql);
			System.out.println("3. 명령 준비 성공!!!");
			// 4. 실행
			rs = psmt.executeQuery(); // select문은 executeQuery 로 실행한다.
			System.out.println("4. 실행 성공!!!");
			// System.out.println("rs=" + rs); // rs=oracle.jdbc.driver.OracleResultSetImpl@543e710e
			// 5. rs 결과 출력
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				System.out.println("empno=" + empno + ", ename=" + ename + ", job=" + job + 
						", mgr=" + mgr);
			}//while
			System.out.println("5. 결과 출력 성공!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 실패!");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}//if rs
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}//if psmt
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}// if conn
		}//finally
	}//main
}//end