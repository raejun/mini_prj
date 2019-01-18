package DB;

import java.sql.*;
public class JDBC4 {
	public static void main(String[] args) {
		String user = "scott";
		String pw = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// ¿¬°á °´Ã¼
		Connection conn = null;
		// ¸í·É °´Ã¼
		PreparedStatement psmt = null;
		String sql = "DELETE FROM member WHERE id=? and passwd=?" ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url, user, pw);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,"im");
			psmt.setString(2,"abcd");
			int ok = psmt.executeUpdate();
			if (ok == 1) {
				System.out.println("Å»Åð");
			} else {
				System.out.println("noÅ»Åð");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}//end
