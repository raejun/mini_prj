package DB;
import java.sql.*;
public class JDBC1 {
	String str; //자동으로 null값이 됨
	public static void main(String[] args) {
		//접속 정보
		String user ="scott";
		String pw = "TIGER";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		//연결 객체
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from emp";
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("성공ㅎㅎ");
			
			//2. 연결
			conn=DriverManager.getConnection(url,user,pw);
			System.out.println("연결 성공");
			
			//3.명령 성공
			psmt = conn.prepareStatement(sql);
			System.out.println("명령 준비 성공");
			
			//4. 실행
			rs = psmt.executeQuery();//select 문은 excute 문으로 실행
			System.out.println("실행 성공!");
			//System.out.println("rs = "+rs);
			
			//5. rs결과 출력
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				System.out.println("empno= "+empno+", ename= "+ename+", job= "+job+" mgr= "+mgr);
			}
			System.out.println("결과 출력");
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 X");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결실패");
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
