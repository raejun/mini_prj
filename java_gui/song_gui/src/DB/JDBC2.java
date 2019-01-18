package DB;

import java.sql.*;

public class JDBC2 {
	public static void main(String[] args) {
		// ���� ����
		String user = "scott";
		String pw = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// ���� ��ü
		Connection conn = null;
		// ��� ��ü
		PreparedStatement psmt = null;
		// SQL
		String sql = "INSERT INTO member(ID, PASSWD, NAME, TEL, ADDRESS, AGE, REGDATE)"
				+ "VALUES(?,?,?,?,?,?,SYSDATE)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 1. ����̹� �ε�
			conn = DriverManager.getConnection(url, user, pw);// 2. ����
			// 3. ��� �غ�
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "im");
			psmt.setString(2, "abcd");
			psmt.setString(3, "�Ӳ���");
			psmt.setString(4, "010-2222-3333");
			psmt.setString(5, "���");
			psmt.setInt(6, 26);
			//����
			int ok = psmt.executeUpdate();
			if(ok==1) {
				System.out.println("���� ����");
			}else {
				System.out.println("�������");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(psmt!=null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}//finally	
	}// main

}// end
