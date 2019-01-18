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
		btn1 = new Button("버튼1");
		btn2 = new Button("버튼2");
		BtnListener listener = new BtnListener();
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		p1.add(btn1);
		p1.add(btn2);
		setVisible(true);
	}//생성자
	// 내부 클래스로 이벤트 처리
	class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("버튼1")) {
				System.out.println("버튼1 클릭!!!");
			} else if(cmd.equals("버튼2")) {
				System.out.println("버튼2 클릭!!!");
			}
		}
	}//BtnListener
	public static void main(String[] args) {
		new BtnTest3();
	}//main
}//end
