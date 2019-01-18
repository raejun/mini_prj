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

		String[] genres = { "선택", "SF", "드라마", "공포", "스릴러", "로맨스/멜로", "로맨틱코미디", "판타지", "다큐", "코미디", "뮤지컬", "애니메이션", "사극" };
		String[] grades = { "선택", "전체이용가", "7세", "12세", "15세", "청소년관람불가" };
		
		btnNewCode = new JButton("생성");
		btnCodeCheck = new JButton("체크");
		
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
		
		// 붙이기
		add(new JLabel("영화코드"));
		add(pCode);
		pCode.add(tfMovieCode);
		pCode.add(btnNewCode);
		pCode.add(btnCodeCheck);
		add(new JLabel("영화제목"));
		add(tfMovieTitle);
		add(new JLabel("감독이름"));
		add(tfDirectName);
		add(new JLabel("영화장르"));
		add(cbGenre);
		add(new JLabel("영화등급"));
		add(cbGrade);
		add(new JLabel("출연배우"));
		add(tfActs);
		add(new JLabel("상영시간"));
		add(pRuntime);
		pRuntime.add(sHour);
		pRuntime.add(new JLabel("시간"));
		pRuntime.add(sMin);
		pRuntime.add(new JLabel("분"));
		add(new JLabel("배급사"));
		add(tfMovieCompany);
		add(new JLabel("개봉일"));
		add(pOpenDate);
		pOpenDate.add(sYear);
		pOpenDate.add(new JLabel("년"));
		pOpenDate.add(sMonth);
		pOpenDate.add(new JLabel("월"));
		pOpenDate.add(sDay);
		pOpenDate.add(new JLabel("일"));
		add(new JLabel("설명"));
		add(tfMovieContents);

	}// 생성자

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
			JOptionPane.showMessageDialog(this, "생성 버튼을 눌러주세요", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(movie.getMovieCode() == null) {
			JOptionPane.showMessageDialog(this, "사용 가능한 코드입니다", "Check OK?", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "이미 사용 중인 코드입니다 재생성해주세요", "Check OK?", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	

}
