package gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BtnTest extends Frame implements ActionListener {
	Button btn1;
	Button btn2;
	Panel p1;
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println("cmd=" + cmd);
		if(cmd.equals("����")) {
			System.out.println("�����մϴ�!");
			System.exit(0); // ���α׷� ����
		} else if(cmd.equals("��ư2")) {
			System.out.println("��ư2�� Ŭ���߽��ϴ�!");
		}
	}//actionPerformed
	public BtnTest() {
		// ����
		setTitle("��ư �׽�Ʈ");
		// ũ��
		setSize(300, 200);
		// �ǳ� �����
		p1 = new Panel();
		p1.setBackground(Color.ORANGE);
		// �����ӿ� �ǳ� ���̱�
		add(p1, BorderLayout.NORTH);
		// ��ư1�� ���� ���̱�
		btn1 = new Button("����");
		btn1.addActionListener(this); // ������ ���
		p1.add(btn1);
		// ��ư2�� ���� �ǳڿ� ���̱�
		btn2 = new Button("��ư2");
		btn2.addActionListener(this); // ������ ���
		p1.add(btn2);
		// ���̱�
		setVisible(true);
	}//������
	public static void main(String[] args) {
		new BtnTest();
	}//main
}//end
