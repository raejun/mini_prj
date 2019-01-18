package team07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAO {
   // ȸ�� ���� �޼ҵ�
   public void insertMember(DTO buk) {
      String sql = "INSERT INTO BUCKETLIST(rank,title,cont,pland,impled,feel,chek) " +
            "VALUES(?,?,?,?,?,?,?)";
      Connection conn = getConn();
      PreparedStatement psmt = null;
      try {
         psmt = conn.prepareStatement(sql);
         psmt.setInt(1, buk.getRank());
         psmt.setString(2, buk.getTitle());
         psmt.setString(3, buk.getCont());
         psmt.setString(4, buk.getPland());
         psmt.setString(5, buk.getImpled());
         psmt.setString(6, buk.getFeel());
         psmt.setString(7, buk.getChek());
         psmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         // 6. �ڿ� ����
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
            }
         }// if conn
      }//finally
   }//insertMember
   // ȸ�� �̸����� �˻�
   public DTO selectMemeber(String name) {
      // 1. �̸����� �˻� : JDBC ���α׷��� 6�ܰ�
      Connection conn = getConn();
      PreparedStatement psmt = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM BUCKETLIST WHERE rank=?";
      // 2. MemberDTO buk �� ���� DB ���̺��� ������ ä���.
      DTO buk = new DTO();
      try {
         psmt = conn.prepareStatement(sql);
         psmt.setString(1,name);
         rs = psmt.executeQuery();
         if(rs.next()) {
            buk.setRank(rs.getInt("rank"));
            buk.setTitle(rs.getString("title"));
            buk.setCont(rs.getString("cont"));
            buk.setPland(rs.getString("pland"));
            buk.setImpled(rs.getString("impled"));
            buk.setFeel(rs.getString("feel"));
            buk.setChek(rs.getString("chek"));
         }//if
      } catch (SQLException e) {
         e.printStackTrace();
      }
      // 3. ����
      return buk;
   }//select
   
   public boolean DeleteBuk(int rank) {
	      // 1. �̸����� �˻� : JDBC ���α׷��� 6�ܰ�
	      Connection conn = getConn();
	      PreparedStatement psmt = null;
	      boolean delOk = false;
	      String sql = "DELETE FROM bucketlist WHERE rank=?";
	      // 2. MemberDTO buk �� ���� DB ���̺��� ������ ä���.
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, rank);
	         int ok = psmt.executeUpdate();
			 if(ok==1) {
				 delOk = true;
			    System.out.println("���� �Ϸ�");
			 }else {
				System.out.println("���� ����!");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return delOk;

		}
   
   
   
   // ���� ��ü ��� �޼ҵ�
   private Connection getConn() {
      final String user = "SCOTT";
      final String password = "TIGER";
      final String url = "jdbc:oracle:thin:@192.168.113.66:1521:XE";
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
   }//getConn

   public Vector all() {
      Vector v = new Vector();
      Connection conn = getConn();
      PreparedStatement psmt = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM BUCKETLIST";
      try {
         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();
         //
         while(rs.next()) {
            Vector vRow = new Vector();
            vRow.add(rs.getInt("rank"));
            vRow.add(rs.getString("title"));
            vRow.add(rs.getString("cont"));
            vRow.add(rs.getString("pland"));
            vRow.add(rs.getString("impled"));
            vRow.add(rs.getString("feel"));
            vRow.add(rs.getString("chek"));
            v.add(vRow);
         }//while
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return v;
   }// allMembers
}//end