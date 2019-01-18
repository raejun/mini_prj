package HW;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MusicPanel extends JPanel {
   JLabel lblArtist, lblTitle, lblLength, lblGenre, lblRanking, lblRelease, lblComposer;
   JTextField tfArtist, tfTitle, tfLength, tfGenre, tfRanking, tfRelease, tfComposer;
   JComboBox cbGenre;//
   
   public MusicPanel() {
      setLayout(new GridLayout (7,3,5,5));
      
      tfArtist = new JTextField();
      tfTitle = new JTextField();
      tfLength = new JTextField();
      tfGenre = new JTextField();
      tfRanking = new JTextField();
      tfRelease = new JTextField();
      tfComposer = new JTextField();
      //텍스트 필드 생성
      
      String[] arrGenre = {"발라드", "힙합", "댄스", "R&B", "록", "재즈", "동요", "가곡"};
      
      cbGenre = new JComboBox(arrGenre);

      add(new JLabel("가수"));
      add(tfArtist);
      add(new JLabel("노래 제목"));
      add(tfTitle);
      add(new JLabel("시간"));
      add(tfLength);
      add(new JLabel("장르"));
      add(cbGenre);
      add(new JLabel("차트 순위"));
      add(tfRanking);
      add(new JLabel("발매일"));
      add(tfRelease);
      add(new JLabel("작곡가"));
      add(tfComposer);
   
   }//main

}