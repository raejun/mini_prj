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
		if (cmd.equals("종료")) {
			System.out.println("end");
			System.exit(0);
		} else if (cmd.equals("버튼2")) {
			System.out.println("버튼2 누름");
//		System.out.println("끝");
//		System.exit(0);//프로그램 종료
		}
	}
	public BtnTest() {
		// 제목
		setTitle("버튼 테스트");
		// 크기
		setSize(300, 200);
		// 판넬 만들기
		p1 = new Panel();
		p1.setBackground(Color.cyan);
		// 프레임에 판넬 붙이기
		add(p1, BorderLayout.NORTH);
		// 컴포넌트 만들기
		btn1 = new Button("종료");
		btn1.addActionListener(this);// this - 내가 처리한다
		p1.add(btn1);
		// 버튼2 만들어서 파넬에 붙이기
		btn2 = new Button("버튼2");
		btn2.addActionListener(this);
		p1.add(btn2);
		// 컴포넌트 붙이기

		// 보이기
		setVisible(true);
	}

	public static void main(String[] args) {
		new BtnTest();
	}
}
