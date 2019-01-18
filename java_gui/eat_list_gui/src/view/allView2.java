package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.resDAO;

public class allView2 extends JFrame implements ActionListener, MouseListener{
	JTable table;
	JPanel pSouth;
	Vector vData;
	Vector vCol;
	JButton btnAdd, btnMylist;
	public allView2() {
		setTitle("전체식당 목록");
		setSize(600, 400);
		setLocation(700,350);
		pSouth = new JPanel();
		pSouth.setBackground(Color.BLUE);
		add(pSouth, BorderLayout.SOUTH);
		resDAO dao = new resDAO();
		vData = dao.allRes();
		vCol = new Vector();
		btnAdd = new JButton("추가");
		btnMylist = new JButton("내목록");
		btnAdd.addActionListener(this);
		btnMylist.addActionListener(this);
		pSouth.add(btnAdd);
		pSouth.add(btnMylist);
		vCol.add("상호명");
		vCol.add("주소");
		vCol.add("전화번호");
		vCol.add("대표메뉴");
		vCol.add("가격");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(this);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnAdd) {
			listadd();
		} else if (obj == btnMylist) {
			new Mylist();
		}
		
	}
	
	String str1 = null;
	String str2 = null;
	String str3 = null;
	String str4 = null;
	String str5 = null;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		str1 = (String) table.getValueAt(row, 0);
		str2 = (String) table.getValueAt(row, 1);
		str3 = (String) table.getValueAt(row, 2);
		str4 = (String) table.getValueAt(row, 3);
		str5 = "" + (Integer) table.getValueAt(row, 4);
		
	}
	
	
	public void listadd() {
		String user = "SCOTT";
		String password = "TIGER";
		String url = "jdbc:oracle:thin:@192.168.22.181:1521:XE";
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = "INSERT INTO mylist(resname,address,tel,reprmenu,price) " +
				"VALUES(?,?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password); 
			// 3. 명령 준비
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, str1);
			psmt.setString(2, str2);
			psmt.setString(3, str3);
			psmt.setString(4, str4);
			psmt.setString(5, str5);
			int ok = psmt.executeUpdate(); //
			if(ok == 1) {
				System.out.println("추가 성공!!!");
				JOptionPane.showMessageDialog(this, "추가 성공!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("추가 실패!");
			}
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (SQLException x) {
			x.printStackTrace();
		} finally {
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException x) {
					x.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException x) {
					x.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new allView2();
	}

}