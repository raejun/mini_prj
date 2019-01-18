package gui2;

import java.awt.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingNotePed extends JFrame implements ActionListener {
	JTextArea ta;
	JMenuBar menuBar;
	JMenu fileMenu, editMenu;
	JMenuItem newItem, openItem, saveItem, exitItem;
	JMenuItem copyItem, cutItem, pasteItem, allItem, dateItem;
	JFileChooser openDialog, saveDialog;
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == exitItem) {
			System.exit(0);// ����
		}
		if (obj == newItem) {
			ta.setText("");
		}
		if (obj == openItem) {
			openDialog = new JFileChooser();
			int returVal = openDialog.showOpenDialog(this);
			if(returVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("���⸦ ����");
				File f = openDialog.getSelectedFile();
				System.out.println(openDialog.getSelectedFile().getName()+" ����");
				openFile(f);
			}else {
				System.out.println("��� ������");
			}
			System.out.println("zzzz");
		}
		if (obj == saveItem) {
			saveDialog = new JFileChooser();
			int returnVal = saveDialog.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("������ ��������");
				File f = saveDialog.getSelectedFile();
				saveFile(f);
			}else {
				System.out.println("��Ҹ� ������");
			}
		}
		if (obj == copyItem) {
			ta.copy();
			copyItem.setEnabled(false);
			cutItem.setEnabled(false);
		}
		if (obj == cutItem) {
			ta.cut();
			copyItem.setEnabled(false);
			cutItem.setEnabled(false);
		}
		if (obj == pasteItem) {
			ta.paste();
			copyItem.setEnabled(true);
			cutItem.setEnabled(true);
		}
		if (obj == allItem) {
			ta.selectAll();
		}
		if (obj == dateItem) {
			java.util.Date date = new java.util.Date();
			ta.append(date.toLocaleString());
		} else {
			System.out.println("��Ÿ ����");
		}

	}

	private void saveFile(File f) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			String str = ta.getText();
			fw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void openFile(File f) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String str = br.readLine();
			while(str !=null) {
				ta.append(str+"\n");
				str = br.readLine();
			}//while
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally
	}//openfile

	public SwingNotePed() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("no ����");
		setSize(500, 500);
		ta = new JTextArea();
		JScrollPane pane = new JScrollPane(ta);
		add(pane);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		fileMenu = new JMenu("����(f)");
		fileMenu.setMnemonic('f');// alt+F (����Ű)
		menuBar.add(fileMenu);
		newItem = new JMenuItem("���θ�������");
		openItem = new JMenuItem("����");
		saveItem = new JMenuItem("����");
		exitItem = new JMenuItem("������");
		newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
		openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
		saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));

		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		// �̺�Ʈ ���
		newItem.addActionListener(this);
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		// ���� �޴�
		editMenu = new JMenu("����(E)");
		editMenu.setMnemonic('e');
		copyItem = new JMenuItem("����");
		cutItem = new JMenuItem("�߶󳻱�");
		pasteItem = new JMenuItem("�ٿ��ֱ�");
		allItem = new JMenuItem("��� ����");
		dateItem = new JMenuItem("��¥/�ð�");

		copyItem.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK));
		cutItem.setAccelerator(KeyStroke.getKeyStroke('X', Event.CTRL_MASK));
		pasteItem.setAccelerator(KeyStroke.getKeyStroke('P', Event.CTRL_MASK));
		allItem.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));
		dateItem.setAccelerator(KeyStroke.getKeyStroke("F5"));

		editMenu.add(copyItem);
		editMenu.add(cutItem);
		editMenu.add(pasteItem);
		editMenu.add(allItem);
		editMenu.add(dateItem);
		menuBar.add(editMenu);

		copyItem.addActionListener(this);
		cutItem.addActionListener(this);
		pasteItem.addActionListener(this);
		allItem.addActionListener(this);
		dateItem.addActionListener(this);

		setVisible(true);
	}

	public static void main(String[] args) {
		new SwingNotePed();
	}// main
}// end
