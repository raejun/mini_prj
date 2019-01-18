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
    	 setLayout(new GridLayout(4,1,5,5));	//���̾ƿ����� ����6��, ����2��, x,y�� 5�ȼ���ŭ ����


    	 tfTitle = new JTextField();
         tfOrigin_Title = new JTextField();    	  
         tfWriter = new JTextField();    	  
         tfLanguage = new JTextField();   
         tfPublish_Year = new JTextField();    
         
         add(new JLabel("����"));
         add(tfTitle);
         add(new JLabel("����"));
         add(tfOrigin_Title);
         add(new JLabel("����"));
         add(tfWriter);
         add(new JLabel("����"));
         add(tfLanguage);
         add(new JLabel("����⵵"));
         add(tfPublish_Year);
         add(new JLabel(""));
         add(new JLabel(""));

         
         btnInsert = new JButton("���");
         btnDelete = new JButton("����");
         btnUpdate = new JButton("����");
         btnCancel = new JButton("���");
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
			
			//ȭ���� �Է°����� �����´�.
			String title=tfTitle.getText();
			String origin_title=tfOrigin_Title.getText();
			String writer=tfWriter.getText();
			String language=tfLanguage.getText();
			String strPublish_year= tfPublish_Year.getText();
			int publish_year=Integer.parseInt(strPublish_year);
			
			//BookDTO ��ü�� ���� �� �����͸� �����Ѵ�.
			
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
			//BookDAO ��ü�� insertBook(dto)�� �����Ѵ�.
			BookDAO dao=new BookDAO();
			dao.insertBook(boo);
			JOptionPane.showMessageDialog(this, "��� �����߽��ϴ�", "���", JOptionPane.INFORMATION_MESSAGE);
			
		}//booInsert
		
		private void booDelete() {
			BookDTO boo=captureView();
			//BookDAO ��ü�� deleteBook(dto)�� �����Ѵ�.
			BookDAO dao=new BookDAO();
			dao.deleteBook(boo);
			JOptionPane.showMessageDialog(this, "���������߽��ϴ�", "����", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		private void booUpdate() {
			BookDTO boo=captureView();
			//BookDAO ��ü�� updateBook(dto)�� �����Ѵ�.
			BookDAO dao=new BookDAO();
			dao.updateBook(boo);
			JOptionPane.showMessageDialog(this, "���������߽��ϴ�", "����", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		private void booCancel() {
			BookDTO boo=captureView();
			//BookDAO ��ü�� updateBook(dto)�� �����Ѵ�.
			BookDAO dao=new BookDAO();
			dao.insertBook(boo);
			JOptionPane.showMessageDialog(this, "��� �����߽��ϴ�", "Save OK?", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		
			
	
}