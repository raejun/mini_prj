package book;

import java.sql.*;

import book.MemberDTO;

public class MemberDAO {
   public void insertMember(MemberDTO mem) {
      String sql = "INSERT INTO member(id,password,name) " +
            "VALUES(?,?,?)";
      Connection conn = getConn();
      PreparedStatement psmt = null;
      try {
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, mem.getId());
         psmt.setString(2, mem.getPassword());
         psmt.setString(3, mem.getName());
         psmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         // 6. 자원 해제
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
            } 
         catch (SQLException e) {
               e.printStackTrace();
            }
         }// if conn
      }//finally
   } //Insert
      
      public boolean deleteMember(MemberDTO mem) {
           String sql="delete from member where id=? and password=? and name=?" ;
           Connection conn =getConn();
           PreparedStatement psmt=null;
           boolean result =false;
           try {
              psmt=conn.prepareStatement(sql);
              psmt.setString(1, mem.getId());
              psmt.setString(2, mem.getPassword());
              psmt.setString(3, mem.getName());
              int ok=psmt.executeUpdate();
              if(ok==1) {
                 result=true;
              }
           }catch (SQLException e) {
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
           } // finally
           return result;  
   } //delete
   
   
      private Connection getConn() {
         final String user = "SCOTT";
         final String password = "TIGER";
         final String url = "jdbc:oracle:thin:@192.168.113.87:1521:XE";
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
   
      
   } // 생성자
 //end