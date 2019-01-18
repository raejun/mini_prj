package Project;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MemberDAO {
	// ȸ�� ���� �޼ҵ�
	public void insertMember(MemberDTO mem) {
		String sql = "INSERT INTO restaurant(rname, menu, tel, location, price)" +
				"VALUES(?,?,?,?,?)";
		Connection conn = getConn();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getRname());
			psmt.setString(2, mem.getMenu());
			psmt.setString(3, mem.getTel());
			psmt.setString(4, mem.getLocation());
			psmt.setInt(5, mem.getPrice());
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
	// ��ȣ������ �˻�
	public MemberDTO selectMemeber(String name) {
		// 1. ��ȣ������ �˻� : JDBC ���α׷��� 6�ܰ�
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM restaurant WHERE rname=?";
		// 2. MemberDTO mem �� ���� DB ���̺��� ������ ä���.
		MemberDTO mem = new MemberDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mem.setRname(rs.getString("rname"));
				mem.setMenu(rs.getString("menu"));
				mem.setLocation(rs.getString("location"));
				mem.setTel(rs.getString("tel"));
				mem.setPrice(rs.getInt("price"));
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
		final String password = "TIGER";
	    final String url = "jdbc:oracle:thin:@192.168.113.81:1521:XE";
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
		String sql = "SELECT * FROM restaurant";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Vector vRow = new Vector();
				vRow.add(rs.getString("rname"));
				vRow.add(rs.getString("menu"));
				vRow.add(rs.getString("location"));
				vRow.add(rs.getString("tel"));
				vRow.add(rs.getString("price"));
				v.add(vRow);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}// allMembers
}//end
