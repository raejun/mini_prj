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
	
	// ������
	public AllPlayer_Frame () {
		setTitle("JTable ���� ���");
		setSize(600, 600);
		BkPlayer_DAO dao = new BkPlayer_DAO();
		vData = dao.allPlayers();

		vCol = new Vector();
		vCol.add("������");
		vCol.add("����");
		vCol.add("3�� ������");
		vCol.add("2�� ������");
		vCol.add("������ ������");
		vCol.add("���ٿ��");
		vCol.add("��ý�Ʈ");
		vCol.add("��ƿ");
		vCol.add("���");
		vCol.add("�Ͽ���");
		vCol.add("��� ����");
		
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		
		setVisible(true);
	}
}
