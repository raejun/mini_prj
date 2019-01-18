package movie;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OneCinemaFrame extends JFrame {
   public OneCinemaFrame() {
      getContentPane().setLayout(null);
      
      JButton btnNewButton = new JButton("康拳 府胶飘 包府");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton.setBounds(145, 69, 141, 42);
      getContentPane().add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("惑康包 惑技 包府");
      btnNewButton_1.setBounds(145, 120, 141, 42);
      getContentPane().add(btnNewButton_1);
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }
}