package Mini_BasketballDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class BkPlayer_DAO {
	// 1. ���� ��ü�� �޼ҵ�� ����
	private Connection getConn() {
		final String user = "SCOTT";
		final String password = "TIGER";
		final String url = "jdbc:oracle:thin:@192.168.22.76:1521:XE"; // SQL ��������� ��
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
	
	
	//2. DAO ���� : ��ü�� ������ ���̽��� ó���ϴ� ���� CRUD
		// 2-1) insert --------------------------------
		public void insertPlayer(BkPlayer_DTO plyr, BkPlayerInf_DTO plyr2) {
			// (1) ���� ��ü
			Connection conn = getConn();
			// (2) ��� ��ü 
			PreparedStatement psmt = null;
			PreparedStatement psmt2 = null;
			String sql = "INSERT INTO PLAYERSTAT(PLAYER,SEASON,P3P, P2P, FTP, TRB, AST, STL, BLK, TOV, PTS)" +
					 "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			String sql2 = "INSERT INTO PLAYER(PLAYER,SEASON,PSAL)" +
					 "VALUES(?,?,?)";
			try {
				// (3) ��� �غ�
				psmt = conn.prepareStatement(sql);
				psmt2 = conn.prepareStatement(sql2);
					// ������ import by DTO
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
					
					// (4) ����
					psmt.executeUpdate();
					psmt2.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // �ڿ� ����
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
			// 1) �̸����� �˻� : JDBC ���α׷��� 6�ܰ� 
			Connection conn = getConn();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			String sql = "SELECT p.player, p.season, p.p3p, p.p2p, p.ftp, p.trb, p.ast, p.stl, p.blk, p.tov, p.pts, s.psal"
					+ " FROM playerstat p, player s"
					+ " WHERE p.player = s.player"
					+ " AND p.PLAYER = ?"
					+ " AND p.SEASON = ?";
			
			// 2) BkPlayer_DTO plyr�� ���� DB���̺��� ������ ä���.
			BkPlayer_DTO plyr = new BkPlayer_DTO();
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, player); //sql���� ?�� ä�� ��
				psmt.setString(2, Season); //sql���� ?�� ä�� ��
				rs = psmt.executeQuery();
				if(rs.next()) {//����� ���� �� ������ ���ǹ����� ó��
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
			} finally { // �ڿ� ����
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
			// 1) �̸����� �˻� : JDBC ���α׷��� 6�ܰ� 
			Connection conn = getConn();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			String sql = "SELECT p.player, p.season, p.p3p, p.p2p, p.ftp, p.trb, p.ast, p.stl, p.blk, p.tov, p.pts, s.psal"
					+ " FROM playerstat p, player s"
					+ " WHERE p.player = s.player"
					+ " AND p.PLAYER = ?"
					+ " AND p.SEASON = ?";
			
			// 2) BkPlayer_DTO plyr�� ���� DB���̺��� ������ ä���.
			BkPlayerInf_DTO plyr = new BkPlayerInf_DTO();
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, player); //sql���� ?�� ä�� ��
				psmt.setString(2, Season); //sql���� ?�� ä�� ��
				rs = psmt.executeQuery();
				if(rs.next()) {//����� ���� �� ������ ���ǹ����� ó��
					plyr.setPlayer(rs.getString("Player"));
					plyr.setSeason(rs.getString("Season"));
					plyr.setPsal(rs.getInt("Psal"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // �ڿ� ����
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
			// ��ü ����
			Connection conn = getConn();
			// ��ɰ�ü �غ�
			PreparedStatement psmt = null;
			// ��ɰ�ü �ۼ�
			String sql = "DELETE FROM playerstat WHERE player =? AND season =?";
			
			try {
			// ��� ��ü�� ���
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, plyr.getPlayer());	 // DTO���� �ҷ����°� �ƴ϶� �Է°����� �ٷ� �ҷ��;� �� �� ������?
				psmt.setString(2, plyr.getSeason());

				// 4) ����
				int ok = psmt.executeUpdate(); 
					if(ok == 1) {
						System.out.println("��� ���� �Ϸ� :D");
					} else {
						System.out.println("��� ���� ���� :X");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // �ڿ� ����
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
			} finally { // �ڿ� ����
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
			} finally { // �ڿ� ����
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
					+ "WHERE player =? AND season =?"; // id�� pwd��� �¾ƾ� �ϱ⿡ And
					// +�� ����� UPDATE member�� space ��ĭ �߰� ����!
			try {
				psmt = conn.prepareStatement(sql);
				// ������ import by DTO
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
				
				// 4) ����
				// int ok : ���� ���� ���ο� ���� 1,0���θ� ����� �����
				int ok = psmt.executeUpdate(); 
					if(ok == 1) {
						System.out.println("ȸ�� ������ �����Ǿ����ϴ�");
					} else {
						System.out.println("���� ���� :p");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // �ڿ� ����
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
