package mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MemberDAO {
	// ȸ�� ���� �޼ҵ�
	public void insertMember(MemberDTO mem) {
		String sql = "INSERT INTO member(id,passwd,name,tel,address,age,regdate) " +
				"VALUES(?,?,?,?,?,?,SYSDATE)";
		Connection conn = getConn();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getId());
			psmt.setString(2, mem.getPasswd());
			psmt.setString(3, mem.getName());
			psmt.setString(4, mem.getTel());
			psmt.setString(5, mem.getAddress());
			psmt.setInt(6, mem.getAge());
			psmt.executeUpdate();
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
	}//insertMember
	// ȸ�� �̸����� �˻�
	public MemberDTO selectMemeber(String name) {
		// 1. �̸����� �˻� : JDBC ���α׷��� 6�ܰ�
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE name=?";
		// 2. MemberDTO mem �� ���� DB ���̺��� ������ ä���.
		MemberDTO mem = new MemberDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mem.setId(rs.getString("id"));
				mem.setPasswd(rs.getString("passwd"));
				mem.setName(rs.getString("name"));
				mem.setTel(rs.getString("tel"));
				mem.setAddress(rs.getString("address"));
				mem.setAge(rs.getInt("age"));
			}//if
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 3. ����
		return mem;
	}//selectMemeber
	
	// ���� ��ü ��� �޼ҵ�
	private Connection getConn() {
		final String user = "scott";
		final String password = "tiger";
		final String url = "jdbc:oracle:thin:@localhost:1521:XE";
		final String driver = "oracle.jdbc.driver.OracleDriver";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}//getConn

	public Vector allMembers() {
		Vector v = new Vector();
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// id,passwd,name,tel,address,age,regdate
			while(rs.next()) {
				Vector vRow = new Vector();
				vRow.add(rs.getString("id"));
				vRow.add(rs.getString("passwd"));
				vRow.add(rs.getString("name"));
				vRow.add(rs.getString("tel"));
				vRow.add(rs.getString("address"));
				vRow.add(rs.getString("age"));
				v.add(vRow);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}// allMembers
}//end
