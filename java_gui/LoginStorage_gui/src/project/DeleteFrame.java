package project;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField inputIndex;
	JFrame f;
	public DeleteFrame(String sc) {
		setTitle("Login Storage - Delete");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(270, 300);
		
		
		JLabel lblIndex = new JLabel("\uC0AD\uC81C\uD560 Index \uBC88\uD638");		// »èÁ¦ÇÒ Index¸¦ ÀÔ·ÂÇÏ½Ê½Ã¿À.
		lblIndex.setFont(new Font("¸¼Àº °íµñOTF Bold", Font.PLAIN, 22));
		lblIndex.setBounds(58, 91, 188, 35);
		contentPane.add(lblIndex);
		
		inputIndex = new JTextField();			// Index ¹ÞÀ½
		inputIndex.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 22));
		inputIndex.setBounds(250, 89, 114, 38);
		contentPane.add(inputIndex);
		inputIndex.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 17));
		btnNewButton.setBounds(163, 180, 105, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = "daeding";
				String password = "10581058";
				String url = "jdbc:oracle:thin:@192.168.113.4:1521:XE";
				Connection conn = null;
				PreparedStatement psmt = null;
				String sql = "Delete from ls_info where authentication = '"+ sc + "' AND i_number = ?";
				String i_number = inputIndex.getText();		// index¹øÈ£
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, password);
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, i_number);

					if(psmt.executeUpdate() == 1) {
						setVisible(false);
					}
					else
						f = new WarningFrame(3);
					
				} catch (ClassNotFoundException e1) {
					f = new WarningFrame(3);
					e1.printStackTrace();
				} catch (SQLException e1) {
					f = new WarningFrame(3);
					e1.printStackTrace();
				}
				finally {
					if(psmt != null) {
						try {
							psmt.close();
						}
						catch (SQLException e1) {
							f = new WarningFrame(3);
							e1.printStackTrace();
						}
					}
					if(conn != null) {
						try {
							conn.close();
						} 
						catch (SQLException e1) {
							f = new WarningFrame(3);
							e1.printStackTrace();
						}
					}
				}
			}
		});
		setVisible(true);
	}
}
