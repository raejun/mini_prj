package jyl;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JY_FestivalPanel extends JPanel {
	
	public JY_FestivalPanel () {
		 String header[] = {"����̸�","�Ǳ��","�帣","�뷡�̸�"};
		    String contents[][] = { /*2�������� �����.2������ rowData��� �ϰ� 1������ columnNames��� �Ѵ�.*/
		          {"Muse","3","Rock","Hysteria"},
		          {"Olivia Ong","5","Jazz","Love Fool"},
		          {"Oasis","4","Rock","Don't look back in anger"},
		          
		    };//string contents, �ش��� ���� �ۼ�
		    	DefaultTableModel model = new DefaultTableModel(contents, header);
				JTable table = new JTable(model); /*JTable ��ü ����, Jtabled���� �Ʊ� �ۼ��� ����� ���� �ִ� �ڵ��ʿ�*/
				JScrollPane scrollpane = new JScrollPane(table); /*�ڽ����� �÷��� Ui���� ĭ�� �����ϸ� ��ũ���� �����Ѵ�*/
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
				
				
				add(scrollpane);
				add(panel);
	}
   
	
}
