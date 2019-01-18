package project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsertFrame extends JFrame {
	private JTextField inputId;
	private JTextField inputPassword;
	private JTextField inputOrganization;
	JFrame f;

	public InsertFrame(String sc) {
		setTitle("Login Storage - Insert");
		getContentPane().setLayout(null);
		setSize(500,330);
		setLocation(750,350);
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(113, 59, 34, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 14));
		lblPassword.setBounds(61, 100, 90, 18);
		getContentPane().add(lblPassword);
		
		JLabel lblOrganization = new JLabel("Organization");
		lblOrganization.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 14));
		lblOrganization.setBounds(47, 141, 100, 18);
		getContentPane().add(lblOrganization);
		
		inputId = new JTextField();
		inputId.setBounds(161, 56, 169, 24);
		getContentPane().add(inputId);
		inputId.setColumns(10);
		
		inputPassword = new JTextField();
		inputPassword.setColumns(10);
		inputPassword.setBounds(161, 97, 169, 24);
		getContentPane().add(inputPassword);
		
		inputOrganization = new JTextField();
		inputOrganization.setColumns(10);
		inputOrganization.setBounds(161, 138, 169, 24);
		getContentPane().add(inputOrganization);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = "daeding";
				String password = "10581058";
				String url = "jdbc:oracle:thin:@192.168.113.4:1521:XE";
				Connection conn = null;
				PreparedStatement psmt = null;
				String sql = "insert into ls_info values((select max(i_number) from ls_info)+1, ?, ?,'" + sc +"', ?)";
				
				String i_id = inputId.getText();
				String i_password = inputPassword.getText();
				String i_organization = inputOrganization.getText();
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, password);
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, i_id);
					psmt.setString(2, i_password);
					psmt.setString(3, i_organization);

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
		btnOk.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 16));
		btnOk.setBounds(190, 197, 105, 27);
		getContentPane().add(btnOk);
		setVisible(true);
	}

}