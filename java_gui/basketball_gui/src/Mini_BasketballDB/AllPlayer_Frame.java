package Mini_BasketballDB;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllPlayer_Frame extends JFrame {
	JTable table;
	Vector vData;
	Vector vCol;
	
	// 생성자
	public AllPlayer_Frame () {
		setTitle("JTable 선수 목록");
		setSize(600, 600);
		BkPlayer_DAO dao = new BkPlayer_DAO();
		vData = dao.allPlayers();

		vCol = new Vector();
		vCol.add("선수명");
		vCol.add("시즌");
		vCol.add("3점 성공률");
		vCol.add("2점 성공률");
		vCol.add("자유투 성공률");
		vCol.add("리바운드");
		vCol.add("어시스트");
		vCol.add("스틸");
		vCol.add("블락");
		vCol.add("턴오버");
		vCol.add("평균 득점");
		
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		
		setVisible(true);
	}
}
