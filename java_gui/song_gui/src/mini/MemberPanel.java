package mini;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberPanel extends JPanel {
	
	JTextField tfId, tfPw, tfName, tfAddress, tfAge;
	JPanel pTel;
	JComboBox cbTel1;
	JTextField tfTel2, tfTel3;
	public MemberPanel() {
		setLayout(new GridLayout(6, 2, 5, 5));  //레이아웃 변경 6개 2개 가로 세로 5씩 간격
		tfId = new JTextField();
		tfPw = new JTextField();
		tfName = new JTextField();
		//전화번호
		pTel = new JPanel();
		String[] arrTel = {"010","011","016","017","019"};
		cbTel1 = new JComboBox(arrTel);
		tfTel2 = new JTextField(6);
		tfTel3 = new JTextField(6);
		pTel.add(cbTel1);
		pTel.add(new JLabel("-"));
		pTel.add(tfTel2);
		pTel.add(new JLabel("-"));
		pTel.add(tfTel3);
		tfAddress = new JTextField();
		tfAge = new JTextField();
		//붙이기
		add(new JLabel("아이디"));
		add(tfId);
		add(new JLabel("비번"));
		add(tfPw);
		add(new JLabel("이름"));
		add(tfName);
		add(new JLabel("전화"));
		add(pTel);
		add(new JLabel("주소"));
		add(tfAddress);
		add(new JLabel("나이"));
		add(tfAge);
		
	}//생성자
}//end
