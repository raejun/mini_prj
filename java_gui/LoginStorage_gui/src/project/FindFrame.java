package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindFrame extends JFrame {

	private JPanel contentPane;
	private JTextField number1;
	private JTextField number2;
	private JTextField number3;

	public FindFrame() {
		setTitle("LS - Find");
		setBounds(100, 100, 351, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(807,410);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 335, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFind = new JLabel("Find");
		lblFind.setFont(new Font("¸¼Àº °íµñ Bold", Font.BOLD, 25));
		lblFind.setBounds(12, 0, 59, 44);
		panel.add(lblFind);
		
		JLabel label_1 = new JLabel("PhoneNumber");
		label_1.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 15));
		label_1.setBounds(33, 67, 103, 15);
		panel.add(label_1);
		
		number1 = new JTextField();
		number1.setColumns(10);
		number1.setBounds(142, 64, 40, 21);
		panel.add(number1);
		
		JLabel label_2 = new JLabel("-");
		label_2.setBounds(187, 67, 19, 15);
		panel.add(label_2);
		
		number2 = new JTextField();
		number2.setColumns(10);
		number2.setBounds(200, 64, 40, 21);
		panel.add(number2);
		
		JLabel label_3 = new JLabel("-");
		label_3.setBounds(246, 67, 19, 15);
		panel.add(label_3);
		
		number3 = new JTextField();
		number3.setColumns(10);
		number3.setBounds(261, 64, 40, 21);
		panel.add(number3);
		
		JButton button = new JButton("Submit");
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String js_phonenumber = number1.getText() + number2.getText() + number3.getText();
				int j_phonenumber = Integer.parseInt(js_phonenumber);
				System.out.println(j_phonenumber);
				FindFrame2 f1 = new FindFrame2(j_phonenumber);		// FindFrame2 ÇÁ·¡ÀÓÀ» ¿­¸ç ÇÚµåÆù¹øÈ£¸¦ ÀÎÀÚ·Î Àü´Þ
			}
		});
		
		
		
		button.setForeground(Color.BLACK);
		button.setFont(new Font("¸¼Àº °íµñ Bold", Font.BOLD, 15));
		button.setBackground(Color.GRAY);
		button.setBounds(125, 106, 97, 30);
		panel.add(button);
		setVisible(true);
	}
}
