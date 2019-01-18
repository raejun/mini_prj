package Project;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MemberDAO {
	// 회원 저장 메소드
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
	}//insertMember
	// 상호명으로 검색
	public MemberDTO selectMemeber(String name) {
		// 1. 상호명으로 검색 : JDBC 프로그래밍 6단계
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM restaurant WHERE rname=?";
		// 2. MemberDTO mem 을 만들어서 DB 데이블의 내용을 채운다.
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
		// 3. 리턴
		return mem;
	}//selectMemeber
	
	// 연결 객체 얻는 메소드
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
