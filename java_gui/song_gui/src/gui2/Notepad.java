package gui2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Notepad extends JFrame implements ActionListener {
   JTextArea ta;
   JMenuBar menuBar;
   JMenu fileMenu, editMenu;
   JMenuItem newItem, openItem, saveItem, exitItem;
   JMenuItem copyItem, cutItem, pasteItem, allItem, dateItem;

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (obj == exitItem) {
         System.exit(0); // exit누르면 종료
      } else if (obj == newItem) { // 새로만들기
         ta.setText("");
      } else if (obj == openItem) { // 열기
         System.out.println("java.io 공부후");
      } else if (obj == saveItem) { // 저장
         System.out.println("java.io 공부후");
      } else if (obj == copyItem) { // 저장
         ta.copy();
         copyItem.setEnabled(false);
         cutItem.setEnabled(false);
      } else if (obj == pasteItem) { // 저장
         ta.paste();
         copyItem.setEnabled(true);
         cutItem.setEnabled(true);
      } else if (obj == allItem) { // 저장
         ta.selectAll();
      } else if (obj == dateItem) { // 저장
         java.util.Date date = new java.util.Date();
         ta.append(date.toLocaleString());
      }

   }

   public Notepad() {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setTitle("제목없음 - 메모장");
      setSize(400, 300);
      ta = new JTextArea();
      JScrollPane pane = new JScrollPane(ta);
      add(pane);

      menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      fileMenu = new JMenu("파일(F)");
      fileMenu.setMnemonic('F'); // ALT + F 단축키
      menuBar.add(fileMenu);
      newItem = new JMenuItem("새로만들기");
      openItem = new JMenuItem("열기");
      saveItem = new JMenuItem("저장");
      // 단축기
      newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
      openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
      saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));
      // 파일메뉴에 붙이기
      fileMenu.add(newItem);
      fileMenu.add(openItem);
      fileMenu.add(saveItem);

      // 이벤트 등록
      newItem.addActionListener(this);
      openItem.addActionListener(this);
      saveItem.addActionListener(this);

      editMenu = new JMenu("편집(E)");
      editMenu.setMnemonic('E');
      menuBar.add(editMenu);
      copyItem = new JMenuItem("복사");
      cutItem = new JMenuItem("잘라내기");
      pasteItem = new JMenuItem("붙여넣기");
      allItem = new JMenuItem("모두선택");
      dateItem = new JMenuItem("날짜/시간");

      copyItem.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK));
      cutItem.setAccelerator(KeyStroke.getKeyStroke('X', Event.CTRL_MASK));
      pasteItem.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK));
      allItem.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));
      dateItem.setAccelerator(KeyStroke.getKeyStroke("F5"));

      editMenu.add(copyItem);
      editMenu.add(cutItem);
      editMenu.add(pasteItem);
      editMenu.add(allItem);
      editMenu.add(dateItem);

      copyItem.addActionListener(this);
      cutItem.addActionListener(this);
      pasteItem.addActionListener(this);
      allItem.addActionListener(this);
      dateItem.addActionListener(this);

      setVisible(true);
   }

   public static void main(String[] args) {
      new Notepad();
   }

}