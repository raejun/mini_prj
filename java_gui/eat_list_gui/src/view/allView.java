package view;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.resDAO;

public class allView extends JFrame {
	JTable table;
	Vector vData;
	Vector vCol;
	public allView() {
		setTitle("��ü�Ĵ� ���");
		setSize(600, 400);
		setLocation(700,350);
		resDAO dao = new resDAO();
		vData = dao.allRes();
		vCol = new Vector();
		vCol.add("��ȣ��");
		vCol.add("�ּ�");
		vCol.add("��ȭ��ȣ");
		vCol.add("��ǥ�޴�");
		vCol.add("����");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
	}
}

