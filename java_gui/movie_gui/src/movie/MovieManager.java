package movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MovieManager extends JFrame implements ActionListener {

	JPanel pNorth;
	JButton btnInsert, btnSelect, btnUpdate, btnDelete, btnExit, btnAll;
	JTextField tfSearch;
	MoviePanel p1;

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnExit) {
			System.exit(0);
		} else if (obj == btnInsert) {
			movieInsert();
		} else if (obj == btnSelect) {
			movieSelect();
		} else if (obj == btnUpdate) {
			movieUpdate();
		} else if (obj == btnDelete) {
			movieDelete();
		} else if (obj == btnAll) {
			new AllMovieFrame();
		}

	}

	public MovieManager() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("영화정보관리 미니 프로젝트");
		setSize(600, 600);
		pNorth = new JPanel();
		pNorth.setBackground(Color.DARK_GRAY);
		add(pNorth, BorderLayout.NORTH);
		btnInsert = new JButton("입력");
		btnSelect = new JButton("검색");
		btnDelete = new JButton("삭제");
		btnUpdate = new JButton("수정");
		btnExit = new JButton("종료");
		btnAll = new JButton("전체보기");
		tfSearch = new JTextField(6);

		btnInsert.addActionListener(this);
		btnSelect.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnExit.addActionListener(this);
		btnAll.addActionListener(this);
		tfSearch.addActionListener(this);
		pNorth.add(btnInsert);
		pNorth.add(tfSearch);
		pNorth.add(btnSelect);
		pNorth.add(btnDelete);
		pNorth.add(btnUpdate);
		pNorth.add(btnExit);
		pNorth.add(btnAll);

		p1 = new MoviePanel();
		add(p1);

		setVisible(true);

	}

	private MovieDTO captureView() {

		String movieCode = p1.tfMovieCode.getText();
		String movieTitle = p1.tfMovieTitle.getText();
		String directName = p1.tfDirectName.getText();
		String acts = p1.tfActs.getText();
		String movieCompany = p1.tfMovieCompany.getText();
		String genre = (String) p1.cbGenre.getSelectedItem();
		String grade = (String) p1.cbGrade.getSelectedItem();
		int hour = (int) p1.sHour.getValue();
		int min = (int) p1.sMin.getValue();
		String runTime = hour + ":" + min;
		int year = (int) p1.sYear.getValue();
		int month = (int) p1.sMonth.getValue();
		int day = (int) p1.sDay.getValue();
		String mon = "0" + month;
		String d = "0" + day;
		String openDate = null;

		if (month < 10 && day >= 10) {
			openDate = year + "-" + mon + "-" + day;
		} else if (month >= 10 && day < 10) {
			openDate = year + "-" + month + "-" + d;
		} else if (month < 10 && day < 10) {
			openDate = year + "-" + mon + "-" + d;
		} else {
			openDate = year + "-" + month + "-" + day;
		}

		Date date = Date.valueOf(openDate);

		String movieContents = p1.tfMovieContents.getText();

		MovieDTO movie = new MovieDTO();

		movie.setMovieCode(movieCode);
		movie.setMovieTitle(movieTitle);
		movie.setDirectName(directName);
		movie.setActs(acts);
		movie.setMovieCompany(movieCompany);
		movie.setGenre(genre);
		movie.setGrade(grade);
		movie.setMovieRunTime(runTime);
		movie.setMovieOpendate(date);
		movie.setMovieContents(movieContents);

		return movie;
	}

	private void movieInsert() {

		MovieDTO movie = captureView();
		MovieDAO dao = new MovieDAO();

		if(p1.tfMovieTitle.getText() == null) {
			JOptionPane.showMessageDialog(this, "영화 제목을 입력해주세요", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(p1.tfDirectName.getText() == null) {
			JOptionPane.showMessageDialog(this, "감독 이름을 입력해주세요", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(p1.tfMovieCode.getText().length() < 11 && p1.tfMovieCode.getText().length() > 11) {
			JOptionPane.showMessageDialog(this, "생성 버튼으로 입력해주세요", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(p1.tfDirectName.getText() == null) {
			JOptionPane.showMessageDialog(this, "감독 이름을 입력해주세요", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(p1.cbGenre.getSelectedItem() == "선택") {
			JOptionPane.showMessageDialog(this, "장르를 선택해주세요", "Select OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(p1.cbGrade.getSelectedItem() == "선택") {
			JOptionPane.showMessageDialog(this, "등급을 선택해주세요", "Select OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(p1.tfActs.getText() == null) {
			JOptionPane.showMessageDialog(this, "출연 배우를 입력해주세요", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if((int)p1.sHour.getValue() == 0) {
			JOptionPane.showMessageDialog(this, "상영 시간을 입력해주세요", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(p1.tfMovieCompany.getText() == null) {
			JOptionPane.showMessageDialog(this, "배급사를 입력해주세요", "Insert OK?", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "저장을 성공했습니다", "Save OK?", JOptionPane.INFORMATION_MESSAGE);
			dao.insertMovie(movie);
			
			p1.tfMovieTitle.setText("");
			p1.tfDirectName.setText("");
			p1.tfMovieCode.setText("");
			p1.cbGenre.setSelectedItem("선택");
			p1.cbGrade.setSelectedItem("선택");
			p1.tfActs.setText("");
			p1.tfMovieCompany.setText("");
			p1.sHour.setValue(0);
			p1.sMin.setValue(0);
			p1.sYear.setValue(2018);
			p1.sMonth.setValue(1);
			p1.sDay.setValue(1);
			p1.tfMovieContents.setText("");
		}
		

	}

	private void movieSelect() {
		String name = tfSearch.getText();
		MovieDAO dao = new MovieDAO();
		MovieDTO movie = dao.selectMovie(name);

		if (movie.getMovieCode() == null) {
			JOptionPane.showMessageDialog(this, "찾는 영화가 없습니다.", "Search OK?", JOptionPane.INFORMATION_MESSAGE);
		} else if(tfSearch.getText() == null) {
			JOptionPane.showMessageDialog(this, "영화 제목을 입력해주세요", "Search OK?", JOptionPane.INFORMATION_MESSAGE);
		} else {
		
			p1.tfMovieCode.setText(movie.getMovieCode());
			p1.tfMovieTitle.setText(movie.getMovieTitle());
			p1.tfDirectName.setText(movie.getDirectName());
			p1.tfActs.setText(movie.getActs());
			p1.tfMovieCompany.setText(movie.getMovieCompany());

			p1.cbGenre.setSelectedItem(movie.getGenre());
			p1.cbGrade.setSelectedItem(movie.getGrade());

			Date openDate = movie.getMovieOpendate();
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String sOpenDate = date.format(openDate);
			String[] arrOpenDate = sOpenDate.split("-");
			int sYear = Integer.parseInt(arrOpenDate[0]);
			int sMonth = Integer.parseInt(arrOpenDate[1]);
			int sDay = Integer.parseInt(arrOpenDate[2]);
			p1.sDay.setValue(sDay);
			p1.sMonth.setValue(sMonth);
			p1.sYear.setValue(sYear);

			String movieRunTime = movie.getMovieRunTime();
			String[] arrMovieRunTime = movieRunTime.split(":");
			int Hour = Integer.parseInt(arrMovieRunTime[0]);
			int Min = Integer.parseInt(arrMovieRunTime[1]);
			p1.sHour.setValue(Hour);
			p1.sMin.setValue(Min);

			p1.tfMovieContents.setText(movie.getMovieContents());

		}

	}

	private void movieUpdate() {
		String movieCode = p1.tfMovieCode.getText();
		String movieTitle = p1.tfMovieTitle.getText();
		int year = (int) p1.sYear.getValue();
		int month = (int) p1.sMonth.getValue();
		int day = (int) p1.sDay.getValue();
		String mon = "0" + month;
		String d = "0" + day;
		String openDate = null;

		if (month < 10 && day >= 10) {
			openDate = year + "-" + mon + "-" + day;
		} else if (month >= 10 && day < 10) {
			openDate = year + "-" + month + "-" + d;
		} else if (month < 10 && day < 10) {
			openDate = year + "-" + mon + "-" + d;
		} else {
			openDate = year + "-" + month + "-" + day;
		}

		Date date = Date.valueOf(openDate);

		String movieContents = p1.tfMovieContents.getText();

		MovieDTO movie = new MovieDTO();
		MovieDAO dao = new MovieDAO();

		movie.setMovieOpendate(date);
		movie.setMovieCode(movieCode);
		movie.setMovieTitle(movieTitle);
		movie.setMovieContents(movieContents);

		dao.updateMovie(movie);

		JOptionPane.showMessageDialog(this, "수정을 성공했습니다", "Save OK?", JOptionPane.INFORMATION_MESSAGE);

		p1.tfMovieTitle.setText("");
		p1.tfDirectName.setText("");
		p1.tfMovieCode.setText("");
		p1.cbGenre.setSelectedItem("선택");
		p1.cbGrade.setSelectedItem("선택");
		p1.tfActs.setText("");
		p1.tfMovieCompany.setText("");
		p1.sHour.setValue(0);
		p1.sMin.setValue(0);
		p1.sYear.setValue(2018);
		p1.sMonth.setValue(1);
		p1.sDay.setValue(1);
		p1.tfMovieContents.setText("");
		
	}

	private void movieDelete() {
		String movieCode = p1.tfMovieCode.getText();
		String movieTitle = p1.tfMovieTitle.getText();

		MovieDTO movie = captureView();
		MovieDAO dao = new MovieDAO();

		movie.setMovieCode(movieCode);
		movie.setMovieTitle(movieTitle);

		JOptionPane.showMessageDialog(this, "삭제를 성공했습니다", "Save OK?", JOptionPane.INFORMATION_MESSAGE);

		dao.deleteMovie(movie);
		
		p1.tfMovieTitle.setText("");
		p1.tfDirectName.setText("");
		p1.tfMovieCode.setText("");
		p1.cbGenre.setSelectedItem("선택");
		p1.cbGrade.setSelectedItem("선택");
		p1.tfActs.setText("");
		p1.tfMovieCompany.setText("");
		p1.sHour.setValue(0);
		p1.sMin.setValue(0);
		p1.sYear.setValue(2018);
		p1.sMonth.setValue(1);
		p1.sDay.setValue(1);
		p1.tfMovieContents.setText("");
		

	}

	public static void main(String[] args) {
		new MovieManager();
	}// main

}// end

/*
-- MOVIE Table Create SQL
CREATE TABLE MOVIE
(
    MOVIE_CODE        VARCHAR2(30)      NOT NULL, 
    MOVIE_TITLE       VARCHAR2(100)     NOT NULL, 
    DIRECT_NAME       VARCHAR2(50)      NOT NULL, 
    GENRE             VARCHAR2(30)      NOT NULL, 
    GRADE             VARCHAR2(30)      NOT NULL, 
    ACTS              VARCHAR2(500)     NOT NULL, 
    MOVIE_RUNTIME     VARCHAR2(30)      NOT NULL, 
    MOVIE_COMPANY     VARCHAR2(50)      NOT NULL, 
    MOVIE_OPENDATE    DATE              NOT NULL, 
    MOVIE_CONTENTS    VARCHAR2(2000)    NULL, 
    CONSTRAINT MOVIE_PK PRIMARY KEY (MOVIE_CODE)
);

-- SCREEN Table Create SQL
CREATE TABLE SCREEN
(
    SCREEN_CODE    VARCHAR2(30)    NOT NULL, 
    SCREEN_NAME    VARCHAR2(50)    NOT NULL, 
    CONSTRAINT SCREEN_PK PRIMARY KEY (SCREEN_CODE)
);

-- SCREEN_TERM Table Create SQL
CREATE TABLE SCREEN_TERM
(
    SCREEN_CODE     VARCHAR2(30)    NOT NULL, 
    MOVIE_CODE      VARCHAR2(30)    NOT NULL, 
    TERM_SRTDATE    DATE            NOT NULL, 
    TERM_ENDDATE    DATE            NULL   
);

ALTER TABLE SCREEN_TERM
    ADD CONSTRAINT FK_SCREEN_TERM_MOVIE_CODE_MOVI FOREIGN KEY (MOVIE_CODE)
        REFERENCES MOVIE (MOVIE_CODE);

ALTER TABLE SCREEN_TERM
    ADD CONSTRAINT FK_SCREEN_TERM_SCREEN_CODE_SCR FOREIGN KEY (SCREEN_CODE)
        REFERENCES SCREEN (SCREEN_CODE);


-- SCREEN_DAY Table Create SQL
CREATE TABLE SCREEN_DAY
(
    DAY_CODE       VARCHAR2(30)    NOT NULL, 
    SCREEN_CODE    VARCHAR2(30)    NOT NULL, 
    MOVIE_CODE     VARCHAR2(30)    NOT NULL, 
    DAY_RUNDAY     DATE            NOT NULL, 
    DAY_SRTTIME    VARCHAR2(30)    NOT NULL, 
    DAY_ENDTIME    VARCHAR2(30)    NOT NULL, 
    CONSTRAINT SCREEN_DAY_PK PRIMARY KEY (DAY_CODE)
);

ALTER TABLE SCREEN_DAY
    ADD CONSTRAINT FK_SCREEN_DAY_SCREEN_CODE_SCRE FOREIGN KEY (SCREEN_CODE)
        REFERENCES SCREEN (SCREEN_CODE);


ALTER TABLE SCREEN_DAY
    ADD CONSTRAINT FK_SCREEN_DAY_MOVIE_CODE_MOVIE FOREIGN KEY (MOVIE_CODE)
        REFERENCES MOVIE (MOVIE_CODE);


 INSERT INTO MOVIE (MOVIE_CODE, MOVIE_TITLE, DIRECT_NAME, GENRE, GRADE, ACTS, MOVIE_RNUTIME, MOVIE_COMPANY, MOVIE_OPENDATE, MOVIE_CONTENTS) 
 VALUES ("MV-12DFE43WS", "베놈", "루번 플라이셔", "SF", "15세", "톰 하디", TO_DATE("02:20", "HH:mm"), "소니픽쳐스 엔터테인먼트", TO_DATE("2018-10-04", "YYYY-MM-DD"), "")
 
 */