package Mini_BasketballDB;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Bk_SalFrame extends JFrame{
	JTable table;
	Vector vData;
	Vector vCol;
	// ������
	public Bk_SalFrame () {
		setTitle("JTable ���� ����");
		setSize(600, 600);
		BkPlayer_DAO dao = new BkPlayer_DAO();
		vData = dao.PlayerSal();

		vCol = new Vector();
		vCol.add("������");
		vCol.add("����");
		vCol.add("����");

		DefaultTableModel model2 = new DefaultTableModel(vData, vCol);
		table = new JTable(model2);
		JScrollPane pane2 = new JScrollPane(table);
		add(pane2);
		
		setVisible(true);
	}
}