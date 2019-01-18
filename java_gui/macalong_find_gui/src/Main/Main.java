package Main;

import UserInterface.FirstFrame;

public class Main {

	/*
	 CREATE TABLE MMEMBER(ID VARCHAR2(20), PASSWD VARCHAR2(20), NICKNAME VARCHAR2(20), SUBWAY VARCHAR2(20));
	 CREATE TABLE LOCATION(SUBWAY VARCHAR2(20), X, Y);
	 CREATE TABLE MACARONMAP(ID NUMBER, SUBWAY VARCHAR2(20), BUNAME VARCHAR2(200));
	 CREATE TABLE MACARONMENU(ID NUMBER, MENU VARCHAR2(200), STOCK(NUMBER));
	*/
	
	//���� ������ INSERT ��ɾ�
	/*
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (1, '����', '�޺�����');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (2, '�����', '����ī��');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (3, 'ȭ����', '���̵��÷θ�');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (4, '�Ѱ���', '�ǿ�');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (5, '���¿�', '��������BY�����Ϸ�');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (6, '���¿�', '��ī�տ�����');
	 INSERT INTO MACARONMAP(ID, SUBWAY, BUNAME) VALUES (7, '���¿�', 'ī��ī��');
	 
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (1, '�ٴҶ�', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (1, '����', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (1, '��纣��', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (2, '���Դ��ٴҶ�', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (2, '������', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (2, '�ӹ���', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (3, '�����������', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (3, '���� ũ��Ű', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (3, '��׷��� ��ũ', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (4, '��׷���', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (4, 'Ʈ���� ����', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (4, '������', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (5, '���� �������', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (5, 'ī���', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (5, '�ĸ�����', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (6, '��纣��', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (6, 'ȭ��Ʈ ���ݷ�', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (6, '����', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (7, '�мǼ��ݶ�', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (7, '����', '20');
	 INSERT INTO MACARONMENU(ID, MENU, STOCK) VALUES (7, '��׷���', '20');
	 */
	
	//LOCATION ���̺� ������ �ֱ�
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
	            // csv ����Ÿ ����
	            File csv = new File("����ö�� ��ġ.csv");
	            BufferedReader br = new BufferedReader(new FileReader(csv));
	            String line = "";
	            int row =0 ,i;
	 
	            while ((line = br.readLine()) != null) {
	                // -1 �ɼ��� ������ "," ���� �� ���鵵 �б� ���� �ɼ�
	                String[] token = line.split(",", -1);
	                for(i=0;i<3;i++)    indat[row][i] = token[i];
	                
	                // CSV���� �о� �迭�� �ű� �ڷ� Ȯ���ϱ� ���� ���
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
		
		//ȸ������
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
						System.out.println("����");
					}else {
						System.out.println("����");
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
