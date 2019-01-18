package Project;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllMemberFrame extends JFrame {
	JTable table;
	Vector vData;
	Vector vCol;
	public AllMemberFrame() {
		setTitle("서초구 맛집");
		setSize(600, 400);
		MemberDAO dao = new MemberDAO();
		vData = dao.allMembers();
		vCol = new Vector();
		vCol.add("상호명");
		vCol.add("메뉴");
		vCol.add("위치");
		vCol.add("전화번호");
		vCol.add("가격");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
	}//생성자
}//end
