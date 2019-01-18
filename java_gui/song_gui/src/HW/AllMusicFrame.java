package HW;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllMusicFrame extends JFrame {
	JTable table;
	Vector vData;
	Vector vCol;
	public AllMusicFrame() {
		setTitle("Music");
		setSize(600, 400);
		MusicDAO dao = new MusicDAO();
		vData = dao.allMusic();
		vCol = new Vector();
		vCol.add("����");
		vCol.add("�뷡 ����");
		vCol.add("�ð�");
		vCol.add("�帣");
		vCol.add("��Ʈ����");
		vCol.add("�߸���");
		vCol.add("�۰");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
	}//������
}//end
