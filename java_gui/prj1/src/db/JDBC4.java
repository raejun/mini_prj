package db;
import java.sql.*;
public class JDBC4 {
	public static void main(String[] args) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = null;
		PreparedStatement psmt = null;
		// id,passwd,name,tel,address,age,regdate
		String sql = "DELETE FROM member WHERE id=? AND passwd=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "hong");
			psmt.setString(2, "abcd");
			int ok = psmt.executeUpdate();
			if(ok == 1) {
				System.out.println("È¸¿ø Å»Åð ¿Ï·áµÇ¾ú½À´Ï´Ù!!!");
			} else {
				System.out.println("Å»Åð ½ÇÆÐ!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
}//end
