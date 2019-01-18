package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {
	public String signin(userDTO usr) {
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT pw FROM usr WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usr.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(usr.getPw().equals(rs.getString("pw"))) {
					System.out.println("로그인 성공");
					if(usr.getId().equals("admin")) {
						return "2";
					} else if (!usr.getId().equals("admin")){
						return "3";
					} else {
						System.out.println("id와 pw를 확인해주세요.");
					}
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
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
		}
		return "1";
	}
	
	private Connection getConn() {
		final String user = "SCOTT";
		final String password = "TIGER";
		final String url = "jdbc:oracle:thin:@192.168.22.181:1521:XE";
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
	}
	
}
