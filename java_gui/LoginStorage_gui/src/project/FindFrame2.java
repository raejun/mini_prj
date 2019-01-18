package project;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FindFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField showQuestion;
	private JTextField inputAnswer;
	private String r_answer;
	private String r_sc;
	JFrame f;
	public FindFrame2(int pn) {
		
		setBounds(100, 100, 351, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocation(800,400);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		btnNewButton.setBounds(113, 111, 105, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("맑은 고딕 Bold", Font.PLAIN, 17));
		lblAnswer.setBounds(55, 78, 69, 18);
		contentPane.add(lblAnswer);
		
		inputAnswer = new JTextField();
		inputAnswer.setBounds(128, 75, 160, 24);
		contentPane.add(inputAnswer);
		inputAnswer.setColumns(10);
		
		String question = null;
		String user = "daeding";
		String password = "10581058";
		String url = "jdbc:oracle:thin:@192.168.113.4:1521:XE";
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = "SELECT * FROM ls_user "
				+ "WHERE phonenumber = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pn);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {		// 핸드폰번호에 맞는 사용자의 Question, Answer, SecretCode를 받음
				question = rs.getString("question");
				r_answer = rs.getString("answer");
				r_sc = rs.getString("secretcode");
			}
			showQuestion = new JTextField();
			showQuestion.setBackground(Color.LIGHT_GRAY);
			showQuestion.setBounds(27, 12, 279, 51);
			contentPane.add(showQuestion);
			
			showQuestion.setColumns(10);
			showQuestion.setText(question);
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			if(psmt != null) {
				try {
					psmt.close();
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer = inputAnswer.getText();
				if(answer.equals(r_answer))
				{
					FindFrame3 f1 = new FindFrame3(r_sc);		// FindFrame3 프레임을 열며 SecretCode를 인자로 전달
					System.out.println("r_sc = " + r_sc);
				}
				else
					f = new WarningFrame(2);
			}
		});
		
		setVisible(true);
	}

}
