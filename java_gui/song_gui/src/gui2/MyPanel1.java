package gui2;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class MyPanel1 extends JPanel implements MouseListener{
	JTable table;
	public MyPanel1() {
		setLayout(new BorderLayout());
		String[] columns = {"생명","학과","과목"};
		String[][] data = {
							{"홍길동","전산과","자바"},
							{"장길산","전산과","자바"},
							{"일지매","기계과","파잇선"}
						  }; //JDBC에서 INSERT로 해라
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(this);
		JScrollPane pane = new JScrollPane(table);
		add(pane,BorderLayout.CENTER);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		System.out.println("row= "+row+"col= "+col);
		String str = (String) table.getValueAt(row, col);
		System.out.println("값= "+str);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}//end
