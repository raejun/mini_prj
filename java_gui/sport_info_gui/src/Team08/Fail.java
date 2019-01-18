package Team08;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fail extends JFrame {
   public Fail() {
      getContentPane().setLayout(null);
      
      JLabel failNewLabel = new JLabel("½ÇÆÐ ¤Ì¤Ì");
      failNewLabel.setBounds(100, 0, 107, 53);
      getContentPane().add(failNewLabel);
      setVisible(true);
      setLocation(750,350);
      setSize(270,110);
   }

   public static void main(String[] args) {
      Dbconn d3 = new Dbconn();
   }
}