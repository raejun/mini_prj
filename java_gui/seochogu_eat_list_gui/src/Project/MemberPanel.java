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
		setLayout(new GridLayout(5, 2, 20, 20)); // ���̾ƿ� ����
		tfRname = new JTextField();
		tfMenu = new JTextField();
		tfLocation = new JTextField();
		// ��ȭ��ȣ �ڵ�
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
		// ���̱�
		add(new JLabel("�ԤԤԤԤԤԤԻ��ȣ�Ը�"));
		add(tfRname);
		add(new JLabel("�ԤԤԤԤԤԤԤԸޤԴ�"));
		add(tfMenu);
		add(new JLabel("�ԤԤԤԤԤԤԤ�����ġ"));
		add(tfLocation);
		add(new JLabel("�ԤԤԤԤԤ�����ȭ�Թ���ȣ"));
		add(pTel);
		add(new JLabel("�ԤԤԤԤԤԤԤ԰��԰�"));
		add(tfPrice);
	}// ������
}// end
