package miniproject;

 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FestivalLineup extends JFrame implements ActionListener{

	JPanel pNorth;
	JPanel pSouth;
	JButton btnInsert, btnSelect, btnDelete, btnExit;
	JTextField tfSearch;
	FestivalPanel p1;

	public FestivalLineup() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle ("페스티벌 라인업");
		setSize(520,300);

		pNorth = new JPanel();
		pSouth = new JPanel();

		pNorth.setBackground(Color.getHSBColor(0, 64, 63));
		pSouth.setBackground(Color.getHSBColor(172, 68, 66));

		add(pNorth, BorderLayout.NORTH);
		add(pSouth,BorderLayout.SOUTH);

		btnSelect=new JButton("검색");
		btnSelect.setBackground(Color.WHITE);
		btnInsert=new JButton("입력");
		btnInsert.setBackground(Color.WHITE);
		btnDelete=new JButton("삭제");
		btnDelete.setBackground(Color.WHITE);
		btnExit=new JButton("종료");
		btnExit.setBackground(Color.WHITE);

		tfSearch=new JTextField(10);	//엔터를 쳤을 때 ActionEvent 발생

		
		btnInsert.addActionListener(this);
		btnSelect.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		tfSearch.addActionListener(this);


		pNorth.add(tfSearch);
		pNorth.add(btnSelect);
		pSouth.add(btnInsert);
		pSouth.add(btnDelete);
		pSouth.add(btnExit);

	
		//p1 붙이기
		p1 = new FestivalPanel();
		add(p1);
		
		setVisible(true);
	}

		@Override

		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj==btnInsert) {
				festInsert();
			} else if(obj==btnSelect) {
				festSelect();
			} else if(obj==btnDelete) {
				festDelete();
			} else if(obj==btnExit) {
				System.exit(0);
			}
		}

	
	public FestivalDTO captureView() {

		String name = p1.tfName.getText();
		String festival = p1.tfFestival.getText();
		String country = p1.tfCountry.getText();
		String genre = p1.tfGenre.getText();
		String explain = p1.tfExplain.getText();
		String strYear = p1.tfYear.getText();
		int year = Integer.parseInt(strYear);
		String strInstrumental = p1.tfInstrumental.getText();
		int instrumental = Integer.parseInt(strInstrumental);
		//name, year, festival, instrumental, country, genre, explain

	
		FestivalDTO fest = new FestivalDTO();
		fest.setName(name);
		fest.setYear(year);
		fest.setFestival(festival);
		fest.setInstrumental(instrumental);
		fest.setCountry(country);
		fest.setGenre(genre);
		fest.setExplain(explain);


		return fest;


	}//DTO

	
	private void festInsert() {
		FestivalDTO fest = captureView();
		FestivalDAO dao = new FestivalDAO();
		dao.insertFestival(fest);
		JOptionPane.showMessageDialog(this, "저장 성공", "Saved?", JOptionPane.INFORMATION_MESSAGE);

	}//insert

	
	private void festSelect() {
		String name = tfSearch.getText();
		FestivalDAO dao = new FestivalDAO();
		FestivalDTO fest = dao.selectFestival(name);
		
		if (fest.getName() == null) {
			System.out.println("검색한 아티스트가 없습니다.");
		} else {//name, year, festival, instrumental, country, genre, explain
			System.out.println(fest);
			p1.tfName.setText(fest.getName());
			p1.tfYear.setText(""+fest.getYear());
			p1.tfFestival.setText(fest.getFestival());
			p1.tfInstrumental.setText(""+fest.getInstrumental());
			p1.tfCountry.setText(fest.getCountry());
			p1.tfGenre.setText(fest.getGenre());
			p1.tfExplain.setText(fest.getExplain());
		}
	}//select

 
	private void festDelete() {
		String name = tfSearch.getText();
		FestivalDAO dao = new FestivalDAO();
		boolean ok = dao.deleteFestival(name);
		if (ok) {
			System.out.println("삭제되었습니다");
		} else {//name, year, festival, instrumental, country, genre, explain
			System.out.println("삭제할 아티스트가 없습니다.");
			
		}
	}//delete
	
	private void festExit() {

	}//exit

	

	public static void main(String[] args) {

		new FestivalLineup();

	}//main

 

 

 

}//end

