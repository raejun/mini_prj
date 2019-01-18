package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Big extends JFrame implements ActionListener {
	Panel2 p2;
	Panel1 p1;
	JPanel pNorth;
	JButton btn2, btn1;
	
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
			p1 = new Panel1();
			add(p1, BorderLayout.CENTER);
			validate();
			repaint();
		}	else if(obj == btn2) {
			if(p1 != null) {
				remove(p1);
			}
			if(p2 != null) { 
				remove(p2);
			}
			p2 = new Panel2();
			add(p2, BorderLayout.CENTER);
			validate();
			repaint();
		}
	}
	public Big() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(501, 401);
		setSize(500, 400);
		setTitle("서초구맛집리스트");
		pNorth = new JPanel();
		pNorth.setBackground(Color.GRAY);
		add(pNorth, BorderLayout.NORTH);
		btn2 = new JButton("리스트");
		btn1 = new JButton("상호명 검색 / 수정");
		btn1.setForeground(Color.BLACK);
		btn2.setForeground(Color.BLACK);
		//btn2.setFont(BoldAction);
		//btn1.setFont(BoldAction);
		btn1.setBackground(Color.LIGHT_GRAY);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addActionListener(this);
		btn1.addActionListener(this);
		pNorth.add(btn2);
		pNorth.add(btn1);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new Big();
	}//main

}//end
