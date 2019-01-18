package gui2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyFrame extends JFrame implements ActionListener {
	JButton btn1, btn2;
	JPanel pNorth;
	MyPanel1 p1;
	MyPanel2 p2;
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btn1) {
			p1=new MyPanel1();
			if(p2!=null) {
				remove(p2);
			}
			if(p1==null) {
				p1 = new MyPanel1();
				add(p1,BorderLayout.CENTER);
			}
			
			add(p1, BorderLayout.CENTER);
			validate(); //상태가 맞는지 체크
			repaint();  //다시 그리기
	        setSize(501,401);
	        setSize(500,400);
			
		}else if(obj==btn2) {
			p2=new MyPanel2();
			if(p1!=null) {
				remove(p1);
			}
			if(p2==null) {
				p2 = new MyPanel2();
				add(p2,BorderLayout.CENTER);
			}
			add(p2, BorderLayout.CENTER);
			validate();
			repaint();
	        setSize(501,401);
	        setSize(500,400);
		}
	}
	public MyFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("예제1");
		setSize(500, 400);
		pNorth = new JPanel();
		pNorth.setBackground(Color.MAGENTA);
		add(pNorth, BorderLayout.NORTH);
		btn1 = new JButton("판넬 1 붙이기");
		btn2 = new JButton("판넬 2 붙이기");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		pNorth.add(btn1);
		pNorth.add(btn2);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}//main

}//end
