package book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.util.*;

public class AllBook extends JPanel{
	JTable table;
	Vector vData;
	Vector vCol;
	DefaultTableModel model;
	JScrollPane pane;
	
	public AllBook () {
		setLayout(new BorderLayout());
	BookDAO dao=new BookDAO();
	vData = dao.allBooks();
	vCol=new Vector();
	vCol.add("����");
	vCol.add("����");
	vCol.add("�۰�");
	vCol.add("���");
	vCol.add("����⵵");

	model=new DefaultTableModel(vData, vCol);
	table=new JTable(model);
	pane=new JScrollPane(table);
	add(pane);
	setVisible(true);
	}
}





