package team07;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class login extends JFrame implements ActionListener {
   JLabel l1, l2, l3;
   JTextField tf1;
   JButton btn1, btnJoin;
   JPasswordField p1;
   
   String connect = new String("jdbc:oracle:thin:@192.168.113.65:1521:XE");
   String user = new String("SCOTT");
   String passwd = new String("TIGER");
   Connection conn;
   Statement stat;
   PreparedStatement prestat1;
   Vector outer, msg;
   ResultSet rs;
   String query;
   
   String ID;
   String passwd2;

   login() {
	  
      JFrame frame = new JFrame("Login Form");
      l1 = new JLabel("Login Form");
      l1.setForeground(Color.blue);
      l1.setFont(new Font("Serif", Font.BOLD, 20));

      l2 = new JLabel("Username");
      l3 = new JLabel("Password");
      tf1 = new JTextField();
      p1 = new JPasswordField();
      btn1 = new JButton("Login");
      btn1.addActionListener(this);
      l1.setBounds(100, 30, 400, 30);
      l2.setBounds(80, 70, 200, 30);
      l3.setBounds(80, 110, 200, 30);
      tf1.setBounds(300, 70, 200, 30);
      p1.setBounds(300, 110, 200, 30);
      btn1.setBounds(150, 160, 100, 30);

      frame.getContentPane().add(l1);
      frame.getContentPane().add(l2);
      frame.getContentPane().add(tf1);
      frame.getContentPane().add(l3);
      frame.getContentPane().add(p1);
      frame.getContentPane().add(btn1);

      frame.setSize(600, 400);
      frame.getContentPane().setLayout(null);

      btnJoin = new JButton("join");
      btnJoin.addActionListener(this);
      btnJoin.setBounds(310, 162, 105, 27);
      frame.getContentPane().add(btnJoin);
      frame.setVisible(true);
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
         // stat = conn.createStatement();
         prestat1 = conn.prepareStatement("select * from BANKJOIN where id = ? and passwd = ? order by id");
      } catch (Exception e) {
    	  
      }
   }
   
   public void select(String name, String pass){
      try{
         prestat1.setString(1, name);
         prestat1.setString(2, pass);
         rs = prestat1.executeQuery();
         System.out.println("rs = " + rs);
         
         if(rs.next()) {
            ID = rs.getString("id");
            passwd2 = rs.getString("passwd");
         }
         // rs안에 데이터가 여부 체크 후 작업
         // outer.clear();
         
            //msg = new Vector<String>();
            //msg.add(rs.getString(1));
            //msg.add(rs.getString(2));
            //msg.add(rs.getString(3));
            //outer.add(msg);
      }catch(Exception e){
         e.printStackTrace();
      }
   }

   public void actionPerformed(ActionEvent ae) {
      Object obj = ae.getSource();
      String uname = tf1.getText();
      String pass = p1.getText();
      System.out.println("uname =" + uname + pass);
      
      if (obj == btn1) {
         prepareDB();
         select(uname, pass);
         System.out.println("ID = " + ID + "비번 = " + passwd2);
         try {
            if (uname.equals(ID) && pass.equals(passwd2)) {
               System.out.println("prestat1 = " + prestat1);
          	  JOptionPane.showMessageDialog(this,"로그인 되었습니다.");
          	  new BucketList2();
          	  dispose();
          	  
          	
            } else {
               JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
         } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } else if (obj == btnJoin){
         new Join();
         
      }
   }//actionPerformed

   public static void main(String[] args) {
      new login();
   }
}