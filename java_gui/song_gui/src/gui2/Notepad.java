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
         System.exit(0); // exit������ ����
      } else if (obj == newItem) { // ���θ����
         ta.setText("");
      } else if (obj == openItem) { // ����
         System.out.println("java.io ������");
      } else if (obj == saveItem) { // ����
         System.out.println("java.io ������");
      } else if (obj == copyItem) { // ����
         ta.copy();
         copyItem.setEnabled(false);
         cutItem.setEnabled(false);
      } else if (obj == pasteItem) { // ����
         ta.paste();
         copyItem.setEnabled(true);
         cutItem.setEnabled(true);
      } else if (obj == allItem) { // ����
         ta.selectAll();
      } else if (obj == dateItem) { // ����
         java.util.Date date = new java.util.Date();
         ta.append(date.toLocaleString());
      }

   }

   public Notepad() {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setTitle("������� - �޸���");
      setSize(400, 300);
      ta = new JTextArea();
      JScrollPane pane = new JScrollPane(ta);
      add(pane);

      menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      fileMenu = new JMenu("����(F)");
      fileMenu.setMnemonic('F'); // ALT + F ����Ű
      menuBar.add(fileMenu);
      newItem = new JMenuItem("���θ����");
      openItem = new JMenuItem("����");
      saveItem = new JMenuItem("����");
      // �����
      newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
      openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
      saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));
      // ���ϸ޴��� ���̱�
      fileMenu.add(newItem);
      fileMenu.add(openItem);
      fileMenu.add(saveItem);

      // �̺�Ʈ ���
      newItem.addActionListener(this);
      openItem.addActionListener(this);
      saveItem.addActionListener(this);

      editMenu = new JMenu("����(E)");
      editMenu.setMnemonic('E');
      menuBar.add(editMenu);
      copyItem = new JMenuItem("����");
      cutItem = new JMenuItem("�߶󳻱�");
      pasteItem = new JMenuItem("�ٿ��ֱ�");
      allItem = new JMenuItem("��μ���");
      dateItem = new JMenuItem("��¥/�ð�");

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