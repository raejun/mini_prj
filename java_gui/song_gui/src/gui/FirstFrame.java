package gui;
import java.awt.*;
public class FirstFrame extends Frame {
	TextArea ta;
	public FirstFrame() {
		//제목
		setTitle("첫번째예제");
		//크기를 지정
		setSize(800,600);
		//컴포넌트 만들기
		ta = new TextArea();
		//붙이기
		add(ta);
		//보이기
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FirstFrame f = new FirstFrame();
		
	}

}
