package jyl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import Mini_BasketballDB.Bk_mainPanel;


public class JY_FestivalFrame extends JFrame{
	JPanel pSouth;
	JButton btnInsert, btnDelete;
	JY_FestivalPanel p1;
	JTextField nameField, sb1, sb2, sb3;
	
	// ������ 
	public JY_FestivalFrame () {
		//1) basic setting 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("������");
		Dimension dim = new Dimension(400,300);
		/*setLocation(200, 400);
	    setPreferredSize(dim);*/

		//2) �г� ���� �� ����
		pSouth = new JPanel();
		pSouth.setBackground(Color.DARK_GRAY);
		add(pSouth, BorderLayout.SOUTH);

		//3)��ư ���� �� ����
		// ��ư ����
		btnInsert = new JButton("�߰�");
		btnDelete = new JButton("����");
		nameField = new JTextField(5);
		sb1 = new JTextField(5);
		sb2 = new JTextField(5);
		sb3 = new JTextField(5);// length
		
		
		pSouth.add(nameField);
		pSouth.add(sb1);
		pSouth.add(sb2);
		pSouth.add(sb3);
		pSouth.add(btnInsert);
		pSouth.add(btnDelete);
		
		
		// 4) p1 �г��� ���� �߾ӿ� ���̱� 
		p1 = new JY_FestivalPanel();
		add(p1);
		
		// setVisible
		setVisible(true);
				
		
	}// ������ 
   
   public static void main(String[] args) {
	   new JY_FestivalFrame();
	   
	   JY_DAO a =new JY_DAO();
	   a.getConn();
	   System.out.println(a);
   }
}