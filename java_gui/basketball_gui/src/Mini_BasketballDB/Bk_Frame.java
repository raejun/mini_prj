package Mini_BasketballDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bk_Frame extends JFrame implements ActionListener {
	// 객체 선언
	JPanel pNorth;
	JPanel pSouth;
	JButton btnInsert, btnSelect, btnUpdate, btnDelete ,btnExit, btnAll, btnSal;
	JTextField tfSearch;
	Bk_mainPanel p1;
	
	// 생성자
	public Bk_Frame () {
		//1) basic setting 
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("선수 스탯 관리 프로젝트");
			setSize(600,900);
			
		//2) 패널 생성 및 부착
			pNorth = new JPanel();
			pNorth.setBackground(Color.DARK_GRAY);
			add(pNorth, BorderLayout.NORTH);


			pSouth = new JPanel();
			pSouth.setBackground(Color.LIGHT_GRAY);
			add(pSouth, BorderLayout.SOUTH);
			
		//3)버튼 생성 및 부착
			// 버튼 생성
			btnInsert = new JButton("입력");
			btnSelect = new JButton("검색");
			btnUpdate = new JButton("수정");
			btnDelete = new JButton("삭제");
			btnExit = new JButton("종료");
			tfSearch = new JTextField(6);// length
			
			btnAll = new JButton("전체");
			btnSal = new JButton("연봉");
			
			// 버튼에 리스너 부착
			btnInsert.addActionListener(this);
			btnSelect.addActionListener(this);
			btnUpdate.addActionListener(this);
			btnDelete.addActionListener(this);
			btnExit.addActionListener(this);
			tfSearch.addActionListener(this); // 이때 리스너는 Enter시 발생
			
			btnAll.addActionListener(this);
			btnSal.addActionListener(this);
			
			// pNorth 판넬에 위 버튼 부착
			pNorth.add(btnInsert);
			pNorth.add(tfSearch); // 이 순서에 따라 출력되는 순서도 바뀜
			pNorth.add(btnSelect);
			pNorth.add(btnUpdate);
			pNorth.add(btnDelete);
			pNorth.add(btnExit);
			pSouth.add(btnAll);
			pSouth.add(btnSal);
			
			
		// 4) p1 패널을 만들어서 중앙에 붙이기 
		p1 = new Bk_mainPanel();
		add(p1);
		
		// setVisible
			setVisible(true);
	}//생성자
	
	// 리스너 액션 등록
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnInsert) {
			plyrInsert();
		} else if(obj == btnSelect) {
			plyrSelect();
		} else if(obj == btnUpdate) {
			plyrUpdate();
		} else if(obj == btnDelete) {
			plyrDelete();
		} else if(obj == btnExit) {
			System.exit(0);
		} else if(obj == tfSearch) {
			// memSelect();
		} else if(obj == btnAll) {
			new AllPlayer_Frame();
		} else if(obj == btnSal) {
			new Bk_SalFrame();
		}
	} //actionPerformed

	

	// 메소드 지정
		// 0) captureView :---------------------
	public BkPlayer_DTO captureView() {
		// 1) 화면의 입력값들을 가져옴
		String player = p1.tfPlayer.getText();
		String season = (String) p1.cbSeason.getSelectedItem();
		int p3p = 0;
		if (!p1.tfP3p.getText().equals("")) {
			p3p = Integer.parseInt(p1.tfP3p.getText());
		}
		int p2p = 0;
		if (!p1.tfP2p.getText().equals("")) {
			p2p = Integer.parseInt(p1.tfP2p.getText());
		}
		int ftp = 0;
		if (!p1.tfFtp.getText().equals("")) {
			ftp = Integer.parseInt(p1.tfFtp.getText());
		}
		int trb = 0;
		if (!p1.tfTrb.getText().equals("")) {
			trb = Integer.parseInt(p1.tfTrb.getText());
		}
		int ast = 0;
		if (!p1.tfAst.getText().equals("")) {
			ast = Integer.parseInt(p1.tfAst.getText());
		}
		int stl = 0;
		if (!p1.tfStl.getText().equals("")) {
			stl = Integer.parseInt(p1.tfStl.getText());
		}
		int blk = 0;
		if (!p1.tfBlk.getText().equals("")) {
			blk = Integer.parseInt(p1.tfBlk.getText());
		}
		int tov = 0;
		if (!p1.tfTov.getText().equals("")) {
			tov = Integer.parseInt(p1.tfTov.getText());
		}
		int pts = 0;
		if (!p1.tfPts.getText().equals("")) {
			pts = Integer.parseInt(p1.tfPts.getText());
		}
		
		// 2) 입력받은 값을 토대로 DTO 구성
		BkPlayer_DTO plyr = new BkPlayer_DTO();
		plyr.setPlayer(player);
		plyr.setSeason(season);
		plyr.setP3p(p3p);
		plyr.setP2p(p2p);
		plyr.setFtp(ftp);
		plyr.setTrb(trb);
		plyr.setAst(ast);
		plyr.setStl(stl);
		plyr.setBlk(blk);
		plyr.setTov(tov);
		plyr.setPts(pts);
		// Value Return
		return plyr; // 이상의 DTO에서 받아온 자료를 리턴
	} // captureView
	
	public BkPlayerInf_DTO captureView2() {
		// 1) field값 받아오기
		String player = p1.tfPlayer.getText();
		String season = (String) p1.cbSeason.getSelectedItem();
		int psal = 0;
		if (!p1.tfPsal.getText().equals("")) {
			psal = Integer.parseInt(p1.tfPsal.getText());
		}
		// 2) 입력받은 값을 토대로 DTO 구성
		BkPlayerInf_DTO plyr2 = new BkPlayerInf_DTO();
		plyr2.setPlayer(player);
		plyr2.setSeason(season);
		plyr2.setPsal(psal);
		return plyr2;
	}

	

	// 1) plyrInsert ---------------------
	private void plyrInsert() {
		BkPlayer_DTO plyr = captureView();
		BkPlayerInf_DTO plyr2 = captureView2();
		// 3) BkPlayer_DTO 객체의 insertMember(plyr)를 실행한다
		BkPlayer_DAO dao = new BkPlayer_DAO();
		dao.insertPlayer(plyr, plyr2);
		JOptionPane.showMessageDialog(this, "저장성공:P", "Save OK", JOptionPane.INFORMATION_MESSAGE);
	}
	// 2) search & select ---------------------------
	private void plyrSelect () {
		// 입력된 이름을 가져온다 
		String player = tfSearch.getText();
		String season = (String) p1.cbSeason.getSelectedItem();
		System.out.println(player);
		System.out.println(season);
		
		// BkPlayer_DTO plyr에 DB의 내용을 담는다.
		BkPlayer_DAO dao = new BkPlayer_DAO();
		BkPlayer_DTO plyr = dao.selectPlayer(player, season);
		BkPlayerInf_DTO plyr2 = dao.selectPlayer2(player, season);
		if(plyr.getPlayer() == null) {
			System.out.println("찾는 선수가 없습니다:x");
			JOptionPane.showMessageDialog(this, "찾는 사람이 없습니다 :x",
					"Search OK?",JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.out.println(plyr);
			System.out.println(plyr2);
			// 결과 출력
			p1.tfPlayer.setText(plyr.getPlayer());
			String Season = plyr.getSeason();
			p1.cbSeason.setSelectedItem(Season);
			p1.tfP3p.setText("" + plyr.getP3p());
			p1.tfP2p.setText("" + plyr.getP2p());
			p1.tfFtp.setText("" + plyr.getFtp());
			p1.tfTrb.setText("" + plyr.getTrb());
			p1.tfAst.setText("" + plyr.getAst());
			p1.tfStl.setText("" + plyr.getStl());
			p1.tfBlk.setText("" + plyr.getBlk());
			p1.tfTov.setText("" + plyr.getTov());
			p1.tfPts.setText("" + plyr.getPts());
			p1.tfPsal.setText("" + plyr2.getPsal());
		}//plyrSelect
	}

	// 3) update --------------------------
	private void plyrUpdate() {
		BkPlayer_DTO plyr = captureView();
		// 3) BkPlayer_DTO 객체의 insertMember(plyr)를 실행한다
		BkPlayer_DAO dao = new BkPlayer_DAO();
		dao.updatePlayer(plyr);
		JOptionPane.showMessageDialog(this, "변경 성공:P", "Save OK", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// 4) delete ---------------------------
	private void plyrDelete() {
		BkPlayer_DTO plyr = captureView();
		BkPlayer_DAO dao = new BkPlayer_DAO();
		dao.deletePlayer(plyr);
		JOptionPane.showMessageDialog(this, "삭제성공:P", "Save OK", JOptionPane.INFORMATION_MESSAGE);
		 
	}

	
	public static void main(String[] args) {
		new Bk_Frame();
	}//main

	
/*
CREATE TABLE PlayerStat (
	PLAYER VARCHAR(100) NOT NULL, 
	SEASON VARCHAR(50) NOT NULL,
	P3P NUMBER,  
	P2P NUMBER, 
	FTP NUMBER,  
	TRB NUMBER,  
	AST NUMBER,  
	STL NUMBER,  
	BLK NUMBER, 
	TOV NUMBER, 
	PTS NUMBER 
);

CREATE TABLE Player (
	PLAYER VARCHAR(100) NOT NULL,   
	SEASON VARCHAR(50) NOT NULL,  
	PSAL NUMBER  
);

"INSERT INTO PLAYERSTAT(PLAYER,SEASON,P3P, P2P, FTP, TRB, AST, STL, BLK, TOV, PTS)" +
		 "VALUES('curry','2013/2014',40,50,48,60,4,8,2,1,35)";
"INSERT INTO PLAYERSTAT(PLAYER,SEASON,P3P, P2P, FTP, TRB, AST, STL, BLK, TOV, PTS)" +
		 "VALUES('curry','2014/2015',50,60,58,50,5,9,3,2,40)";		 
"INSERT INTO PLAYER(PLAYER,SEASON,PSAL) VALUES(curry,"2013/2014",5000)";
"INSERT INTO PLAYER(PLAYER,SEASON,PSAL) VALUES(curry,"2014/2015",6000)";
"INSERT INTO PLAYERSTAT(PLAYER,SEASON,P3P, P2P, FTP, TRB, AST, STL, BLK, TOV, PTS)" +
		 "VALUES('durant','2013/2014',30,40,58,50,3,9,3,2,38)";
"INSERT INTO PLAYERSTAT(PLAYER,SEASON,P3P, P2P, FTP, TRB, AST, STL, BLK, TOV, PTS)" +
		 "VALUES('durant','2014/2015',40,50,68,80,7,8,4,3,36)";		 
"INSERT INTO PLAYER(PLAYER,SEASON,PSAL) VALUES('curry','2013/2014',5000)";
"INSERT INTO PLAYER(PLAYER,SEASON,PSAL) VALUES('curry','2014/2015',6000)";
"INSERT INTO PLAYER(PLAYER,SEASON,PSAL) VALUES('durant','2013/2014',3000)";
"INSERT INTO PLAYER(PLAYER,SEASON,PSAL) VALUES('durant','2014/2015',7000)";

*/

}//end
