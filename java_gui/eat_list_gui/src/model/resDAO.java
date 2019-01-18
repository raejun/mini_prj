package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class resDAO {
	
	public int deleteRes(resDTO res) {
		String sql = "DELETE FROM res WHERE resname = ? AND address = ?";
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res.getResName());
			pstmt.setString(2, res.getAddress());
			int rs = pstmt.executeUpdate();
			if(rs == 1) {
				return 2;
			} else {
				return 0;
			}
			
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
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
		return 9;
	}
	
	public int updateRes(resDTO res) {
		String sql = "UPDATE res " + "SET address = ?, tel = ?, reprmenu = ?, price = ?"
				+ "WHERE resname = ?";
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res.getAddress());
			pstmt.setString(2, res.getTel());
			pstmt.setString(3, res.getReprMenu());
			pstmt.setInt(4, res.getPrice());
			pstmt.setString(5, res.getResName());
			int rs = pstmt.executeUpdate();
			if(rs == 1) {
				return 2;
			} else {
				return 0;
			}
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
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
		return 9;
	}
	
	public void insertRes(resDTO res) {
		String sql = "insert into res(resname,address,tel,reprmenu,price) " + "values (?,?,?,?,?)";
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res.getResName());
			pstmt.setString(2, res.getAddress());
			pstmt.setString(3, res.getTel());
			pstmt.setString(4, res.getReprMenu());
			pstmt.setInt(5, res.getPrice());
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
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
		
	}
	
	public resDTO selectRes(String name) {
		// 1. 이름으로 검색
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM res WHERE resname=?";
		resDTO res = new resDTO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res.setResName(rs.getString("resname"));
				res.setAddress(rs.getString("address"));
				res.setTel(rs.getString("tel"));
				res.setReprMenu(rs.getString("reprmenu"));
				res.setPrice(Integer.parseInt(rs.getString("price")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		// 3. 리턴
		return res;
	}
	
	private Connection getConn() {
		final String user = "SCOTT";
		final String password = "TIGER";
		final String url = "jdbc:oracle:thin:@192.168.22.181:1521:XE";
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
	
	public Vector allRes() {
		Vector v = new Vector();
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM res";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vRow = new Vector();
				vRow.add(rs.getString("resname"));
				vRow.add(rs.getString("address"));
				vRow.add(rs.getString("tel"));
				vRow.add(rs.getString("reprmenu"));
				vRow.add(rs.getInt("price"));
				v.add(vRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
	public Vector allMylist() {
		Vector v = new Vector();
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM mylist";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vRow = new Vector();
				vRow.add(rs.getString("resname"));
				vRow.add(rs.getString("address"));
				vRow.add(rs.getString("tel"));
				vRow.add(rs.getString("reprmenu"));
				vRow.add(rs.getInt("price"));
				v.add(vRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}
}
