package gui2;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
public class MyPanel1 extends JPanel implements MouseListener {
	JTable table;
	public MyPanel1() {
		setLayout(new BorderLayout());
		String[] columns = {"����", "�а�", "����"};
		String[][] data = {
							{ "ȫ�浿", "�����", "Java" },
							{ "����", "���ڰ�", "XML" },
							{ "������", "����", "Spring" }
						  };
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(this);
		JScrollPane pane = new JScrollPane(table);
		add(pane, BorderLayout.CENTER);
	}//������
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int column = table.getSelectedColumn();
		System.out.println("row=" + row + ", column=" + column);
		String str = (String) table.getValueAt(row, column);
		System.out.println("��=" + str);
		if(str.equals("ȫ�浿")) {
			System.out.println("aaaa");
		}
	}//mouseClicked
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