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
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1. ����̹� �ε�
			conn = DriverManager.getConnection(url, user, password); // 2. ����
			// 3. ��� �غ�
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "im");
			psmt.setString(2, "abcd");
			psmt.setString(3, "�Ӳ���");
			psmt.setString(4, "010-2222-3333");
			psmt.setString(5, "���");
			psmt.setInt(6, 45);
			// 4. ���� -> 5. ���(1:����, 0:����)
			int ok = psmt.executeUpdate(); // insert, update, delete���� executeUpdate �� ����
			if(ok == 1) {
				System.out.println("���� ����!!!");
			} else {
				System.out.println("���� ����!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. �ڿ� ����
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
