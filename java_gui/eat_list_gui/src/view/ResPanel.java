package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

	public class ResPanel extends JPanel {
		JTextField tfResName, tfAddress, tfTel, tfReprMenu, tfPrice;
		JPanel pTel;
		JTextField tfTel1, tfTel2, tfTel3;
		
		public ResPanel() {
			setLayout(new GridLayout(6, 2, 5, 5)); //���̾ƿ� ����
			
			tfResName= new JTextField();
			tfAddress= new JTextField();
			pTel= new JPanel();
			tfTel1 = new JTextField(4);
			tfTel2 = new JTextField(4);
			tfTel3 = new JTextField(4);
			pTel.add(tfTel1);
			pTel.add(new JLabel("-"));
			pTel.add(tfTel2);
			pTel.add(new JLabel("-"));
			pTel.add(tfTel3);
			tfReprMenu= new JTextField();
			tfPrice= new JTextField();
			
			add(new JLabel("��ȣ��"));
			add(tfResName);
			add(new JLabel("�ּ�"));
			add(tfAddress);
			add(new JLabel("��ȭ��ȣ"));
			add(pTel);
			add(new JLabel("��ǥ�޴�"));
			add(tfReprMenu);
			add(new JLabel("����"));
			add(tfPrice);
		}
	}


