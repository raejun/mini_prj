package book;

import java.awt.*;
import javax.swing.*;

public class LoginPlzPanel extends JPanel {

   JPanel pCenter;
   
   public LoginPlzPanel() {
      pCenter = new JPanel();
      pCenter.setBackground(Color.WHITE);
      pCenter.add(new JLabel("도서검색을 원하시면 로그인을 해주세요!"));
      
      add(pCenter, BorderLayout.CENTER);
   }
}