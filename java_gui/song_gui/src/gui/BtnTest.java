package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BtnTest extends Frame implements ActionListener {
	Button btn1;
	Button btn2;
	Panel p1;
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println("cmd= " + cmd);
		if (cmd.equals("����")) {
			System.out.println("end");
			System.exit(0);
		} else if (cmd.equals("��ư2")) {
			System.out.println("��ư2 ����");
//		System.out.println("��");
//		System.exit(0);//���α׷� ����
		}
	}
	public BtnTest() {
		// ����
		setTitle("��ư �׽�Ʈ");
		// ũ��
		setSize(300, 200);
		// �ǳ� �����
		p1 = new Panel();
		p1.setBackground(Color.cyan);
		// �����ӿ� �ǳ� ���̱�
		add(p1, BorderLayout.NORTH);
		// ������Ʈ �����
		btn1 = new Button("����");
		btn1.addActionListener(this);// this - ���� ó���Ѵ�
		p1.add(btn1);
		// ��ư2 ���� �ĳڿ� ���̱�
		btn2 = new Button("��ư2");
		btn2.addActionListener(this);
		p1.add(btn2);
		// ������Ʈ ���̱�

		// ���̱�
		setVisible(true);
	}

	public static void main(String[] args) {
		new BtnTest();
	}
}
