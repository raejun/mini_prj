package book;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class BestSeller extends JFrame implements ActionListener {
	JButton btn1;
	JButton btn2;
	JPanel pNorth,pSouth, pSouth2;
	BookBlank p1;
	JTextField find;
	JLabel lb1,lb2, title;
	JMenuBar menuBar;
	JMenu addMenu, loginMenu, exitMenu;
	JMenuItem addItem, minusItem, exitItem,loginItem;
	AllBook allbook;

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();//이벤트가 발생된 곳의 위치
		if(obj==btn1) {
			bookSelect();
		}
		if(obj==find) {
			find.setText("");
		}

		if(obj==btn2) {
			remove(allbook);
			allbook=new AllBook();
			add(allbook, BorderLayout.CENTER);
			validate();
			repaint();
		}
		if(obj==exitItem) {
			System.exit(0);
		}
		if(obj==addItem) {
			new MemberJoin();
		}
		if(obj==minusItem) {
			new MemberOut();
		}

//		if(obj==loginItem) {
//			new LogIn();
//		}
	}
	
	private void bookSelect() {
		//이름을 가져온다
		String title=find.getText();
		//BookDTO boo에  DB의 내용을 담는다.
		
		BookDAO dao=new BookDAO();
		/*
		allbook.remove(allbook.pane);
		allbook.vData = dao.selectBook(title);
		allbook.model=new DefaultTableModel(allbook.vData, allbook.vCol);
		allbook.table=new JTable(allbook.model);
		allbook.pane=new JScrollPane(allbook.table);
		allbook.add(allbook.pane);
		*/
		allbook.vData = dao.selectBook(title);
		allbook.model.setDataVector(allbook.vData, allbook.vCol);
		validate();
		repaint();

		
	}


	
	public BestSeller() {
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//윈도우 닫기
		setTitle("BestSeller"); //제목
		setSize(700,600);	//사이즈
		setBackground(Color.WHITE);
		
		menuBar =new JMenuBar();
		setJMenuBar(menuBar);
//		loginMenu=new JMenu("로그인");
		addMenu=new JMenu("회원가입/탈퇴");
		exitMenu=new JMenu("끝내기");
		
//		menuBar.add(loginMenu);
		menuBar.add(addMenu);
		menuBar.add(exitMenu);
		
		
//		loginItem=new JMenuItem("로그인");
		addItem=new JMenuItem("가입");
		minusItem=new JMenuItem("탈퇴");
		exitItem=new JMenuItem("끝내기");
		
//		loginMenu.add(loginItem);
		addMenu.add(addItem);
		addMenu.addSeparator();
		addMenu.add(minusItem);
		exitMenu.add(exitItem);
		
//		loginItem.addActionListener(this);
		addItem.addActionListener(this);
		minusItem.addActionListener(this);
		exitItem.addActionListener(this);

		
		
		
		
		pNorth=new JPanel(); 
		pNorth.setBackground(Color.white); //pNorth패널 화이트로.
		add(pNorth, BorderLayout.NORTH);//pNorth 패널 북쪽에 붙이기(보더레이아웃)
		
		pSouth=new JPanel();
		pSouth.setBackground(Color.white);
		add(pSouth, BorderLayout.SOUTH);
		
		
	
		
		title=new JLabel("제목");
		find=new JTextField(37);
		find.setText("책 제목을 입력하라 어쩌구 저쩌구 블라블라");
		find.addActionListener(this);
		btn1=new JButton("검색");
		btn1.addActionListener(this);
		btn2=new JButton("새로고침");
		btn2.addActionListener(this);

		pNorth.add(title);
		pNorth.add(find);
		pNorth.add(btn1);
		pNorth.add(btn2);

		//전체 책 목록
		allbook=new AllBook();
		add(allbook,BorderLayout.CENTER);
		
		//책 추가  붙이기
		
		p1=new BookBlank();
		add(p1, BorderLayout.SOUTH);
		
		setVisible(true);
		}//생성자
	


	
	public static void main(String[] args) {
		new BestSeller();
	}
}

//book
/*
CREATE TABLE Book (
   title VARCHAR2(200) NOT NULL, 
   origin_title VARCHAR2(200) NOT NULL, 
   writer VARCHAR2(200) NOT NULL,
   language VARCHAR2(200) NOT NULL,
   publish_year NUMBER NOT NULL
);

CREATE UNIQUE INDEX PK_Book
   ON Book (
      title ASC
   );

ALTER TABLE Book
   ADD
      CONSTRAINT PK_Book
      PRIMARY KEY (
         title
      );

insert into Book(title, origin_title, writer, language, publish_year) values('두 도시 이야기', 'A Tale of Two Cities', '찰스 디킨스', '영어', 1859);
insert into Book(title, origin_title, writer, language, publish_year) values('어린 왕자', 'Le Petit Prince', '앙투안 드 생텍쥐페리', '프랑스어', 1943);
insert into Book(title, origin_title, writer, language, publish_year) values('반지의 제왕', 'The Lord of the Rings', 'J. R. R. 톨킨', '영어', 1954);
insert into Book(title, origin_title, writer, language, publish_year) values('그리고 아무도 없었다', 'And Then There Were None', '애거사 크리스티', '영어', 1939);
insert into Book(title, origin_title, writer, language, publish_year) values('호빗', 'The Hobbit', 'J. R. R. 톨킨', '영어', 1937);
*/

//member
/*
CREATE TABLE Member (
id VARCHAR2(20) NOT NULL,
password VARCHAR2(20) NOT NULL,
name VARCHAR2(100) NOT NULL
);

CREATE UNIQUE INDEX PK_Member
ON Member (
   id ASC
);

ALTER TABLE Member
ADD
   CONSTRAINT PK_Member
   PRIMARY KEY (
      id
   );

insert into Member(id, password, name) values('kim1234', 'abcd', '김수연');
insert into Member(id, password, name) values('ha1234', 'abcd', '하종우');
*/