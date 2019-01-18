package Project;
 //panel1
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel1 extends JPanel implements ActionListener {
	JPanel pSouth;
	JButton btnSelect, btnInsert, btnUpdate, btnDelete, btnAll;
	JTextField tfSearch;
	
	public static final String user = "scott";
	public static final String password = "TIGER";
	public static final String url = "jdbc:oracle:thin:@192.168.113.81:1521:XE";
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	
	MemberPanel pn;
	public Panel1() {
		setLayout(new BorderLayout());
		pSouth = new JPanel();
		pSouth.setBackground(Color.GRAY);
		add(pSouth, BorderLayout.SOUTH);
		tfSearch = new JTextField(6);
		btnSelect  = new JButton("�˻�");
		btnInsert = new JButton("�Է�");
		btnUpdate  = new JButton("����");
		btnDelete = new JButton("����");
		btnAll = new JButton("��ü����");
		btnSelect.setBackground(Color.WHITE);
		btnInsert.setBackground(Color.WHITE);
		btnUpdate.setBackground(Color.WHITE);
		btnDelete.setBackground(Color.WHITE);
		btnAll.setBackground(Color.WHITE);
		tfSearch.addActionListener(this); // ���͸� ���� �� ActionEvent �߻�
		btnSelect.addActionListener(this);
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnAll.addActionListener(this);
		pSouth.add(tfSearch);
		pSouth.add(btnSelect);
		pSouth.add(btnInsert);
		pSouth.add(btnUpdate);
		pSouth.add(btnDelete);
		pSouth.add(btnAll);
		// p1�� ���� �߾ӿ�  ���̱�
		pn = new MemberPanel();
		add(pn);
		setVisible(true);
	}//������
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnInsert) {
			memInsert();
		} else if(obj == btnSelect) {
			memSelect();
		} else if(obj == btnUpdate) {
			memUpdate();
		} else if(obj == btnDelete) {
			memDelete();
		} else if(obj == tfSearch) {
			memSelect();
		} else if(obj == btnAll) {
			new AllMemberFrame();
		}
	} 
	
	
	private void memUpdate() {
		String rname = pn.tfRname.getText();
	    String menu = pn.tfMenu.getText();
	    String location = pn.tfLocation.getText();
	    String tel = pn.cbTel1.getSelectedItem()+ "-" +pn.tfTel2.getText()+"-"+pn.tfTel3.getText();
	    String price = pn.tfPrice.getText();
	    String sql = "update restaurant set rname=?, menu=?, location=?, tel=?, price=? where rname=?";
	    Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	    	Class.forName(driver);
	    	conn = DriverManager.getConnection(url, user, password);
	    	ps = conn.prepareStatement(sql);
	    	ps.setString(1, rname);
	    	ps.setString(2, menu);
	    	ps.setString(3, location);
	    	ps.setString(4, tel);
	    	ps.setString(5, price);
	    	ps.setString(6, rname);
	    	ps.executeUpdate();
	    } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
	    	if(ps != null) { try { ps.close(); } catch (Exception e) { } }//if
	    	if(conn != null) { try { conn.close(); } catch (Exception e) { } }//if
	    }//finally
	    JOptionPane.showMessageDialog(this, "���� �Ϸ�!", "Update OK?", JOptionPane.INFORMATION_MESSAGE);
	  }//updateDB


	private void memDelete() {
		String user = "scott";
	    String password = "TIGER";
	    String url = "jdbc:oracle:thin:@192.168.113.81:1521:XE";
	    // ���� ��ü
	    Connection conn = null;
	    PreparedStatement ps = null;
	    String rname = pn.tfRname.getText();
	    String sql = "DELETE FROM restaurant WHERE rname=?" ;
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	conn=DriverManager.getConnection(url, user, password);
	    	ps = conn.prepareStatement(sql);
	    	ps.setString(1, rname);
	    	int ok = ps.executeUpdate();
	    } catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    JOptionPane.showMessageDialog(this, "���� �Ϸ�!", "Delete OK?", JOptionPane.INFORMATION_MESSAGE);
	  }
	//actionPerformed
	
	
	private void memSelect() {
		// ��ȣ���� �����´�.
		String name = tfSearch.getText();
		// MemberDTO mem �� DB�� ������ ��´�.
		MemberDAO dao = new MemberDAO();
		MemberDTO mem = dao.selectMemeber(name);
		if(mem.getRname() == null) {
			System.out.println("��ȣ���� �Է����ּ���.");
			JOptionPane.showMessageDialog(this, "���� ��ȣ�� �Դϴ�.",
					"Search OK?", JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.out.println(mem);
			// ȭ�鿡 �����ش�.
			pn.tfRname.setText(mem.getRname());
			pn.tfMenu.setText(mem.getMenu());
			pn.tfLocation.setText(mem.getLocation());
			pn.tfPrice.setText( "" +  mem.getPrice() );
			String tel = mem.getTel(); // 011-1234-5678
			String[] arrTel = tel.split("-");
			String tel1 = arrTel[0]; // 011
			String tel2 = arrTel[1]; // 1234
			String tel3 = arrTel[2]; // 5678
			pn.cbTel1.setSelectedItem(tel1); // 011
			pn.tfTel2.setText(tel2); // 1234
			pn.tfTel3.setText(tel3); // 5678
		}//else
	}//memSelect
	private MemberDTO captureView() {
		// ȭ���� �Է°����� �����´�.
		String rname = pn.tfRname.getText();
		String menu = pn.tfMenu.getText();
		String tel1 = (String) pn.cbTel1.getSelectedItem(); // ��ȭ ù° �ڸ� ��) 010
		String tel2 = pn.tfTel2.getText();
		String tel3 = pn.tfTel3.getText();
		String tel = tel1 + "-" + tel2 + "-" + tel3;
		String location = pn.tfLocation.getText();
		int price = Integer.parseInt(pn.tfPrice.getText()); // ���ڷ� �ٲٱ�
		// MemberDTO mem ��ü�� ���� �� �����͸� �����Ѵ�.
		MemberDTO mem = new MemberDTO();
		mem.setRname(rname);
		mem.setMenu(menu);
		mem.setLocation(location);
		mem.setTel(tel);
		mem.setPrice(price);
		return mem;
	}//captureView
	private void memInsert() {
		MemberDTO mem = captureView();
		// MemberDAO ��ü�� ���� �� insertMember(mem) �� �����Ѵ�.
		MemberDAO dao = new MemberDAO();
		dao.insertMember(mem);
		JOptionPane.showMessageDialog(this, "��ϿϷ�!", "Save OK?", JOptionPane.INFORMATION_MESSAGE);
	}//memInsert
	public static void main(String[] args) {
		new Panel1();
	}//main
}//end
