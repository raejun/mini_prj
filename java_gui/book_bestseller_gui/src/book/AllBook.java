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
	vCol.add("제목");
	vCol.add("원제");
	vCol.add("작가");
	vCol.add("언어");
	vCol.add("발행년도");

	model=new DefaultTableModel(vData, vCol);
	table=new JTable(model);
	pane=new JScrollPane(table);
	add(pane);
	setVisible(true);
	}
}





