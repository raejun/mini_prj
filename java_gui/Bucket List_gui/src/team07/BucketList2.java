package team07;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BucketList2 extends JFrame implements ActionListener {
	private JTable table;
	private JTextField textField;
	private JTextField textField_R;
	private JTextField textField_T;
	private JTextField textField_C;
	private JTextField textField_P;
	private JTextField textField_I;
	private JTextField textField_F;
	private JTextField textField_CH;
	DefaultTableModel model;
	private JScrollPane pane;
	Vector vData;
	Vector vCol;
	public BucketList2() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(0, 85, 985, 300);
		getContentPane().add(panel);
		getContentPane().setLayout(null);

		table = new JTable();
		table.setBounds(0, 85, 985, 300);
		getContentPane().add(table);
		DAO dao = new DAO();
		vData = dao.all();
		vCol = new Vector();
		vCol.add("rank");
		vCol.add("title");
		vCol.add("cont");
		vCol.add("pland");
		vCol.add("impled");
		vCol.add("feel");
		vCol.add("chek");

		model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		pane = new JScrollPane(table);
		pane.setBounds(0, 85, 900, 300);
		panel.add(pane);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(14, 36, 72, 24);
		getContentPane().add(comboBox);

		textField = new JTextField();
		textField.setBounds(110, 36, 116, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("�˻�");
		btnNewButton.setBounds(239, 35, 73, 27);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBuk();
			}

			private void SearchBuk() {
				String user = "SCOTT";
				String pw = "TIGER";
				String url = "jdbc:oracle:thin:@192.168.113.66:1521:XE";
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM BUCKETLIST WHERE title LIKE ?";
				try {
					String a = textField.getText();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, pw);
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, "%" + a + "%");
					rs = psmt.executeQuery();
					vData.clear();
					while(rs.next()) {
						Vector vRow = new Vector<>();
						int rank = rs.getInt("rank");
						String title = rs.getString("title");
						String cont = rs.getString("cont");
						String pland = rs.getString("pland");
						String impled = rs.getString("impled");
						String feel = rs.getString("feel");						//String���� ������ null���� null�� ����ش�. ���࿡ int�� ������ null�� 0�� �ȴ�.
						String chek = rs.getString("chek");
						vRow.add(rank);
						vRow.add(title);
						vRow.add(cont);
						vRow.add(pland);
						vRow.add(impled);
						vRow.add(feel);
						vRow.add(chek);
						vData.add(vRow);
					}//while
					model.setDataVector(vData, vCol);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//SearchBuk
		});

		JButton btnNewButton_1 = new JButton("�Է�");
		btnNewButton_1.setBounds(326, 35, 105, 27);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insertbuk();
			}

			private void Insertbuk() {
				// ���� ����
				String user = "SCOTT";
				String pw = "TIGER";
				String url = "jdbc:oracle:thin:@192.168.113.66:1521:XE";

				// ���� ��ü
				Connection conn = null;
				// ��� ��ü
				PreparedStatement psmt = null;
				// SQL
				String sql = "INSERT INTO BUCKETLIST(rank,title,cont,pland,impled,feel,chek)" + "VALUES(?,?,?,?,?,?,?)";
				try {
					// 1. ����̹� �ε�
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println(" 1.����̹� ���� ����!!");

					// 2. ����
					conn = DriverManager.getConnection(url, user, pw);

					// 3. ��� �غ�
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, textField_R.getText()); // id�� �ߺ��Ǹ� �ȵȴ�. pk�̱� ������
					psmt.setString(2, textField_T.getText());
					psmt.setString(3, textField_C.getText());
					psmt.setString(4, textField_P.getText());
					psmt.setString(5, textField_I.getText());
					psmt.setString(6, textField_F.getText());
					psmt.setString(7, textField_CH.getText());

					// 4. ����
					int ok = psmt.executeUpdate(); // insert,update,delete���� executeUpdate�� ����
					if (ok == 1) {
						System.out.println("���� ����");

					} else {
						System.out.println("���� ����");
					}

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();

				} finally {
					if (psmt != null) {
					}
					try {
						psmt.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					// if(psmt)
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {

							e.printStackTrace();
						}
					} // if(conn)
				} // finally
			}

		});

		JButton btnNewButton_2 = new JButton("����");
		btnNewButton_2.setBounds(445, 35, 105, 27);
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				UpdateBuk();
			}

			private void UpdateBuk() {
				String user = "SCOTT";
				String password = "TIGER";
				String url = "jdbc:oracle:thin:@192.168.113.66:1521:XE";
				Connection conn = null;
				PreparedStatement psmt = null;
				int row = table.getSelectedRow();
				int rank = (int) table.getValueAt(row, 0);
				System.out.println(rank);

				String sql = "UPDATE BUCKETLIST " + "SET rank=?, title=?, cont=?, pland=?, impled=?,"
						+ "feel=? , chek=? WHERE rank=?";

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, password);
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, Integer.parseInt(textField_R.getText())); // id�� �ߺ��Ǹ� �ȵȴ�. pk�̱� ������
					psmt.setString(2, textField_T.getText());
					psmt.setString(3, textField_C.getText());
					psmt.setString(4, textField_P.getText());
					psmt.setString(5, textField_I.getText());
					psmt.setString(6, textField_F.getText());
					psmt.setString(7, textField_CH.getText());
					psmt.setInt(8, rank);

					int ok = psmt.executeUpdate();
					if (ok == 1) {
						System.out.println("�����Ǿ����ϴ�!");
					} else {
						System.out.println("���� ����...");
					}
				} // try

				catch (ClassNotFoundException e) {
					e.printStackTrace();
				} // catch
				catch (SQLException e) {
					e.printStackTrace();
				} // catch

				finally {
					if (psmt != null) {
					}
					try {
						psmt.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					// if(psmt)
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {

							e.printStackTrace();
						}
					} // if(conn)
				} // finally

			}
		});

		JButton button = new JButton("����");
		button.setBounds(564, 35, 105, 27);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBuk();
			}

			private void DeleteBuk() {
				int row = table.getSelectedRow();
				int rank = (int) table.getValueAt(row, 0);
				System.out.println("rank=" + rank);
				DAO dao = new DAO();
				boolean ok = dao.DeleteBuk(rank);
				System.out.println("ok=" + ok);

			}
		});

		JButton button_2 = new JButton("���ΰ�ħ");
		button_2.setBounds(704, 35, 105, 27);
		getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshBuk();
			}

			private void RefreshBuk() {
				String user = "SCOTT";
				String pw = "TIGER";
				String url = "jdbc:oracle:thin:@192.168.113.66:1521:XE";

				// ���� ��ü
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null; // ��ü�� ������ �� null�� �ʱ�ȭ�ϴ� ���� �����̴�.
				String sql = "SELECT * FROM BUCKETLIST";

				try {
					// 1. �ڹ�jdbc�� 1�ܰ� : ����̹� �ε�
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println(" 1. jdbc ����̹� �ε� ����!!");
					// 2 .����
					conn = DriverManager.getConnection(url, user, pw);
					System.out.println(" 2. ���� ����!!");

					// 3. ��� �غ�
					psmt = conn.prepareStatement(sql);
					System.out.println(" 3. ��� �غ� ����!!");

					// 4. sql�� ���� �� ����
					rs = psmt.executeQuery(); // select���� executeQuery �� �����Ѵ�.
					System.out.println(" 4. ���� ����");
					System.out.println("rs=" + rs);
					// rs=oracle.jdbc.driver.OracleResultSetImpl@3e0e1046

					// 5. rs ��� ���
					while (rs.next()) {
						int rank = rs.getInt("rank");
						String title = rs.getString("title");
						String cont = rs.getString("cont");
						String pland = rs.getString("pland");
						String impled = rs.getString("impled");
						String feel = rs.getString("feel"); // String���� ������ null���� null�� ����ش�. ���࿡ int�� ������ null�� 0�� �ȴ�.
						String chek = rs.getString("chek");
						System.out.println("rank =" + rank + ", title =" + title + ", cont =" + cont + ", pland ="
								+ pland + ", impled=" + impled + ", feel=" + feel + ", chek=" + chek);

						// 6. ���� ����(����� �ٸ� ��� �ڿ����� �����Ѵ�.)
					} // 1) try

				}

				// ����ó��!!!!
				catch (ClassNotFoundException e) {
					System.out.println("������ �߻��߽��ϴ�. Ŭ������ ã�� �� �����ϴ�!!");
					e.printStackTrace();
				} // 1) catch // 1)java.io 2)java.sql 3)java.net ���ܻ�Ȳ try,catch,finally ex)
					// try{���ܻ�Ȳ}, catch(exception),finally{�ڿ�����}
				catch (SQLException e) {
					System.out.println("���� ����...");
					e.printStackTrace();
				} // 2) catch

				finally { // ���� ��ü�� ���� �������� �ݾ��ش�.
					if (rs != null) {
						try {

							rs.close();
						} catch (SQLException e) {

							e.printStackTrace();
						}
					} // if(rs)

					if (psmt != null) {
						try {
							psmt.close();
						} catch (SQLException e) {

							e.printStackTrace();
						}
					} // if(psmt)
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {

							e.printStackTrace();
						}
					} // if(conn)
				} // finally
				JPanel panel = new JPanel();
				panel.setLayout(new BorderLayout());
				panel.setBounds(0, 85, 985, 300);
				getContentPane().add(panel);
				getContentPane().setLayout(null);

				table = new JTable();
				table.setBounds(0, 85, 985, 300);
				getContentPane().add(table);
				DAO dao = new DAO();
				Vector vRow = dao.all();
				Vector v = new Vector();
				v.add("rank");
				v.add("title");
				v.add("cont");
				v.add("pland");
				v.add("impled");
				v.add("feel");
				v.add("chek");

				model = new DefaultTableModel(vRow, v);
				table = new JTable(model);
				pane = new JScrollPane(table);
				pane.setBounds(0, 85, 900, 300);
				panel.add(pane);
				repaint();

			}
		});

		JButton button_1 = new JButton("�α׾ƿ�");
		button_1.setBounds(848, 35, 105, 27);
		getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f;
				f = new JFrame();
				JOptionPane.showMessageDialog(f, "�α׾ƿ� �Ǿ����ϴ�.");
				System.exit(0);
			}

		});

		JLabel lblNewLabel = new JLabel("�켱����");
		lblNewLabel.setBounds(67, 395, 62, 18);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("����");
		label.setBounds(196, 395, 62, 18);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("����");
		label_1.setBounds(326, 395, 62, 18);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("��ȹ��¥");
		label_2.setBounds(472, 395, 62, 18);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("���೯¥");
		label_3.setBounds(607, 395, 62, 18);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("����");
		label_4.setBounds(747, 395, 62, 18);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel("üũ");
		label_5.setBounds(891, 395, 62, 18);
		getContentPane().add(label_5);

		textField_R = new JTextField();
		textField_R.setBounds(47, 438, 105, 24);
		getContentPane().add(textField_R);
		textField_R.setColumns(10);

		textField_T = new JTextField();
		textField_T.setColumns(10);
		textField_T.setBounds(177, 438, 116, 24);
		getContentPane().add(textField_T);

		textField_C = new JTextField();
		textField_C.setColumns(10);
		textField_C.setBounds(311, 438, 116, 24);
		getContentPane().add(textField_C);

		textField_P = new JTextField();
		textField_P.setColumns(10);
		textField_P.setBounds(449, 438, 116, 24);
		getContentPane().add(textField_P);

		textField_I = new JTextField();
		textField_I.setColumns(10);
		textField_I.setBounds(589, 438, 116, 24);
		getContentPane().add(textField_I);

		textField_F = new JTextField();
		textField_F.setColumns(10);
		textField_F.setBounds(729, 438, 116, 24);
		getContentPane().add(textField_F);

		textField_CH = new JTextField();
		textField_CH.setColumns(10);
		textField_CH.setBounds(869, 438, 116, 24);
		getContentPane().add(textField_CH);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("��Ŷ����Ʈ �����ý���");
		setSize(1030, 592);
		setVisible(true);

	}// ������

	public class OptionPane {
		JFrame f;

		OptionPane() {
			f = new JFrame();
			JOptionPane.showMessageDialog(f, "Hello, Welcome to Javatpoint.");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new BucketList2();

	}// main
}// end
