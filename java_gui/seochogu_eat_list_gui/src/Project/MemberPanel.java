package Project;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberPanel extends JPanel {
	JTextField tfRname, tfMenu, tfLocation, tfPrice;
	JPanel pTel;
	JComboBox cbTel1;
	JTextField tfTel2, tfTel3;

	public MemberPanel() {
		setLayout(new GridLayout(5, 2, 20, 20)); // 레이아웃 변경
		tfRname = new JTextField();
		tfMenu = new JTextField();
		tfLocation = new JTextField();
		// 전화번호 코드
		pTel = new JPanel();
		String[] arrTel = { "010", "011", "016", "017", "019" };
		cbTel1 = new JComboBox(arrTel);
		tfTel2 = new JTextField(6);
		tfTel3 = new JTextField(6);
		pTel.add(cbTel1);
		pTel.add(new JLabel("-"));
		pTel.add(tfTel2);
		pTel.add(new JLabel("-"));
		pTel.add(tfTel3);
		tfPrice = new JTextField();
		// 붙이기
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤ상ㅤ호ㅤ명"));
		add(tfRname);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤ메ㅤ뉴"));
		add(tfMenu);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤ위ㅤ치"));
		add(tfLocation);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤ전ㅤ화ㅤ번ㅤ호"));
		add(pTel);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤ가ㅤ격"));
		add(tfPrice);
	}// 생성자
}// end
