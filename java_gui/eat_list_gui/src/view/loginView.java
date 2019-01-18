package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.userDAO;
import model.userDTO;

public class loginView extends JFrame{
	private JTextField tfId;
	private JPasswordField tfPw;
	private JButton btnSignUp, btnSignIn;
	
	public loginView() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("로그인");
		setSize(230, 150);
		setLocation(800,450);
		
		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		
		add(panel);
		
		setVisible(true);
		
	}
	
	public void placeLoginPanel(JPanel panel) {
		JLabel idLabel = new JLabel("아이디 :   ");
	    panel.add(idLabel);
	    
	    tfId = new JTextField(10);
		panel.add(tfId);
	    
	    JLabel pwLabel = new JLabel("비밀번호 : ");
	    panel.add(pwLabel);
	    
	    tfPw = new JPasswordField(10);
	    panel.add(tfPw);
		
		
	    
	    btnSignIn = new JButton("로그인");
	    btnSignIn.setBounds(160,80,100,25);
	    panel.add(btnSignIn);
	    btnSignIn.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	Object obj = e.getSource();
	        	if(obj == btnSignIn) {
	        		usrSignIn();
	        	}
	         }
	      });
	    
	      btnSignUp = new JButton("회원가입");
	      btnSignUp.setBounds(10,80,100,25);
	      panel.add(btnSignUp);
	      btnSignUp.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 
	         }
	         
	      });
	    
	}

	
	private void usrSignIn() {
		String id = tfId.getText();
		String pw = tfPw.getText();
		userDAO dao = new userDAO();
		userDTO usr = new userDTO();
		usr.setId(id);
		usr.setPw(pw);
		dao.signin(usr);
		if(dao.signin(usr).equals("2")) {
			JOptionPane.showMessageDialog(this, "관리자 로그인 성공!", "Login success", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			new startView();
		} else if ((dao.signin(usr).equals("3"))){
			JOptionPane.showMessageDialog(this, "회원 로그인 성공!", "Login success", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			new allView2();
		} else {
			JOptionPane.showMessageDialog(this, "ID 혹은 PW를 확인해주세요.", "Login Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void main(String[] args) {
		new loginView();
	}
}




