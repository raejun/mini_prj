package gui2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyFrame1 extends JFrame implements ActionListener {
	JButton btn1, btn2;
	JPanel pNorth;
	MyPanel1 p1;
	MyPanel2 p2;
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn1) {
			if(p2 != null) {
				remove(p2);
			}
			if(p1 != null) { 
				remove(p1);
			}
			p1 = new MyPanel1();
			add(p1, BorderLayout.CENTER);
			validate();
			repaint();
		} else if(obj == btn2) {
			if(p1 != null) {
				remove(p1);
			}
			if(p2 != null) {
				remove(p2);
			}
			p2 = new MyPanel2();
			add(p2, BorderLayout.CENTER);
			validate();
			repaint();
			// setSize(501, 401);
			// setSize(500, 400);
		}
	}//actionPerformed
	public MyFrame1() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("예제1");
		setSize(500, 400);
		pNorth = new JPanel();
		pNorth.setBackground(Color.MAGENTA);
		add(pNorth, BorderLayout.NORTH);
		btn1 = new JButton("판넬1 붙이기");
		btn2 = new JButton("판넬2 붙이기");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		pNorth.add(btn1);
		pNorth.add(btn2);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new MyFrame1();
	}//main
}//end