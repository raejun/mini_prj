package db;
import java.sql.*;
public class JDBC2 {
	public static void main(String[] args) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = "INSERT INTO member(id,passwd,name,tel,address,age,regdate) " +
				"VALUES(?,?,?,?,?,?,SYSDATE)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1. 드라이버 로딩
			conn = DriverManager.getConnection(url, user, password); // 2. 연결
			// 3. 명령 준비
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "im");
			psmt.setString(2, "abcd");
			psmt.setString(3, "임꺽정");
			psmt.setString(4, "010-2222-3333");
			psmt.setString(5, "방배");
			psmt.setInt(6, 45);
			// 4. 실행 -> 5. 결과(1:성공, 0:실패)
			int ok = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행
			if(ok == 1) {
				System.out.println("저장 성공!!!");
			} else {
				System.out.println("저장 실패!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
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
