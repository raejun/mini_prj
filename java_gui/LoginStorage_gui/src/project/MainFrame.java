package project;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JPasswordField;
import java.awt.Color;

public class MainFrame extends JFrame {
	private JPanel contentPane;
	private JPasswordField secretcode;
	JFrame f;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public MainFrame() {
		setTitle("Login Storage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(800,400);
		
		
		JButton btnLogin = new JButton("Login");		// Login ��ư
		btnLogin.setBackground(Color.GRAY);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBounds(10, 113, 94, 34);
		
		JButton btnJoin = new JButton("Join");			// Join ��ư
		btnJoin.setForeground(Color.BLACK);
		btnJoin.setBackground(Color.GRAY);
		btnJoin.setBounds(115, 113, 66, 34);
		
		JButton btnFind = new JButton("Find");			// Find ��ư
		btnFind.setForeground(Color.BLACK);
		btnFind.setBackground(Color.GRAY);
		btnFind.setBounds(193, 113, 66, 34);
		
		
		JButton btnExit = new JButton("Exit");			// Exit ��ư
		btnExit.setForeground(Color.BLACK);
		btnExit.setBackground(Color.GRAY);
		btnExit.setBounds(271, 113, 66, 34);
		secretcode = new JPasswordField();
		secretcode.setBounds(140, 65, 164, 21);

		JLabel lblLoginStorage = new JLabel("Login Storage");
		lblLoginStorage.setFont(new Font("���� ���", Font.BOLD, 25));
		lblLoginStorage.setBounds(12, 10, 192, 34);
		contentPane.add(lblLoginStorage);
		
		JLabel lblSecretCode = new JLabel("Secret Code");
		lblSecretCode.setFont(new Font("���� ���", Font.PLAIN, 15));
		lblSecretCode.setBounds(40, 66, 97, 15);
		
		contentPane.add(lblSecretCode);
		contentPane.add(btnLogin);
		contentPane.add(btnJoin);
		contentPane.add(btnExit);
		contentPane.add(btnFind);
		contentPane.add(secretcode);
		
	
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sc;
				sc = new String(secretcode.getPassword());	// SecretCode �Է¹޾Ƽ� sc�� ����
				String user = "daeding";
				String password = "10581058";
				String url = "jdbc:oracle:thin:@192.168.113.4:1521:XE";
				Connection conn = null;
				PreparedStatement psmt = null;
				String sql = "SELECT * FROM ls_user "
						+ "WHERE secretcode = ?";
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, password);
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, sc);			// sc sql���� �ø�
					//psmt.executeUpdate();
					ResultSet rs = psmt.executeQuery();
					if(rs.next()) {
						f = new LoginFrame(rs.getString("secretcode"));		// ������ ���鼭 secretcode ���ڷ� ����
					}
					else {
						f = new WarningFrame(1);
					}

					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				finally {
					if(psmt != null) {
						try {
							psmt.close();
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					if(conn != null) {
						try {
							conn.close();
						} 
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				
			}
			
		});
		btnFind.addActionListener(new ActionListener() {	// Find��ư Ŭ���� FindFrame ����
			public void actionPerformed(ActionEvent e) {
				f = new FindFrame();
			}
		});
		btnJoin.addActionListener(new ActionListener() {	// Join��ư Ŭ���� JoinFrame ����
			public void actionPerformed(ActionEvent e) {
				f = new JoinFrame();
			}
		});
		btnExit.addActionListener(new ActionListener() {	// Exit��ư Ŭ���� ����
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}
}

/*
 	CREATE TABLE LS_USER
	(
		SECRETCODE VARCHAR2(10) NOT NULL,
		NAME VARCHAR2(10) NOT NULL,
		BIRTH NUMBER NOT NULL,
		PHONENUMBER NUMBER NOT NULL,
		QUESTION VARCHAR2(50) NOT NULL,
		ANSWER VARCHAR2(30) NOT NULL,
 	 	CONSTRAINT LS_USER_PK PRIMARY KEY (SECRETCODE)
	)
	CREATE TABLE LS_INFO
	(
		I_NUMBER NUMBER	NOT NULL,
		ID VARCHAR2(20) NOT NULL,
		PASSWORD VARCHAR2(20) NOUT NULL,
		AUTHENTICATION VARCHAR2(10) NOT NULL,
 	 	ORGANIZATION VARCHAR2(20) NOT NULL,
 	 	CONSTRAINT LS_INFO_PK PRIMARY KEY (I_NUMBER)
	)
	
	ALTER TABLE LS_INFO
    ADD CONSTRAINT FK_LS_INFO_AUTH_LS_USER_SC FOREIGN KEY (AUTHENTICATION)
        REFERENCES LS_USER (SECRETCODE)
        
	INSERT INTO LS_USER VALUES('1234123', '�ȴ���', 940730, 01043210738, '���� ������ �ʵ��б���?', '�����ʵ��б�')
 	INSERT INTO LS_USER VALUES('151515', '����ȣ', 941108, 01033336666, '���� ����ϴ� ��й�ȣ��?', '1234')
 	INSERT INTO LS_USER VALUES('23102310', '�質��', 920725, 01040124992, '���� ��ġ��', '���ھ�')
 	INSERT INTO LS_INFO VALUES(0, 'test', 'test', 1234123, 'test')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'dh0730', '1q2w3e4r!', 1234123, 'NAVER(���̹�)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'eogns0730', '1q2w3e4r!', 1234123, 'DAUM(����)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'dh1303', '1q2w3e4r!', 1234123, 'NEXON(�ؽ�)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'sksmswogh', '123123', 151515, 'NAVER(���̹�)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'sksmswogh', '123123', 151515, 'NEXON(�ؽ�)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'sksmswogh', '123123', 151515, 'GOOGLE(����)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, '��ȣ��¯', '123456', 151515, 'CA(ũ��)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'dh0730', '1234123423', 1234123, 'STEAM(����)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, '����¯¯', 'dh0730', 1234123, 'CA(ũ��)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'abc@naver.com', '1q2w3e4r!@#', 1234123, 'MAPLE(������)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, '20131692', '1q2w3e4r!', 1234123, 'UNIV(���б�)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'Encore', '7276', 1234123, 'ENCORE(���ھ�)')
 	INSERT INTO LS_INFO VALUES((select max(i_number) from ls_info)+1, 'dh0730', 'eogns0730', 1234123, 'GMARKET(������)')
 	
 */
