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
		setTitle("���ʱ� ����");
		setSize(600, 400);
		MemberDAO dao = new MemberDAO();
		vData = dao.allMembers();
		vCol = new Vector();
		vCol.add("��ȣ��");
		vCol.add("�޴�");
		vCol.add("��ġ");
		vCol.add("��ȭ��ȣ");
		vCol.add("����");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
	}//������
}//end