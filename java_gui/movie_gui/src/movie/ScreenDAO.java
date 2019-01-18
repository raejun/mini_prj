package movie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ScreenDAO {

   private Connection getConn() {
      final String user = "SCOTT";
      final String password = "TIGER";
      final String url = "jdbc:oracle:thin:@192.168.113.2:1521:XE";
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
   
   public void insertScreenTerm(ScreenDTO screen) {
      
      String sql = "INSERT INTO SCREEN_TERM(SCREEN_CODE, MOVIE_CODE, TERM_SRTDATE, TERM_ENDDATE) "
               + "VALUES(?, ?, ?, ?)";
      Connection conn = getConn();
      PreparedStatement pstmt = null;
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, screen.getScreenCode());
         pstmt.setString(2, screen.getMovieCode());
         pstmt.setDate(3, (Date) screen.getSrtDate());
         pstmt.setDate(4, (Date) screen.getEndDate());
         
         pstmt.executeUpdate();
         
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
         if(conn != null ) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      
   }

}