package Team08;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class D1 extends JFrame {
   public JFrame f;
   public JTable table;
   public JScrollPane pane;
   public DefaultTableModel model;
   public JComboBox comboBox_1,comboBox_2; // ( 종목, 팀 )
   public JPanel panel_1; // (조회,추가,수정,삭제) 판넬
   public JPanel panel_2,panel_3,panel_4,panel_5; // (축구,농구,배구,야구) 판넬
   public JButton button_1,button_2,button_3,button_4; // (조회,추가,수정,삭제) 버튼
   public JButton dbbutton_1, dbbutton_2;  // DB 접속, 종료 버튼
   public JLabel label_1,label_2,label_3,label_4;
   public JLabel footlabel_1,footlabel_2,footlabel_3,footlabel_4,footlabel_5;
   public JLabel basketlabel_1,basketlabel_2,basketlabel_3,basketlabel_4,basketlabel_5;
   public JLabel baselabel_1,baselabel_2,baselabel_3,baselabel_4,baselabel_5;
   public JLabel volleylabel_1,volleylabel_2,volleylabel_3,volleylabel_4,volleylabel_5;
   public String[] sportsType = {"농구","축구","야구","배구"}; 
   public String[] footTeam = {"전북","경남","울산","수원","포항","제주","강원","대구","서울","상주","전남","인천","*"};
   public String[] basketTeam = {"울산","인천","전주","고양","부산","서울삼성","원주","서울SK","창원","안양","*"};
   public String[] baseTeam = {"두산","SK","한화","넥센","KIA","삼성","롯데","LG","KT","NC","*"};
   public String[] volleyTeam = {"현대캐피탈","OK저축은행","삼성화재","대한항공","우리카드","한국전력","KB손해보험","*"};
   public String[] not = {};
   public String getSports; // 종목콤보박스 겟
   public String getTeams; // 팀콤보박스 겟
   public Vector v, vRow; // JTable (데이터)
   public Vector footvcol,basevcol,basketvcol,volleyvcol,nullcol; // JTable 컬럼
   public JTextField textField_1, textField_2; // (이름, 번호) 텍스트
   public JTextField foottextField_1,foottextField_2,foottextField_3,foottextField_4,foottextField_5;
   public JTextField baskettextField_1,baskettextField_2,baskettextField_3,baskettextField_4,baskettextField_5;
   public JTextField basetextField_1,basetextField_2,basetextField_3,basetextField_4,basetextField_5;
   public JTextField volleytextField_1,volleytextField_2,volleytextField_3,volleytextField_4,volleytextField_5;
   //접속정보
   String user = "SCOTT";
   String password ="TIGER";
   String url = "jdbc:oracle:thin:@192.168.113.151:1521:XE";
   //연결 객체
   Connection conn = null;
   PreparedStatement psmt = null;
   ResultSet rs = null;
   String sql = null;
   
   public D1() {
      setLayout(null);
      
      footvcol = new Vector();
      footvcol.add("선수번호");
      footvcol.add("팀명");
      footvcol.add("이름");
      footvcol.add("득점");
      footvcol.add("도움");
      
      basketvcol = new Vector();
      basketvcol.add("선수번호");
      basketvcol.add("팀명");
      basketvcol.add("이름");
      basketvcol.add("득점");
      basketvcol.add("도움");
      
      basevcol = new Vector();
      basevcol.add("선수번호");
      basevcol.add("팀명");
      basevcol.add("이름");
      basevcol.add("타율");
      basevcol.add("타점");
      
      volleyvcol = new Vector();
      volleyvcol.add("선수번호");
      volleyvcol.add("팀명");
      volleyvcol.add("이름");
      volleyvcol.add("득점");
      volleyvcol.add("블로킹");
   
      //Jtable 생성
      model = new DefaultTableModel(v, nullcol);
      table = new JTable(model);
      pane = new JScrollPane(table);
      pane.setBounds(279, 10, 493, 241);
      add(pane);
      
      //버튼판넬
      panel_1 = new JPanel();
      panel_1.setBounds(0, 10, 274, 39);
      add(panel_1);
      
      //조회버튼
      button_1 = new JButton("조회");
      panel_1.add(button_1);
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               if (getSports =="축구") {
                  if(getTeams == "*") {
                     sql = "select * from football ";
                     psmt = conn.prepareStatement(sql);
                     //4. 실행
                     rs = psmt.executeQuery();
                     //5. 결과출력
                     remove(pane);
                     remove(table);
                     v = new Vector();
                     while(rs.next()) {
                         vRow = new Vector();
                         vRow.add(rs.getInt("f_no"));
                         vRow.add(rs.getString("f_team"));
                         vRow.add(rs.getString("f_name"));
                         vRow.add(rs.getInt("goal"));
                         vRow.add(rs.getInt("assist"));
                         v.add(vRow);
                     }//while
                     
                     //축구입력판넬
                     panel_3.setVisible(false);
                     panel_4.setVisible(false);
                     panel_5.setVisible(false);
                     panel_2.setVisible(true);
                     
                     //축구JTable
                     model = new DefaultTableModel(v,footvcol);
                     table = new JTable(model);
                     table.setAutoCreateRowSorter(true);
                     pane = new JScrollPane(table);
                     pane.setBounds(279, 10, 493, 241);
                     add(pane);
                     pane.validate();
                     pane.repaint();
                     
                  }else {
                     sql = "select * from football where f_team = ? ";
                     psmt = conn.prepareStatement(sql);
                     psmt.setString(1,getTeams);
                     
                     //4. 실행
                     rs = psmt.executeQuery();
                    
                     //5. 결과출력
                     remove(pane);
                     remove(table);
                     v = new Vector();
                     while(rs.next()) {
                         vRow = new Vector();
                         vRow.add(rs.getInt("f_no"));
                         vRow.add(rs.getString("f_team"));
                         vRow.add(rs.getString("f_name"));
                         vRow.add(rs.getInt("goal"));
                         vRow.add(rs.getInt("assist"));
                         v.add(vRow);
                     }//while
                     
                     //축구입력판넬
                     panel_3.setVisible(false);
                     panel_4.setVisible(false);
                     panel_5.setVisible(false);
                     panel_2.setVisible(true);
                     
                     //축구JTable
                     model = new DefaultTableModel(v,footvcol);
                     table = new JTable(model);
                     table.setAutoCreateRowSorter(true);
                     pane = new JScrollPane(table);
                     pane.setBounds(279, 10, 493, 241);
                     add(pane);
                     pane.validate();
                     pane.repaint();
                  } // 축구조회
               }
               else if (getSports =="야구") {
                  if(getTeams == "*") {
                     sql = "select * from baseball ";
                     psmt = conn.prepareStatement(sql);

                     //4. 실행
                     rs = psmt.executeQuery();
                     
                     //5. 결과출력
                     remove(pane);
                     remove(table);
                     v = new Vector();
                     while(rs.next()) {
                         vRow = new Vector();
                         vRow.add(rs.getInt("b_no"));
                         vRow.add(rs.getString("b_team"));
                         vRow.add(rs.getString("b_name"));
                         vRow.add(rs.getFloat("b_avr"));
                         vRow.add(rs.getInt("b_score"));
                         v.add(vRow);
                     }//while
                     
                     //야구입력판넬
                     panel_5.setVisible(false);
                     panel_2.setVisible(false);
                     panel_3.setVisible(false);
                     panel_4.setVisible(true);
                     
                     //야구JTable
                     model = new DefaultTableModel(v,basevcol);
                     table = new JTable(model);
                     table.setAutoCreateRowSorter(true);
                     pane = new JScrollPane(table);
                     pane.setBounds(279, 10, 493, 241);
                     add(pane);
                     pane.validate();
                     pane.repaint();
                     
                  }else {
                     sql = "select * from baseball where b_team = ? ";
                     psmt = conn.prepareStatement(sql);
                     psmt.setString(1,getTeams);
                     
                     //4. 실행
                     rs = psmt.executeQuery();
                     
                     //5. 결과출력
                     remove(pane);
                     remove(table);
                     v = new Vector();
                     while(rs.next()) {
                         vRow = new Vector();
                         vRow.add(rs.getInt("b_no"));
                         vRow.add(rs.getString("b_team"));
                         vRow.add(rs.getString("b_name"));
                         vRow.add(rs.getFloat("b_avr"));
                         vRow.add(rs.getInt("b_score"));
                         v.add(vRow);
                     }//while
                     
                     //야구입력판넬
                     panel_5.setVisible(false);
                     panel_2.setVisible(false);
                     panel_3.setVisible(false);
                     panel_4.setVisible(true);
                     
                     //야구JTable
                     model = new DefaultTableModel(v,basevcol);
                     table = new JTable(model);
                     table.setAutoCreateRowSorter(true);
                     pane = new JScrollPane(table);
                     pane.setBounds(279, 10, 493, 241);
                     add(pane);
                     pane.validate();
                     pane.repaint();
                  }
                  
               }else if (getSports =="농구") {
                  if(getTeams == "*") {
                     sql = "select * from basketball ";
                     psmt = conn.prepareStatement(sql);

                     //4. 실행
                     rs = psmt.executeQuery();

                     //5. 결과출력
                     remove(pane);
                     remove(table);
                     v = new Vector();
                     while(rs.next()) {
                         vRow = new Vector();
                         vRow.add(rs.getInt("bk_no"));
                         vRow.add(rs.getString("bk_team"));
                         vRow.add(rs.getString("bk_name"));
                         vRow.add(rs.getInt("bk_goal"));
                         vRow.add(rs.getInt("bk_assist"));
                         v.add(vRow);
                     }//while
                     
                     //농구입력판넬
                     panel_4.setVisible(false);
                     panel_5.setVisible(false);
                     panel_2.setVisible(false);
                     panel_3.setVisible(true);
                     
                     //농구JTable
                     model = new DefaultTableModel(v,basketvcol);
                     table = new JTable(model);
                     table.setAutoCreateRowSorter(true);
                     pane = new JScrollPane(table);
                     pane.setBounds(279, 10, 493, 241);
                     add(pane);
                     pane.validate();
                     pane.repaint();
                     
                  }else {
                     sql = "select * from basketball where bk_team = ? ";
                     psmt = conn.prepareStatement(sql);
                     psmt.setString(1,getTeams);
                     
                     //4. 실행
                     rs = psmt.executeQuery();
                     
                     //5. 결과출력
                     remove(pane);
                     remove(table);
                     v = new Vector();
                     while(rs.next()) {
                         vRow = new Vector();
                         vRow.add(rs.getInt("bk_no"));
                         vRow.add(rs.getString("bk_team"));
                         vRow.add(rs.getString("bk_name"));
                         vRow.add(rs.getInt("bk_goal"));
                         vRow.add(rs.getInt("bk_assist"));
                         v.add(vRow);
                     }//while
                     
                     //농구입력판넬
                     panel_4.setVisible(false);
                     panel_5.setVisible(false);
                     panel_2.setVisible(false);
                     panel_3.setVisible(true);
                     
                     //농구JTable
                     model = new DefaultTableModel(v,basketvcol);
                     table = new JTable(model);
                     table.setAutoCreateRowSorter(true);
                     pane = new JScrollPane(table);
                     pane.setBounds(279, 10, 493, 241);
                     add(pane);
                     pane.validate();
                     pane.repaint();
                  }
                  
               }else if (getSports =="배구") {
                  if(getTeams == "*") {
                     sql = "select * from volleyball ";
                     psmt = conn.prepareStatement(sql);
                     
                     //4. 실행
                     rs = psmt.executeQuery();

                     //5. 결과출력
                     remove(pane);
                     remove(table);
                     v = new Vector();
                     while(rs.next()) {
                         vRow = new Vector();
                         vRow.add(rs.getInt("v_no"));
                         vRow.add(rs.getString("v_team"));
                         vRow.add(rs.getString("v_name"));
                         vRow.add(rs.getInt("v_score"));
                         vRow.add(rs.getInt("v_block"));
                         v.add(vRow);
                     }//while
                     
                     //배구입력판넬
                     panel_2.setVisible(false);
                     panel_3.setVisible(false);
                     panel_4.setVisible(false);
                     panel_5.setVisible(true);
                     
                     //배구JTable
                     model = new DefaultTableModel(v,volleyvcol);
                     table = new JTable(model);
                     table.setAutoCreateRowSorter(true);
                     pane = new JScrollPane(table);
                     pane.setBounds(279, 10, 493, 241);
                     add(pane);
                     pane.validate();
                     pane.repaint();
                     
                  }else {
                     sql = "select * from volleyball where v_team = ? ";
                     psmt = conn.prepareStatement(sql);
                     psmt.setString(1,getTeams);
                     
                     //4. 실행
                     rs = psmt.executeQuery();
                     
                     //5. 결과출력
                     remove(pane);
                     v = new Vector();
                     while(rs.next()) {
                         vRow = new Vector();
                         vRow.add(rs.getInt("v_no"));
                         vRow.add(rs.getString("v_team"));
                         vRow.add(rs.getString("v_name"));
                         vRow.add(rs.getInt("v_score"));
                         vRow.add(rs.getInt("v_block"));
                         v.add(vRow);
                     }//while
                     
                     //배구입력판넬
                     panel_2.setVisible(false);
                     panel_3.setVisible(false);
                     panel_4.setVisible(false);
                     panel_5.setVisible(true);
                     
                     //배구JTable
                     model = new DefaultTableModel(v,volleyvcol);
                     table = new JTable(model);
                     table.setAutoCreateRowSorter(true);
                     pane = new JScrollPane(table);
                     pane.setBounds(279, 10, 493, 241);
                     add(pane);
                     pane.repaint();
                  }
               }//if 조건끝
            } 
            catch (SQLException e) {
               e.printStackTrace();
            } 
         }
      });
      //추가버튼 
      button_2 = new JButton("추가");
      panel_1.add(button_2);
      button_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            switch(getSports) {
            case "축구":
               sql = "INSERT INTO football(f_no, f_team, f_name, goal ,assist )"  + 
                     "VALUES(?,?,?,?,?)";
               try {
                  psmt = conn.prepareStatement(sql);
                  psmt.setInt(1,Integer.parseInt(foottextField_1.getText()));
                  psmt.setString(2,foottextField_2.getText());
                  psmt.setString(3,foottextField_3.getText());
                  psmt.setInt(4,Integer.parseInt(foottextField_4.getText()));
                  psmt.setInt(5,Integer.parseInt(foottextField_5.getText()));
                  int ok = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행, 1이면 성공, 0이면 실패
                  if (ok ==1) { 
                      f = new Insertsucc();
                  }else {
                     f = new Fail();
                  } 
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
               break;
            case "농구":
               sql = "INSERT INTO basketball(bk_no, bk_team, bk_name, bk_goal ,bk_assist )"  + 
                     "VALUES(?,?,?,?,?)";
               try {
                  psmt = conn.prepareStatement(sql);
                  psmt.setInt(1,Integer.parseInt(baskettextField_1.getText()));
                  psmt.setString(2,baskettextField_2.getText());
                  psmt.setString(3,baskettextField_3.getText());
                  psmt.setInt(4,Integer.parseInt(baskettextField_4.getText()));
                  psmt.setInt(5,Integer.parseInt(baskettextField_5.getText()));
                  int ok = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행, 1이면 성공, 0이면 실패
                  if (ok ==1) { 
                     f = new Insertsucc();
                  }else {
                     f = new Fail();
                  }
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
               break;
            case "야구":
               sql = "INSERT INTO baseball(b_no, b_team, b_name, b_avr ,b_score )"  + 
                     "VALUES(?,?,?,?,?)";
               try {
                  psmt = conn.prepareStatement(sql);
                  psmt.setInt(1,Integer.parseInt(basetextField_1.getText()));
                  psmt.setString(2,basetextField_2.getText());
                  psmt.setString(3,basetextField_3.getText());
                  psmt.setFloat(4,Float.parseFloat(basetextField_4.getText()));
                  psmt.setInt(5,Integer.parseInt(basetextField_5.getText()));
                  int ok = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행, 1이면 성공, 0이면 실패
                  if (ok ==1) { 
                     f = new Insertsucc();
                  }else {
                     f = new Fail();
                  }
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
               break;
            case "배구":
               sql = "INSERT INTO volleyball(v_no, v_team, v_name, v_score ,v_block )"  + 
                     "VALUES(?,?,?,?,?)";
               try {
                  psmt = conn.prepareStatement(sql);
                  psmt.setInt(1,Integer.parseInt(volleytextField_1.getText()));
                  psmt.setString(2,volleytextField_2.getText());
                  psmt.setString(3,volleytextField_3.getText());
                  psmt.setInt(4,Integer.parseInt(volleytextField_4.getText()));
                  psmt.setInt(5,Integer.parseInt(volleytextField_5.getText()));
                  int ok = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행, 1이면 성공, 0이면 실패
                  if (ok ==1) { 
                     f = new Insertsucc();
                  }else {
                     f = new Fail();
                  }
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
               break;
            }
         }
      });
      
      //수정버튼
      button_3 = new JButton("수정");
      panel_1.add(button_3);
      button_3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {      
            switch(getSports) {
            case "축구":
            	sql = "UPDATE football SET f_name = ?, goal =? , assist = ? " + "where f_no =? and f_team =?";
                  try {
                     psmt = conn.prepareStatement(sql);
                     psmt.setString(1,foottextField_3.getText());
                     psmt.setInt(2,Integer.parseInt(foottextField_4.getText()));
                     psmt.setInt(3,Integer.parseInt(foottextField_5.getText()));
                     psmt.setInt(4,Integer.parseInt(foottextField_1.getText()));
                     psmt.setString(5,foottextField_2.getText());
                     int UPDATE = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행, 1이면 성공, 0이면 실패
                     if (UPDATE ==1) { 
                        f = new Insertsucc();
                     }else {
                        f = new Fail();
                     }
                  } catch (SQLException e1) {
                     e1.printStackTrace();
                  }
               break;
            case "농구":
            	sql = "UPDATE basketball SET bk_name = ?, bk_goal =? ,bk_assist =?"  + "where bk_no = ?, bk_team =?";
                  try {
                     psmt = conn.prepareStatement(sql);
                     psmt.setString(1,baskettextField_3.getText());
                     psmt.setInt(2,Integer.parseInt(baskettextField_4.getText()));
                     psmt.setInt(3,Integer.parseInt(baskettextField_5.getText()));
                     psmt.setInt(4,Integer.parseInt(baskettextField_1.getText()));
                     psmt.setString(5,baskettextField_2.getText());
                     int ok = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행, 1이면 성공, 0이면 실패
                     if (ok ==1) { 
                        f = new Insertsucc();
                     }else {
                        f = new Fail();
                     }
                  } catch (SQLException e1) {
                     e1.printStackTrace();
                  }
               break;
            case "야구":
            	sql = "UPDATE baseball SET bk_name = ?, bk_goal =? ,bk_assist =? "  + "where bk_no = ?, bk_team = ?";
                  try {
                     psmt = conn.prepareStatement(sql);
                     psmt.setString(1,basetextField_3.getText());
                     psmt.setInt(2,Integer.parseInt(basetextField_4.getText()));
                     psmt.setInt(3,Integer.parseInt(basetextField_5.getText()));
                     psmt.setInt(4,Integer.parseInt(basetextField_1.getText()));
                     psmt.setString(5,basetextField_2.getText());
                     int ok = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행, 1이면 성공, 0이면 실패
                     if (ok ==1) { 
                        f = new Insertsucc();
                     }else {
                        f = new Fail();
                     }
                  } catch (SQLException e1) {
                     e1.printStackTrace();
                  }     
               break;
            case "배구":
            	sql = "UPDATE volleyball set  v_name = ?, v_score = ?,v_block = ?"  + "where v_no = ?, v_team = ";
                  try {
                     psmt = conn.prepareStatement(sql);
                     psmt.setInt(4,Integer.parseInt(volleytextField_1.getText()));
                     psmt.setString(5,volleytextField_2.getText());
                     int ok = psmt.executeUpdate(); // insert, update, delete문은 executeUpdate 로 실행, 1이면 성공, 0이면 실패
                     if (ok ==1) { 
                        f = new Insertsucc();
                     }else {
                        f = new Fail();
                     }
                  } catch (SQLException e1) {
                     e1.printStackTrace();
                  }
               break;
            }
         }
      });
      //삭제버튼
      button_4 = new JButton("삭제");
      panel_1.add(button_4); 
      button_4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            switch(getSports) {
            case "축구":
               sql = "DELETE FROM football WHERE f_team = ? and f_name = ? and f_no = ? ";
               try {
                  psmt = conn.prepareStatement(sql);
                  psmt.setString(1,getTeams);
                  psmt.setString(2,textField_1.getText());
                  psmt.setInt(3,Integer.parseInt(textField_2.getText()));
                  int ok = psmt.executeUpdate();
                  if(ok ==1) {
                     f = new Insertsucc();
                  }else {
                     f = new Fail();
                  }
               } catch (SQLException e1) {

                  e1.printStackTrace();
               }
               break;
            case "농구":
               sql = "DELETE FROM basketball WHERE bk_team = ? and bk_name = ? and bk_no = ? ";
               try {
                  psmt = conn.prepareStatement(sql);
                  psmt.setString(1,getTeams);
                  psmt.setString(2,textField_1.getText());
                  psmt.setInt(3,Integer.parseInt(textField_2.getText()));
                  int ok = psmt.executeUpdate();
                  if(ok ==1) {
                     f = new Insertsucc();
                  }else {
                     f = new Fail();
                  }
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
               break;
            case "야구":
               sql = "DELETE FROM baseball WHERE b_team = ? and b_name = ? and b_no = ? ";
               try {
                  psmt = conn.prepareStatement(sql);
                  psmt.setString(1,getTeams);
                  psmt.setString(2,textField_1.getText());
                  psmt.setInt(3,Integer.parseInt(textField_2.getText()));
                  int ok = psmt.executeUpdate();
                  if(ok ==1) {
                     f = new Insertsucc();
                  }else {
                     f = new Fail();
                  }
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
               break;
            case "배구":
               sql = "DELETE FROM volleyball WHERE v_team = ? and v_name = ? and v_no = ? ";
               try {
                  psmt = conn.prepareStatement(sql);
                  psmt.setString(1,getTeams);
                  psmt.setString(2,textField_1.getText());
                  psmt.setInt(3,Integer.parseInt(textField_2.getText()));
                  int ok = psmt.executeUpdate();
                  if(ok ==1) {
                     f = new Insertsucc();
                  }else {
                     f = new Fail();
                  }
               } catch (SQLException e1) {

                  e1.printStackTrace();
               }
               break;
            }
         }
      });  
      //콤보박스 설정
      comboBox_1 = new JComboBox(sportsType);
      comboBox_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            getSports = comboBox_1.getSelectedItem().toString();
            switch(getSports) {
            case "축구":
               remove(comboBox_2);
               comboBox_2 = new JComboBox(footTeam);
               comboBox_2.setBounds(147, 100, 110, 26);
               getContentPane().add(comboBox_2);
               comboBox_2.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  getTeams = comboBox_2.getSelectedItem().toString();
                  }
               });
               break;
            case "야구":
               remove(comboBox_2);
               comboBox_2 = new JComboBox(baseTeam);
               comboBox_2.setBounds(147, 100, 110, 26);
               add(comboBox_2);
               comboBox_2.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  getTeams = comboBox_2.getSelectedItem().toString();
                  }
               });
               break;
            case "농구":
               remove(comboBox_2);
               comboBox_2 = new JComboBox(basketTeam);
               comboBox_2.setBounds(147, 100, 110, 26);
               add(comboBox_2);
               comboBox_2.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  getTeams = comboBox_2.getSelectedItem().toString();
                  }
               });
               break;
            case "배구":
               remove(comboBox_2);
               comboBox_2 = new JComboBox(volleyTeam);
               comboBox_2.setBounds(147, 100, 110, 26);
               add(comboBox_2);
               comboBox_2.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                  getTeams = comboBox_2.getSelectedItem().toString();
                  }
               });
               break;
            }//switch
         }
      });
      //콤보박스
      comboBox_1.setBounds(147, 61, 103, 26);
      add(comboBox_1);
      comboBox_2 = new JComboBox(not);
      comboBox_2.setBounds(147, 100, 103, 26);
      add(comboBox_2);
      
      // 이름 ,번호 입력창
      textField_1 = new JTextField();
      textField_1.setColumns(10);
      textField_1.setBounds(147, 136, 103, 26);
      add(textField_1);
      
      textField_2 = new JTextField();
      textField_2.setColumns(10);
      textField_2.setBounds(147, 170, 103, 26);
      add(textField_2);
      
      // 좌측 라벨 (종목,팀,이름,번호)
      label_1 = new JLabel("종목");
      label_1.setBounds(22, 61, 120, 26);
      add(label_1);
      
      label_2 = new JLabel("팀");
      label_2.setBounds(22, 100, 120, 26);
      add(label_2);
      
      label_3 = new JLabel("이름");
      label_3.setBounds(22, 136, 120, 26);
      add(label_3);
      
      label_4 = new JLabel("번호");
      label_4.setBounds(22, 170, 120, 26);
      add(label_4);
      
      //축구판넬 /밑부분은 판넬관련 볼필요 x
      panel_2 = new JPanel();
      panel_2.setBounds(279, 263, 493, 98);
      add(panel_2);
      panel_2.setLayout(new GridLayout(2, 5, 5, 5));
      
      footlabel_1 = new JLabel("선수번호");
      footlabel_2 = new JLabel("팀명");
      footlabel_3 = new JLabel("이름");
      footlabel_4 = new JLabel("득점");
      footlabel_5 = new JLabel("도움");
      
      panel_2.add(footlabel_1);
      panel_2.add(footlabel_2);
      panel_2.add(footlabel_3);
      panel_2.add(footlabel_4);
      panel_2.add(footlabel_5);
      
      foottextField_1 = new JTextField();
      panel_2.add(foottextField_1);
      foottextField_1.setColumns(10);
      
      foottextField_2 = new JTextField();
      panel_2.add(foottextField_2);
      foottextField_2.setColumns(10);
      
      foottextField_3 = new JTextField();
      panel_2.add(foottextField_3);
      foottextField_3.setColumns(10);
      
      foottextField_4 = new JTextField();
      panel_2.add(foottextField_4);
      foottextField_4.setColumns(10);
      
      foottextField_5 = new JTextField();
      panel_2.add(foottextField_5);
      foottextField_5.setColumns(10);
      panel_2.setVisible(false);
    
      //농구판넬
      panel_3 = new JPanel();
      panel_3.setBounds(279, 263, 493, 98);
      add(panel_3);
      panel_3.setLayout(new GridLayout(2, 5, 5, 5));
      
      basketlabel_1 = new JLabel("선수번호");
      basketlabel_2 = new JLabel("팀명");
      basketlabel_3 = new JLabel("이름");
      basketlabel_4 = new JLabel("득점");
      basketlabel_5 = new JLabel("도움");
      
      panel_3.add(basketlabel_1);
      panel_3.add(basketlabel_2);
      panel_3.add(basketlabel_3);
      panel_3.add(basketlabel_4);
      panel_3.add(basketlabel_5);
      
      baskettextField_1 = new JTextField();
      panel_3.add(baskettextField_1);
      foottextField_1.setColumns(10);
      
      baskettextField_2 = new JTextField();
      panel_3.add(baskettextField_2);
      baskettextField_2.setColumns(10);
      
      baskettextField_3 = new JTextField();
      panel_3.add(baskettextField_3);
      baskettextField_3.setColumns(10);
      
      baskettextField_4 = new JTextField();
      panel_3.add(baskettextField_4);
      baskettextField_4.setColumns(10);
      
      baskettextField_5 = new JTextField();
      panel_3.add(baskettextField_5);
      baskettextField_5.setColumns(10);
      panel_3.setVisible(false);
      
      //야구판넬
      panel_4 = new JPanel();
      panel_4.setBounds(279, 263, 493, 98);
      add(panel_4);
      panel_4.setLayout(new GridLayout(2, 5, 5, 5));
      
      baselabel_1 = new JLabel("선수번호");
      baselabel_2 = new JLabel("팀명");
      baselabel_3 = new JLabel("이름");
      baselabel_4 = new JLabel("타율");
      baselabel_5 = new JLabel("타점");
      
      panel_4.add(baselabel_1);
      panel_4.add(baselabel_2);
      panel_4.add(baselabel_3);
      panel_4.add(baselabel_4);
      panel_4.add(baselabel_5);
      
      basetextField_1 = new JTextField();
      panel_4.add(basetextField_1);
      basetextField_1.setColumns(10);
      
      basetextField_2 = new JTextField();
      panel_4.add(basetextField_2);
      basetextField_2.setColumns(10);
      
      basetextField_3 = new JTextField();
      panel_4.add(basetextField_3);
      basetextField_3.setColumns(10);
      
      basetextField_4 = new JTextField();
      panel_4.add(basetextField_4);
      basetextField_4.setColumns(10);
      
      basetextField_5 = new JTextField();
      panel_4.add(basetextField_5);
      basetextField_5.setColumns(10);    
      panel_4.setVisible(false);
            
      //배구판넬
      panel_5 = new JPanel();
      panel_5.setBounds(279, 263, 493, 98);
      add(panel_5);
      panel_5.setLayout(new GridLayout(2, 5, 5, 5));
      
      volleylabel_1 = new JLabel("선수번호");
      volleylabel_2 = new JLabel("팀명");
      volleylabel_3 = new JLabel("이름");
      volleylabel_4 = new JLabel("득점");
      volleylabel_5 = new JLabel("블로킹");
      
      panel_5.add(volleylabel_1);
      panel_5.add(volleylabel_2);
      panel_5.add(volleylabel_3);
      panel_5.add(volleylabel_4);
      panel_5.add(volleylabel_5);
      
      volleytextField_1 = new JTextField();
      panel_5.add(volleytextField_1);
      volleytextField_1.setColumns(10);
      
      volleytextField_2 = new JTextField();
      panel_5.add(volleytextField_2);
      volleytextField_2.setColumns(10);
      
      volleytextField_3 = new JTextField();
      panel_5.add(volleytextField_3);
      volleytextField_3.setColumns(10);
      
      volleytextField_4 = new JTextField();
      panel_5.add(volleytextField_4);
      volleytextField_4.setColumns(10);
      
      volleytextField_5 = new JTextField();
      panel_5.add(volleytextField_5);
      volleytextField_5.setColumns(10);
      panel_5.setVisible(false);
      
   //DB접속, 종료버튼
   dbbutton_1 = new JButton("DB접속");
   dbbutton_1.setBounds(22, 208, 105, 27);
   add(dbbutton_1);
   dbbutton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            f = new Dbconn();
         } catch (ClassNotFoundException e1) {
            
            e1.printStackTrace();
         } catch (SQLException e1) {

            e1.printStackTrace();
         }
      }
   });
   
   dbbutton_2 = new JButton("DB종료");
   dbbutton_2.setBounds(145, 208, 105, 27);
   add(dbbutton_2);
   dbbutton_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
            if(rs != null) {
               try {
                  rs.close();
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
            }//if rs
            if(psmt != null) {
               try {
                  psmt.close();
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
            }//if psmt
            if(conn != null) {
               try {
                  conn.close();
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
            }// if conn
            f = new Dbconnx();
      }
   });
   
   setLocation(600,300);
   setSize(800,420);
   setVisible(true);
   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}
public static void main(String[] args) {
   D1 d2 = new D1();   
	}
}//main