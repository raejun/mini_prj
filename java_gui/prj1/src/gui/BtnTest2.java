package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BtnTest2 extends Frame {
	Button btn1, btn2;
	Panel p1;
	public BtnTest2() {
		setSize(400, 300);
		p1 = new Panel();
		p1.setBackground(Color.LIGHT_GRAY);
		add(p1, BorderLayout.NORTH);
		btn1 = new Button("��ư1");
		btn2 = new Button("��ư2");
		// ���� : �������� ���ڴ�.
		btn1.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("��ư1 Ŭ���߽��ϴ�!!!");
				}
			}
		);
		// Java 8�� �߰��� ���� ǥ����
		btn2.addActionListener( (e) -> { System.out.println("��ư2 Ŭ���߽��ϴ�!"); } );
		p1.add(btn1);
		p1.add(btn2);
		setVisible(true);
	}//������
	public static void main(String[] args) {
		new BtnTest2();
	}//main
}//end
