package mini;

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
		setTitle("JTable 회원 예제");
		setSize(600, 400);
		MemberDAO dao = new MemberDAO();
		vData = dao.allMembers();
		vCol = new Vector();
		vCol.add("아이디");
		vCol.add("비밀번호");
		vCol.add("이름");
		vCol.add("전화번호");
		vCol.add("주소");
		vCol.add("나이");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
	}//생성자
}//end
