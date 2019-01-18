package team07;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Join extends JFrame implements ActionListener {
   String connect = new String("jdbc:oracle:thin:@192.168.113.65:1521:XE");
   String user = new String("SCOTT");
   String passwd = new String("TIGER");
   Connection conn;
   Statement stat;
   PreparedStatement prestat1;
   JFrame frame = new JFrame("Join Form");
   JTextField tsid, tspasswd, tsname;
   JLabel lblNewLabel, lblNewLabel_1;
   JButton btnJoin;
   Vector outer, msg;
   ResultSet rs;
   
   
   @SuppressWarnings("rawtypes")
   public Join() {
      msg = new Vector();
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setTitle("회원가입");
      setSize(400, 400);
      getContentPane().setLayout(null);
      
      tsid = new JTextField();
      tsid.setBounds(95, 44, 254, 48);
      getContentPane().add(tsid);
      tsid.setColumns(10);
      
      tspasswd = new JTextField();
      tspasswd.setColumns(10);
      tspasswd.setBounds(95, 104, 254, 48);
      getContentPane().add(tspasswd);
      
      tsname = new JTextField();
      tsname.setColumns(10);
      tsname.setBounds(95, 164, 254, 48);
      getContentPane().add(tsname);
      
      JLabel label = new JLabel("ID");
      label.setBounds(19, 59, 62, 18);
      getContentPane().add(label);
      
      lblNewLabel = new JLabel("비밀번호");
      lblNewLabel.setBounds(19, 119, 62, 18);
      getContentPane().add(lblNewLabel);
      
      lblNewLabel_1 = new JLabel("이름");
      lblNewLabel_1.setBounds(19, 179, 62, 18);
      getContentPane().add(lblNewLabel_1);
      
      btnJoin = new JButton("가 입");
      btnJoin.setBounds(95, 254, 105, 27);
      getContentPane().add(btnJoin);
      btnJoin.addActionListener(this);
      setVisible(true);
      
   }
   
   public void prepareDB(){
      //Statement
      //PreparedStatement      
    try {
         //driver 등록
         Class.forName("oracle.jdbc.driver.OracleDriver");   //객체 생성
         //connection 얻기
         conn = DriverManager.getConnection(connect, user, passwd);
         //statement 얻기
         stat = conn.createStatement();
         prestat1 = conn.prepareStatement("insert into BankJoin values(?,?,?)");
      } catch (Exception e) {
      }
   }
   public void join(){
      String id = tsid.getText();
      String passwd = tspasswd.getText();
      String name = tsname.getText();
      
      try {
         prestat1.setString(1, id);
         prestat1.setString(2, passwd);
         prestat1.setString(3, name);
         prestat1.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   

   @Override
   public void actionPerformed(ActionEvent w) {
      Object obj = w.getSource();
      String id = tsid.getText();
      String passwd = tspasswd.getText();
      String name = tsname.getText();
      if(obj == btnJoin) {
         
         prepareDB();
         join();
         setVisible(false);
         JFrame f;
    	  f = new JFrame();
    	  JOptionPane.showMessageDialog(f,"회원가입이 되었습니다.");
         
      }
   }
   public static void main(String[] args) {
      new Join();
   }
}