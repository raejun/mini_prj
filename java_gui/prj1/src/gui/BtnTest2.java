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
		btn1 = new Button("버튼1");
		btn2 = new Button("버튼2");
		// 단점 : 가독성이 나쁘다.
		btn1.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("버튼1 클릭했습니다!!!");
				}
			}
		);
		// Java 8에 추가된 람다 표현식
		btn2.addActionListener( (e) -> { System.out.println("버튼2 클릭했습니다!"); } );
		p1.add(btn1);
		p1.add(btn2);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new BtnTest2();
	}//main
}//end
