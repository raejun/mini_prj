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
      //�ؽ�Ʈ �ʵ� ����
      
      String[] arrGenre = {"�߶��", "����", "��", "R&B", "��", "����", "����", "����"};
      
      cbGenre = new JComboBox(arrGenre);

      add(new JLabel("����"));
      add(tfArtist);
      add(new JLabel("�뷡 ����"));
      add(tfTitle);
      add(new JLabel("�ð�"));
      add(tfLength);
      add(new JLabel("�帣"));
      add(cbGenre);
      add(new JLabel("��Ʈ ����"));
      add(tfRanking);
      add(new JLabel("�߸���"));
      add(tfRelease);
      add(new JLabel("�۰"));
      add(tfComposer);
   
   }//main

}