package book;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BookBlank extends JPanel implements ActionListener{
      JTextField tfTitle, tfOrigin_Title, tfWriter, tfLanguage, tfPublish_Year;
      JButton btnInsert, btnDelete, btnUpdate, btnCancel;
      
      public BookBlank() {     
    	 
    	 setBackground(Color.WHITE);
    	 setLayout(new GridLayout(4,1,5,5));	//레이아웃변경 세로6개, 가로2개, x,y축 5픽셀만큼 띄우기


    	 tfTitle = new JTextField();
         tfOrigin_Title = new JTextField();    	  
         tfWriter = new JTextField();    	  
         tfLanguage = new JTextField();   
         tfPublish_Year = new JTextField();    
         
         add(new JLabel("제목"));
         add(tfTitle);
         add(new JLabel("원제"));
         add(tfOrigin_Title);
         add(new JLabel("저자"));
         add(tfWriter);
         add(new JLabel("원어"));
         add(tfLanguage);
         add(new JLabel("발행년도"));
         add(tfPublish_Year);
         add(new JLabel(""));
         add(new JLabel(""));

         
         btnInsert = new JButton("등록");
         btnDelete = new JButton("삭제");
         btnUpdate = new JButton("수정");
         btnCancel = new JButton("취소");
         add(btnInsert);
         add(btnDelete);
         add(btnUpdate);
         add(btnCancel);
         
        btnInsert.addActionListener(this);
 		btnCancel.addActionListener(this);
 		btnDelete.addActionListener(this);
 		btnUpdate.addActionListener(this);

      }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==btnInsert) {
			booInsert();
		} else if(obj==btnDelete) {
			booDelete();
		} else if(obj==btnCancel) {
			tfTitle.setText("");
			tfOrigin_Title.setText("");
			tfWriter.setText("");
			tfLanguage.setText("");
			tfPublish_Year.setText("");
			
		} else if(obj==btnUpdate) {
			booUpdate();
		}
		
	}
	private BookDTO captureView() {
			
			//화면의 입력값들을 가져온다.
			String title=tfTitle.getText();
			String origin_title=tfOrigin_Title.getText();
			String writer=tfWriter.getText();
			String language=tfLanguage.getText();
			String strPublish_year= tfPublish_Year.getText();
			int publish_year=Integer.parseInt(strPublish_year);
			
			//BookDTO 객체를 만든 후 데이터를 셋팅한다.
			
			BookDTO boo=new BookDTO();
			boo.setTitle(title);
			boo.setOrigin_title(origin_title);
			boo.setWriter(writer);
			boo.setLanguage(language);
			boo.setPublish_year(publish_year);

			return boo;
		}	//captureView
		
		private void booInsert() {
			BookDTO boo=captureView();
			//BookDAO 객체의 insertBook(dto)를 실행한다.
			BookDAO dao=new BookDAO();
			dao.insertBook(boo);
			JOptionPane.showMessageDialog(this, "등록 성공했습니다", "등록", JOptionPane.INFORMATION_MESSAGE);
			
		}//booInsert
		
		private void booDelete() {
			BookDTO boo=captureView();
			//BookDAO 객체의 deleteBook(dto)를 실행한다.
			BookDAO dao=new BookDAO();
			dao.deleteBook(boo);
			JOptionPane.showMessageDialog(this, "삭제성공했습니다", "삭제", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		private void booUpdate() {
			BookDTO boo=captureView();
			//BookDAO 객체의 updateBook(dto)를 실행한다.
			BookDAO dao=new BookDAO();
			dao.updateBook(boo);
			JOptionPane.showMessageDialog(this, "수정성공했습니다", "수정", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		private void booCancel() {
			BookDTO boo=captureView();
			//BookDAO 객체의 updateBook(dto)를 실행한다.
			BookDAO dao=new BookDAO();
			dao.insertBook(boo);
			JOptionPane.showMessageDialog(this, "등록 성공했습니다", "Save OK?", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		
			
	
}