package project;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginFrame extends JFrame {
	private JPanel contentPane;
	private JTextField searchWord;
	String r_sc;		// Secretcode
	
	public LoginFrame(String scode) {		// scode -> secretcode
		setTitle("Login Storage");
		r_sc = scode;
		String name = null;
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
			psmt.setString(1, scode);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
			else
				System.exit(0);
			
			

			
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel(new String(name));
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 23));
		lblNewLabel.setBounds(60, 122, 121, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.setBackground(Color.LIGHT_GRAY);
		btnShowAll.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 17));
		
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.repaint();
				
				JTextPane textPane = new JTextPane();
				
				textPane.setBounds(14, 156, 533, 279);
				Connection conn = null;
				PreparedStatement psmt= null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String sql = "SELECT * FROM ls_info "
							+ "WHERE authentication = ? and organization != 'test'";
					conn = DriverManager.getConnection(url, user, password);
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, scode);
					ResultSet rs = psmt.executeQuery();

					JTextArea txtpn = new JTextArea();
					txtpn.setBounds(14, 160, 554, 281);
					txtpn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
					contentPane.add(txtpn);
		
					while(rs.next())
					{
						int index_num;
						String id = null;
						String password = null;
						String organization = null;
						index_num = rs.getInt("i_number");
						id = rs.getString("id");
						password = rs.getString("password");
						organization = rs.getString("organization");
						String i_num = String.valueOf(index_num);
						String s = i_num + "      :  " + id + "      " + password + "     " + organization;
						txtpn.append(s + "\n");
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
		
		
		btnShowAll.setBounds(60, 18, 121, 36);
		contentPane.add(btnShowAll);
		
		
		searchWord = new JTextField();
		searchWord.setBounds(229, 72, 272, 24);
		contentPane.add(searchWord);
		searchWord.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//contentPane.repaint();
				String st = ("%" + searchWord.getText() + "%");
				JTextPane textPane = new JTextPane();
				textPane.setBounds(14, 156, 533, 279);
				Connection conn = null;
				PreparedStatement psmt= null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String sql = "SELECT * FROM ls_info "
							+ "WHERE authentication = ? AND organization LIKE ? AND organization != 'test'";
					conn = DriverManager.getConnection(url, user, password);
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, scode);
					psmt.setString(2,  st);
					ResultSet rs = psmt.executeQuery();

					JTextArea txtpn = new JTextArea();
					txtpn.setBounds(14, 160, 554, 281);
					txtpn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
					contentPane.add(txtpn);
					
					while(rs.next())
					{
						int index_num;
						String id = null;
						String password = null;
						String organization = null;
						index_num = rs.getInt("i_number");
						id = rs.getString("id");
						password = rs.getString("password");
						organization = rs.getString("organization");
						String i_num = String.valueOf(index_num);
						String s = i_num + "      :  " + id + "      " + password + "     " + organization;
						txtpn.append(s + "\n");
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
		
		btnSearch.setBackground(Color.GRAY);
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 15));
		btnSearch.setBounds(92, 71, 105, 27);
		contentPane.add(btnSearch);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBackground(Color.LIGHT_GRAY);
		btnInsert.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 17));
		
		
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new InsertFrame(r_sc);
			}
		});
		
		btnInsert.setBounds(237, 18, 121, 37);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 17));
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new DeleteFrame(r_sc);
			}
		});

		
		btnDelete.setBounds(407, 18, 121, 36);
		contentPane.add(btnDelete);
		
		JLabel label = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		label.setBounds(183, 128, 151, 18);
		contentPane.add(label);
		setLocation(700,300);
		
		
		setVisible(true);
	}
}

