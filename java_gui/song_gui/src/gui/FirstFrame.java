package gui;
import java.awt.*;
public class FirstFrame extends Frame {
	TextArea ta;
	public FirstFrame() {
		//����
		setTitle("ù��°����");
		//ũ�⸦ ����
		setSize(800,600);
		//������Ʈ �����
		ta = new TextArea();
		//���̱�
		add(ta);
		//���̱�
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FirstFrame f = new FirstFrame();
		
	}

}
