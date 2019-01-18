package book;

import java.sql.*;
import book.*;
import java.util.Vector;

import javax.swing.JOptionPane;

import book.BookDTO;

//책저장
public class BookDAO {
	
		public void insertBook(BookDTO boo) {
		String sql="insert into book(title,origin_title,writer,language,publish_year)"
				+"values(?,?,?,?,?)";
		Connection conn =getConn();
		PreparedStatement psmt=null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, boo.getTitle());
			psmt.setString(2, boo.getOrigin_title());
			psmt.setString(3, boo.getWriter());
			psmt.setString(4, boo.getLanguage());
			psmt.setInt(5, boo.getPublish_year());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}	//insert Book
	
		//책검색
		public Vector selectBook(String title) {
			Vector v = new Vector();
			//1. 이름으로 검색	: JDBC 프로그래밍 6단계
			Connection conn=getConn();
			PreparedStatement psmt=null;
			ResultSet rs=null;
			String sql="select * from book where title=?";
			try {
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, title);
				rs = psmt.executeQuery();
				if(rs.next()) {
					Vector vRow = new Vector();
					vRow.add(rs.getString("title"));
					vRow.add(rs.getString("origin_title"));
					vRow.add(rs.getString("writer"));
					vRow.add(rs.getString("language"));
					vRow.add(rs.getInt("publish_year"));
					v.add(vRow);
				}	//if
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//3. 리턴
			return v;
		}//selectBook
		
		public void updateBook(BookDTO boo) {
			System.out.println(boo);
			String sql="update book set origin_title=?, writer=?, "
						+ " language=?, publish_year=? where title=?";
			Connection conn =getConn();
			PreparedStatement psmt=null;
			try {
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, boo.getOrigin_title());
				psmt.setString(2, boo.getWriter());
				psmt.setString(3, boo.getLanguage());
				psmt.setInt(4, boo.getPublish_year());
				psmt.setString(5, boo.getTitle());
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}//update
		
		//삭제
		public boolean deleteBook(BookDTO boo) {
			String sql="delete from book where title=? and writer=?";
			Connection conn =getConn();
			PreparedStatement psmt=null;
			boolean result =false;
			try {
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, boo.getTitle());
				psmt.setString(2, boo.getOrigin_title());
				int ok=psmt.executeUpdate();
				if(ok==1) {
					result=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
			
		}
		
		public BookDTO selectMember(String title) {
			//1. 이름으로 검색	: JDBC 프로그래밍 6단계
			Connection conn=getConn();
			PreparedStatement psmt=null;
			ResultSet rs=null;
			String sql="select * from member where title=?";
			//2. MemberDTO mem 을 만들어서 DB 테이블의 내용을 채운다.
			BookDTO boo=new BookDTO();
			try {
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, title);
				rs = psmt.executeQuery();
				if(rs.next()) {
					boo.setTitle(rs.getString("title"));
					boo.setOrigin_title(rs.getString("origin_title"));
					boo.setWriter(rs.getString("writer"));
					boo.setLanguage(rs.getString("language"));
					boo.setPublish_year(rs.getInt("publish_year"));
				}	//if
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//3. 리턴
			return boo;
		}
		
		


	//연결 객체가 얻는 메소드
	private Connection getConn() {
		final String user="scott";
		final String password="TIGER";
		final String url="jdbc:oracle:thin:@192.168.113.87:1521:XE";
		final String driver = "oracle.jdbc.driver.OracleDriver";
		Connection conn=null;
		try {
			Class.forName(driver);
			conn =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}//getConn
	
	public Vector allBooks() {
		Vector v = new Vector();
		Connection conn=getConn();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select * from book";
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			//title,origin_title,writer,language,publish_year
			while(rs.next()){
				Vector vRow=new Vector();
				vRow.add(rs.getString("title"));
				vRow.add(rs.getString("origin_title"));
				vRow.add(rs.getString("writer"));
				vRow.add(rs.getString("language"));
				vRow.add(rs.getInt("publish_year"));
				v.add(vRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}	//allBook
	
}//end
