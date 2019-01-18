package mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MemberDAO {

	public void insertMember(MemberDTO mem) {
		String sql = "INSERT INTO member(ID, PASSWD, NAME, TEL, ADDRESS, AGE, REGDATE)"
				+ "VALUES(?,?,?,?,?,?,SYSDATE)";
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
				psmt.executeUpdate(); // 저장
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
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
		}// finally
	}//insertMember
	// 회원이름으로 검색

	public MemberDTO selectMember(String name) {
		// 1. 이름으로 검색 : JDBC 프로그래밍 6단계
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE name=?";
		// 2. MemberDTO mem을 만들어서 DB 테이블의 내용을 채움
		MemberDTO mem = new MemberDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery(); // 실행
			if (rs.next()) {
				Vector vRow = new Vector();
				mem.setId(rs.getString("id"));
				mem.setPasswd(rs.getString("passwd"));
				mem.setName(rs.getString("name"));
				mem.setTel(rs.getString("tel"));
				mem.setAddress(rs.getString("address"));
				mem.setAge(rs.getInt("age"));
			} // if
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3. 리턴
		return mem;
	}//selectMember

	// 연결 객체 얻는 매소드
	private Connection getConn() {
		final String USER = "scott";
		final String PASSWORD = "TIGER";
		final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}// getConn

	public Vector allMembers() {
		Vector v = new Vector();
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member";
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			Vector vRow = new Vector();
			while(rs.next()) {
				vRow.add(rs.getString("id"));
				vRow.add(rs.getString("passwd"));
				vRow.add(rs.getString("name"));
				vRow.add(rs.getString("tel"));
				vRow.add(rs.getString("address"));
				vRow.add(rs.getString("age"));
				v.add(vRow);
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return v;
	}//allmember
}// end
