package movie;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;

public class ScreenManager extends JFrame {
   private JButton btnSearchAll;
   public ScreenManager() {
      getContentPane().setLayout(null);
      
      JLabel lblScreen = new JLabel("»ó¿µ°ü");
      lblScreen.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      lblScreen.setBounds(18, 17, 55, 20);
      getContentPane().add(lblScreen);
      
      JComboBox cbScreen = new JComboBox();
      cbScreen.setBounds(90, 12, 130, 30);
      getContentPane().add(cbScreen);
      
      JLabel lblMovie = new JLabel("\uC601\uD654");
      lblMovie.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      lblMovie.setBounds(237, 18, 37, 18);
      getContentPane().add(lblMovie);
      
      JComboBox cbMovie = new JComboBox();
      cbMovie.setBounds(291, 12, 180, 30);
      getContentPane().add(cbMovie);
      
      JLabel lblScreenAssign = new JLabel("\uC0C1\uC601\uAD00 \uBC30\uC815 \uAD00\uB9AC");
      lblScreenAssign.setFont(new Font("µ¸¿ò", Font.BOLD, 18));
      lblScreenAssign.setBounds(18, 87, 157, 38);
      getContentPane().add(lblScreenAssign);
      
      JLabel lblSrtDate = new JLabel("\uC0C1\uC601 \uC2DC\uC791\uC77C");
      lblSrtDate.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      lblSrtDate.setBounds(18, 142, 86, 20);
      getContentPane().add(lblSrtDate);
      
      JComboBox comboBox_2 = new JComboBox();
      comboBox_2.setBounds(122, 138, 94, 30);
      getContentPane().add(comboBox_2);
      
      JLabel label_2 = new JLabel("\uB144");
      label_2.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_2.setBounds(234, 142, 19, 20);
      getContentPane().add(label_2);
      
      JComboBox comboBox_3 = new JComboBox();
      comboBox_3.setBounds(271, 137, 50, 30);
      getContentPane().add(comboBox_3);
      
      JLabel label_3 = new JLabel("\uC6D4");
      label_3.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_3.setBounds(339, 142, 19, 20);
      getContentPane().add(label_3);
      
      JComboBox comboBox_4 = new JComboBox();
      comboBox_4.setBounds(376, 141, 50, 30);
      getContentPane().add(comboBox_4);
      
      JLabel label_4 = new JLabel("\uC77C");
      label_4.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_4.setBounds(440, 142, 19, 20);
      getContentPane().add(label_4);
      
      JLabel lblEndDate = new JLabel("\uC0C1\uC601 \uC885\uB8CC\uC77C");
      lblEndDate.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      lblEndDate.setBounds(18, 193, 86, 20);
      getContentPane().add(lblEndDate);
      
      JComboBox comboBox_5 = new JComboBox();
      comboBox_5.setBounds(122, 188, 94, 30);
      getContentPane().add(comboBox_5);
      
      JLabel label_6 = new JLabel("\uB144");
      label_6.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_6.setBounds(234, 193, 19, 20);
      getContentPane().add(label_6);
      
      JComboBox comboBox_6 = new JComboBox();
      comboBox_6.setBounds(271, 188, 50, 30);
      getContentPane().add(comboBox_6);
      
      JLabel label_7 = new JLabel("\uC6D4");
      label_7.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_7.setBounds(339, 193, 19, 20);
      getContentPane().add(label_7);
      
      JComboBox comboBox_7 = new JComboBox();
      comboBox_7.setBounds(376, 188, 50, 30);
      getContentPane().add(comboBox_7);
      
      JLabel label_8 = new JLabel("\uC77C");
      label_8.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_8.setBounds(444, 193, 19, 20);
      getContentPane().add(label_8);
      
      JButton btnUpdate01 = new JButton("\uC218\uC815");
      btnUpdate01.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnUpdate01.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnUpdate01.setBounds(313, 242, 73, 27);
      getContentPane().add(btnUpdate01);
      
      JButton btnDelete = new JButton("\uC0AD\uC81C");
      btnDelete.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnDelete.setBounds(400, 242, 73, 27);
      getContentPane().add(btnDelete);
      
      JLabel lblScreenSchedule = new JLabel("\uC0C1\uC601\uAD00 \uC77C\uC815 \uAD00\uB9AC");
      lblScreenSchedule.setFont(new Font("µ¸¿ò", Font.BOLD, 18));
      lblScreenSchedule.setBounds(18, 269, 157, 38);
      getContentPane().add(lblScreenSchedule);
      
      JButton btnSearch01 = new JButton("\uD655\uC778");
      btnSearch01.setForeground(Color.BLACK);
      btnSearch01.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnSearch01.setBounds(400, 54, 73, 27);
      getContentPane().add(btnSearch01);
      
      JLabel lblRunDay = new JLabel("\uC0C1\uC601\uC77C");
      lblRunDay.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      lblRunDay.setBounds(22, 328, 55, 20);
      getContentPane().add(lblRunDay);
      
      JComboBox comboBox_8 = new JComboBox();
      comboBox_8.setBounds(99, 323, 94, 30);
      getContentPane().add(comboBox_8);
      
      JLabel label_11 = new JLabel("\uB144");
      label_11.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_11.setBounds(215, 328, 19, 20);
      getContentPane().add(label_11);
      
      JComboBox comboBox_9 = new JComboBox();
      comboBox_9.setBounds(256, 323, 50, 30);
      getContentPane().add(comboBox_9);
      
      JLabel label_12 = new JLabel("\uC6D4");
      label_12.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_12.setBounds(328, 328, 19, 20);
      getContentPane().add(label_12);
      
      JComboBox comboBox_10 = new JComboBox();
      comboBox_10.setBounds(369, 323, 50, 30);
      getContentPane().add(comboBox_10);
      
      JLabel label_13 = new JLabel("\uC77C");
      label_13.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_13.setBounds(441, 328, 19, 20);
      getContentPane().add(label_13);
      
      JButton btnSearch02 = new JButton("\uD655\uC778");
      btnSearch02.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnSearch02.setBounds(400, 365, 73, 27);
      getContentPane().add(btnSearch02);
      
      JButton btnInsert02 = new JButton("\uCD94\uAC00");
      btnInsert02.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnInsert02.setBounds(313, 365, 73, 27);
      getContentPane().add(btnInsert02);
      
      JLabel label_14 = new JLabel("\uBD84");
      label_14.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_14.setBounds(316, 426, 19, 20);
      getContentPane().add(label_14);
      
      JLabel label_15 = new JLabel("\uBD84");
      label_15.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_15.setBounds(316, 477, 19, 20);
      getContentPane().add(label_15);
      
      JComboBox comboBox_11 = new JComboBox();
      comboBox_11.setBounds(252, 421, 50, 30);
      getContentPane().add(comboBox_11);
      
      JComboBox comboBox_12 = new JComboBox();
      comboBox_12.setBounds(252, 472, 50, 30);
      getContentPane().add(comboBox_12);
      
      JLabel label_16 = new JLabel("\uC2DC");
      label_16.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_16.setBounds(215, 426, 19, 20);
      getContentPane().add(label_16);
      
      JLabel label_17 = new JLabel("\uC2DC");
      label_17.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      label_17.setBounds(215, 477, 19, 20);
      getContentPane().add(label_17);
      
      JComboBox comboBox_13 = new JComboBox();
      comboBox_13.setBounds(147, 421, 50, 30);
      getContentPane().add(comboBox_13);
      
      JComboBox comboBox_14 = new JComboBox();
      comboBox_14.setBounds(147, 472, 50, 30);
      getContentPane().add(comboBox_14);
      
      JLabel lblSrtTime = new JLabel("\uC0C1\uC601 \uC2DC\uC791 \uC2DC\uAC04");
      lblSrtTime.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      lblSrtTime.setBounds(18, 426, 115, 20);
      getContentPane().add(lblSrtTime);
      
      JLabel lblEndTime = new JLabel("\uC0C1\uC601 \uC885\uB8CC \uC2DC\uAC04");
      lblEndTime.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
      lblEndTime.setBounds(18, 477, 115, 20);
      getContentPane().add(lblEndTime);
      
      JButton btnInsert03 = new JButton("\uCD94\uAC00");
      btnInsert03.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnInsert03.setBounds(321, 514, 73, 27);
      getContentPane().add(btnInsert03);
      
      btnSearchAll = new JButton("\uC804\uCCB4");
      btnSearchAll.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnSearchAll.setBounds(406, 514, 73, 27);
      getContentPane().add(btnSearchAll);
      
      JSeparator separator = new JSeparator();
      separator.setBounds(18, 123, 157, 2);
      getContentPane().add(separator);
      
      JSeparator separator_1 = new JSeparator();
      separator_1.setBounds(18, 305, 157, 2);
      getContentPane().add(separator_1);
      
      JButton btnInsert01 = new JButton("\uCD94\uAC00");
      btnInsert01.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnInsert01.setBounds(226, 242, 73, 27);
      getContentPane().add(btnInsert01);
      
      JButton btnDelete02 = new JButton("\uC0AD\uC81C");
      btnDelete02.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnDelete02.setBounds(225, 365, 73, 27);
      getContentPane().add(btnDelete02);
      
      JButton btnDelete03 = new JButton("\uC0AD\uC81C");
      btnDelete03.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));
      btnDelete03.setBounds(237, 514, 73, 27);
      getContentPane().add(btnDelete03);
      
   }
}