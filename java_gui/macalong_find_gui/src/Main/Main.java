package Main;

import UserInterface.FirstFrame;

public class Main {

	/*
	 CREATE TABLE MMEMBER(ID VARCHAR2(20), PASSWD VARCHAR2(20), NICKNAME VARCHAR2(20), SUBWAY VARCHAR2(20));
	 CREATE TABLE LOCATION(SUBWAY VARCHAR2(20), X, Y);
	 CREATE TABLE MACARONMAP(ID NUMBER, SUBWAY VARCHAR2(20), BUNAME VARCHAR2(200));
	 CREATE TABLE MACARONMENU(ID NUMBER, MENU VARCHAR2(200), STOCK(NUMBER));
	*/
	
	//샘플 데이터 INSERT 명령어
	/*
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (1, '월곡', '달봄제과');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (2, '고려대', '마이카롱');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (3, '화랑대', '제이드플로르');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (4, '한강진', '피에');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (5, '이태원', '에끌레어BY가루하루');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (6, '이태원', '마카롱원더스');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (7, '이태원', '카롱카롱');
	 
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (1, '바닐라', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (1, '초코', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (1, '블루베리', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (2, '투게더바닐라', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (2, '순우유', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (2, '앙버터', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (3, '헤이즐넛초코', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (3, '유자 크런키', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (3, '얼그레이 밀크', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (4, '얼그레이', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (4, '트리플 베리', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (4, '흑임자', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (5, '초코 헤이즐넛', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (5, '카라멜', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (5, '후리지에', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (6, '블루베리', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (6, '화이트 초콜렛', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (6, '유자', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (7, '패션쇼콜라', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (7, '레몬', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (7, '얼그레이', '20');
	 */
	
	//LOCATION 테이블에 데이터 넣기
	//1. Insert.java
	/*
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	
	public class Insert {
	
		public String[][] i() {
			// TODO Auto-generated method stub
	        String[][] indat = new String[537][3];
	        
	        try {
	            // csv 데이타 파일
	            File csv = new File("지하철역 위치.csv");
	            BufferedReader br = new BufferedReader(new FileReader(csv));
	            String line = "";
	            int row =0 ,i;
	 
	            while ((line = br.readLine()) != null) {
	                // -1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션
	                String[] token = line.split(",", -1);
	                for(i=0;i<3;i++)    indat[row][i] = token[i];
	                
	                // CSV에서 읽어 배열에 옮긴 자료 확인하기 위한 출력
	                for(i=0;i<3;i++)    System.out.print(indat[row][i] + " ");
	                System.out.println("");
	                
	                row++;
	            }
	            br.close();
	 
	        } 
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return indat;
	
		}
	
	}

	 */
	
	//2.DAO.java
	/*
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	
	public class DAO {
		public static final String USER = "SCOTT";
		public static final String PASSWORD = "TIGER";
		public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		
		//회원가입
		public static void insertMember(Insert insert) {
			String sql = "INSERT INTO locationtable(subway, x, y)" + "VALUES(?,?,?)";
			Connection conn = null;
			PreparedStatement psmt = null;
			
			String[][] temp = insert.i();
			
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				psmt = conn.prepareStatement(sql);
				
				String[] temp2 = new String[3];
				for(int i = 1; i < temp.length; i++) {
					for(int j = 0; j < temp[i].length; j++) {
						//psmt.setString(j+1, temp[i][j]);
						temp2[j] = temp[i][j];
						System.out.println(temp2[j]);
					}
					
					psmt.setString(1, temp2[0]);
					psmt.setInt(2, Integer.parseInt(temp2[1]));
					psmt.setInt(3, Integer.parseInt(temp2[2]));
					int ok = psmt.executeUpdate();
					
					if(ok == 1) {
						System.out.println("성공");
					}else {
						System.out.println("실패");
					}
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			Insert i = new Insert();
			insertMember(i);
		}
		
	
	} 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstFrame f = new FirstFrame();
		
	}

}
