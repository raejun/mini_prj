package movie;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllMovieFrame extends JFrame {
	JTable table;
	Vector vData;
	Vector vCol;
	public AllMovieFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("��ȭ�������� �̴� ������Ʈ");
		setSize(600,400);
		MovieDAO dao = new MovieDAO();
		vData = dao.allMovies();
		vCol = new Vector();
		vCol.add("��ȭ�ڵ�");
		vCol.add("��ȭ����");
		vCol.add("����");
		vCol.add("�帣");
		vCol.add("���");
		vCol.add("�⿬���");
		vCol.add("�󿵽ð�");
		vCol.add("��޻�");
		vCol.add("������");
		vCol.add("����");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
		
	}//������
}//end