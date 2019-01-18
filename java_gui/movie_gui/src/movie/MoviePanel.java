package movie;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class MoviePanel extends JPanel implements ActionListener {
	JTextField tfMovieCode, tfSearch, tfMovieTitle, tfDirectName, tfActs, tfMovieCompany, tfMovieContents;
	JComboBox cbGenre, cbGrade;
	JPanel pRuntime, pOpenDate, pCode;
	SpinnerNumberModel yearModel, monthModel, dayModel, hourModel, minModel;
	JSpinner sYear, sMonth, sDay, sHour, sMin;
	MoviePanel p1;
	JButton btnNewCode, btnCodeCheck;

	private int certCharLength = 8;
	private final char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	public MoviePanel() {
		setLayout(new GridLayout(10, 2, 5, 5));

		String[] genres = { "����", "SF", "���", "����", "������", "�θǽ�/���", "�θ�ƽ�ڹ̵�", "��Ÿ��", "��ť", "�ڹ̵�", "������", "�ִϸ��̼�", "���" };
		String[] grades = { "����", "��ü�̿밡", "7��", "12��", "15��", "û�ҳ�����Ұ�" };
		
		btnNewCode = new JButton("����");
		btnCodeCheck = new JButton("üũ");
		
		cbGenre = new JComboBox(genres);
		cbGrade = new JComboBox(grades);

		pRuntime = new JPanel();
		pOpenDate = new JPanel();
		pCode = new JPanel();

		tfMovieCode = new JTextField(11);
		tfMovieTitle = new JTextField();
		tfDirectName = new JTextField();
		tfActs = new JTextField();
		tfMovieCompany = new JTextField();
		tfMovieContents = new JTextField();

		yearModel = new SpinnerNumberModel(2018, 1999, 2999, 1);
		monthModel = new SpinnerNumberModel(1, 1, 12, 1);
		dayModel = new SpinnerNumberModel(1, 1, 31, 1);
		hourModel = new SpinnerNumberModel(0, 0, 23, 1);
		minModel = new SpinnerNumberModel(0, 0, 59, 1);
		
		sYear = new JSpinner(yearModel);
		sMonth = new JSpinner(monthModel);
		sDay = new JSpinner(dayModel);
		sHour = new JSpinner(hourModel);
		sMin = new JSpinner(minModel);

		NumberEditor editor = new NumberEditor (sYear, "#");
		sYear.setEditor(editor);

		btnNewCode.addActionListener(this);
		btnCodeCheck.addActionListener(this);
		
		// ���̱�
		add(new JLabel("��ȭ�ڵ�"));
		add(pCode);
		pCode.add(tfMovieCode);
		pCode.add(btnNewCode);
		pCode.add(btnCodeCheck);
		add(new JLabel("��ȭ����"));
		add(tfMovieTitle);
		add(new JLabel("�����̸�"));
		add(tfDirectName);
		add(new JLabel("��ȭ�帣"));
		add(cbGenre);
		add(new JLabel("��ȭ���"));
		add(cbGrade);
		add(new JLabel("�⿬���"));
		add(tfActs);
		add(new JLabel("�󿵽ð�"));
		add(pRuntime);
		pRuntime.add(sHour);
		pRuntime.add(new JLabel("�ð�"));
		pRuntime.add(sMin);
		pRuntime.add(new JLabel("��"));
		add(new JLabel("��޻�"));
		add(tfMovieCompany);
		add(new JLabel("������"));
		add(pOpenDate);
		pOpenDate.add(sYear);
		pOpenDate.add(new JLabel("��"));
		pOpenDate.add(sMonth);
		pOpenDate.add(new JLabel("��"));
		pOpenDate.add(sDay);
		pOpenDate.add(new JLabel("��"));
		add(new JLabel("����"));
		add(tfMovieContents);

	}// ������

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnNewCode) {
			insertNewCode();
		} else if(obj == btnCodeCheck) {
			selectCodeCheck();
		}
	}

	private void insertNewCode() {
		Random random = new Random(System.currentTimeMillis());
		int tablelength = characterTable.length;
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < certCharLength; i++) {
			buf.append(characterTable[random.nextInt(tablelength)]);
		}
		
		String newCode = "MV-" + buf.toString();
		
		tfMovieCode.setText(newCode);
	}

	private void selectCodeCheck() {
		String code = tfMovieCode.getText();
		MovieDAO dao = new MovieDAO();
		MovieDTO movie = dao.selectCodeCheck(code);
		
		if (tfMovieCode.getText() == null) {
			JOptionPane.showMessageDialog(this, "���� ��ư�� �����ּ���", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(movie.getMovieCode() == null) {
			JOptionPane.showMessageDialog(this, "��� ������ �ڵ��Դϴ�", "Check OK?", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "�̹� ��� ���� �ڵ��Դϴ� ��������ּ���", "Check OK?", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	

}
