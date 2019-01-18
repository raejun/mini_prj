package Team08;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dbconnx extends JFrame {
	public Dbconnx() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DB 접속 종료");
		lblNewLabel.setBounds(71, 0, 107, 53);
		getContentPane().add(lblNewLabel);
		setVisible(true);
		setLocation(750,350);
		setSize(270,110);
	}

	public static void main(String[] args) {
		Dbconn d4 = new Dbconn();
	}
}
