package project;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WarningFrame extends JFrame {

	private JPanel contentPane;

	public WarningFrame(int a) {
		setBounds(100, 100, 345, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uAC12\uC774 \uC785\uB825\uB418\uC9C0 \uC54A\uC558\uAC70"
				+ "\uB098 \uC798\uBABB\uB41C \uAC12\uC785\uB2C8\uB2E4.");	// ���� �Է����� �ʾҰų� �߸��� �� �Դϴ�.
		label.setFont(new Font("���� ��� Bold", Font.PLAIN, 15));
		label.setBounds(14, 0, 298, 76);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("���� ��� Bold", Font.PLAIN, 17));
		btnNewButton.setBounds(106, 71, 105, 29);
		contentPane.add(btnNewButton);
		
		if(a == 1)		// ������ ��ġ�� ���� ���â ��ġ ����
			setLocation(810,420);
		else if(a == 2)
			setLocation(810,420);
		else if(a == 3)
			setLocation(330,360);
		setVisible(true);
	}

}
