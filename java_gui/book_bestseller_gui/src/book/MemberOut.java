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
      setTitle("ȸ��Ż��");
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setSize(400, 200);
       
       setLayout(new BorderLayout());       
       
       //���� �ǳڿ� ���̱�
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
       
       //�Ʒ����ǳں��̱�
       pSouth = new JPanel();
       btnOut = new JButton("Ż��");
       pSouth.add(btnOut);
       btnOut.addActionListener(this);
       
       add(pNorth, BorderLayout.NORTH);
       add(pSouth, BorderLayout.SOUTH);
       
       setVisible(true);
       
   } // ������
   
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
         JOptionPane.showMessageDialog(this, "ȸ��Ż�� �Ϸ�Ǿ����ϴ�.", "Save OK?", JOptionPane.INFORMATION_MESSAGE);
      }//memdelete
      
      public static void main(String[] args) {
         new MemberOut();
         
      } //main
}