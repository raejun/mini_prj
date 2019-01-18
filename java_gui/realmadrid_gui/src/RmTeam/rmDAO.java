package RmTeam;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

public class rmDAO {

	// 저장메소드
	public void insertRm(rmDTO rd) {
		String sql = "INSERT INTO rmTeam(P_ID, NAME ,HEIGHT ,WEIGHT ,AGE ,POSITION, NATION, JDATE)"
				+ "VALUES(?,?,?,?,?,?,?,SYSDATE)";

		Connection conn = getConn();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rd.getP_id());
			psmt.setString(2, rd.getName());
			psmt.setString(3, rd.getHeight());
			psmt.setString(4, rd.getWeight());
			psmt.setInt(5, rd.getAge());
			psmt.setString(6, rd.getPosition());
			psmt.setString(7, rd.getNation());
			psmt.executeUpdate();
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
	}
	public boolean UpdateRm(rmDTO rd) {
		boolean ok = false;
		Connection conn = getConn();
		PreparedStatement psmt = null;
		String sql = "UPDATE rmTeam " + "SET height=?, weight=?, age=?, position=?, nation=? "
				+ "WHERE p_id=? AND name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rd.getHeight());
			psmt.setString(2, rd.getWeight());
			psmt.setInt(3, rd.getAge());
			psmt.setString(4, rd.getPosition());
			psmt.setString(5, rd.getNation());
			psmt.setString(6, rd.getP_id());
			psmt.setString(7, rd.getName());
			int aaa = psmt.executeUpdate();
			if (aaa == 1) {
				ok = true;
				System.out.println("정보가 수정 되었습니다.");
			} else {
				System.out.println("수정 실패!");
			}
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
		return ok;
	}
	public boolean DeleteRm(rmDTO rd) {
		boolean ok = false;
		Connection conn = getConn();
		PreparedStatement psmt = null;
		String sql = "DELETE FROM rmTeam where NAME = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rd.getName());
			int bbb = psmt.executeUpdate();
			if (bbb == 1) {
				ok = true;
				System.out.println("선수가 삭제 되었습니다.");
			} else {
				System.out.println("삭제 실패!");
			}
		} catch (SQLException e) {
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
		return ok;
	}

	public rmDTO selectRm(String name) {
		// 1.이름으로 검색
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RmTeam WHERE NAME LIKE ?"; // 한글자 써도 검색 되도록 LIKE
		// 2.rmDTO rd를 만들어서 db 데이터 테이블의 내용을 채운다.
		rmDTO rd = new rmDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name + "%"); // 한글자 써도 검색 되도록
			rs = psmt.executeQuery();
			if (rs.next()) {
				rd.setP_id(rs.getString("P_id"));
				rd.setName(rs.getString("name"));
				rd.setHeight(rs.getString("height"));
				rd.setWeight(rs.getString("weight"));
				rd.setAge(rs.getInt("age"));
				rd.setPosition(rs.getString("position"));
				rd.setNation(rs.getString("nation"));
			} // if
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3.리턴
		return rd;
	}// select

	// 연결 객체 얻는 메소드
	private Connection getConn() {
		final String user = "scott";
		final String pw = "TIGER";
		final String url = "jdbc:oracle:thin:@192.168.113.58:1521:XE";
		final String driver = "oracle.jdbc.driver.OracleDriver";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}// getConn

	public Vector allrms() {
		Vector v = new Vector();
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM rmTeam";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Vector vRow = new Vector();
				vRow.add(rs.getString("p_id"));
				vRow.add(rs.getString("name"));
				vRow.add(rs.getString("height"));
				vRow.add(rs.getString("weight"));
				vRow.add(rs.getString("age"));
				vRow.add(rs.getString("position"));
				vRow.add(rs.getString("nation"));
				v.add(vRow);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}// allrms
}// class
