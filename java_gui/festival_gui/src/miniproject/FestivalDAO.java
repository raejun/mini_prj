package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FestivalDAO {

	// 저장
	public void insertFestival(FestivalDTO fest) {
		String sql = "INSERT INTO festivallineup (name, year, festival, instrumental, country, genre, explain)"
				+ "values(?,?,?,?,?,?,?)";

		Connection conn = getConn();
		PreparedStatement psmt = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, fest.getName());
			psmt.setInt(2, fest.getYear());
			psmt.setString(3, fest.getFestival());
			psmt.setInt(4, fest.getInstrumental());
			psmt.setString(5, fest.getCountry());
			psmt.setString(6, fest.getGenre());
			psmt.setString(7, fest.getExplain());

			int ok = psmt.executeUpdate();
			if (ok == 1) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
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
			} // if
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // if
		}
	}// insert

	// 검색

	public FestivalDTO selectFestival(String name) {
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM SCOTT.FESTIVALLINEUP where name = ?";

		FestivalDTO fest = new FestivalDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				fest.setName(rs.getString("name"));
				fest.setYear(rs.getInt("year"));
				fest.setFestival(rs.getString("festival"));
				fest.setInstrumental(rs.getInt("instrumental"));
				fest.setCountry(rs.getString("country"));
				fest.setGenre(rs.getString("genre"));
				fest.setExplain(rs.getString("explain"));
			} // if
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fest;
	}// SelectName

	// 삭제
	public boolean deleteFestival(String name) {

		String sql = "DELETE FROM festivallineup where name = ?";

		Connection conn = getConn();
		PreparedStatement psmt = null;

		boolean result = false;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int ok = psmt.executeUpdate();
			if (ok == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Connection getConn() {
		final String user = "SCOTT";
		final String password = "TIGER";
		final String url = "jdbc:oracle:thin:@192.168.22.98:1521:XE";
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

	}// getConn

}// end
