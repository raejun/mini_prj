package book;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import book.MemberDAO;
import book.MemberDTO;

public class MemberOut extends JFrame implements ActionListener {
   JPanel pNorth;
   JPanel pSouth;
   JTextField tfId, tfPw, tfName;
   JButton btnOut;
   
   public MemberOut() {
      setTitle("È¸¿øÅ»Åð");
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setSize(400, 200);
       
       setLayout(new BorderLayout());       
       
       //ºÏÂÊ ÆÇ³Ú¿¡ ºÙÀÌ±â
       pNorth = new JPanel();
       pNorth.setLayout(new GridLayout(4, 2, 5, 5));
       tfId = new JTextField(25);
       pNorth.add(new JLabel("ID"));
       pNorth.add(tfId);
       tfPw = new JTextField(25);
       pNorth.add(new JLabel("PASSWORD"));
       pNorth.add(tfPw);
       tfName = new JTextField(25);
       pNorth.add(new JLabel("NAME"));
       pNorth.add(tfName);
       
       //¾Æ·¡ÂÊÆÇ³ÚºÙÀÌ±â
       pSouth = new JPanel();
       btnOut = new JButton("Å»Åð");
       pSouth.add(btnOut);
       btnOut.addActionListener(this);
       
       add(pNorth, BorderLayout.NORTH);
       add(pSouth, BorderLayout.SOUTH);
       
       setVisible(true);
       
   } // »ý¼ºÀÚ
   
      @Override
      public void actionPerformed(ActionEvent e) {
         Object obj = e.getSource();
         if(obj == btnOut) {
            memDelete(); 
         }
      }
      
      private MemberDTO captureView() {
         
         String ID = tfId.getText();
         String PASSWORD = tfPw.getText();
         String NAME = tfName.getText();

         MemberDTO mem = new MemberDTO();
         mem.setId(ID);
         mem.setPassword(PASSWORD);
         mem.setName(NAME);

         return mem;
      }//captureView
      
      private void memDelete() {
         MemberDTO mem = captureView();
         MemberDAO dao = new MemberDAO();
         dao.deleteMember(mem);
         JOptionPane.showMessageDialog(this, "È¸¿øÅ»Åð°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.", "Save OK?", JOptionPane.INFORMATION_MESSAGE);
      }//memdelete
      
      public static void main(String[] args) {
         new MemberOut();
         
      } //main
}