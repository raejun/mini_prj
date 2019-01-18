package DB;
import java.sql.*;
public class JDBC3 {
	public static void main(String[] args) {
		// 접속 정보
		String user = "scott";
		String pw = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// 연결 객체
		Connection conn = null;
		// 명령 객체
		PreparedStatement psmt = null;
		// id, passwd,name, tel, address, age, regdate
		String sql = "UPDATE member " + "SET name=?, tel=?, address=?, age=?, regdate=SYSDATE "
				+ "WHERE id=? AND passwd=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			psmt = conn.prepareStatement(sql);
			System.out.println("송동찬 바보에에에에ㅔㅇ에에에ㅔ");
			psmt.setString(1, "찬동송");
			psmt.setString(2, "01092637827");
			psmt.setString(3, "송파");
			psmt.setInt(4, 26);
			psmt.setString(5, "im");
			psmt.setString(6, "abcd");
			int ok = psmt.executeUpdate();
			if (ok == 1) {
				System.out.println("회원정보 추가");
			} else {
				System.out.println("추가 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // finally

	}// main

}// end
