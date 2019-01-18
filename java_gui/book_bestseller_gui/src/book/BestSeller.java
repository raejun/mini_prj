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
		Object obj=e.getSource();//�̺�Ʈ�� �߻��� ���� ��ġ
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
		//�̸��� �����´�
		String title=find.getText();
		//BookDTO boo��  DB�� ������ ��´�.
		
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
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//������ �ݱ�
		setTitle("BestSeller"); //����
		setSize(700,600);	//������
		setBackground(Color.WHITE);
		
		menuBar =new JMenuBar();
		setJMenuBar(menuBar);
//		loginMenu=new JMenu("�α���");
		addMenu=new JMenu("ȸ������/Ż��");
		exitMenu=new JMenu("������");
		
//		menuBar.add(loginMenu);
		menuBar.add(addMenu);
		menuBar.add(exitMenu);
		
		
//		loginItem=new JMenuItem("�α���");
		addItem=new JMenuItem("����");
		minusItem=new JMenuItem("Ż��");
		exitItem=new JMenuItem("������");
		
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
		pNorth.setBackground(Color.white); //pNorth�г� ȭ��Ʈ��.
		add(pNorth, BorderLayout.NORTH);//pNorth �г� ���ʿ� ���̱�(�������̾ƿ�)
		
		pSouth=new JPanel();
		pSouth.setBackground(Color.white);
		add(pSouth, BorderLayout.SOUTH);
		
		
	
		
		title=new JLabel("����");
		find=new JTextField(37);
		find.setText("å ������ �Է��϶� ��¼�� ��¼�� �����");
		find.addActionListener(this);
		btn1=new JButton("�˻�");
		btn1.addActionListener(this);
		btn2=new JButton("���ΰ�ħ");
		btn2.addActionListener(this);

		pNorth.add(title);
		pNorth.add(find);
		pNorth.add(btn1);
		pNorth.add(btn2);

		//��ü å ���
		allbook=new AllBook();
		add(allbook,BorderLayout.CENTER);
		
		//å �߰�  ���̱�
		
		p1=new BookBlank();
		add(p1, BorderLayout.SOUTH);
		
		setVisible(true);
		}//������
	


	
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

insert into Book(title, origin_title, writer, language, publish_year) values('�� ���� �̾߱�', 'A Tale of Two Cities', '���� ��Ų��', '����', 1859);
insert into Book(title, origin_title, writer, language, publish_year) values('� ����', 'Le Petit Prince', '������ �� �������丮', '��������', 1943);
insert into Book(title, origin_title, writer, language, publish_year) values('������ ����', 'The Lord of the Rings', 'J. R. R. ��Ų', '����', 1954);
insert into Book(title, origin_title, writer, language, publish_year) values('�׸��� �ƹ��� ������', 'And Then There Were None', '�ְŻ� ũ����Ƽ', '����', 1939);
insert into Book(title, origin_title, writer, language, publish_year) values('ȣ��', 'The Hobbit', 'J. R. R. ��Ų', '����', 1937);
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

insert into Member(id, password, name) values('kim1234', 'abcd', '�����');
insert into Member(id, password, name) values('ha1234', 'abcd', '������');
*/