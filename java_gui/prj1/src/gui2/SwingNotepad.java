package gui2;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.io.*;
public class SwingNotepad extends JFrame implements ActionListener {
	JTextArea ta;
	JMenuBar menuBar;
	JMenu fileMenu, editMenu;
	JMenuItem newItem, openItem, saveItem, exitItem;
	JMenuItem copyItem, cutItem, pasteItem, allItem, dateItem;
	JFileChooser openDialog, saveDialog;
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == exitItem) { // ������
			System.exit(0); // ����
		} else if(obj == newItem) { // ���� �����
			ta.setText(""); // �� ĭ���� ���� => �����.
		} else if(obj == openItem) {
			openDialog = new JFileChooser();
			int returnVal = openDialog.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("���⸦ �����߽��ϴ�!!!");
				File f = openDialog.getSelectedFile();
				System.out.println(f.getName() + "�� ����!!!");
				openFile(f);
			} else {
				System.out.println("��Ҹ� �����߽��ϴ�!!!");
			}
		} else if(obj == saveItem) {
			saveDialog = new JFileChooser();
			int returnVal = saveDialog.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("������ �����߽��ϴ�!!!");
				File f = saveDialog.getSelectedFile();
				saveFile(f);
			} else {
				System.out.println("��Ҹ� �����߽��ϴ�!!!");
			}
		} else if(obj == copyItem) {
			ta.copy();
			copyItem.setEnabled(false);
			cutItem.setEnabled(false);
		} else if(obj == cutItem) {
			ta.cut();
			copyItem.setEnabled(false);
			cutItem.setEnabled(false);
		} else if(obj == pasteItem) {
			ta.paste();
			copyItem.setEnabled(true);
			cutItem.setEnabled(true);
		} else if(obj == allItem) {
			ta.selectAll();
		} else if(obj == dateItem) {
			Date date = new Date();
			// java.util.Date date = new java.util.Date();
			ta.append(date.toLocaleString());
		} else {
			System.out.println("��Ÿ ����");
		}
	}//actionPerformed
	private void saveFile(File f) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			String str = ta.getText();
			fw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally
	}//saveFile
	private void openFile(File f) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String str = br.readLine();
			while(str != null) {
				ta.append(str + "\n");
				str = br.readLine();
			}//while
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally
	}//openFile
	public SwingNotepad() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // X -> ����
		setTitle("���� ���� - �޸���");
		setSize(400, 300);
		ta = new JTextArea();
		JScrollPane pane = new JScrollPane(ta);
		add(pane);
		// �޴� ���� �ڵ�
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		fileMenu = new JMenu("����(F)");
		fileMenu.setMnemonic('F'); // Alt + F (����Ű)
		menuBar.add(fileMenu);
		newItem = new JMenuItem("���� �����");
		openItem = new JMenuItem("����");
		saveItem = new JMenuItem("����");
		exitItem = new JMenuItem("������");
		// ����Ű
		newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK)); // Ctrl + N
		openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK)); // Ctrl + O
		saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK)); // Ctrl + S
		// ���� �޴��� ���̱�
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator(); // ���м� �߰�
		fileMenu.add(exitItem);
		// �̺�Ʈ ���
		newItem.addActionListener(this);
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		// ���� �޴�
		editMenu = new JMenu("����(E)");
		editMenu.setMnemonic('E');
		menuBar.add(editMenu);
		copyItem = new JMenuItem("����");
		cutItem = new JMenuItem("�߶󳻱�");
		pasteItem = new JMenuItem("�ٿ��ֱ�");
		allItem = new JMenuItem("��� ����");
		dateItem = new JMenuItem("��¥/�ð�");
		copyItem.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK)); // Ctrl + C
		cutItem.setAccelerator(KeyStroke.getKeyStroke('X', Event.CTRL_MASK)); // Ctrl + X
		pasteItem.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK)); // Ctrl + V
		allItem.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK)); // Ctrl + A
		dateItem.setAccelerator(KeyStroke.getKeyStroke("F5")); // F5
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
	}//������
	public static void main(String[] args) {
		new SwingNotepad();
	}//main
}//end
