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
		setTitle("전체식당 목록");
		setSize(600, 400);
		setLocation(700,350);
		resDAO dao = new resDAO();
		vData = dao.allRes();
		vCol = new Vector();
		vCol.add("상호명");
		vCol.add("주소");
		vCol.add("전화번호");
		vCol.add("대표메뉴");
		vCol.add("가격");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
	}
}

