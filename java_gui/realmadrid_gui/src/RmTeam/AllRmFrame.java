package RmTeam;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AllRmFrame extends JFrame {
	JTable table;
	Vector vData;
	Vector vCol;

	public AllRmFrame() {
		
		setTitle("RealMadrid ������");
		setSize(400, 350);
		rmDAO dao = new rmDAO();
		vData = dao.allrms();
		vCol = new Vector();
		vCol.add("������ȣ");
		vCol.add("�̸�");
		vCol.add("Ű");
		vCol.add("������");
		vCol.add("����");
		vCol.add("������");
		vCol.add("����");
		vCol.add("�Դ���");
		
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		
		add(pane);
		setVisible(true);
	}//������
	
}// class
