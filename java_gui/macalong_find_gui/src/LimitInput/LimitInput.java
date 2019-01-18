package LimitInput;

import java.util.regex.Pattern;

import javax.swing.JTextField;

public class LimitInput {
	//���鸷��
	public int checkNull(JTextField field) {
		if(field.getText().equals("")) {
			return 0;
		}else {
			return 1;
		}
	}

	//�����Է�, �����Է¸���
	public int checkNumOREng(JTextField field) {
		if(field.getText().equals("")||(Pattern.matches("^[0-9]+$", field.getText())) || (Pattern.matches("^[a-zA-Z]+$", field.getText()))) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//�ѱ��Է¸���
	public int checkHan(JTextField field) {
		if(field.getText().equals("")||(Pattern.matches("^[��-����-�Ӱ�-�R]+$", field.getText()))) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//����ö�� ��ȿ���� ���� �� ����
	public int checkSub(JTextField field) {
		String[] sub = {"����", "����", "�ұ�", "������", "���ų�", "����", "����", "����", "����", "�����й̵���Ƽ", "�����Ű����", "������û", "����", "����", "���", "����â", "����", "����", "ȿâ������","�ﰢ��","�����", "���¿�", "�Ѱ���", "��Ƽ��", "���", "û��", "�Ŵ�", "������", "â��", "����", "�Ⱦ�", "�����", "����", "�����", "������", "����", "�¸��Ա�", "ȭ����", "��ȭ��"};
		for(int i =0; i <sub.length; i++) {
			if(field.getText().equals(sub[i])) { return 1; }
			else {continue;}
		}
		return 0;
	}
}
