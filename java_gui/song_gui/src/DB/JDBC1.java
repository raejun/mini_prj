package DB;
import java.sql.*;
public class JDBC1 {
	String str; //�ڵ����� null���� ��
	public static void main(String[] args) {
		//���� ����
		String user ="scott";
		String pw = "TIGER";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		//���� ��ü
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from emp";
		try {
			//1. JDBC ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("��������");
			
			//2. ����
			conn=DriverManager.getConnection(url,user,pw);
			System.out.println("���� ����");
			
			//3.��� ����
			psmt = conn.prepareStatement(sql);
			System.out.println("��� �غ� ����");
			
			//4. ����
			rs = psmt.executeQuery();//select ���� excute ������ ����
			System.out.println("���� ����!");
			//System.out.println("rs = "+rs);
			
			//5. rs��� ���
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				System.out.println("empno= "+empno+", ename= "+ename+", job= "+job+" mgr= "+mgr);
			}
			System.out.println("��� ���");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ ã�� �� X");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("�������");
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
			}//finally	
			}
	}//main
}//end
