package HW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MusicDAO {
	public void insertMusic(MusicDTO mu) {
		String sql = "INSERT INTO music(Artist, Title, Length, Genre, Ranking, Release, Composer)"
				+ "VALUES(?,?,?,?,?,?,?)";
		Connection conn = getConn();
		PreparedStatement psmt = null;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, mu.getArtist());
				psmt.setString(2, mu.getTitle());
				psmt.setInt(3, mu.getLength());
				psmt.setString(4, mu.getGenre());
				psmt.setInt(5, mu.getRanking());
				psmt.setString(6, mu.getRelease());
				psmt.setString(7, mu.getComposer());
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
	
	// 노래 제목으로 검색
	public MusicDTO selectMusic(String Title) {
		// 1. 이름으로 검색 : JDBC 프로그래밍 6단계
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM music WHERE Artist=?";
		// 2. MusicDTO mu을 만들어서 DB 테이블의 내용을 채움
		MusicDTO mu = new MusicDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Title);
			rs = psmt.executeQuery(); // 실행
			if (rs.next()) {
				Vector vRow = new Vector();
				mu.setArtist(rs.getString("Artist"));
				mu.setTitle(rs.getString("Title"));
				mu.setLength(rs.getInt("Length"));
				mu.setGenre(rs.getString("Genre"));
				mu.setRanking(rs.getInt("Ranking"));
				mu.setRelease(rs.getString("Release"));
				mu.setComposer(rs.getString("Composer"));
			} // if
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 3. 리턴
		return mu;
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

	public Vector allMusic() {
		Vector v = new Vector();
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM music";
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Vector vRow = new Vector();
				vRow.add(rs.getString("Artist"));
				vRow.add(rs.getString("Title"));
				vRow.add(rs.getInt("Length"));
				vRow.add(rs.getString("Genre"));
				vRow.add(rs.getInt("Ranking"));
				vRow.add(rs.getString("Release"));
				vRow.add(rs.getString("Composer"));
				v.add(vRow);
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return v;
	}//allmember
	   public void updateMusic(MusicDTO mu){
		      String Artist = mu.getArtist();
		      String Title = mu.getTitle();
		      int Length = mu.getLength();
		      String Genre = mu.getGenre();
		      int Ranking = mu.getRanking();
		      String Release = mu.getRelease();
		      String Composer = mu.getComposer();
		      
		      String sql = "UPDATE music SET Artist=?, Title=?, Length=?, Genre=?, Ranking=?, Release=?, Composer=? WHERE Artist=?";
		      PreparedStatement psmt = null;
		      Connection conn = getConn();
		      //위 문장을 나중에 
		      try {
		         Class.forName("oracle.jdbc.driver.OracleDriver");
		         
		         psmt = conn.prepareStatement(sql);
		         psmt.setString(1, Artist);
		         psmt.setString(2, Title);
		         psmt.setInt(3, Length);
		         psmt.setString(4, Genre);
		         psmt.setInt(5, Ranking);
		         psmt.setString(6, Release);
		         psmt.setString(7, Composer);
		         psmt.setString(8, Artist);

		         //where절이 들어가있으므로 Id와 passwd가 맞는 경우에 수정할 수 있음을 의미
		         int ok = psmt.executeUpdate();
		         if(ok ==1) {
		            System.out.println("음악 정보가 수정되었습니다");
		         } else {
		            System.out.println("수정 실패");
		         }
		         
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
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
		            }//if conn
		         }
		      }//finally
		   }//Update
		      
		   
		   public void deleteMusic(MusicDTO mu) {
			  String user = "scott";
		      String password = "TIGER";
		      String url = "jdbc:oracle:thin:@192.168.113.50:1521:XE";
		      Connection conn = getConn();
		      PreparedStatement psmt = null;
		      //String i_ar = getText;
		      //String i_ti
		    		  
		      String sql = "DELETE FROM music where artist = ? and title= ? ";
		      try {
		         Class.forName("oracle.jdbc.driver.OracleDriver");//프로젝트 같은 대용량 처리시 연결 메소드를 활용하여 관리
		         conn=DriverManager.getConnection(url, user, password);

		         psmt = conn.prepareStatement(sql);
		         //prepareStatement에 대한 내용 보충할 것
		         psmt.setString(1, mu.getArtist());
		         psmt.setString(2, mu.getTitle());
		         
		         int ok = psmt.executeUpdate();
//		         if (ok == 1) {
//		            System.out.println("정보 삭제 완료");
//		         } else {
//		            System.out.println("삭제 실패");
//		         }
//		     
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		   }
		   
}// end

