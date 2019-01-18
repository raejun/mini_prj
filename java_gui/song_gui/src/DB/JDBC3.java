package DB;
import java.sql.*;
public class JDBC3 {
	public static void main(String[] args) {
		// ���� ����
		String user = "scott";
		String pw = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// ���� ��ü
		Connection conn = null;
		// ��� ��ü
		PreparedStatement psmt = null;
		// id, passwd,name, tel, address, age, regdate
		String sql = "UPDATE member " + "SET name=?, tel=?, address=?, age=?, regdate=SYSDATE "
				+ "WHERE id=? AND passwd=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			psmt = conn.prepareStatement(sql);
			System.out.println("�۵��� �ٺ����������Ĥ���������");
			psmt.setString(1, "������");
			psmt.setString(2, "01092637827");
			psmt.setString(3, "����");
			psmt.setInt(4, 26);
			psmt.setString(5, "im");
			psmt.setString(6, "abcd");
			int ok = psmt.executeUpdate();
			if (ok == 1) {
				System.out.println("ȸ������ �߰�");
			} else {
				System.out.println("�߰� ����");
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
