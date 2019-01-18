package Mini_BasketballDB;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bk_mainPanel extends JPanel {
	// 1) 객체 선언 
	JTextField tfPlayer, tfP3p, tfP2p, tfFtp, tfTrb, tfAst, tfStl, tfBlk, tfTov, tfPts, tfPsal;
	JPanel pSeason;
	JComboBox cbSeason; // 클릭시 선택 카테고리가 아래방향으로 확장되는 버튼
	
	// 2) 생성자
	public Bk_mainPanel () {
		setLayout(new GridLayout(12,2, 5, 5)); //레이아웃 변경  GridLayout(세로,가로, 좌우 공백 , 상하 공백)

	// 3) panel내 field  생성	
		// 정보 입력 공간
		tfPlayer = new JTextField();
		pSeason = new JPanel();
		String[] arrSeason = {"2013/2014"
							,"2014/2015"
							,"2015/2016"
							,"2016/2017"
							,"2017/2018"
							,"2018/2019"};
		cbSeason = new JComboBox(arrSeason);
		pSeason.add(cbSeason);
		tfP3p = new JTextField();
		tfP2p = new JTextField();
		tfFtp = new JTextField();
		tfTrb = new JTextField();
		tfAst = new JTextField();
		tfStl = new JTextField();
		tfBlk = new JTextField();
		tfTov = new JTextField();
		tfPts = new JTextField();
		tfPsal = new JTextField();
		
	// 4) 붙이기 
		add(new JLabel("선수명")); // Bk_mainPanel의 생성자내에서 붙이기에 붙이는 대상 생략 가능
		add(tfPlayer);
		add(new JLabel("시즌"));
		add(pSeason);
		add(new JLabel("3점 성공률"));
		add(tfP3p);
		add(new JLabel("2점 성공률"));
		add(tfP2p);
		add(new JLabel("자유투 성공률"));
		add(tfFtp);
		add(new JLabel("리바운드"));
		add(tfTrb);
		add(new JLabel("어시스트"));
		add(tfAst);
		add(new JLabel("스틸"));
		add(tfStl);
		add(new JLabel("블락"));
		add(tfBlk);
		add(new JLabel("턴오버"));
		add(tfTov);
		add(new JLabel("평균 득점"));
		add(tfPts);
		add(new JLabel("연봉"));
		add(tfPsal);
	}//생성자
}//end


