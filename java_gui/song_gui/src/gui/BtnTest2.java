package gui;
import java.awt.*;
import java.awt.event.*;

public class BtnTest2 extends Frame implements ActionListener {
   Button btn1;
   Button btn2;
   Panel p1;

   public BtnTest2() {

      setTitle("버튼 테스트");
      setSize(400,300);
      p1 = new Panel();
      p1.setBackground(Color.LIGHT_GRAY);
      add(p1, BorderLayout.NORTH);
      btn1 = new Button("버튼1");
      btn2 = new Button("버튼2");
      btn1.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         System.out.println("버튼1을 클릭했습니다");
         
      }
   });
      //Java 8에 추가된 람다표현
      btn2.addActionListener((e) -> {System.out.println("버튼2를 클릭했습니다.");});
     p1.add(btn1);
     p1.add(btn2);
     setVisible(true);
   }    
     public static void main(String[] args) {
      BtnTest2 f = new BtnTest2();
   }//main
}//class