package book;

import java.awt.*;
import javax.swing.*;

public class LoginPlzPanel extends JPanel {

   JPanel pCenter;
   
   public LoginPlzPanel() {
      pCenter = new JPanel();
      pCenter.setBackground(Color.WHITE);
      pCenter.add(new JLabel("�����˻��� ���Ͻø� �α����� ���ּ���!"));
      
      add(pCenter, BorderLayout.CENTER);
   }
}