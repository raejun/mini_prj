package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JoinFrame extends JFrame {

	private JPanel contentPane;		// ÆÇ³Ú
	private JLabel lblPhonenumber;
	private JPasswordField inputSc;		// È¸¿ø°¡ÀÔ¿¡ µé¾î°¡´Â SecretCode
	private JTextField inputName,inputBirth, inputPn1, inputPn2, inputPn3, inputQ, inputA;		// È¸¿ø°¡ÀÔ¿¡ µé¾î°¡´Â °ª
	private JLabel phoneLabel1, phoneLabel2;	// -
	private JLabel lblQuestion, lblAnswer, lblBirth;
	private JButton submitButton;		// Submit ¹öÆ°
	JFrame f;


	public JoinFrame() {
		setTitle("LS - Join");
		setBounds(100, 100, 384, 365);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(800,300);
		setVisible(true);
		
		JLabel lblJoin = new JLabel("Join");
		lblJoin.setFont(new Font("¸¼Àº °íµñ Bold", Font.BOLD, 25));
		lblJoin.setBounds(12, 0, 59, 44);
		contentPane.add(lblJoin);
		
		inputName = new JTextField();
		inputName.setBounds(142, 51, 110, 21);
		contentPane.add(inputName);
		inputName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 15));
		lblName.setBounds(90, 55, 57, 15);
		contentPane.add(lblName);
		
		JLabel lblSecretcode = new JLabel("SecretCode");
		lblSecretcode.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 15));
		lblSecretcode.setBounds(52, 88, 95, 15);
		contentPane.add(lblSecretcode);
		
		lblPhonenumber = new JLabel("PhoneNumber");
		lblPhonenumber.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 15));
		lblPhonenumber.setBounds(35, 115, 103, 15);
		contentPane.add(lblPhonenumber);
		
		lblBirth = new JLabel("Birth");
		lblBirth.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 15));
		lblBirth.setBounds(90, 152, 40, 15);
		contentPane.add(lblBirth);
		
		inputBirth = new JTextField();
		inputBirth.setColumns(10);
		inputBirth.setBounds(142, 148, 110, 21);
		contentPane.add(inputBirth);
		
		inputPn1 = new JTextField();
		inputPn1.setColumns(10);
		inputPn1.setBounds(141, 115, 40, 21);
		contentPane.add(inputPn1);
		
		inputPn2 = new JTextField();
		inputPn2.setColumns(10);
		inputPn2.setBounds(199, 115, 40, 21);
		contentPane.add(inputPn2);
		
		inputPn3 = new JTextField();
		inputPn3.setColumns(10);
		inputPn3.setBounds(260, 115, 40, 21);
		contentPane.add(inputPn3);
		
		phoneLabel1 = new JLabel("-");
		phoneLabel1.setBounds(186, 118, 19, 15);
		contentPane.add(phoneLabel1);
		
		phoneLabel2 = new JLabel("-");
		phoneLabel2.setBounds(245, 118, 19, 15);
		contentPane.add(phoneLabel2);
		
		lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 15));
		lblQuestion.setBounds(65, 185, 72, 15);
		contentPane.add(lblQuestion);
		
		inputQ = new JTextField();
		inputQ.setColumns(10);
		inputQ.setBounds(142, 181, 171, 44);
		contentPane.add(inputQ);
		
		lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 15));
		lblAnswer.setBounds(79, 239, 59, 15);
		contentPane.add(lblAnswer);
		
		inputA = new JTextField();
		inputA.setColumns(10);
		inputA.setBounds(141, 239, 110, 21);
		contentPane.add(inputA);
		
		inputSc = new JPasswordField();
		inputSc.setBounds(142, 84, 110, 21);
		contentPane.add(inputSc);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String j_secretcode = new String(inputSc.getPassword());
				String j_name = inputName.getText();
				String js_birth = inputBirth.getText();
				String js_phonenumber = inputPn1.getText() + inputPn2.getText() + inputPn3.getText();
				String j_question = inputQ.getText();
				String j_answer = inputA.getText();
				
				
				String user = "daeding";
				String password = "10581058";
				String url = "jdbc:oracle:thin:@192.168.113.4:1521:XE";
				Connection conn = null;
				PreparedStatement psmt = null;
				String sql = "insert into ls_user values(?, ?, ?, ?, ?, ?)";

				int j_birth = Integer.parseInt(js_birth);
				int j_phonenumber = Integer.parseInt(js_phonenumber);
				
				// System.out.println(j_secretcode + j_name + j_birth + j_phonenumber + j_question + j_answer);
				
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, password);
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, j_secretcode);
					psmt.setString(2, j_name);
					psmt.setInt(3, j_birth);
					psmt.setInt(4, j_phonenumber);
					psmt.setString(5, j_question);
					psmt.setString(6, j_answer);
					
					if(psmt.executeUpdate() == 1) {
						setVisible(false);
					}
					else
						f = new WarningFrame(2);
					
				} catch (ClassNotFoundException e1) {
					f = new WarningFrame(2);
					e1.printStackTrace();
				} catch (SQLException e1) {
					f = new WarningFrame(2);
					e1.printStackTrace();
				}
				finally {
					if(psmt != null) {
						try {
							psmt.close();
						}
						catch (SQLException e1) {
							f = new WarningFrame(2);
							e1.printStackTrace();
						}
					}
					if(conn != null) {
						try {
							conn.close();
						} 
						catch (SQLException e1) {
							f = new WarningFrame(2);
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		submitButton.setFont(new Font("¸¼Àº °íµñ Bold", Font.BOLD, 12));
		submitButton.setForeground(Color.BLACK);
		submitButton.setBackground(Color.GRAY);
		submitButton.setBounds(143, 281, 97, 23);
		contentPane.add(submitButton);
	}
}
