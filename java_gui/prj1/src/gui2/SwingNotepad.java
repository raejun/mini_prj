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
		if(obj == exitItem) { // 끝내기
			System.exit(0); // 종료
		} else if(obj == newItem) { // 새로 만들기
			ta.setText(""); // 빈 칸으로 셋팅 => 지운다.
		} else if(obj == openItem) {
			openDialog = new JFileChooser();
			int returnVal = openDialog.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("열기를 선택했습니다!!!");
				File f = openDialog.getSelectedFile();
				System.out.println(f.getName() + "을 선택!!!");
				openFile(f);
			} else {
				System.out.println("취소를 선택했습니다!!!");
			}
		} else if(obj == saveItem) {
			saveDialog = new JFileChooser();
			int returnVal = saveDialog.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("저장을 선택했습니다!!!");
				File f = saveDialog.getSelectedFile();
				saveFile(f);
			} else {
				System.out.println("취소를 선택했습니다!!!");
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
			System.out.println("기타 선택");
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // X -> 종료
		setTitle("제목 없음 - 메모장");
		setSize(400, 300);
		ta = new JTextArea();
		JScrollPane pane = new JScrollPane(ta);
		add(pane);
		// 메뉴 관련 코드
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		fileMenu = new JMenu("파일(F)");
		fileMenu.setMnemonic('F'); // Alt + F (단축키)
		menuBar.add(fileMenu);
		newItem = new JMenuItem("새로 만들기");
		openItem = new JMenuItem("열기");
		saveItem = new JMenuItem("저장");
		exitItem = new JMenuItem("끝내기");
		// 단축키
		newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK)); // Ctrl + N
		openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK)); // Ctrl + O
		saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK)); // Ctrl + S
		// 파일 메뉴에 붙이기
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator(); // 구분선 추가
		fileMenu.add(exitItem);
		// 이벤트 등록
		newItem.addActionListener(this);
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		// 편집 메뉴
		editMenu = new JMenu("편집(E)");
		editMenu.setMnemonic('E');
		menuBar.add(editMenu);
		copyItem = new JMenuItem("복사");
		cutItem = new JMenuItem("잘라내기");
		pasteItem = new JMenuItem("붙여넣기");
		allItem = new JMenuItem("모두 선택");
		dateItem = new JMenuItem("날짜/시간");
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
	}//생성자
	public static void main(String[] args) {
		new SwingNotepad();
	}//main
}//end
