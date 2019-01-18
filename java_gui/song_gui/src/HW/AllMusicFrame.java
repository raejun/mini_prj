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
		vCol.add("가수");
		vCol.add("노래 제목");
		vCol.add("시간");
		vCol.add("장르");
		vCol.add("차트순위");
		vCol.add("발매일");
		vCol.add("작곡가");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
	}//생성자
}//end
