package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.resDAO;
import model.resDTO;

public class startView extends JFrame implements ActionListener{
	JPanel pNorth;
	JButton btnInsert, btnSelect, btnUpdate, btnDelete, btnExit, btnAll;
	JTextField tfSearch;
	ResPanel p1;
	
	public startView() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�̴� ������Ʈ");
		setSize(500,300);
		setLocation(700,350);
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
		btnAll.addActionListener(this);
		tfSearch.addActionListener(this); //���͸� ���� �� �̺�Ʈ �߻�
		pNorth.add(btnInsert);
		pNorth.add(tfSearch);
		pNorth.add(btnSelect);
		pNorth.add(btnUpdate);
		pNorth.add(btnDelete);
		pNorth.add(btnExit);
		pNorth.add(btnAll);
		p1 = new ResPanel();
		add(p1);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnInsert) {
			resInsert();
		} else if (obj == btnSelect) {
			resSelect();
		} else if (obj == btnUpdate) {
			resUpdate();
		} else if (obj == btnDelete) {
			resDelete();
		} else if (obj == btnExit) {
			System.exit(0);
		} else if (obj == tfSearch) {
			//memSelect();
		} else if (obj == btnAll) {
			new allView();
		}
	}
	
	private void resSelect() {
		String resname = tfSearch.getText();
		resDAO dao = new resDAO();
		resDTO res = dao.selectRes(resname);
		if(res.getResName() != null) {
			System.out.println(res);
			p1.tfResName.setText(res.getResName());
			p1.tfAddress.setText(res.getAddress());
			p1.tfReprMenu.setText(res.getReprMenu());
			p1.tfPrice.setText("" + res.getPrice()); // �տ� ���� String�̸� �ڿ� �͵� String ó��
			String tel1 = null;
			String tel2 = null;
			String tel3 = null;
			if (!res.getTel().equals("--")) {
				String tel = res.getTel();
				String [] arrTel = tel.split("-");
				tel1 = arrTel[0];
				tel2 = arrTel[1];
				tel3 = arrTel[2];
			}
			p1.tfTel1.setText(tel1);
			p1.tfTel2.setText(tel2);
			p1.tfTel3.setText(tel3);
		} else {
			JOptionPane.showMessageDialog(this, "�������� �ʽ��ϴ�.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private resDTO captureView() {
		//1. ȭ���� �Է°����� �����´�.
		String resname = p1.tfResName.getText();
		String address = p1.tfAddress.getText();
		String tel1 = (String)p1.tfTel1.getText(); //��ȭ��ȣ ù° �ڸ�
		String tel2 = (String)p1.tfTel2.getText();
		String tel3 = (String)p1.tfTel3.getText();
		String tel = tel1 + "-" + tel2 + "-" + tel3;
		String reprmenu = p1.tfReprMenu.getText();
		int price = 0;
		if(!p1.tfPrice.getText().equals("")) {
			price  = Integer.parseInt(p1.tfPrice.getText());
		}
		resDTO res = new resDTO();
		res.setResName(resname);
		res.setAddress(address);
		res.setTel(tel);
		res.setReprMenu(reprmenu);
		res.setPrice(price);
		return res;
	}
	
	private void resInsert() {
		resDTO res = captureView();
		resDAO dao = new resDAO();
		if (!res.getResName().equals("") && !res.getAddress().equals("") && !res.getReprMenu().equals("")) {
			dao.insertRes(res);
			JOptionPane.showMessageDialog(this, "���� ����", "Save Success", JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (res.getResName().equals("")) {
				JOptionPane.showMessageDialog(this, "��ȣ���� �Է����ּ���.", "Error", JOptionPane.INFORMATION_MESSAGE);
			} else if (res.getAddress().equals("")) {
				JOptionPane.showMessageDialog(this, "�ּҸ� �Է����ּ���.", "Error", JOptionPane.INFORMATION_MESSAGE);
			} else if (res.getReprMenu().equals("")) {
				JOptionPane.showMessageDialog(this, "��ǥ�޴��� �Է����ּ���.", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	private void resUpdate() {
		resDTO res = captureView();
		resDAO dao = new resDAO();
		if(dao.updateRes(res) == 0) {
			JOptionPane.showMessageDialog(this, "�������� �ʴ� ��ȣ���Դϴ�.", "Update Result", JOptionPane.INFORMATION_MESSAGE);
		} 
		if(dao.updateRes(res) == 2) {
			dao.updateRes(res);
			JOptionPane.showMessageDialog(this, "���� �����߽��ϴ�.", "Update Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void resDelete() {
		resDTO res = captureView();
		resDAO dao = new resDAO();
		
		if(dao.deleteRes(res) == 0) {
			JOptionPane.showMessageDialog(this, "��ȣ��� �ּҸ� Ȯ�����ּ���.", "Delete Result", JOptionPane.INFORMATION_MESSAGE);
		} else {
			dao.deleteRes(res);
			JOptionPane.showMessageDialog(this, "���� �����߽��ϴ�.", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new startView();
	}
}
