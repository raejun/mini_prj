package Team08;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dbconn extends JFrame {
	public Dbconn() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DB 접속 성공");
		lblNewLabel.setBounds(71, 0, 107, 53);
		getContentPane().add(lblNewLabel);
		setVisible(true);
		setLocation(750,350);
		setSize(270,110);
	}

	public static void main(String[] args) {
		Dbconn d3 = new Dbconn();
	}
}
