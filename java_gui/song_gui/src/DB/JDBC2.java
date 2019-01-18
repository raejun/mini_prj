package DB;

import java.sql.*;

public class JDBC2 {
	public static void main(String[] args) {
		// 접속 정보
		String user = "scott";
		String pw = "TIGER";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// 연결 객체
		Connection conn = null;
		// 명령 객체
		PreparedStatement psmt = null;
		// SQL
		String sql = "INSERT INTO member(ID, PASSWD, NAME, TEL, ADDRESS, AGE, REGDATE)"
				+ "VALUES(?,?,?,?,?,?,SYSDATE)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 1. 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pw);// 2. 연결
			// 3. 명령 준비
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "im");
			psmt.setString(2, "abcd");
			psmt.setString(3, "임꺽정");
			psmt.setString(4, "010-2222-3333");
			psmt.setString(5, "방배");
			psmt.setInt(6, 26);
			//실행
			int ok = psmt.executeUpdate();
			if(ok==1) {
				System.out.println("저장 성공");
			}else {
				System.out.println("저장실패");
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
