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
		setLayout(new GridLayout(6, 2, 5, 5));  //���̾ƿ� ���� 6�� 2�� ���� ���� 5�� ����
		tfId = new JTextField();
		tfPw = new JTextField();
		tfName = new JTextField();
		//��ȭ��ȣ
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
		//���̱�
		add(new JLabel("���̵�"));
		add(tfId);
		add(new JLabel("���"));
		add(tfPw);
		add(new JLabel("�̸�"));
		add(tfName);
		add(new JLabel("��ȭ"));
		add(pTel);
		add(new JLabel("�ּ�"));
		add(tfAddress);
		add(new JLabel("����"));
		add(tfAge);
		
	}//������
}//end
