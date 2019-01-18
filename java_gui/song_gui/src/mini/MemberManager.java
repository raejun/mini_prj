package mini;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class MemberManager extends JFrame implements ActionListener {
	JPanel pNorth;
	JButton btnInsert, btnSelect, btnUpdate, btnDelete, btnExit, btnAll;
	JTextField tfSearch;
	MemberPanel p1;
	public MemberManager() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //â�ݱ�
		setTitle("ȸ�� ���� �̴� ������Ʈ");
		setSize(500,300);
		pNorth = new JPanel();
		pNorth.setBackground(Color.ORANGE);
		add(pNorth, BorderLayout.NORTH);
		btnInsert = new JButton("�Է�");
		btnSelect = new JButton("�˻�"); 
		btnUpdate = new JButton("����");
		btnDelete = new JButton("����");
		btnExit = new JButton("����");
		btnAll = new JButton("��ü");
		tfSearch = new JTextField(6);
		btnInsert.addActionListener(this);
		btnSelect.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		tfSearch.addActionListener(this);
		btnAll.addActionListener(this);// ������ ���  ���͸� ���� �� ActionEvent ��
		pNorth.add(btnInsert);
		pNorth.add(tfSearch);
		pNorth.add(btnSelect);
		pNorth.add(btnUpdate);
		pNorth.add(btnDelete);
		pNorth.add(btnExit);
		pNorth.add(btnAll);
		// p1 ����� �߾ӿ� ���̱�
		p1=new MemberPanel();
		add(p1);
		setVisible(true);
	}//������
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btnInsert) {
			memInsert();
		}else if(obj==btnSelect) {
			memSelet();
		}else if(obj==btnUpdate) {
			//memUpdate();
		}else if(obj==btnDelete) {
			//memDelete();
		}else if(obj==btnExit) {
			System.exit(0);
		}else if(obj==tfSearch) {
			//memSelect();
		}else if(obj == btnAll) {
			new AllMemberFrame();
		}
	}//actionPerformed
	private void memSelet() {
		//�̸��� �����´�
		String name = tfSearch.getText();
		//MemberDTO mem ���� �� DB�� ������ ��´�
		MemberDAO dao = new MemberDAO();
		MemberDTO mem = dao.selectMember(name);
		if(mem.getId() == null) {
			System.out.println("���� �����");
			JOptionPane.showMessageDialog(this, "�����ϴ�", 
					"search ok?", JOptionPane.INFORMATION_MESSAGE);
		}else {
			System.out.println(mem);			
			//ȭ�鿡 ������
			p1.tfId.setText(mem.getId());
			p1.tfPw.setText(mem.getPasswd());
			p1.tfName.setText(mem.getName());
			p1.tfAddress.setText(mem.getAddress());
			p1.tfAge.setText(""+mem.getAge());
			String tel = mem.getTel();       //010-9263-7827
			String[] arrTel = tel.split("-");
			String tel1=arrTel[0];            
			String tel2=arrTel[1];            
			String tel3=arrTel[2];            
			p1.cbTel1.setSelectedItem(tel1);  //010
			p1.tfTel2.setText(tel2);          //9263
			p1.tfTel3.setText(tel3);          //7827

		}//else
	}//memSelect
	private MemberDTO captureView() {
		// ȭ�鿡 �Է°����� ������
		String id = p1.tfId.getText();
		String passwd = p1.tfPw.getText();
		String name = p1.tfName.getText();
		String tel1 = (String) p1.cbTel1.getSelectedItem();//��ȭ��ȣ ù° �ڸ� 010
		String tel2 = p1.tfTel2.getText();
		String tel3 = p1.tfTel3.getText();
		String tel = tel1+"-"+tel2+"-"+tel3;
		String address = p1.tfAddress.getText();
		int age = Integer.parseInt(p1.tfAge.getText());
		// MemberDTO mem ��ü�� ���� �� �����͸� ����
		MemberDTO mem = new MemberDTO();
		mem.setId(id);
		mem.setPasswd(passwd);
		mem.setName(name);
		mem.setTel(tel);
		mem.setAddress(address);
		mem.setAge(age);
		return mem;
	}//captureView
	private void memInsert() {
		MemberDTO mem = captureView();
		//3. MemberDAO ��ü�� ���� �� insertMember(mem)�� ���ा
		MemberDAO dao = new MemberDAO();
		dao.insertMember(mem);
		JOptionPane.showMessageDialog(this, "���强��", "save ok?", JOptionPane.INFORMATION_MESSAGE);
	}//mainInsert
	public static void main(String[] args) {
		MemberManager f = new MemberManager();
	}//main
}//end
