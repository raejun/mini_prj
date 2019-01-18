package Team08;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Insertsucc extends JFrame {
   public Insertsucc() {
      getContentPane().setLayout(null);
      
      JLabel sucNewLabel = new JLabel("¼º°ø!!!!");
      sucNewLabel.setBounds(100, 0, 107, 53);
      getContentPane().add(sucNewLabel);
      setVisible(true);
      setLocation(750,350);
      setSize(270,110);
   }

   public static void main(String[] args) {
      Dbconn d3 = new Dbconn();
   }
}