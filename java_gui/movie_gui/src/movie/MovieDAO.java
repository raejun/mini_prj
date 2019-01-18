package movie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MovieDAO {

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

	public void insertMovie(MovieDTO mv) {
		String sql = "INSERT INTO movie(MOVIE_CODE, MOVIE_TITLE, DIRECT_NAME, GENRE, GRADE, ACTS, "
				+ "MOVIE_RUNTIME, MOVIE_COMPANY, MOVIE_OPENDATE, MOVIE_CONTENTS ) " + "VALUES(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = getConn();
		PreparedStatement psmt = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mv.getMovieCode());
			psmt.setString(2, mv.getMovieTitle());
			psmt.setString(3, mv.getDirectName());
			psmt.setString(4, mv.getGenre());
			psmt.setString(5, mv.getGrade());
			psmt.setString(6, mv.getActs());
			psmt.setString(7, mv.getMovieRunTime());
			psmt.setString(8, mv.getMovieCompany());
			psmt.setDate(9, (Date) mv.getMovieOpendate());
			psmt.setString(10, mv.getMovieContents());
			// 실행단계
			System.out.println(mv.getMovieCode());
			System.out.println(mv.getMovieTitle());
			System.out.println(mv.getDirectName());
			System.out.println(mv.getGenre());
			System.out.println(mv.getGrade());
			System.out.println(mv.getActs());
			System.out.println(mv.getMovieRunTime());
			System.out.println(mv.getMovieCompany());
			System.out.println(mv.getMovieOpendate());
			System.out.println(mv.getMovieContents());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public MovieDTO selectMovie(String MovieTitle) {
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM movie WHERE MOVIE_TITLE=?";
		MovieDTO mv = new MovieDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, MovieTitle);
			rs = psmt.executeQuery();
			if (rs.next()) {
				mv.setMovieCode(rs.getString("MOVIE_CODE"));
				mv.setMovieTitle(rs.getString("MOVIE_TITLE"));
				mv.setDirectName(rs.getString("DIRECT_NAME"));
				mv.setGenre(rs.getString("GENRE"));
				mv.setGrade(rs.getString("GRADE"));
				mv.setActs(rs.getString("ACTS"));
				mv.setMovieRunTime(rs.getString("MOVIE_RUNTIME"));
				mv.setMovieCompany(rs.getString("MOVIE_COMPANY"));
				mv.setMovieOpendate(rs.getDate("MOVIE_OPENDATE"));
				mv.setMovieContents(rs.getString("MOVIE_CONTENTS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

	public void updateMovie(MovieDTO mv) {
		Connection conn = getConn();
		PreparedStatement psmt = null;
		String sql = "UPDATE movie SET MOVIE_OPENDATE=?, MOVIE_CONTENTS=?" + "WHERE MOVIE_TITLE=? AND MOVIE_CODE=?";
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setDate(1, mv.getMovieOpendate());
			psmt.setString(2, mv.getMovieContents());
			psmt.setString(3, mv.getMovieTitle());
			psmt.setString(4, mv.getMovieCode());

			System.out.println(mv.getMovieOpendate());
			System.out.println(mv.getMovieContents());
			System.out.println(mv.getMovieTitle());
			System.out.println(mv.getMovieCode());

			psmt.executeUpdate();

		} catch (SQLException e) {
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void deleteMovie(MovieDTO mv) {
		Connection conn = getConn();
		PreparedStatement psmt = null;
		String sql = "DELETE FROM movie WHERE MOVIE_TITLE=? AND MOVIE_CODE=?";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mv.getMovieTitle());
			psmt.setString(2, mv.getMovieCode());

			System.out.println(mv.getMovieCode());
			System.out.println(mv.getMovieTitle());

			psmt.executeUpdate();

		} catch (SQLException e) {
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Vector allMovies() {
		Vector v = new Vector();
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM movie";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			Vector vRow = new Vector();
			while (rs.next()) {
				vRow.add(rs.getString("MOVIE_CODE"));
				vRow.add(rs.getString("MOVIE_TITLE"));
				vRow.add(rs.getString("DIRECT_NAME"));
				vRow.add(rs.getString("GENRE"));
				vRow.add(rs.getString("GRADE"));
				vRow.add(rs.getString("ACTS"));
				vRow.add(rs.getString("MOVIE_RUNTIME"));
				vRow.add(rs.getString("MOVIE_COMPANY"));
				vRow.add(rs.getDate("MOVIE_OPENDATE"));
				vRow.add(rs.getString("MOVIE_CONTENTS"));
				v.add(vRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
	public MovieDTO selectCodeCheck(String movieCode) {
		Connection conn = getConn();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "SELECT MOVIE_CODE FROM movie WHERE MOVIE_CODE=?";
		MovieDTO mv = new MovieDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieCode);
			rs = psmt.executeQuery();
			if (rs.next()) {
				mv.setMovieCode(rs.getString("MOVIE_CODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mv;
	}
}// end