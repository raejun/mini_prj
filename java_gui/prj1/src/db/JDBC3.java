package db;
import java.sql.*;
public class JDBC3 {
	public static void main(String[] args) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = null;
		PreparedStatement psmt = null;
		// id,passwd,name,tel,address,age,regdate
		String sql = "UPDATE member "
				+ "SET name=?, tel=?, address=?, age=?, regdate=SYSDATE "
				+ "WHERE id=? AND passwd=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "홍길순");
			psmt.setString(2, "010-3333-4444");
			psmt.setString(3, "서초");
			psmt.setInt(4, 26);
			psmt.setString(5, "hong");
			psmt.setString(6, "abcd");
			int ok = psmt.executeUpdate();
			if(ok == 1) {
				System.out.println("회원 정보가 수정되었습니다!!!");
			} else {
				System.out.println("수정 실패!");
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
