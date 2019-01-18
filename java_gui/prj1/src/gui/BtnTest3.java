package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BtnTest3 extends Frame {
	Button btn1, btn2;
	Panel p1;
	public BtnTest3() {
		setSize(400, 300);
		p1 = new Panel();
		p1.setBackground(Color.PINK);
		add(p1, BorderLayout.NORTH);
		btn1 = new Button("��ư1");
		btn2 = new Button("��ư2");
		BtnListener listener = new BtnListener();
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		p1.add(btn1);
		p1.add(btn2);
		setVisible(true);
	}//������
	// ���� Ŭ������ �̺�Ʈ ó��
	class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("��ư1")) {
				System.out.println("��ư1 Ŭ��!!!");
			} else if(cmd.equals("��ư2")) {
				System.out.println("��ư2 Ŭ��!!!");
			}
		}
	}//BtnListener
	public static void main(String[] args) {
		new BtnTest3();
	}//main
}//end
