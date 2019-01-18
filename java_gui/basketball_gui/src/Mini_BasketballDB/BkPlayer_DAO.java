package Mini_BasketballDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class BkPlayer_DAO {
	// 1. 연결 객체를 메소드로 생성
	private Connection getConn() {
		final String user = "SCOTT";
		final String password = "TIGER";
		final String url = "jdbc:oracle:thin:@192.168.22.76:1521:XE"; // SQL 실행해줘야 함
		final String driver = "oracle.jdbc.driver.OracleDriver";

		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user,  password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	} //getConn
	
	
	//2. DAO 생성 : 객체를 데이터 베이스에 처리하는 역할 CRUD
		// 2-1) insert --------------------------------
		public void insertPlayer(BkPlayer_DTO plyr, BkPlayerInf_DTO plyr2) {
			// (1) 연결 객체
			Connection conn = getConn();
			// (2) 명령 객체 
			PreparedStatement psmt = null;
			PreparedStatement psmt2 = null;
			String sql = "INSERT INTO PLAYERSTAT(PLAYER,SEASON,P3P, P2P, FTP, TRB, AST, STL, BLK, TOV, PTS)" +
					 "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			String sql2 = "INSERT INTO PLAYER(PLAYER,SEASON,PSAL)" +
					 "VALUES(?,?,?)";
			try {
				// (3) 명령 준비
				psmt = conn.prepareStatement(sql);
				psmt2 = conn.prepareStatement(sql2);
					// 데이터 import by DTO
					psmt.setString(1, plyr.getPlayer());	
					psmt.setString(2, plyr.getSeason());
					psmt.setDouble(3, plyr.getP3p());
					psmt.setDouble(4, plyr.getP2p());
					psmt.setDouble(5, plyr.getFtp());
					psmt.setDouble(6, plyr.getTrb());
					psmt.setDouble(7, plyr.getAst());
					psmt.setDouble(8, plyr.getStl());
					psmt.setDouble(9, plyr.getBlk());
					psmt.setDouble(10, plyr.getTov());
					psmt.setDouble(11, plyr.getPts());
					
					psmt2.setString(1, plyr2.getPlayer());	
					psmt2.setString(2, plyr2.getSeason());
					psmt2.setDouble(3, plyr2.getPsal());
					
					// (4) 실행
					psmt.executeUpdate();
					psmt2.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // 자원 해제
				// closing 2. psmt 
				if ( psmt != null) {
					try {
						psmt.close();
						psmt2.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				// closing 1. conn
				if ( conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
			}
		}//insert_end
		
		// 2-2) DTO_1_Select --------------------------------
		public BkPlayer_DTO selectPlayer(String player, String Season) {
			// 1) 이름으로 검색 : JDBC 프로그래밍 6단계 
			Connection conn = getConn();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			String sql = "SELECT p.player, p.season, p.p3p, p.p2p, p.ftp, p.trb, p.ast, p.stl, p.blk, p.tov, p.pts, s.psal"
					+ " FROM playerstat p, player s"
					+ " WHERE p.player = s.player"
					+ " AND p.PLAYER = ?"
					+ " AND p.SEASON = ?";
			
			// 2) BkPlayer_DTO plyr을 만들어서 DB테이블의 내용을 채운다.
			BkPlayer_DTO plyr = new BkPlayer_DTO();
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, player); //sql문의 ?를 채울 것
				psmt.setString(2, Season); //sql문의 ?를 채울 것
				rs = psmt.executeQuery();
				if(rs.next()) {//사람이 없을 수 있음에 조건문으로 처리
					plyr.setPlayer(rs.getString("Player"));
					plyr.setSeason(rs.getString("Season"));
					plyr.setP3p(rs.getInt("P3p"));
					plyr.setP2p(rs.getInt("P2p"));
					plyr.setFtp(rs.getInt("Ftp"));
					plyr.setTrb(rs.getInt("Trb"));
					plyr.setAst(rs.getInt("Ast"));
					plyr.setStl(rs.getInt("Stl"));
					plyr.setBlk(rs.getInt("Blk"));
					plyr.setTov(rs.getInt("Tov"));
					plyr.setPts(rs.getInt("Pts"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // 자원 해제
				// closing 2. psmt 
				if ( psmt != null) {
					try {
						psmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				// closing 1. conn
				if ( conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
			}
			// 3) Value Return
			return plyr;
		} // select_end
		
		// 2-2) DTO_1_Select --------------------------------
		public BkPlayerInf_DTO selectPlayer2(String player, String Season) {
			// 1) 이름으로 검색 : JDBC 프로그래밍 6단계 
			Connection conn = getConn();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			String sql = "SELECT p.player, p.season, p.p3p, p.p2p, p.ftp, p.trb, p.ast, p.stl, p.blk, p.tov, p.pts, s.psal"
					+ " FROM playerstat p, player s"
					+ " WHERE p.player = s.player"
					+ " AND p.PLAYER = ?"
					+ " AND p.SEASON = ?";
			
			// 2) BkPlayer_DTO plyr을 만들어서 DB테이블의 내용을 채운다.
			BkPlayerInf_DTO plyr = new BkPlayerInf_DTO();
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, player); //sql문의 ?를 채울 것
				psmt.setString(2, Season); //sql문의 ?를 채울 것
				rs = psmt.executeQuery();
				if(rs.next()) {//사람이 없을 수 있음에 조건문으로 처리
					plyr.setPlayer(rs.getString("Player"));
					plyr.setSeason(rs.getString("Season"));
					plyr.setPsal(rs.getInt("Psal"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // 자원 해제
				// closing 2. psmt 
				if ( psmt != null) {
					try {
						psmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				// closing 1. conn
				if ( conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
			}
			// 3) Value Return
			return plyr;
		} // select_end
		
		
		// 2-3) Delete --------------------------------
		public void deletePlayer(BkPlayer_DTO plyr) {
			// 객체 연결
			Connection conn = getConn();
			// 명령객체 준비
			PreparedStatement psmt = null;
			// 명령객체 작성
			String sql = "DELETE FROM playerstat WHERE player =? AND season =?";
			
			try {
			// 명령 객체에 담기
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, plyr.getPlayer());	 // DTO에서 불러오는게 아니라 입력값에서 바로 불러와야 할 것 같은데?
				psmt.setString(2, plyr.getSeason());

				// 4) 실행
				int ok = psmt.executeUpdate(); 
					if(ok == 1) {
						System.out.println("기록 삭제 완료 :D");
					} else {
						System.out.println("기록 삭제 실패 :X");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // 자원 해제
				// closing 2. psmt 
				if ( psmt != null) {
					try {
						psmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				// closing 1. conn
				if ( conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
			}
		}// delete_end
		
		// 2-4) View All --------------------------------
		public Vector allPlayers() {
			Vector v = new Vector();
			Connection conn = getConn();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM playerstat";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					Vector vRow = new Vector();
					vRow.add(rs.getString("player"));
					vRow.add(rs.getString("season"));
					vRow.add(rs.getInt("p3p"));
					vRow.add(rs.getInt("p2p"));
					vRow.add(rs.getInt("ftp"));		
					vRow.add(rs.getInt("trb"));		
					vRow.add(rs.getInt("ast"));		
					vRow.add(rs.getInt("stl"));		
					vRow.add(rs.getInt("blk"));		
					vRow.add(rs.getInt("tov"));		
					vRow.add(rs.getInt("pts"));	
					
					v.add(vRow);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // 자원 해제
				// closing 2. psmt 
				if ( psmt != null) {
					try {
						psmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				// closing 1. conn
				if ( conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
			}
			return v;
		}//all_end
		
		// 2-4) View palyer all --------------------------------
		public Vector PlayerSal() {
			Vector v = new Vector();
			Connection conn = getConn();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM player";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					Vector vRow = new Vector();
					vRow.add(rs.getString("player"));
					vRow.add(rs.getString("season"));
					vRow.add(rs.getInt("psal"));
					
					v.add(vRow);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // 자원 해제
				// closing 2. psmt 
				if ( psmt != null) {
					try {
						psmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				// closing 1. conn
				if ( conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
			}
			return v;
		}//all_end
		
		
		// 2-5) Update	--------------------------------
		public void updatePlayer(BkPlayer_DTO plyr) {
			Connection conn = getConn();
			PreparedStatement psmt = null;
			String sql = "UPDATE playerstat " 
					+ "SET p3p =?, p2p =?, ftp =?, trb =?, ast = ?, stl = ? , blk = ?, tov = ?, pts = ?" 
					+ "WHERE player =? AND season =?"; // id와 pwd모두 맞아야 하기에 And
					// +로 연결시 UPDATE member에 space 한칸 추가 주의!
			try {
				psmt = conn.prepareStatement(sql);
				// 데이터 import by DTO
				psmt.setDouble(1, plyr.getP3p());
				psmt.setDouble(2, plyr.getP2p());
				psmt.setDouble(3, plyr.getFtp());
				psmt.setDouble(4, plyr.getTrb());
				psmt.setDouble(5, plyr.getAst());
				psmt.setDouble(6, plyr.getStl());
				psmt.setDouble(7, plyr.getBlk());
				psmt.setDouble(8, plyr.getTov());
				psmt.setDouble(9, plyr.getPts());
				psmt.setString(10, plyr.getPlayer());	
				psmt.setString(11, plyr.getSeason());
				
				// 4) 실행
				// int ok : 저장 실패 여부에 따라 1,0으로만 결과가 산출됨
				int ok = psmt.executeUpdate(); 
					if(ok == 1) {
						System.out.println("회원 정보가 수정되었습니다");
					} else {
						System.out.println("수정 실패 :p");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // 자원 해제
				// closing 2. psmt 
				if ( psmt != null) {
					try {
						psmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				// closing 1. conn
				if ( conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}//Update_end 
		
}//end
