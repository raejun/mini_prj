package gui;
import java.awt.*;
public class FirstFrame extends Frame {
	TextArea ta;
	public FirstFrame() {
		// ����
		setTitle("ù��° ����");
		// ũ�⸦ ����
		setSize(600, 400);
		// ������Ʈ �����
		ta = new TextArea();
		// ���̱�
		add(ta);
		// ���̱�
		setVisible(true);
	}// ������
	public static void main(String[] args) {
		FirstFrame f = new FirstFrame();
	}//main
}//end
