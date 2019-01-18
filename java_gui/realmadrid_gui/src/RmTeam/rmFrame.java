package RmTeam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class rmFrame extends JFrame implements ActionListener {
	JPanel pNorth, pSouth;
	JButton btnInsert, btnSelect, btnUpdate, btnDelete, btnExit, btnAll;
	JTextField tfSearch;
	rmPanel p1;
	
	public rmFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Real Madrid �������� ���α׷�");
		setSize(400, 400);
		pNorth = new JPanel();
		pSouth = new JPanel();
		pNorth.setBackground(Color.BLUE);
		pSouth.setBackground(Color.ORANGE);
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		btnSelect = new JButton("�˻�");
		btnUpdate = new JButton("����");
		btnInsert = new JButton("���� ���");
		btnDelete = new JButton("����");
		btnExit = new JButton("����");
		btnAll = new JButton("������ ����");
		tfSearch = new JTextField(15);
		btnSelect.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnInsert.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		tfSearch.addActionListener(this);
		btnAll.addActionListener(this);
		pNorth.add(tfSearch);
		pNorth.add(btnSelect);
		pSouth.add(btnUpdate);
		pNorth.add(btnInsert);
		pSouth.add(btnDelete);
		pNorth.add(btnExit);
		pSouth.add(btnAll);
		// rmPanel ���̱�
		//p1 = new rmPanel(new ImageIcon("C:\\Program Files\\Dev\\eclipse-workspace\\prj1\\src\\rmteam\\rm.png").getImage());
		p1 = new rmPanel(new ImageIcon("C:/Dev/workspace/team03/bin/rm.png").getImage());
		
		add(p1);
		pack();
		setVisible(true);
	}// ������

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnInsert) {
			rmInsert();
		} else if (obj == btnSelect) {
			rmSelect();
		} else if (obj == btnUpdate) {
			rmUpdate();
		} else if (obj == btnDelete) {
			rmDelete();
		} else if (obj == btnExit) {
			System.exit(0);
		} else if (obj == tfSearch) {

		} else if (obj == btnAll) {
			new AllRmFrame();
		}

	}// actionPerformed

	private rmDTO captureView() {
//		1.ȭ���Է°����� �����´�.
		String P_id = p1.tfP_id.getText();
		String name = p1.tfName.getText();
		String height = p1.tfHeight.getText();
		String weight = p1.tfWeight.getText();
		int age = Integer.parseInt(p1.tfAge.getText());
		String position = (String) p1.cbPosition.getSelectedItem();
		String nation = p1.tfNation.getText();

//		2.�� �����͸� ������ rd(DTO)�� �����.
		rmDTO rd = new rmDTO();
		rd.setP_id(P_id);
		rd.setName(name);
		rd.setHeight(height);
		rd.setWeight(weight);
		rd.setAge(age);
		rd.setPosition(position);
		rd.setNation(nation);
		return rd;
	}// capture view

	private void rmInsert() {
//		3.DAO�� ��ü�� ���� �� rd�� ����
		rmDTO rd = captureView();
		rmDAO dao = new rmDAO();
		dao.insertRm(rd);
		p1.tfP_id.setText("");
		p1.tfName.setText("");
		p1.tfHeight.setText("");
		p1.tfWeight.setText("");
		p1.tfAge.setText("");
		p1.tfPosition.setText("");
		p1.tfNation.setText("");
		JOptionPane.showMessageDialog(this, "���强��", "Save, OK?", JOptionPane.INFORMATION_MESSAGE);
	}// rminsert

	private void rmSelect() {
//		�̸��� �����´�
		String name = tfSearch.getText();
//		rmDTO rd�� db ������ ��´�.
		rmDAO dao = new rmDAO();
		rmDTO rd = dao.selectRm(name);
//		ȭ�鿡 �����ش�.
		if (rd.getP_id() == null) {
//			System.out.println("ã�� ������ �����ϴ�!");
			JOptionPane.showMessageDialog(this, "ã�� ������ �����ϴ�!", "Search, OK?", JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.out.println(rd);
			p1.tfP_id.setText(rd.getP_id());
			p1.tfName.setText(rd.getName());
			p1.tfHeight.setText(rd.getHeight());
			p1.tfWeight.setText(rd.getWeight());
			p1.tfAge.setText("" + rd.getAge());
			String position = rd.getPosition();
			p1.cbPosition.setSelectedItem(position);
			p1.tfNation.setText(rd.getNation());

		}

	}// rmselect

	private void rmUpdate() {
		rmDTO rd = captureView();
		rmDAO dao = new rmDAO();
		boolean ok = dao.UpdateRm(rd);
		if(ok) {
			JOptionPane.showMessageDialog(this, "���� ����", "Update, OK?", JOptionPane.INFORMATION_MESSAGE);
			p1.tfP_id.setText("");
			p1.tfName.setText("");
			p1.tfHeight.setText("");
			p1.tfWeight.setText("");
			p1.tfAge.setText("");
			p1.tfPosition.setText("");
			p1.tfNation.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "���� ����(������ȣ, �̸��� ���� �Ұ�", "Check, OK?", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void rmDelete() {
		rmDTO rd = captureView();
		rmDAO dao = new rmDAO();
		boolean ok = dao.DeleteRm(rd);
		p1.tfP_id.setText("");
		p1.tfName.setText("");
		p1.tfHeight.setText("");
		p1.tfWeight.setText("");
		p1.tfAge.setText("");
		p1.tfPosition.setText("");
		p1.tfNation.setText("");
		if(ok) {
			JOptionPane.showMessageDialog(this, "���� ����", "Delete, OK?", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "DB�� �ش� ������ �������� �ʽ��ϴ�.", "Check, OK?", JOptionPane.INFORMATION_MESSAGE);
		}
		

	}

	public static void main(String[] args) {
		new rmFrame();
	}// main

}// class
