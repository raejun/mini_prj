package jyl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JY_DAO {
	int a;
	//������ 
	public JY_DAO(){
		a = 0;
	}
	
	public void abc() {
		System.out.println("����");
	}
	//1. ���� ��ü�� �޼ҵ�� ����
	public Connection getConn() {
		final String user = "SCOTT";
		final String password = "TIGER";
		final String url ="jdbc:oracle:thin:@localhost:1521:XE";
		final String driver = "oracle.jdbc.driver.OracleDriver";

		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
		
	
	}
}
