package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class DAO {
	public static final String USER = "SCOTT";
	public static final String PASSWORD = "TIGER";
	public static final String URL = "jdbc:oracle:thin:@192.168.22.177:1521:XE";
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//회원가입
	public void insertMember(SignUpDTO suMem) {
		String sql = "INSERT INTO mmember(id, passwd, nickname, subway)" + "VALUES(?,?,?,?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, suMem.getId());
			psmt.setString(2, suMem.getPw());
			psmt.setString(3, suMem.getNickname());
			psmt.setString(4, suMem.getSub());
			
			int ok = psmt.executeUpdate();
			
			if(ok == 1) {
				System.out.println("성공");
				conn.commit();
			}else {
				System.out.println("실패");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//로그인
	public int signin(SignInDTO siMem) {
		String sql = "SELECT passwd FROM mmember WHERE id =? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int a = 0;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, siMem.getId());
			rs = psmt.executeQuery();
            if (rs.next()) // 입력된 아이디에 해당하는 비번 있을경우
            {
            	if(siMem.getPw().equals(rs.getString("passwd"))) {
            		System.out.println("로그인 성공!");
            		a = 1;
            	}else {
            		System.out.println("로그인 실패!");
            		a = 0;
            	}
            }

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return a;
	}
	
	//정보검색
	public String[] selectinfo(ImportInfo i) {
		String sql = "SELECT * FROM mmember WHERE id =? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String[] temp = new String[2];
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, i.getId());
			rs = psmt.executeQuery();
            if (rs.next())
            {
            	temp[0] = rs.getString("nickname");
            	temp[1] = rs.getString("subway");
            }

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;				
	}
	
	//가까운 역 찾기
	public String[] recommemdMarket(RecommendDTO r){
		String sql = "SELECT X,Y FROM LOCATIONTABLE WHERE SUBWAY =? ";
		String sql2 = "SELECT X,Y,SUBWAY FROM LOCATIONTABLE";
		Connection conn = null;
		PreparedStatement psmt = null;
		PreparedStatement psmt2 = null;
		ResultSet rs1 = null;	
		ResultSet rs2 = null;	
		int X = 0;
		int Y = 0;
		String[] rsub = new String[3];
		HashMap<Double, String> map = new HashMap<Double, String>();
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, r.getSub());
			rs1 = psmt.executeQuery();
			if(rs1.next()) {
				X = rs1.getInt("X");
				Y = rs1.getInt("Y");
			}
			psmt2 = conn.prepareStatement(sql2);
			rs2 = psmt2.executeQuery();
            while (rs2.next())
            {
            	int tx = rs2.getInt("X");
            	int ty = rs2.getInt("Y");
            	String sub = rs2.getString("SUBWAY");
            	double distance = Math.sqrt((X-tx)*(X-tx) + (Y-ty)*(Y-ty));
            	map.put(distance, sub);
            }
            
            TreeMap sort = new TreeMap(map);
            System.out.println(sort);
            
            int count = 0;
            for(Object x : sort.keySet()) {
            	if(count < 3) {
            		rsub[count] = (String) sort.get(x);
            		count++;
            	}else {
            		break;
            	}
            }
            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsub;
	}
	
	//가까운 역 마카롱 판매점 찾기
	public HashMap<String, String> findMarket(String[] sub){
		
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "SELECT BUNAME, SUBWAY FROM macaronmap WHERE subway =? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = conn.prepareStatement(sql);
			for(int i = 0; i < sub.length; i++) {
				psmt.setString(1, sub[i]);
				rs=psmt.executeQuery();
				while(rs.next()) {
					map.put(rs.getString("BUNAME"), rs.getString("SUBWAY"));
				}
			}
			
			System.out.println(map);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	//판매점 번호로 메뉴 가져오기
	public ArrayList<String> getMenu(HashMap<String,String> map){
		String sql = "SELECT ID FROM macaronmap WHERE SUBWAY = ? AND BUNAME= ?";
		String sql2 = "SELECT m.menu, m.stock, e.buname FROM MACARONMENU m, MACARONMAP e WHERE m.ID = ? AND e.ID = ?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		PreparedStatement psmt2 = null;
		ResultSet rs2 = null;
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = conn.prepareStatement(sql);
			psmt2 = conn.prepareStatement(sql2);
			
			for(String x : map.keySet()) {
				psmt.setString(1, map.get(x));
				psmt.setString(2, x);
				rs=psmt.executeQuery();
				while(rs.next()) {
					psmt2.setInt(1, rs.getInt("ID"));
					psmt2.setInt(2, rs.getInt("ID"));
					rs2 = psmt2.executeQuery();
					while(rs2.next()) {
						list.add(rs2.getString("MENU"));
						list.add(rs2.getString("STOCK"));
						list.add(rs2.getString("BUNAME"));
					}
				}
			}
			
			System.out.println(list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int checkduplicate(DuplicateDTO d) {
		int ok = 1;
		String sql = "SELECT * FROM mmember WHERE id =? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, d.getId());
			rs = psmt.executeQuery();
            if (rs.next())
            {
            	ok = 0;
            }

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return ok;
	}
	
}
