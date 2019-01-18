package project;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindFrame3 extends JFrame {

	private JPanel contentPane;
	private JTextField showSecretcode;

	public FindFrame3(String sc) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocation(750,350);
		contentPane.setLayout(null);
		
		showSecretcode = new JTextField();
		showSecretcode.setBounds(46, 78, 329, 43);
		contentPane.add(showSecretcode);
		showSecretcode.setColumns(10);
		
		showSecretcode.setText(sc);
		
		JLabel lblSecretCode = new JLabel("Secret Code");
		lblSecretCode.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 21));
		lblSecretCode.setBounds(150, 25, 137, 31);
		contentPane.add(lblSecretCode);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.setFont(new Font("¸¼Àº °íµñ Bold", Font.PLAIN, 18));
		btnOk.setBounds(158, 177, 105, 27);
		contentPane.add(btnOk);
		
		setVisible(true);
	}

}
