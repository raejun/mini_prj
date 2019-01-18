package db;
import java.sql.*;
public class JDBC1 {
	public static void main(String[] args) {
		// ���� ����
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// ���� ��ü
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from emp";
		try {
			// 1. JDBC ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. JDBC ����̹� �ε� ����!!!");
			// 2. ����
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2. ���� ����!!!");
			// 3. ��� �غ�
			psmt = conn.prepareStatement(sql);
			System.out.println("3. ��� �غ� ����!!!");
			// 4. ����
			rs = psmt.executeQuery(); // select���� executeQuery �� �����Ѵ�.
			System.out.println("4. ���� ����!!!");
			// System.out.println("rs=" + rs); // rs=oracle.jdbc.driver.OracleResultSetImpl@543e710e
			// 5. rs ��� ���
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				System.out.println("empno=" + empno + ", ename=" + ename + ", job=" + job + 
						", mgr=" + mgr);
			}//while
			System.out.println("5. ��� ��� ����!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ ã�� �� �����ϴ�!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���� ����!");
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