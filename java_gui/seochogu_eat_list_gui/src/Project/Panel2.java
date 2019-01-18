package Project;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Panel2 extends JPanel {
	JTable table;
	Vector vData;
	Vector vCol;
	public Panel2() {
		MemberDAO dao = new MemberDAO();
		vData = dao.allMembers();
		vCol = new Vector();
		vCol.add("상호명");
		vCol.add("대표메뉴");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
	}//생성자

}
