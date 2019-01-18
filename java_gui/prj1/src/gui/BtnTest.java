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
		if(cmd.equals("종료")) {
			System.out.println("종료합니다!");
			System.exit(0); // 프로그램 종료
		} else if(cmd.equals("버튼2")) {
			System.out.println("버튼2를 클릭했습니다!");
		}
	}//actionPerformed
	public BtnTest() {
		// 제목
		setTitle("버튼 테스트");
		// 크기
		setSize(300, 200);
		// 판넬 만들기
		p1 = new Panel();
		p1.setBackground(Color.ORANGE);
		// 프레임에 판넬 붙이기
		add(p1, BorderLayout.NORTH);
		// 버튼1을 만들어서 붙이기
		btn1 = new Button("종료");
		btn1.addActionListener(this); // 리스너 등록
		p1.add(btn1);
		// 버튼2를 만들어서 판넬에 붙이기
		btn2 = new Button("버튼2");
		btn2.addActionListener(this); // 리스너 등록
		p1.add(btn2);
		// 보이기
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new BtnTest();
	}//main
}//end
